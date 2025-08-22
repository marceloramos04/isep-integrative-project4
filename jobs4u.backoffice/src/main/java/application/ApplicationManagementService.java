package application;

import application.domain.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utils.plugins.runners.IntervModelRunner;

@Component
public class ApplicationManagementService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private IntervModelRunner intervModelRunner;

    @Transactional
    public boolean uploadInterviewAnswers(String file, Application app) {
        if (!(intervModelRunner.validateFileSyntax(file))){
            return false;
        }

        app.uploadInterviewAnswers(file);
        applicationRepository.save(app);
        return true;
    }
}
