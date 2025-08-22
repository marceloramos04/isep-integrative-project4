package userManagement.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    @DisplayName("Ensure Name With No Name Fails")
    void ensureNameWithNoNameFails() {
        assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name("");
        });
    }

    @Test
    @DisplayName("Ensure Null Name Fails")
    void ensureNullNameFails() {
        assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name(null);
        });
    }

    @Test
    @DisplayName("Ensure Name With Invalid Name Fails")
    void ensureNameWithInvalidNameFails() {
        assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name("123");
        });
    }

    @Test
    @DisplayName("Ensure Name With Invalid Name Fails")
    void ensureNameWithInvalidNameFails2() {
        assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name("Clor3");
        });
    }

    @Test
    @DisplayName("Ensure Name With Valid Name Succeeds")
    void ensureNameWithValidNameSucceeds() {
        Name name = new Name("User");
        assertEquals("User", name.toString());
    }

}