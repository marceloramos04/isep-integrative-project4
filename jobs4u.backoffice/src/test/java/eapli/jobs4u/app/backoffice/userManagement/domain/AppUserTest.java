package eapli.jobs4u.app.backoffice.userManagement.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import userManagement.domain.AppUser;
import userManagement.domain.Name;
import userManagement.domain.UserRole;

import static org.junit.jupiter.api.Assertions.*;

class AppUserTest {

    @Test
    @DisplayName("Ensure That Created User Is Active")
    void ensureThatCreatedUserIsActive() {

        Name name = new Name("User");
        AppUser user = new AppUser(name, "user@isep.ipp.pt", "password", UserRole.ADMINISTRATOR);

        assertTrue(user.isEnabled());
    }


    @Test
    @DisplayName("Ensure User With No Name Fails")
    void ensureUserWithNoNameFails() {

        assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name("");
            AppUser user = new AppUser(name, "user@isep.ipp.pt", "password", UserRole.ADMINISTRATOR);
        });
    }

    @Test
    @DisplayName("Ensure User With No Password Fails")
    void ensureUserWithNoPasswordFails() {

        Name name = new Name("User");

        assertThrows(IllegalArgumentException.class, () -> {
            AppUser user = new AppUser(name, "user@isep.ipp.pt", "", UserRole.ADMINISTRATOR);
        });
    }

    @Test
    @DisplayName("Ensure User With No Email Fails")
    void ensureUserWithNoEmailFails() {

        Name name = new Name("User");

        assertThrows(IllegalArgumentException.class, () -> {
            AppUser user = new AppUser(name, "", "password", UserRole.ADMINISTRATOR);
        });
    }

    @Test
    @DisplayName("Ensure User With No Email Fails")
    void ensureUserWithInvalidEmailFails() {

        Name name = new Name("User");

        assertThrows(IllegalArgumentException.class, () -> {
            AppUser user = new AppUser(name, "user.com", "password", UserRole.ADMINISTRATOR);
        });
    }

    @Test
    @DisplayName("Ensure Other User Attributes Are Not Null")
    void ensureOtherUserAttributesAreNotNull() {

        Name name = new Name("User");

        AppUser user = new AppUser(name, "user@isep.ipp.pt", "password", UserRole.ADMINISTRATOR);

        assertNotNull(user.getAuthorities());
        assertNotNull(user.getUsername());
        assertNotNull(user.getPassword());
    }

    @Test
    @DisplayName("Ensure isAccountNonExpired Is True")
    void ensureIsAccountNonExpiredIsTrue() {

        Name name = new Name("User");

        AppUser user = new AppUser(name, "user@isep.ipp.pt", "password", UserRole.ADMINISTRATOR);

        assertTrue(user.isAccountNonExpired());
    }

    @Test
    @DisplayName("Ensure isAccountNonExpired Is True")
    void isAccountNonLocked() {

        Name name = new Name("User");

        AppUser user = new AppUser(name, "user@isep.ipp.pt", "password", UserRole.ADMINISTRATOR);

        assertTrue(user.isAccountNonLocked());
    }

    @Test
    @DisplayName("Ensure isCredentialsNonExpired Is True")
    void isCredentialsNonExpired() {
        Name name = new Name("User");

        AppUser user = new AppUser(name, "user@isep.ipp.pt", "password", UserRole.ADMINISTRATOR);

        assertTrue(user.isCredentialsNonExpired());
    }

}
