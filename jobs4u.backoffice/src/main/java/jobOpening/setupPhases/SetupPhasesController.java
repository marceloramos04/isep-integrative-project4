package jobOpening.setupPhases;

import jobOpening.domain.JobOpening;
import jobOpening.JobOpeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;

@Controller
public class SetupPhasesController {

    @Autowired
    private JobOpeningRepository jobOpeningRepository;

    @Autowired
    private SetupPhasesService setupPhasesService;

    public void setupPhases(int jobOpeningIndex, LocalDate applicationDateStart, LocalDate applicationDateEnd, LocalDate screeningDateStart, LocalDate screeningDateEnd, LocalDate interviewsDateStart, LocalDate interviewsDateEnd, LocalDate analysisDateStart, LocalDate analysisDateEnd, LocalDate resultDateStart, LocalDate resultDateEnd) {
        JobOpening jobOpening = jobOpeningRepository.findAll().get(jobOpeningIndex-1);
        JobOpening jobOpening1 = setupPhasesService.setupPhases(jobOpening.getId(), applicationDateStart, applicationDateEnd, screeningDateStart, screeningDateEnd, interviewsDateStart, interviewsDateEnd, analysisDateStart, analysisDateEnd, resultDateStart, resultDateEnd);
        jobOpeningRepository.save(jobOpening1);
    }

    public List<JobOpening> getJobOpeningsToSetup() {
        return jobOpeningRepository.findAllByRecruitmentProcessIsNull();
    }

    public boolean jobOpeningExists(int jobOpeningIndex) {
        return getJobOpeningsToSetup().size() >= jobOpeningIndex && jobOpeningIndex >= 0;
    }
}
