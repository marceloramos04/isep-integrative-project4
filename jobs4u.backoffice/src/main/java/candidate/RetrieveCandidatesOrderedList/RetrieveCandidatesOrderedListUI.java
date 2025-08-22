package candidate.RetrieveCandidatesOrderedList;

import application.domain.Application;
import candidate.domain.Candidate;
import jobOpening.JobOpeningRepository;
import jobOpening.domain.JobOpening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utils.Utils;

import java.util.List;
import java.util.Map;

@Component
public class RetrieveCandidatesOrderedListUI implements Runnable {

    @Autowired
    private RetrieveCandidatesOrderedListController registerCandidateController;
    private Map<Candidate, Double> candidatesAndTheirInterviewPoints;

    @Autowired
    private RetrieveCandidatesOrderedListController retrieveCandidatesOrderedListController;


    private List<JobOpening> jobOpennings;
    private Long id;

    @Override
    public void run() {

        jobOpennings = retrieveCandidatesOrderedListController.retrieveJobOpennings();
        if (jobOpennings.isEmpty()) {
            System.out.println("Sorry, but there are no job opennings registered yet");
        } else {
            System.out.println("-----ORDERED LIST OF CANDIDATES-----");
            System.out.println("-------BY INTERVIEW POINTS-------");

            for (JobOpening jobOpening : jobOpennings) {
                System.out.println(jobOpening.getId());
                System.out.println(String.format("%d: %s", jobOpening.getId(), jobOpening.getJobTitle()));
            }

            System.out.println();

            int answer = Utils.readIntegerFromConsole("Choose the job opening you wish to retrieve its ordered list of candidates:");
            Long id = (long) answer;
            List<Application> applications = retrieveCandidatesOrderedListController.getApplications(id);

            if (!applications.isEmpty() && applications != null) {

                if (retrieveCandidatesOrderedListController.checkValidApplications(applications)) {

                    candidatesAndTheirInterviewPoints = retrieveCandidatesOrderedListController.retrieveCandidatesByInterviewPoints(applications);
                    if (candidatesAndTheirInterviewPoints.isEmpty() || candidatesAndTheirInterviewPoints == null) {
                        System.out.println("Something went wrong and we weren´t able to obtain the list\nCheck if there are any applications registered for such job opening");
                    } else {
                        System.out.println(candidatesAndTheirInterviewPoints);
                    }
                } else {
                    System.out.println("There are no Applications with pre-conducted Interviews");
                }

            } else {
                System.out.println("There are no applications registered for this job opening");

            }
        }
    }
}
