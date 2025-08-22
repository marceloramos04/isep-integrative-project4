package application.use_cases.upload_interv_answers;

import application.ApplicationManagementService;
import application.ApplicationRepository;
import application.domain.Application;
import jobOpening.JobOpeningRepository;
import jobOpening.domain.JobOpening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UploadInterviewAnswersController {

    @Autowired
    private JobOpeningRepository jobOpeningRepo;

    @Autowired
    private ApplicationRepository applicationRepo;

    @Autowired
    private ApplicationManagementService applicationManagementServ;

    public List<JobOpening> getJobOpeningsInInterviewPhase(){
        return jobOpeningRepo.getJobOpeningsInInterviewPhase();
    }

    public List<Application> getApplicationsForJobOpening(Long jobOfferID){
        return applicationRepo.findApplicationsByJobOfferId(jobOfferID);
    }

    public boolean registerInterviewAnswers(String file, Application app){
        return applicationManagementServ.uploadInterviewAnswers(file, app);
    }
}
