package userManagement.useractivation;

import userManagement.domain.AppUser;
import userManagement.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserActivationService {

    @Autowired
    private UserRepository userRepository;

    public boolean activateUser(Long id) {
        AppUser user = userRepository.findById(id);
        user.activateUser();
        userRepository.updateUserStatusById(id, true);
        return true;
    }

    public boolean activateUserByEmail(String email) {
        AppUser user = (AppUser) userRepository.findByEmail(email);
        user.activateUser();
        userRepository.updateUserStatusByEmail(email, true);
        return true;
    }
}
