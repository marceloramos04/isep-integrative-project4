package candidate.activate_candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import userManagement.domain.AppUser;
import userManagement.useractivation.UserActivationService;

import java.util.List;

@Component
public class ActivateCandidateController {

    @Autowired
    private UserActivationService userActivationService;

    @Autowired
    private ListDeactivatedCandidatesService listDeactivatedCandidatesService;

    public boolean activateCandidateByEmail(String email) {
        return userActivationService.activateUserByEmail(email);
    }

    public List<AppUser> listDeactivatedCandidates() {
        return listDeactivatedCandidatesService.listDeactivatedCandidates();
    }
}
