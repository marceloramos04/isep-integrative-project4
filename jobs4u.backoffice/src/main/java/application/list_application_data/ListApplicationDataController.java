package application.list_application_data;

import application.domain.Application;
import application.listapplications.ListApplicationsService;
import jobOpening.domain.JobOpening;
import jobOpening.listJobOpenings.ListJobOpeningsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListApplicationDataController {

    @Autowired
    private ShowApplicationDataService showApplicationDataService;

    @Autowired
    private ListApplicationsService listApplicationsService;

    @Autowired
    private ListJobOpeningsService listJobOpeningsService;

    public List<JobOpening> listJobOpenings() {
        return listJobOpeningsService.listJobOpenings();
    }

    public Application findApplicationByJobOfferID(Long jobOfferId) {
        return showApplicationDataService.listApplications(jobOfferId);
    }

    public List<Application> findApplicationsByJobOfferID(Long jobOfferId) {
        return listApplicationsService.listApplications(jobOfferId);
    }

}
