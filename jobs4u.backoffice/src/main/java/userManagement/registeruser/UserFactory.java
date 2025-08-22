package userManagement.registeruser;

import org.springframework.stereotype.Component;
import userManagement.domain.AppUser;
import userManagement.domain.Name;
import userManagement.domain.UserRole;

@Component
public class UserFactory {

    public AppUser createUser(String name, String email, UserRole userRole, String password) {

        password = PasswordGeneratorService.hashPassword(password);

        Name nameObj = new Name(name);

        return new AppUser(nameObj, email, password, userRole);
    }
}
