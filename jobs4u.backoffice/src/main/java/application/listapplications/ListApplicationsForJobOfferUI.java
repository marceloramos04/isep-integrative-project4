package application.listapplications;

import application.domain.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utils.Utils;

import java.util.List;

@Component
public class ListApplicationsForJobOfferUI implements Runnable {

    @Autowired
    private ListApplicationsForJobOfferController controller;

    @Override
    public void run() {

        try {

            System.out.println(controller.listJobOpenings());

            long id = Utils.readLongFromConsole("INSERT JOB OFFER TO LIST APPLICATIONS");

            System.out.println(" ==== List of Application for the Job Offer ====");

            List<Application> applications = controller.findApplicationsByJobOfferID(id);

            for (Application application : applications) {
                System.out.print(application.toString());
            }
            System.out.println("==== END OF THE LIST ====");

        } catch (Exception e) {

            System.out.println("ERROR" + e.getMessage());
        }
    }
}
