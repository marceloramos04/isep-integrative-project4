package application.use_cases.upload_interv_answers;

import application.ApplicationRepository;
import application.domain.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListApplicationsForJobOpeningService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public List<Application> getApplicationsForJobOpening(Long jobOfferID) {
        return applicationRepository.findApplicationsByJobOfferId(jobOfferID);
    }

}
