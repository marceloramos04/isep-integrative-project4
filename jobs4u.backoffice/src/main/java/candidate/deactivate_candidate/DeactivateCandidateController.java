package candidate.deactivate_candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import userManagement.domain.AppUser;
import userManagement.userdeactivation.UserDeactivationService;

import java.util.List;

@Component
public class DeactivateCandidateController {

    @Autowired
    private UserDeactivationService userDeactivationService;

    @Autowired
    private ListActivatedCandidatesService listActivatedCandidatesService;

    public boolean deactivateCandidateByEmail(String email) {
        return userDeactivationService.deactivateUserByEmail(email);
    }

    public List<AppUser> listActivatedCandidates() {
        return listActivatedCandidatesService.listActivatedCandidates();
    }
}
