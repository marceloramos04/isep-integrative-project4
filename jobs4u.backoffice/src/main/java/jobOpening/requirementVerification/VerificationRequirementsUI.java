package jobOpening.requirementVerification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utils.Utils;

@Component
public class VerificationRequirementsUI implements Runnable{

    @Autowired
    private VerificationRequirementsController verificationRequirementsController;

    @Override
    public void run() {
        if (verificationRequirementsController.getJobOpeningsOnScreeningPhase().isEmpty()) {
            System.out.println("There are no job openings on the screening phase.");
            return;
        }

        int input;
        do {
            System.out.println("Displaying existing job openings on the screening phase : ");
            input = Utils.showAndSelectIndex(verificationRequirementsController.getJobOpeningsOnScreeningPhase(), "Select a job opening to verify applications");
            if (input == -1) {
                System.out.println("Exiting...");
                return;
            }
            System.out.println("\n\nSelected job opening: \n" + verificationRequirementsController.getJobOpening(input));
        } while (!Utils.confirm("Do you want to verify the applications that meet the requirements to this job opening? (Y/N)"));

        verificationRequirementsController.verifyRequirements(input);
        System.out.println("Applications verified successfully!");
    }

}
