package eapli.jobs4u.app.backoffice.userManagement.domain.lisUsers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import userManagement.listusers.ListUsersService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ListUsersTest {

    @Test
    @DisplayName("Ensure List Users Is Not Null")
    void ensureListUsersIsNotNull() {

        ListUsersService listUsersService = new ListUsersService();
        assertNotNull(listUsersService);
    }
}
