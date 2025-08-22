package candidate.scheduleCandidateInterview;

import application.ApplicationRepository;
import application.domain.Application;
import application.domain.Interview;
import application.domain.InterviewStatus;
import candidate.CandidateRepository;
import candidate.domain.Candidate;
import eapli.framework.general.domain.model.EmailAddress;
import jobOpening.JobOpeningRepository;
import jobOpening.domain.JobOpening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class ScheduleInterviewController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobOpeningRepository jobOpeningRepository;

    public Optional<Application> getApplicationById(Long id) {
        System.out.println(id);
        return applicationRepository.findById(id);
    }

    public List<Application> getApplicationsByCandidateId(Long id) {
      return applicationRepository.findApplicationsByCandidateId(id);
    }

    public Interview createInterview(LocalDateTime intData, LocalDate endDate, InterviewStatus interviewStatus) {
        return new Interview(intData,endDate,interviewStatus);
    }

    public Candidate getCandidateIdByEmail(EmailAddress email) {
       return candidateRepository.findByEmail(email);
    }

    public List<JobOpening> getJobOpenings(List<Long> jobIds) {
        return jobOpeningRepository.findAllByIdIn(jobIds);
    }

    @Transactional
    public void saveApplication(Application application,Interview interview) {
        application.setInterview(interview);
        applicationRepository.save(application);
    }




}
