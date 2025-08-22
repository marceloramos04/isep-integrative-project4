package jobOpening;

import jobOpening.domain.jobOpeningAttributes.JobTitle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JobTitleTest {

    @Test
    void isValid_returnsTrue_whenJobTitleIsValid() {
        assertTrue(JobTitle.isValid("Software Engineer"));
    }

    @Test
    void isValid_returnsFalse_whenJobTitleIsInvalid() {
        assertFalse(JobTitle.isValid(""));
    }

    @Test
    void constructor_setsCorrectJobTitle_whenJobTitleIsValid() {
        JobTitle jobTitle = new JobTitle("Software Engineer");
        assertEquals("Software Engineer", jobTitle.toString());
    }

    @Test
    void constructor_throwsException_whenJobTitleIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new JobTitle(""));
    }

    @Test
    void toString_returnsCorrectString_whenJobTitleIsValid() {
        JobTitle jobTitle = new JobTitle("Software Engineer");
        assertEquals("Software Engineer", jobTitle.toString());
    }
}
