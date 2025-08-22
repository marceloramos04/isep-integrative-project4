package userManagement.useractivation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import userManagement.domain.AppUser;
import userManagement.domain.Name;
import userManagement.domain.UserRole;

import static org.junit.jupiter.api.Assertions.*;

class UserActivationServiceTest {

    @Test
    @DisplayName("Ensure User Activation Succeeds")
    void ensureUserActivationSucceeds() {

        Name name = new Name("User");

        AppUser user = new AppUser(name, "user@isep.ipp.pt", "password", UserRole.ADMINISTRATOR);

        user.deactivateUser();

        assertFalse(user.isEnabled());
    }

}