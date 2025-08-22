package candidate.ListAllCandidates;


import candidate.domain.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ListAllCandidatesUI implements Runnable {

    @Autowired
    private ListAllCandidatesController listAllCandidatesController;

    @Override
    public void run() {

        String format = "| %-20s | %-15s | %-30s |%n";
        System.out.println("----LIST OF ALL CANDIDATES REGISTERED:----");
        System.out.printf(format, "Name", "Phone Number", "Email");
        List<Candidate> candidates = listAllCandidatesController.listAllCandidates();
        for (Candidate candidate : candidates) {
            System.out.printf(format, candidate.getName(), candidate.getPhoneNumber(), candidate.getEmail());
        }
        System.out.println("-----END OF THE LIST-----");


    }
}
