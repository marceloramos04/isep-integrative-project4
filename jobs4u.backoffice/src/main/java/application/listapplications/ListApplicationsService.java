package application.listapplications;

import application.ApplicationRepository;
import application.domain.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ListApplicationsService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @GetMapping
    public List<Application> listApplications(Long jobOfferId) {
        return applicationRepository.findApplicationsByJobOfferId(jobOfferId);
    }
}
