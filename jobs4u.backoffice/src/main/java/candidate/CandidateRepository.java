package candidate;

import candidate.domain.Candidate;
import eapli.framework.general.domain.model.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import utils.PhoneNumber;

import java.util.List;
import java.util.Optional;

@Transactional
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    @Transactional
    Candidate findById(long candidateId);

    @Transactional
    Candidate findByEmail(EmailAddress email);

    @Transactional
    Candidate findByPhoneNumber(PhoneNumber phoneNumber);

    @Transactional
    @Query("SELECT c.id FROM Candidate c WHERE c.email = :email")
    Optional<Long> findIdByEmail(@Param("email") EmailAddress email);

    boolean existsByEmail(EmailAddress email);
}