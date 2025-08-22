package eapli.jobs4u.app.candidate.email;

import eapli.jobs4u.app.candidate.email.email.SendEmailController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.Socket;

@Component
public class SMTPClient implements Runnable {

    @Autowired
    private SendEmailController sendEmailController;

    private static final String SERVER_ADDRESS = "frodo.dei.isep.ipp.pt";
    private static final int SERVER_PORT = 25;

    @Override
    public void run() {

        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {

            System.out.println("Connecting to SMTP server..." + socket.getInetAddress().getHostName());

            sendEmailController.sendEmail("", "");

        } catch (Exception e) {
            System.out.println("Error connecting to SMTP server: " + e.getMessage());
        }
    }
}
