package customer.listAllJobOpenings;

import application.ApplicationRepository;
import application.domain.Application;
import eapli.framework.general.domain.model.EmailAddress;
import jobOpening.JobOpeningRepository;
import jobOpening.domain.JobOpening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ListAllJobOpeningsController {

    @Autowired
    private JobOpeningRepository jobOpeningRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    private List<JobOpening> jobOpenings;

    public Map<JobOpening, Integer> listAllJobOpenings(String companyName) {

        jobOpenings = jobOpeningRepository.findByCompanyName(companyName);

        Map<JobOpening, Integer> jobOpeningAndNumberOfApplicants = new HashMap<>();
        List<Application> applications;

        if (!jobOpenings.isEmpty() || jobOpenings != null) {

            for (JobOpening jobOpening : jobOpenings) {

                applications = applicationRepository.findApplicationsByJobOfferId(jobOpening.getId());

                if (applications == null || applications.isEmpty()) {

                    jobOpeningAndNumberOfApplicants.put(jobOpening, 0);

                } else {

                    jobOpeningAndNumberOfApplicants.put(jobOpening, applications.size());
                }

            }

        }

        return jobOpeningAndNumberOfApplicants;
    }
}
