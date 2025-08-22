package candidate.ListAllCandidates;

import candidate.domain.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
 class ListAllCandidatesController {

    @Autowired
    private ListAllCandidatesService listAllCandidatesService;

    public List<Candidate> listAllCandidates() {
        return listAllCandidatesService.listAllCandidates();
    }

}
