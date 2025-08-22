package userManagement.auth.userui;

import application.register_applications.RegisterApplicationsUI;
import candidate.activate_candidate.ActivateCandidateUI;
import candidate.deactivate_candidate.DeactivateCandidateUI;
import candidate.file_upload.UploadRequirementsFileUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utils.Utils;

@Component
public class OperatorUI implements Runnable {

    @Autowired
    private RegisterApplicationsUI registerApplicationsUI;

    @Autowired
    private ActivateCandidateUI activateCandidateUI;

    @Autowired
    private DeactivateCandidateUI deactivateCandidateUI;

    @Autowired
    private UploadRequirementsFileUI uploadRequirementsFileUI;

    @Override
    public void run() {

        boolean exit = false;

        while (!exit) {
            System.out.println(" ======= Welcome to the Operator UI =======\n");
            System.out.println("1 - Register Application");
            System.out.println("2 - Activate Candidate");
            System.out.println("3 - Deactivate Candidate");
            System.out.println("4 - Upload Candidate Requirements File");
            System.out.println("0 - Exit");

            System.out.println();

            switch (Utils.readIntegerFromConsole("Enter the number of the option you want to choose:")) {

                case 0:
                    exit = true;
                    break;

                case 1:
                    registerApplicationsUI.run();
                    break;

                case 2:
                    activateCandidateUI.run();
                    break;

                case 3:
                    deactivateCandidateUI.run();
                    break;

                case 4:
                    uploadRequirementsFileUI.run();
                    break;

                default:
                    System.err.println("INVALID OPTION");
                    break;
            }
        }
    }
}
