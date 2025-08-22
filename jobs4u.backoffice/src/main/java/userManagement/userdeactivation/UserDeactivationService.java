package userManagement.userdeactivation;

import userManagement.domain.AppUser;
import userManagement.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDeactivationService {

    @Autowired
    private UserRepository userRepository;

    public boolean deactivateUser(Long id) {
        AppUser user = userRepository.findById(id);
        user.deactivateUser();
        userRepository.updateUserStatusById(id, false);
        return true;
    }

    public boolean deactivateUserByEmail(String email) {
        AppUser user = (AppUser) userRepository.findByEmail(email);
        user.deactivateUser();
        userRepository.updateUserStatusByEmail(email, false);
        return true;
    }
}
