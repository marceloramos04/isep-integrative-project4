package candidate.deactivate_candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userManagement.UserRepository;
import userManagement.domain.AppUser;
import userManagement.domain.UserRole;

import java.util.List;

@Service
public class ListActivatedCandidatesService {

    @Autowired
    private UserRepository userRepository;

    public List<AppUser> listActivatedCandidates() {
        return userRepository.findAllActivatedCandidates(UserRole.CANDIDATE);
    }
}
