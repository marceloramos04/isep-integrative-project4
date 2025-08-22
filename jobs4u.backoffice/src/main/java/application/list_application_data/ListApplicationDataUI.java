package application.list_application_data;

import application.domain.Application;
import jobOpening.domain.JobOpening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utils.Utils;

import java.util.List;

@Component
public class ListApplicationDataUI implements Runnable {

    @Autowired
    private ListApplicationDataController listApplicationDataController;

    @Override
    public void run() {

        System.out.println("List of Job Openings");

        List<JobOpening> jobOpenings = listApplicationDataController.listJobOpenings();
        for (JobOpening jobOpening : jobOpenings) {
            System.out.println(jobOpening);
        }

        int input = Utils.showAndSelectIndex(jobOpenings, "Select a job opening to list applications for: \n") + 1;

        if (input == 0) {
            System.out.println("Exiting list applications...");
            return;
        }

        //=============================================================================================================

        // List Applications By Job Opening
        List<Application> applications = listApplicationDataController.findApplicationsByJobOfferID(jobOpenings.get(input - 1).getId());
        for (Application application : applications) {
            System.out.println(application);
        }

        int input2 = Utils.showAndSelectIndex(jobOpenings, "Select a job opening to list applications for: \n") + 1;

        if (input2 == 0) {
            System.out.println("Exiting list applications...");
            return;
        }

        //=============================================================================================================

        // Show Application Data
        Application application = listApplicationDataController.findApplicationByJobOfferID(jobOpenings.get(input - 1).getId());
        System.out.println("Application Data:\n");
        System.out.println(application);
    }
}
