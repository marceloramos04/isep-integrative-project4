package jobOpening.requirementVerification;

import jobOpening.domain.JobOpening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Component
public class VerificationRequirementsController {

    @Autowired
    private GetJobOpeningsOnScreeningPhaseService getJobOpeningsWithApplicationsService;

    @Autowired
    private VerifyRequirementsService verifyRequirementsService;

    public List<JobOpening> getJobOpeningsOnScreeningPhase() {
        return getJobOpeningsWithApplicationsService.GetJobOpeningsOnScreeningPhase();
    }

    public JobOpening getJobOpening(int index) {
        return getJobOpeningsOnScreeningPhase().get(index);
    }

    public void verifyRequirements(int input) {
        verifyRequirementsService.verifyRequirements(getJobOpening(input).getId());
    }
}
