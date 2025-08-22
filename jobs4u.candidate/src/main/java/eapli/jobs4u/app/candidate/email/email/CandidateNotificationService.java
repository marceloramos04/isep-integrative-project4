package eapli.jobs4u.app.candidate.email.email;

import candidate.CandidateRepository;
import candidate.domain.Candidate;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.jobs4u.app.candidate.email.SMTPClient;
import eapli.jobs4u.app.candidate.email.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateNotificationService {

    @Autowired
    private EmailService emailService;

    @Autowired
    private CandidateRepository candidateRepository;

    public void notifyAllCandidates(String subject, String text) {

        List<Candidate> allCandidates = candidateRepository.findAll();

        for (Candidate candidate : allCandidates) {
            EmailAddress email = candidate.getEmail();
            emailService.sendEmail(email.toString(), subject, text);
        }
    }

}
