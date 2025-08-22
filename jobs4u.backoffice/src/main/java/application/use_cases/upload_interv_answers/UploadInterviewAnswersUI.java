package application.use_cases.upload_interv_answers;

import application.domain.Application;
import eapli.framework.io.util.Console;
import jobOpening.domain.JobOpening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

@Component
public class UploadInterviewAnswersUI implements Runnable {

    @Autowired
    private UploadInterviewAnswersController ctrl;

    private JobOpening jobOpening;
    private Application app;
    private String intervAnswersFile;

    @Override
    public void run() {
        if (getJobOpening()){
            if (getApplication()){
                getAnswersFile();
                if (ctrl.registerInterviewAnswers(intervAnswersFile, app)) {
                    System.out.println("Interview answers uploaded successfully.\n");
                } else {
                    System.err.println("Invalid file.\n");
                }
            }
        }
    }

    private boolean getJobOpening() {
        List<JobOpening> jobOpeningsInIntervPhase=ctrl.getJobOpeningsInInterviewPhase();
        if (jobOpeningsInIntervPhase.isEmpty()) {
            System.err.println("There are no job openings in interview phase.\n");
            return false;
        }

        jobOpening=listAndChooseJobOpening(jobOpeningsInIntervPhase);
        return true;
    }

    private boolean getApplication() {
        List<Application> applications=ctrl.getApplicationsForJobOpening(jobOpening.getId());
        if (applications.isEmpty()) {
            System.err.println("There are no applications for the selected job opening.\n");
            return false;
        }

        app=listAndChooseApplication(jobOpening, applications);
        return true;
    }

    private void getAnswersFile() {
        boolean fileChecked=false;
        do {
            intervAnswersFile=Console.readLine("Enter the path to the file with the interview answers:");
            System.out.println();
            try {
                new Scanner(new File(intervAnswersFile));
                fileChecked=true;

            } catch (FileNotFoundException e){
                System.err.println("File not found. Please enter a valid path.");
            }

        } while (!fileChecked);
    }

    private JobOpening listAndChooseJobOpening(List<JobOpening> list) {
        System.out.println("Job Openings in Interview Phase:\n");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i+1 + ". " + list.get(i).getJobTitle());
        }
        System.out.println();

        int choice= -1;

        do {
            choice= Console.readInteger("Select the job opening:");
            System.out.println();
        } while (choice < 1 || choice > list.size());

        return list.get(choice-1);
    }

    private Application listAndChooseApplication(JobOpening jo, List<Application> list) {
        System.out.println("\nApplication for " + jo.getJobTitle() + " \n");

        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d. %s - %s\n", i+1, list.get(i).getCandidate().getName(), list.get(i).getCandidate().getEmail());
        }
        System.out.println();
        int choice= -1;

        do {
            choice= Console.readInteger("Select the job opening:");
            System.out.println();
        } while (choice < 1 || choice > list.size());

        return list.get(choice-1);
    }
}
