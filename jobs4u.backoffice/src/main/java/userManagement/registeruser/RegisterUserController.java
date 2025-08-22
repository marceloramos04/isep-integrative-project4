package userManagement.registeruser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import userManagement.UserRepository;
import userManagement.domain.AppUser;
import userManagement.domain.UserRole;

import java.util.Arrays;
import java.util.List;

@Component
public class RegisterUserController {

    @Autowired
    private UserFactory userFactory;

    @Autowired
    private UserRepository userRepository;

    public void registerUser(String name, String email, UserRole userRole,String password) {

        AppUser newUser = userFactory.createUser(name, email, userRole,password);
        userRepository.save(newUser);
    }

    public List<UserRole> getRolesAsList() {
        return Arrays.asList(UserRole.values());
    }

}
