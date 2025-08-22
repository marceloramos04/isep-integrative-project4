package userManagement.userdeactivation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import userManagement.domain.AppUser;
import userManagement.domain.Name;
import userManagement.domain.UserRole;

import static org.junit.jupiter.api.Assertions.*;

class UserDeactivationServiceTest {

    @Test
    @DisplayName("Ensure User Deactivation Succeeds")
    void ensureUserActivationSucceeds() {

        Name name = new Name("User");

        AppUser user = new AppUser(name, "user@isep.ipp.pt", "password", UserRole.ADMINISTRATOR);

        user.deactivateUser();

        user.activateUser();

        assertTrue(user.isEnabled());
    }

}