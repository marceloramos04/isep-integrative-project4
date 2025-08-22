package customer.listAllJobOpenings;

import jobOpening.JobOpeningRepository;
import jobOpening.domain.JobOpening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import userManagement.domain.AppUser;

import java.util.Map;

@Component
public class ListAllJobOpeningsUI implements Runnable {

    @Autowired
    private ListAllJobOpeningsController listAllJobOpeningsController;
    private AppUser user;

    @Override
    public void run() {

        Map<JobOpening, Integer> jobOpeningList = listAllJobOpeningsController.listAllJobOpenings(user.getUsername());
        int x = 0;
        if (jobOpeningList != null || !jobOpeningList.isEmpty()) {

            System.out.println("------LIST OF ALL JOB OPENINGS------");
            //System.out.println(String.format("------BY: %d------", user.getUsername()));

            for (Map.Entry<JobOpening, Integer> entry : jobOpeningList.entrySet()) {
                JobOpening jobOpening = entry.getKey();
                Integer numberOfApplicants = entry.getValue();

                System.out.println(String.format("%d) JobOpening Number: %d\nJobOpening Title: %s\nNumber Of Applicants: %d", x + 1, jobOpening.getId(), jobOpening.getJobTitle(), numberOfApplicants));
                System.out.println("\n");

            }
            System.out.println("------LIST OF ALL JOB OPENINGS------");
        } else {
            System.out.println("There are no job openings from this Customer");
        }

    }
}
