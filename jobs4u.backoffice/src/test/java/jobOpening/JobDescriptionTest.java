package jobOpening;

import jobOpening.domain.jobOpeningAttributes.JobDescription;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JobDescriptionTest {

    @Test
    void isValid_returnsTrue_whenJobDescriptionIsValid() {
        assertTrue(JobDescription.isValid("This is a valid job description."));
    }

    @Test
    void isValid_returnsFalse_whenJobDescriptionIsInvalid() {
        assertFalse(JobDescription.isValid(""));
        assertFalse(JobDescription.isValid("Invalid"));
    }

    @Test
    void constructor_setsCorrectJobDescription_whenJobDescriptionIsValid() {
        JobDescription jobDescription = new JobDescription("This is a valid job description.");
        assertEquals("This is a valid job description.", jobDescription.toString());
    }

    @Test
    void constructor_throwsException_whenJobDescriptionIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new JobDescription(""));
    }

    @Test
    void toString_returnsCorrectString_whenJobDescriptionIsValid() {
        JobDescription jobDescription = new JobDescription("This is a valid job description.");
        assertEquals("This is a valid job description.", jobDescription.toString());
    }
}
