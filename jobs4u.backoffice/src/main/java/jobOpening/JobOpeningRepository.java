package jobOpening;

import jobOpening.domain.JobOpening;
import jobOpening.domain.jobOpeningAttributes.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface JobOpeningRepository extends JpaRepository<JobOpening, Long> {

    @Transactional
    JobOpening findById(long id);

    @Transactional
    List<JobOpening> findAllByRecruitmentProcessIsNull();

    /*@Transactional
    @Query("select j from JobOpening j where j.recruitmentProcess.activePhase = 'Application phase'")
    List<JobOpening> findAllByRecruitmentProcessActivePhase();*/

    @Transactional
    List<JobOpening> findAllByIdIn(List<Long> ids);

    List<JobOpening> findByCompanyName(String companyName);

    @Query ("select j from JobOpening j where current date between j.recruitmentProcess.interviewPhase.start and j.recruitmentProcess.interviewPhase.end")
    List<JobOpening> getJobOpeningsInInterviewPhase();

    boolean existsByJobTitle(JobTitle jobTitle);
    JobOpening findByJobTitle(JobTitle jobTitle);

    @Query ("select j from JobOpening j where current date between j.recruitmentProcess.applicationPhase.start and j.recruitmentProcess.applicationPhase.end")
    List<JobOpening> getJobOpeningsInApplicationPhase();
}
