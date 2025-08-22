package candidate.RetrieveCandidatesOrderedList;


import application.ApplicationRepository;
import application.domain.Application;
import candidate.CandidateRepository;
import candidate.domain.Candidate;
import jobOpening.JobOpeningRepository;
import jobOpening.domain.JobOpening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Map;

@Component
public class RetrieveCandidatesOrderedListController {

    @Autowired
    JobOpeningRepository openingRepo;
    @Autowired
    RetrieveCandidatesOrderedListService retrieveCandidatesOrderedListService;

    @Autowired
    ApplicationRepository applicationRepository;


    public Map<Candidate, Double> retrieveCandidatesByInterviewPoints(List<Application> applications) {

        return retrieveCandidatesOrderedListService.getCandidatesOrderedList(applications);

    }

    public List<JobOpening> retrieveJobOpennings() {
        return openingRepo.findAll();
    }

    public List<Application> getApplications(Long id) {
        return applicationRepository.findApplicationsByJobOfferId(id);
    }

    public boolean checkValidApplications(List<Application> applications) {
        for (Application a : applications){
            if(a.getInterview().equals("Not Interviewed")) return true;
        }return false;
    }
}
