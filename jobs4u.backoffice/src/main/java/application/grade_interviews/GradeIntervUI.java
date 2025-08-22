package application.grade_interviews;

import application.domain.Application;
import jobOpening.JobOpeningRepository;
import jobOpening.domain.JobOpening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class GradeIntervUI implements  Runnable{


    @Autowired
    private GradeIntervController gradeIntervController;

    @Autowired
    private JobOpeningRepository jobOpeningRepository;

    @Override
    public void run() {

        JobOpening chosenJobOpening = gradeIntervController.chooseJobOpening();
        if (chosenJobOpening == null) {
            return;
        }

        Long jobId = chosenJobOpening.getId();
        List<Application> appsToBeGraded = gradeIntervController.getApplicationsByJobOffer(jobId);
        List <Application> appsGraded = new ArrayList<>();

        if (appsToBeGraded.isEmpty()) {
            System.out.println("No applications available for this job opening.");
            return;
        }

        for(Application app : appsToBeGraded){
            if(app.getInterview().getIntervAnswersFile() != null) {
                gradeIntervController.gradeInterviewAnswers(app.getInterview().getIntervAnswersFile(), app);
                appsGraded.add(app);
            }

        gradeIntervController.saveApplication(appsGraded);
        }

        System.out.println("Applications graded successfully.");
    }
}
