package jobOpening.closePhase;

import jobOpening.JobOpeningRepository;
import jobOpening.domain.JobOpening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetActiveJobOpeningsService {

    @Autowired
    private JobOpeningRepository jobOpeningRepository;

    public List<JobOpening> getActivePhases() {

        return jobOpeningRepository.findAll().stream()
                .filter(JobOpening::isActive)
                .collect(Collectors.toList());

    }

}
