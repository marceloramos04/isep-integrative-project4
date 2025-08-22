package jobOpening.addRanking;

import application.ApplicationRepository;
import application.domain.Application;
import candidate.domain.Candidate;
import eapli.framework.general.domain.model.EmailAddress;
import jobOpening.domain.JobOpening;
import jobOpening.JobOpeningRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import utils.domain.ranking.Ranking;

import java.util.*;

@Component
public class AddRankingController {

    @Autowired
    private JobOpeningRepository jobOpeningRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Transactional
    public void addRanking(JobOpening jobOpening, Candidate candidate, String rank, int numToBeRanked) {
        Ranking ranking = new Ranking(candidate.getId(), jobOpening.getId(), rank,numToBeRanked);
        jobOpening.addRanking(ranking);
    }

    @Transactional
    public void addRanking(JobOpening jobOpening, Candidate candidate, String rank) {
        Ranking ranking = new Ranking(candidate.getId(), jobOpening.getId(), rank);
        jobOpening.addRanking(ranking);

    }

    @Transactional
    public void saveJobOpening(JobOpening jobOpening) {
        jobOpeningRepository.save(jobOpening);
    }

    public boolean candidateHasAppToJob(Long candidateId,Long jobOfferId) {

        Optional<Application> app = applicationRepository.findByJobOfferIdAndCandidateId(jobOfferId, candidateId);

        if(app.isEmpty()){
            return false;
        }
        return true;
    }

    public JobOpening getJobOpeningById(Long jobOpeningId) {
        return jobOpeningRepository.findById(jobOpeningId)
                .orElseThrow(() -> new IllegalArgumentException("Job Opening not found"));
    }
}
