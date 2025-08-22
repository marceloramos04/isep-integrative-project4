package eapli.jobs4u.app.candidate.email.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendEmail(String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("operator@isep.ipp.pt");
        message.setTo(to);
        message.setText(text);
        message.setSubject(subject);

        emailSender.send(message);

        System.out.println("Email sent to " + to);
    }
}
