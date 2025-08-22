package application;

import application.domain.Application;
import application.domain.File;
import candidate.domain.Candidate;
import jakarta.transaction.Transactional;
import jobOpening.domain.JobOpening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    @Transactional
    List<Application> findApplicationsByJobOfferId(Long jobOfferId);

    @Transactional
    List<Application> findApplicationsByCandidateId(Long candidateId);

    @Transactional
    Optional<Application> findByJobOfferIdAndCandidateId(Long jobOfferId, Long candidateId);

    @Transactional
    List<Application> findAllByJobOfferId(Long id);

    boolean existsByJobOfferAndCandidate(JobOpening jobOffer, Candidate candidate);

    Application findByJobOfferAndCandidate(JobOpening jobOffer, Candidate candidate);


    @Modifying
    @Transactional
    @Query("update Application a set a.requirementsFile = :requirementsFile where a.id = :id")
    void updateFilePathById(@Param("id") Long id, @Param("requirementsFile") File filePath);
}
