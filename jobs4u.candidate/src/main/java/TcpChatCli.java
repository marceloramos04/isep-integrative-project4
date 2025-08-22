

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

class TcpChatCli {
    static InetAddress serverIP;
    static Socket sock;

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
            System.out.println("Command read: " + command);
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
                case "10": // Handle command "10"
                    sendOptionRequest(sOut, 10);
                    break;
                case "11": // Handle command "11"
                    sendOptionRequest(sOut, 11);
                    break;

                case "AUTH":
                    if (parts.length == 3) {
                        sendAuthRequest(sOut, parts[1], parts[2]);
                    } else {
                        System.out.println("Usage: AUTH <username> <password>");
                    }
                default:
                    System.out.println("Unknown command: " + cmd);
                    continue;
            }
        }

        serverConn.join();
        sock.close();
    }

    private static void sendOptionRequest(DataOutputStream out, int optionCode) throws IOException {
        byte[] message = {1, (byte) optionCode, 0, 0, 0, 0}; // VERSION = 1, CODE = optionCode, no DATA1 or DATA2, two zero bytes at the end
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
    private boolean authenticated = false;

    public TcpChatCliConn(Socket tcp_s) {
        s = tcp_s;
    }

    public void run() {
        try {
            sIn = new DataInputStream(s.getInputStream());

            while (true) {

                if (!authenticated) {
                    handleAuthResponse();
                    continue;
                }

                System.out.println("\nCandidate User Menu:");
                System.out.println("10. List all my applications and their status");
                System.out.println("11. View my notifications");

                handleServerMessages();
            }
        } catch (IOException | ClassNotFoundException ex) {
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

    private void handleServerMessages() throws IOException, ClassNotFoundException {
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

                switch(code){

                    case 6:
                        handleApplicationListResponse(data);
                        break;
                    case 18:
                    handleNotification(data);
                        break;
                }
            }
        }
    }

    private void handleApplicationListResponse(byte[] data) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            ApplicationInfo app = (ApplicationInfo) objectInputStream.readObject();

            // Process the application info
            System.out.println("-------------------------------------------------------");
            System.out.println("Job Title: " + app.getJobTitle());
            String result = app.getScreeningResult();
            System.out.println("Screening Result: " + app.getScreeningResultString(result));
            System.out.println("Total Number of Applicants for the Job Opening : " + app.getApplicationCount());
            System.out.println("-------------------------------------------------------");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        run();
    }


    private void handleNotification(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        List<Notification> noti = (List<Notification>) objectInputStream.readObject();

        for(Notification notification : noti){
            System.out.println("-------------------------------------------------------");
            System.out.println("Notification: " + notification.getNotification());
            System.out.println("-------------------------------------------------------");
        }
    }

    private static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder();
        for (byte b : a) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
