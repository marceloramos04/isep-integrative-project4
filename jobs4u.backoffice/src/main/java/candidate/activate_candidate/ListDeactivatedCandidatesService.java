package candidate.activate_candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userManagement.UserRepository;
import userManagement.domain.AppUser;
import userManagement.domain.UserRole;

import java.util.List;

@Service
public class ListDeactivatedCandidatesService {

    @Autowired
    private UserRepository userRepository;

    public List<AppUser> listDeactivatedCandidates() {
        return userRepository.findAllDeactivatedCandidates(UserRole.CANDIDATE);
    }
}
