package candidate.domain;

import eapli.framework.general.domain.model.EmailAddress;
import org.junit.jupiter.api.Test;
import userManagement.domain.Name;
import utils.PhoneNumber;

import static org.junit.jupiter.api.Assertions.*;

class CandidateTest {

    @Test
    void shouldCreateCandidateWithValidData() {
        Name validName = new Name("John Doe");
        PhoneNumber validPhoneNumber = new PhoneNumber("123456789");
        EmailAddress validEmail = EmailAddress.valueOf("john.doe@example.com");

        Candidate candidate = new Candidate(validName, validPhoneNumber, validEmail);

        assertEquals(validName, candidate.getName());
        assertEquals(validPhoneNumber, candidate.getPhoneNumber());
        assertEquals(validEmail, candidate.getEmail());
    }

    @Test
    void shouldThrowNullPointerExceptionWhenNameIsNull() {
        PhoneNumber validPhoneNumber = new PhoneNumber("123456789");
        EmailAddress validEmail = EmailAddress.valueOf("john.doe@example.com");

        assertThrows(NullPointerException.class, () -> new Candidate(null, validPhoneNumber, validEmail));
    }

    @Test
    void shouldThrowNullPointerExceptionWhenPhoneNumberIsNull() {
        Name validName = new Name("John Doe");
        EmailAddress validEmail = EmailAddress.valueOf("john.doe@example.com");

        assertThrows(NullPointerException.class, () -> new Candidate(validName, null, validEmail));
    }

    @Test
    void shouldThrowNullPointerExceptionWhenEmailIsNull() {
        Name validName = new Name("John Doe");
        PhoneNumber validPhoneNumber = new PhoneNumber("123456789");

        assertThrows(NullPointerException.class, () -> new Candidate(validName, validPhoneNumber, null));
    }
}