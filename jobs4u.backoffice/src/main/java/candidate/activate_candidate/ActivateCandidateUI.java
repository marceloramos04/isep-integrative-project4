package candidate.activate_candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import userManagement.domain.AppUser;
import utils.Utils;

import java.util.List;

@Component
public class ActivateCandidateUI implements Runnable {

    @Autowired
    private ActivateCandidateController activateCandidateController;

    @Override
    public void run() {

        try {

            System.out.println("Listing deactivated candidates...");

            List<AppUser> deactivatedCandidates = activateCandidateController.listDeactivatedCandidates();

            for (AppUser candidate : deactivatedCandidates) {
                System.out.println(candidate);
            }

            String email = Utils.readLineFromConsole("Enter the email of the candidate you want to activate:");

            if (activateCandidateController.activateCandidateByEmail(email)) {

                System.out.println("Candidate activated successfully!");

            } else {

                System.out.println("An error occurred while activating the candidate.");
            }


        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }
}
