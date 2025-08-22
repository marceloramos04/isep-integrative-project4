package application.listapplications;

import application.domain.Application;
import application.ApplicationRepository;
import jobOpening.JobOpeningRepository;
import jobOpening.domain.JobOpening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListApplicationsForJobOfferController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ListApplicationsService applicationService;

    @Autowired
    private JobOpeningRepository jobOpeningRepository;

    public List<JobOpening> listJobOpenings() {
        return jobOpeningRepository.findAll();
    }

    public List<Application> findApplicationsByCandidateID(Long candidateID) {
        return applicationRepository.findApplicationsByCandidateId(candidateID);
    }

    public List<Application> findApplicationsByJobOfferID(Long jobOfferID) {
        return applicationService.listApplications(jobOfferID);
    }
}
