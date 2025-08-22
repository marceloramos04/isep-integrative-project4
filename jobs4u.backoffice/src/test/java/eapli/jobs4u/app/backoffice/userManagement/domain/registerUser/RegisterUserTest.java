package eapli.jobs4u.app.backoffice.userManagement.domain.registerUser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import userManagement.UserRepository;
import userManagement.domain.UserRole;
import userManagement.registeruser.PasswordGeneratorService;
import userManagement.registeruser.UserFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

public class RegisterUserTest {
    @Mock
    private UserFactory factory;

    @Test
    @DisplayName("Ensure Register User Without Name Fails")
    void ensureRegisterUserWithoutNameFails() {

        assertThrows(NullPointerException.class, () -> {
            factory.createUser("", "user1@isep.ipp.pt", UserRole.ADMINISTRATOR,"123");
        });
    }

    @Test
    @DisplayName("Ensure Register User Without Email Fails")
    void ensureRegisterUserWithoutEmailFails() {

        assertThrows(NullPointerException.class, () -> {
            factory.createUser("User1", "", UserRole.ADMINISTRATOR,"123");
        });
    }

    @Test
    @DisplayName("Ensure Register User Invalid Email Fails")
    void ensureRegisterUserInvalidEmailFails() {

        assertThrows(NullPointerException.class, () -> {
            factory.createUser("User1", "user.isep.ipp.pt", UserRole.ADMINISTRATOR,"123");
        });
    }
}
