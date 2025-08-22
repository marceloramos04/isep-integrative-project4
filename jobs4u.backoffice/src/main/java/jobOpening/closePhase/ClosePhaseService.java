package jobOpening.closePhase;

import jobOpening.JobOpeningRepository;
import jobOpening.domain.JobOpening;
import jobOpening.domain.jobOpeningAttributes.RecruitmentProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClosePhaseService {

    @Autowired
    private JobOpeningRepository jobOpeningRepository;

    public String closePhase(long jobOpeningIndex) {
        JobOpening jobOpening = jobOpeningRepository.findById(jobOpeningIndex);
        String result = jobOpening.closeActivePhase();
        jobOpeningRepository.save(jobOpening);
        return result;
    }

}
