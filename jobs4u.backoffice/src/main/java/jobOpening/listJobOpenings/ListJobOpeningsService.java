package jobOpening.listJobOpenings;

import jobOpening.JobOpeningRepository;
import jobOpening.domain.JobOpening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListJobOpeningsService {

    @Autowired
    private JobOpeningRepository jobOpeningRepository;

    public List<JobOpening> listJobOpenings() {
        return jobOpeningRepository.findAll();
    }

    public List<JobOpening> listJobOpeningInApplicationPhase() {
        return jobOpeningRepository.getJobOpeningsInApplicationPhase();
    }
}
