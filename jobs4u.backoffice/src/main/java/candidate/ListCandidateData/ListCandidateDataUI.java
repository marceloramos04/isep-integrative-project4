package candidate.ListCandidateData;

import application.domain.Application;
import application.domain.File;
import application.listapplications.ListApplicationsForJobOfferController;
import candidate.countTopNWords.TopNWordCountController;
import candidate.countTopNWords.Word;
import candidate.domain.Candidate;
import eapli.framework.general.domain.model.EmailAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utils.Utils;

import java.sql.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ListCandidateDataUI implements Runnable {

    @Autowired
    private ListCandidateDataController candidateDataController;

    @Autowired
    private TopNWordCountController topNWordCountController;

    @Autowired
    private ListApplicationsForJobOfferController listApplicationsForJobOfferController;
//    @Autowired
//    private TopN

    List<String> files = new ArrayList<>();

    @Override
    public void run() {

        Candidate candidate = listAndGetCandidate();
        System.out.println();

        System.out.println("Candidate details:\n");
        System.out.println("Name: " + candidate.getName());
        System.out.println("Phone Number: " + candidate.getPhoneNumber());
        System.out.println("Email: " + candidate.getEmail());
        System.out.println("\n-------------------------\n");
//        String format = "| %-15s | %-15s | %-30s %n";
//        System.out.printf(format, "Name", "Phone Number", "Email");
//        System.out.printf(format, candidate.getName(), candidate.getPhoneNumber(), candidate.getEmail());

        List<Application> applications = listApplicationsForJobOfferController.findApplicationsByCandidateID(candidate.getId());

        System.out.println("Candidate Applications:\n");

        if (applications.isEmpty()) {
            System.out.println("No applications found for this candidate.");
            return;
        }

        for (Application application : applications) {
            for (File file : application.getFile()) {
                files.add(file.getFilePath());
            }

            System.out.println("Job Reference = " + application.getJobOffer().getReference());
            System.out.println("Screening result = " + application.getScreeningResult().getValue());
            System.out.println("Interview Status = " + application.getInterview().getStatus());
            LocalDateTime dateTime=application.getInterview().getInterviewDateTime();
            System.out.println("Interview schedule = " + dateTime.toLocalDate().toString() + ", " + String.format("%s:%s", dateTime.getHour(), dateTime.getMinute()));
            System.out.println("Interview score = " + application.getInterview().getInterviewResult());
            System.out.println();
        }

        if (files.isEmpty()) {
            System.out.println("No files found for this candidate's applications.");

        } else {
            try {
                List<Word> sortedWords = topNWordCountController.retrieveTop20Words(files);

                System.out.println("TOP 20 WORD COUNT:");

                if (sortedWords.size() >= 20) {
                    for (int i = 0; i < 20; ++i) {
                        System.out.println("-------------------------");
                        System.out.println("" + (i + 1) + ") WORD: " + ((Word) sortedWords.get(i)).getWord() + "\nWas mentioned: " + ((Word) sortedWords.get(i)).getCount() + " times\nMentioned in files: " + sortedWords.get(i).getFiles());

                    }

                } else {
                    for (int i = 0; i < sortedWords.size(); ++i) {
                        System.out.println("-------------------------");
                        System.out.println("" + (i + 1) + ") WORD: " + ((Word) sortedWords.get(i)).getWord() + "\nWas mentioned: " + ((Word) sortedWords.get(i)).getCount() + " times\nMentioned in files: " + sortedWords.get(i).getFiles());

                    }
                }

                System.out.println("-------------------------\n");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Candidate listAndGetCandidate() {
        List<Candidate> candidates = candidateDataController.getAllCandidates();
        if (candidates.isEmpty()) {
            System.out.println("No candidates found\n");
            return null;
        }

        System.out.println("Candidates:\n");

        for (int i = 0; i < candidates.size(); i++) {
            System.out.printf("%d. %s - %s\n", i + 1, candidates.get(i).getName(), candidates.get(i).getEmail());
        }
        System.out.println();

        int choice = -1;
        do {
            choice = Utils.readIntegerFromConsole1("Select the candidate:");
        } while (choice < 1 || choice > candidates.size());
        System.out.println();

        return candidates.get(choice - 1);
    }
}