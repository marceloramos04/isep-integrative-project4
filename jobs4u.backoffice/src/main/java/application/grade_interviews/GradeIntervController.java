package application.grade_interviews;


import application.ApplicationRepository;
import application.domain.Application;
import jobOpening.JobOpeningRepository;
import jobOpening.domain.JobOpening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import utils.Utils;
import utils.plugins.runners.IntervModelRunner;

import java.util.List;

@Component
public class GradeIntervController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private IntervModelRunner intervModelRunner;

    @Autowired
    private JobOpeningRepository jobOpeningRepository;

    public List<Application> getApplicationsByJobOffer(Long jobOfferId) {
        return applicationRepository.findApplicationsByJobOfferId(jobOfferId);
    }

    public JobOpening chooseJobOpening() {
        List<JobOpening> jobOpenings = jobOpeningRepository.findAll();
        if (jobOpenings.isEmpty()) {
            System.out.println("No job openings available.");
            return null;
        }

        System.out.println("Available job openings:");
        for (int i = 0; i < jobOpenings.size(); i++) {
            System.out.println((i + 1) + ". " + jobOpenings.get(i).toString());
        }

        int choice = Utils.readIntegerFromConsole("Choose a job opening: ") - 1;

        if (choice < 0 || choice >= jobOpenings.size()) {
            System.out.println("Invalid choice. Please run the program again and choose a valid number.");
            return null;
        }

        return jobOpenings.get(choice);
    }


    @Transactional
    public boolean gradeInterviewAnswers(String file, Application app) {
      double grade = intervModelRunner.evaluateFile(file);
        System.out.println(grade);

        app.uploadInterviewGrade(grade);
        return false;
    }

    @Transactional
    public void saveApplication(List<Application> apps) {
        for(Application app : apps){
        applicationRepository.save(app);
        }
    }




}
