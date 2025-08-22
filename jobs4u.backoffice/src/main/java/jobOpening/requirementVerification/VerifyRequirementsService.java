package jobOpening.requirementVerification;

import application.ApplicationRepository;
import application.domain.Application;
import application.domain.ScreeningResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.plugins.runners.RequiremSpecsRunner;

import java.util.List;

@Service
public class VerifyRequirementsService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private RequiremSpecsRunner requiremSpecsRunner;


    public void verifyRequirements(Long id) {
        List<Application> applications = applicationRepository.findAllByJobOfferId(id);

        for (Application application : applications) {
            if (requiremSpecsRunner.evaluateFile(application.getRequirementsFile().getFilePath())) {
                application.setScreeningResult(ScreeningResult.ACCEPTED);
                applicationRepository.save(application);
            } else {
                application.setScreeningResult(ScreeningResult.REJECTED);
                applicationRepository.save(application);
            }
        }


    }



}
