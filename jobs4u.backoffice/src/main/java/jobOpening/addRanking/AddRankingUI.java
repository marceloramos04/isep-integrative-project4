package jobOpening.addRanking;

import application.domain.Application;
import application.listapplications.ListApplicationsForJobOfferController;
import candidate.ListCandidateData.ListCandidateDataController;
import candidate.domain.Candidate;
import eapli.framework.general.domain.model.EmailAddress;
import jobOpening.JobOpeningRepository;
import jobOpening.domain.JobOpening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utils.Utils;
import utils.domain.ranking.Ranking;

import java.util.*;

@Component
public class AddRankingUI implements Runnable {

    @Autowired
    private AddRankingController addRankingController;

    @Autowired
    private ListCandidateDataController candidateDataController;

    @Autowired
    private ListApplicationsForJobOfferController listApplicationsForJobOfferController;

    private final List<String> candidatesEmails = new ArrayList<>();


    public void run() {

        long jobOpeningId = Utils.readLongFromConsole("Enter the job opening ID: ");
        JobOpening jobOpening = addRankingController.getJobOpeningById(jobOpeningId);
        System.out.println("Num of vacancies :" + jobOpening.getNumberVacancies());

        int extra = Utils.readIntegerFromConsole("Enter the number of extra candidates to be ranked besides the number of vancacies: ");

        if(extra < 0){
            System.out.println("The number of extra candidates cannot be negative. Please try again.");
            return;
        }

        List<Application> apps = listApplicationsForJobOfferController.findApplicationsByJobOfferID(jobOpeningId);
        int appsSize = apps.size();
        int numVac = jobOpening.getNumberVacancies().getNumber();
        int numToBeRanked = numVac + extra;
        if(numToBeRanked > appsSize){
            System.out.println("Not enough applications to this job offer to rank that many candidates. Please try again.");
            return;
        }
        System.out.println("Number of candidates to be ranked: " + numToBeRanked);


        boolean validInput;
        do {
            validInput = true;
            candidatesEmails.clear();
            String emailsInput = Utils.readLineFromConsole("Enter the emails of the candidates to be ranked, separated by a comma: ");
            String[] emails = emailsInput.split(",");
            for(String email : emails){
                if(candidatesEmails.contains(email)){
                    System.out.println("Email address " + email + " duplicated. Please enter a different email.");
                    validInput = false;
                    break;
                }
                Long cId = candidateDataController.getCandidateIdByEmail(EmailAddress.valueOf(email));
                if(!addRankingController.candidateHasAppToJob(cId,jobOpeningId)){
                    System.out.println("Candidate with email " + email + " not found or has no application to this job offer. Please enter a valid email.");
                    validInput = false;
                    break;
                }
                candidatesEmails.add(email);
            }
            if(validInput && numToBeRanked != candidatesEmails.size()){
                System.out.println("The number of emails entered does not match the number of candidates to be ranked. Please try again.");
                validInput = false;
            }
        } while(!validInput);

        List<String> ranksAdded = new ArrayList<>();
        for(String email : candidatesEmails){
            String rank;
            Candidate c = candidateDataController.listCandidateDataByEmail(EmailAddress.valueOf(email));
            while (true) {
                rank = Utils.readLineFromConsole("Enter the ranking for the candidate with email " + email + "(1 means the highest etc...)");
                if(ranksAdded.contains(rank)){
                    System.out.println("Rank already added. Please enter a different rank.");
                    continue;
                }
                try {
                    addRankingController.addRanking(jobOpening, c, rank, numToBeRanked);
                    ranksAdded.add(rank);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        for(Application app : apps){
            Candidate c = app.getCandidate();
            String email = c.getEmail().toString();
            if(!candidatesEmails.contains(email)){
                addRankingController.addRanking(jobOpening, c, "rank not recorded");
            }
        }

        addRankingController.saveJobOpening(jobOpening);

        System.out.println(jobOpening);

        System.out.println("Rankings added successfully!");
    }
}
