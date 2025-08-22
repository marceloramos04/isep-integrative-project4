package candidate.file_upload;

import application.ApplicationRepository;
import application.domain.Application;
import application.domain.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.plugins.runners.RequiremSpecsRunner;

@Service
public class UploadRequirementsFileService {

    @Autowired
    private RequiremSpecsRunner pluginRunner;

    @Autowired
    private ApplicationRepository applicationRepository;

    public boolean uploadRequirementsFile(String inputFileName) {

        return pluginRunner.validateFileSyntax(inputFileName);
    }

    public void saveRequirementsFile(Application application, String fileName) {

        File file = new File(fileName);
        applicationRepository.updateFilePathById(application.getId(), file);
    }
}
