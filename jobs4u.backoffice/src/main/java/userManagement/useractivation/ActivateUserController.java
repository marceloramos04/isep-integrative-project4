package userManagement.useractivation;

import userManagement.domain.AppUser;
import userManagement.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ActivateUserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserActivationService userActivationService;

    public List<AppUser> listDeactivatedUsers() {
        return userRepository.findAllDeactivatedUsers();
    }

    public boolean activateUser(Long id) {
        return userActivationService.activateUser(id);
    }
}
