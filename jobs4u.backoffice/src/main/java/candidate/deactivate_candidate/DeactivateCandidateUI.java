package candidate.deactivate_candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import userManagement.domain.AppUser;
import utils.Utils;

import java.util.List;

@Component
public class DeactivateCandidateUI implements Runnable {

    @Autowired
    private DeactivateCandidateController deactivateCandidateController;

    @Override
    public void run() {

        try {

            System.out.println("Listing activated candidates...");

            List<AppUser> activatedCandidates = deactivateCandidateController.listActivatedCandidates();

            for (AppUser candidate : activatedCandidates) {
                System.out.println(candidate);
            }

            String email = Utils.readLineFromConsole("Enter the email of the candidate you want to deactivate:");

            if (deactivateCandidateController.deactivateCandidateByEmail(email)) {

                System.out.println("Candidate deactivated successfully!");

            } else {

                System.out.println("An error occurred while deactivating the candidate.");
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
