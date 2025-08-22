package jobOpening.listJobOpenings;

import jobOpening.domain.JobOpening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ListJobOpeningController {

    @Autowired
    private ListJobOpeningsService listJobOpeningsService;

    public List<JobOpening> getJobOpenings() {
        return listJobOpeningsService.listJobOpenings();
    }
}
