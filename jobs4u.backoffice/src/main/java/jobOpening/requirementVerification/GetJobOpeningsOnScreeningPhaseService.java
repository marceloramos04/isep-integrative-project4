package jobOpening.requirementVerification;

import application.ApplicationRepository;
import jobOpening.JobOpeningRepository;
import jobOpening.domain.JobOpening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetJobOpeningsOnScreeningPhaseService {

    @Autowired
    private JobOpeningRepository jobOpeningRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    List<JobOpening> GetJobOpeningsOnScreeningPhase() {
        return jobOpeningRepository.findAll().stream()
                .filter(jobOpening -> "Screening phase".equalsIgnoreCase(jobOpening.activePhase()))
                .collect(Collectors.toList());
    }
}
