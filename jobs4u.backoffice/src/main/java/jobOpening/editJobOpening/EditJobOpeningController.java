package jobOpening.editJobOpening;

import jobOpening.JobOpeningRepository;
import jobOpening.domain.JobOpening;
import jobOpening.setupPhases.SetupPhasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;

@Controller
public class EditJobOpeningController {

    @Autowired
    private JobOpeningRepository jobOpeningRepository;

    @Autowired
    private EditJobOpeningService editJobOpeningService;

    @Autowired
    private SetupPhasesService setupPhasesService;

    public List<JobOpening> listAllJobOpenings() {
        return jobOpeningRepository.findAll();
    }

    public boolean editJobTitle(String s, int index) {

        return editJobOpeningService.editJobTitle(s, listAllJobOpenings().get(index).getId());

    }

    public boolean editJobType(String s, int index) {
        return editJobOpeningService.editJobType(s, listAllJobOpenings().get(index).getId());
    }

    public boolean editWorkingMode(String s, int index) {
        return editJobOpeningService.editWorkingMode(s, listAllJobOpenings().get(index).getId());
    }

    public void editAddress(String city, String street, String zipcode, int buildingNumber, int index) {
        editJobOpeningService.editAddress(city, street, zipcode, buildingNumber, listAllJobOpenings().get(index).getId());
    }

    public boolean editCompanyName(String s, int index) {
        return editJobOpeningService.editCompanyName(s, listAllJobOpenings().get(index).getId());
    }

    public boolean editNumberVacancies(int i, int index) {
        return editJobOpeningService.editNumberVacancies(i, listAllJobOpenings().get(index).getId());
    }

    public boolean editJobDescription(String s, int index) {
        return editJobOpeningService.editJobDescription(s, listAllJobOpenings().get(index).getId());
    }

    public void editRecruitmentProcess(LocalDate applicationStart, LocalDate applicationEnd, LocalDate screeningStart, LocalDate screeningEnd, LocalDate interviewsStart, LocalDate interviewsEnd, LocalDate analysisStart, LocalDate analysisEnd, LocalDate resultsStart, LocalDate resultsEnd, int index) {
        jobOpeningRepository.save(setupPhasesService.setupPhases(listAllJobOpenings().get(index).getId(), applicationStart, applicationEnd, screeningStart, screeningEnd, interviewsStart, interviewsEnd, analysisStart, analysisEnd, resultsStart, resultsEnd));
    }
}
