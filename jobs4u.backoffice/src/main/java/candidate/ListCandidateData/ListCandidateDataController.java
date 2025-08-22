package candidate.ListCandidateData;

import candidate.CandidateRepository;
import candidate.domain.Candidate;
import eapli.framework.general.domain.model.EmailAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ListCandidateDataController {

    @Autowired
    private CandidateRepository candidateRepository;

    public Candidate listCandidateData(int id) {
        return candidateRepository.findById(id);
    }

    public Candidate listCandidateDataByEmail(EmailAddress email) {
        return candidateRepository.findByEmail(email);
    }

    public Long getCandidateIdByEmail(EmailAddress email) {
        Optional<Long> id = candidateRepository.findIdByEmail(email);
        if(id.isEmpty()){
            throw new IllegalArgumentException("Candidate not found");
        }
        return id.get();
    }

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

}
