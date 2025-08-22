package eapli.jobs4u.app.candidate.email.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendEmailController {

    @Autowired
    private CandidateNotificationService candidateNotificationService;

    public void sendEmail(String subject, String text) {
        candidateNotificationService.notifyAllCandidates(subject, text);
    }
}
