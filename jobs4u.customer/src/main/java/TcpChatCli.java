

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.sleep;


class TcpChatCli {
    static InetAddress serverIP;
    static Socket sock;
    static boolean check = false;

    public static void main(String args[]) throws Exception {
        String nick, command;

        if (args.length != 1) {
            System.out.println("Server IPv4/IPv6 address or DNS name is required as argument");
            System.exit(1);
        }

        try {
            serverIP = InetAddress.getByName(args[0]);
        } catch (UnknownHostException ex) {
            System.out.println("Invalid server: " + args[0]);
            System.exit(1);
        }

        try {
            sock = new Socket(serverIP, 11170);
        } catch (IOException ex) {
            System.out.println("Failed to connect.");
            System.exit(1);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());

        System.out.print("Enter your email: ");
        String username = in.readLine();
        System.out.print("Enter your password: ");
        String password = in.readLine();
        sendAuthRequest(sOut, username, password);


        Thread serverConn = new Thread(new TcpChatCliConn(sock));
        serverConn.start();

        // Continue with the message loop
        while (true) {
            command = in.readLine();
            if (command.equalsIgnoreCase("DISCONN")) {
                sendDisconnRequest(sOut);
                break;
            }

            String[] parts = command.split(" ");
            String cmd = parts[0].toUpperCase();

            switch (cmd) {
                case "COMMTEST":
                    sendCommTestRequest(sOut);
                    break;
                case "21":
                    sendOptionRequest(sOut, 21);
                    break;
                case "22":
                    sendOptionRequest(sOut, 22);
                    break;

                    case "AUTH":
                    if (parts.length == 3) {
                        sendAuthRequest(sOut, parts[1], parts[2]);
                    } else {
                        System.out.println("Usage: AUTH <username> <password>");
                    }
                default:
                    if (command.trim().isEmpty()) {
                        check = true;
                        continue;
                    } else {
                        System.out.println("Unknown command: " + cmd);
                    }
                    break;
            }
        }

        serverConn.join();
        sock.close();
    }

    private static void sendOptionRequest(DataOutputStream out, int optionCode) throws IOException {
        byte[] message = {1, (byte) optionCode, 0, 0, 0, 0};
        out.write(message);
        out.flush();
        System.out.println("Sent option request " + optionCode + ": " + byteArrayToHex(message) + " 0000");
    }

    private static void sendAuthRequest(DataOutputStream out, String username, String password) throws IOException {
        byte[] usernameBytes = username.getBytes(StandardCharsets.US_ASCII);
        byte[] passwordBytes = password.getBytes(StandardCharsets.US_ASCII);
        byte[] message = createAuthRequest(usernameBytes, passwordBytes);
        out.write(message);
        out.flush();
        System.out.println("Sent AUTH request with username length " + usernameBytes.length + " and password length " + passwordBytes.length);
    }

    private static byte[] createAuthRequest(byte[] usernameBytes, byte[] passwordBytes) {
        int data1Len = usernameBytes.length;
        int data2Len = passwordBytes.length;

        ByteBuffer buffer = ByteBuffer.allocate(4 + data1Len + 2 + data2Len + 2);
        buffer.put((byte) 1); // VERSION
        buffer.put((byte) 4); // CODE (AUTH)
        buffer.put((byte) (data1Len & 0xFF)); // DATA1_LEN_L
        buffer.put((byte) ((data1Len >> 8) & 0xFF)); // DATA1_LEN_M
        buffer.put(usernameBytes); // Include the username bytes
        buffer.put((byte) (data2Len & 0xFF)); // DATA2_LEN_L
        buffer.put((byte) ((data2Len >> 8) & 0xFF)); // DATA2_LEN_M
        buffer.put(passwordBytes); // Include the password bytes

        return buffer.array();
    }

    private static void sendCommTestRequest(DataOutputStream out) throws IOException {
        byte[] message = {1, 0, 0, 0, 0, 0}; // VERSION = 1, CODE = 0 (COMMTEST), no DATA1 or DATA2, two zero bytes at the end
        out.write(message);
        out.flush();
        System.out.println("Sent COMMTEST request: " + byteArrayToHex(message) + " 0000");
    }

    private static void sendDisconnRequest(DataOutputStream out) throws IOException {
        byte[] message = {1, 1, 0, 0, 0, 0}; // VERSION = 1, CODE = 1 (DISCONN), no DATA1 or DATA2, two zero bytes at the end
        out.write(message);
        out.flush();
        System.out.println("Sent DISCONN request: " + byteArrayToHex(message) + " 0000");
    }

    private static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder();
        for (byte b : a) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}

class TcpChatCliConn implements Runnable {
    private Socket s;
    private DataInputStream sIn;
    private DataOutputStream sOut;
    private boolean authenticated = false;
    private LocalDateTime localDateTime;
    private BufferedReader reader;

    public TcpChatCliConn(Socket tcp_s) {
        s = tcp_s;
    }

    public void run() {
        try {
            sIn = new DataInputStream(s.getInputStream());
            sOut = new DataOutputStream(s.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                if (!authenticated) {
                    handleAuthResponse();
                    continue;
                }

                System.out.println("\nCustomer User Menu:");
                System.out.println("21. View my notifications");
                System.out.println("22. View My Job Openings");

                handleServerMessages();
            }
        } catch (IOException ex) {
            System.out.println("Client disconnected.");
        }
    }

    private void handleAuthResponse() throws IOException {
        byte[] header = new byte[6];
        sIn.readFully(header);
        int version = header[0] & 0xFF;
        int code = header[1] & 0xFF;
        int data1Len = (header[2] & 0xFF) + ((header[3] & 0xFF) * 256);
        int terminator = (header[4] & 0xFF) + (header[5] & 0xFF);
        if (terminator != 0) {
            System.out.println("Invalid terminator bytes: " + terminator);
            return;
        }

        byte[] data1 = new byte[data1Len];
        if (data1Len > 0) {
            sIn.readFully(data1);
        }

        switch (code) {
            case 3:
                System.out.println("Received Error response from server: Version=" + version + ", Code=" + code + ", DATA1=" + byteArrayToHex(data1) + " (" + new String(data1, "ASCII") + ")");
                break;
            case 100:
                System.out.println("Received Auth Ack response from server: Version=" + version + ", Code=" + code + ", DATA1=" + byteArrayToHex(data1) + " (" + new String(data1, "ASCII") + ")");
                authenticated = true;
                break;
            default:
                System.out.println("Received from server: Version=" + version + ", Code=" + code + ", DATA1=" + byteArrayToHex(data1) + " (" + new String(data1, "ASCII") + ")");
                break;
        }
    }

    private void handleServerMessages() throws IOException {
        while (true) {
            byte[] header = new byte[2];
            sIn.readFully(header);
            int code = header[1] & 0xFF;

            int totalLength = sIn.available();
            while (totalLength > 0) {
                byte[] dataLenBytes = new byte[2];
                sIn.readFully(dataLenBytes);
                int dataLength = (dataLenBytes[0] & 0xFF) + ((dataLenBytes[1] & 0xFF) * 256);

                if (dataLength == 0) {
                    break;
                }

                byte[] data = new byte[dataLength];
                sIn.readFully(data);
                totalLength -= (2 + dataLength);

                switch (code){
                    case 8:
                        handleNotificationsListResponse(data);
                        break;
                    case 7:
                        handleJobOpeningInfoResponse(data);
                        break;
                }
            }
        }
    }

    private void handleJobOpeningInfoResponse(byte[] data) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

            List<JobOpeningInfo> jofs = (List<JobOpeningInfo>) objectInputStream.readObject();

            System.out.println(jofs.size());
            for (JobOpeningInfo jobOpeningInfo : jofs) {
                System.out.println("-------------------------------------------------------");
                System.out.println("Job Reference: " + jobOpeningInfo.getId());
                System.out.println("Job Title: " + jobOpeningInfo.getJobTitle());
                System.out.println("Active Since: " + jobOpeningInfo.getActivateSince());
                System.out.println("Number of Applications: " + jobOpeningInfo.getNoOfApplications());
                System.out.println("-------------------------------------------------------");
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        run();
    }

    private void handleNotificationsListResponse(byte[] data) {
        int aux = 0;
        try {
            boolean check = true;
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            List<Notifications> notifications = (List<Notifications>) objectInputStream.readObject();

            List<Long> notificationsToMarkAsRead = new ArrayList<>();

            for (Notifications noti : notifications) {
                if (noti.getIsRead() == 0) {
                    displayNotification(noti, notificationsToMarkAsRead);
                }
            }

            if (!notificationsToMarkAsRead.isEmpty()) {
                markNotificationsAsRead(notificationsToMarkAsRead);
                aux = 1;
            }

            if (aux == 0) {
                    System.out.println("\nNo new notifications. Displaying all notifications:\n");

                for (Notifications noti : notifications) {
                    displayAllNotifications(noti);
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        run();
    }

    private void displayNotification(Notifications noti, List<Long> notificationsToMarkAsRead) throws IOException {
        System.out.println("-------------------------------------------------------");
        System.out.println("Notification: " + noti.getNotification());
        System.out.println("-------------------------------------------------------");
        System.out.print("Press Enter to mark this notification as read and go to the next, or type 'no' to skip: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String response = reader.readLine();
        if (response.trim().isEmpty() || "yes".equalsIgnoreCase(response)) {
            notificationsToMarkAsRead.add(noti.getId());
        }
    }

    private void displayAllNotifications(Notifications noti) {
        System.out.println("-------------------------------------------------------");
        System.out.println("Notification: " + noti.getNotification());
        System.out.println("-------------------------------------------------------");
    }

    public void markNotificationsAsRead(List<Long> notificationIds) throws IOException {
        byte[] message = createMarkAsReadRequest(notificationIds);
        sOut.write(message);
        sOut.flush();
        System.out.println("Sent request to mark notifications as read: " + byteArrayToHex(message));
    }

    private byte[] createMarkAsReadRequest(List<Long> notificationIds) {
        int totalDataLength = notificationIds.size() * Long.BYTES;
        ByteBuffer buffer = ByteBuffer.allocate(4 + totalDataLength + 2 * notificationIds.size());
        System.out.println(notificationIds);
        buffer.put((byte) 1);
        buffer.put((byte) 23);

        for (long id : notificationIds) {
            byte[] idBytes = ByteBuffer.allocate(Long.BYTES).putLong(id).array();
            buffer.put((byte) (idBytes.length & 0xFF));
            buffer.put((byte) ((idBytes.length >> 8) & 0xFF));
            buffer.put(idBytes);
        }
        buffer.put((byte) 0);
        buffer.put((byte) 0);

        return buffer.array();
    }

    private static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder();
        for (byte b : a) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}

