package candidate.file_upload;

import application.domain.Application;
import application.use_cases.upload_interv_answers.ListApplicationsForJobOpeningService;
import jobOpening.domain.JobOpening;
import jobOpening.listJobOpenings.ListJobOpeningsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UploadRequirementsFileController {

    @Autowired
    private UploadRequirementsFileService uploadRequirementsFileService;

    @Autowired
    private ListJobOpeningsService listJobOpeningsService;

    @Autowired
    private ListApplicationsForJobOpeningService listApplicationsForJobOpeningService;

    public boolean uploadRequirementsFile(String fileName) {
        return uploadRequirementsFileService.uploadRequirementsFile(fileName);
    }

    public void saveRequirementsFile(Application application, String fileName) {
        uploadRequirementsFileService.saveRequirementsFile(application, fileName);
    }

    public List<JobOpening> listJobOpenings() {
        return listJobOpeningsService.listJobOpeningInApplicationPhase();
    }

    public List<Application> listApplicationsForJobOpening(Long jobOfferID) {
        return listApplicationsForJobOpeningService.getApplicationsForJobOpening(jobOfferID);
    }
}
