package application.list_application_data;

import application.ApplicationRepository;
import application.domain.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShowApplicationDataService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public Application listApplications(Long jobOfferId) {

        List<Application> applications = applicationRepository.findApplicationsByJobOfferId(jobOfferId);

        return applications.get(0);
    }
}
