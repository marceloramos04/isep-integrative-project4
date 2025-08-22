package jobOpening.closePhase;

import jobOpening.JobOpeningRepository;
import jobOpening.domain.JobOpening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ClosePhaseController {

    @Autowired
    private JobOpeningRepository jobOpeningRepository;

    @Autowired
    private GetActiveJobOpeningsService getActiveJobOpeningsService;

    @Autowired
    private ClosePhaseService closePhaseService;

    public List<JobOpening> getJobOpeningsWithActivePhases() {
        return getActiveJobOpeningsService.getActivePhases();
    }

    public boolean jobOpeningExists(int input) {
        return getJobOpeningsWithActivePhases().size()>=input && input>0;
    }

    public String closePhase(int input) {
        return closePhaseService.closePhase(getJobOpeningsWithActivePhases().get(input-1).getId());
    }



}
