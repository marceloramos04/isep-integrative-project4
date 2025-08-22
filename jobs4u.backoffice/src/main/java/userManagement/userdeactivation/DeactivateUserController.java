package userManagement.userdeactivation;

import userManagement.domain.AppUser;
import userManagement.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeactivateUserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDeactivationService userDeactivationService;

    public List<AppUser> listActivatedUsers() {
        return userRepository.findAllActivatedUsers();
    }

    public boolean deactivateUser(Long id) {
        return userDeactivationService.deactivateUser(id);
    }
}
