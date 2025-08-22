package application.register_applications;

import candidate.CandidateRepository;
import eapli.framework.strings.util.StringPredicates;
import jobOpening.JobOpeningRepository;
import jobOpening.domain.JobOpening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import application.ApplicationManagementService;

import java.util.Collections;
import java.util.List;

@Component
public class RegisterApplicationController {

    @Autowired
    private JobOpeningRepository jobOpeningRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private ApplicationManagementService applicationService;

    /*protected List<JobOpening> getActiveJobOffers(){

        return jobOpeningRepository.findAllByRecruitmentProcessActivePhase();
    }*/

    public boolean checkEmailFormat(String email){
        return StringPredicates.isEmail(email);
    }

    /*protected boolean isThereCandidate(String email){
        return candidateRepository.existsCandidateByEmail(email);
    }

    public boolean registerApplication(String candidateEmail, JobOpening jobOpening, String filesDirectory){
        Candidate candidate=candidateRepository.findByEmail(candidateEmail);
        return applicationService.registerApplication(candidate, jobOpening, filesDirectory);
    }*/
}
