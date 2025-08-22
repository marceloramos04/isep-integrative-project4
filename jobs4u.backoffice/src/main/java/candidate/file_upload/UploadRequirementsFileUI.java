package candidate.file_upload;

import application.domain.Application;
import jobOpening.domain.JobOpening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utils.Utils;

import java.util.List;

@Component
public class UploadRequirementsFileUI implements Runnable {

    @Autowired
    private UploadRequirementsFileController uploadRequirementsFileController;

    @Override
    public void run() {

        try {

            System.out.println("Uploading requirements file...");

            System.out.println("Job Openings:");
            List<JobOpening> jobOpenings = uploadRequirementsFileController.listJobOpenings();

            JobOpening selectedJobOpening = listAndChooseJobOpening(jobOpenings);

            System.out.println("Applications for Job Opening:");
            List<Application> applications = uploadRequirementsFileController.listApplicationsForJobOpening(selectedJobOpening.getId());

            Application selectedApplication = listAndChooseApplication(selectedJobOpening, applications);

            String fileName = Utils.readLineFromConsole("Enter the file path: ");

            if (uploadRequirementsFileController.uploadRequirementsFile(fileName)) {

                System.out.println("Requirements file uploaded successfully!\n");
                uploadRequirementsFileController.saveRequirementsFile(selectedApplication, fileName);

            } else {
                System.err.println("Requirements file upload failed!\nInvalid file syntax!\n");
            }

        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    private JobOpening listAndChooseJobOpening(List<JobOpening> list) {

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ". " + list.get(i).getJobTitle());
        }

        System.out.println();

        int choice = -1;

        do {
            choice = Utils.readIntegerFromConsole("Select the job opening:");
            System.out.println();

        } while (choice < 1 || choice > list.size());

        return list.get(choice - 1);
    }

    private Application listAndChooseApplication(JobOpening jobOpening, List<Application> list) {

        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d. %s - %s\n", i + 1, list.get(i).getCandidate().getName(), list.get(i).getCandidate().getEmail());
        }

        System.out.println();
        int choice = -1;

        do {
            choice = Utils.readIntegerFromConsole("Select the application: ");
            System.out.println();
        } while (choice < 1 || choice > list.size());

        return list.get(choice - 1);
    }
}
