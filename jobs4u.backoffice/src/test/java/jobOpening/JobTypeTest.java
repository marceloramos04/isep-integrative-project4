package jobOpening;

import jobOpening.domain.jobOpeningAttributes.JobType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JobTypeTest {

    @Test
    void isValid_returnsTrue_whenTypeIndexIsValid() {
        assertTrue(JobType.isValid(1));
        assertTrue(JobType.isValid(2));
    }

    @Test
    void isValid_returnsFalse_whenTypeIndexIsInvalid() {
        assertFalse(JobType.isValid(0));
        assertFalse(JobType.isValid(3));
    }

    @Test
    void constructor_setsCorrectType_whenTypeIndexIsValid() {
        assertEquals("Full time", new JobType(1).toString());
        assertEquals("Part time", new JobType(2).toString());
    }

    @Test
    void constructor_throwsException_whenTypeIndexIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new JobType(0));
        assertThrows(IllegalArgumentException.class, () -> new JobType(3));
    }

    @Test
    void toString_returnsCorrectString_whenTypeIsFullTime() {
        JobType jobType = new JobType(1);
        assertEquals("Full time", jobType.toString());
    }

    @Test
    void toString_returnsCorrectString_whenTypeIsPartTime() {
        JobType jobType = new JobType(2);
        assertEquals("Part time", jobType.toString());
    }
}
