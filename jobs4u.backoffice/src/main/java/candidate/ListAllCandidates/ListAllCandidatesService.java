package candidate.ListAllCandidates;

import candidate.CandidateRepository;
import candidate.domain.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
 class ListAllCandidatesService {

    @Autowired
    CandidateRepository candidateRepository;

    public List<Candidate> listAllCandidates() {
        return candidateRepository.findAll();
    }
}
