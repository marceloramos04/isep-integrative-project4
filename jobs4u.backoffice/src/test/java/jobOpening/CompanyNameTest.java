package jobOpening;

import jobOpening.domain.jobOpeningAttributes.CompanyName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompanyNameTest {

    @Test
    void isValid_returnsTrue_whenCompanyNameIsValid() {
        assertTrue(CompanyName.isValid("Valid Company"));
    }

    @Test
    void isValid_returnsFalse_whenCompanyNameIsInvalid() {
        assertFalse(CompanyName.isValid(""));
    }

    @Test
    void constructor_setsCorrectCompanyName_whenCompanyNameIsValid() {
        CompanyName companyName = new CompanyName("Valid Company");
        assertEquals("Valid Company", companyName.toString());
    }

    @Test
    void constructor_throwsException_whenCompanyNameIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new CompanyName(""));
    }

    @Test
    void toString_returnsCorrectString_whenCompanyNameIsValid() {
        CompanyName companyName = new CompanyName("Valid Company");
        assertEquals("Valid Company", companyName.toString());
    }
}