package jobOpening;

import jobOpening.domain.jobOpeningAttributes.JobWorkingMode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JobWorkingModeTest {

    @Test
    void isValid_returnsTrue_whenModeIndexIsValid() {
        assertTrue(JobWorkingMode.isValid(1));
        assertTrue(JobWorkingMode.isValid(2));
        assertTrue(JobWorkingMode.isValid(3));
    }

    @Test
    void isValid_returnsFalse_whenModeIndexIsInvalid() {
        assertFalse(JobWorkingMode.isValid(0));
        assertFalse(JobWorkingMode.isValid(4));
    }

    @Test
    void constructor_setsCorrectMode_whenModeIndexIsValid() {
        assertEquals("Remote", new JobWorkingMode(1).toString());
        assertEquals("On site", new JobWorkingMode(2).toString());
        assertEquals("Hybrid", new JobWorkingMode(3).toString());
    }

    @Test
    void constructor_throwsException_whenModeIndexIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new JobWorkingMode(0));
        assertThrows(IllegalArgumentException.class, () -> new JobWorkingMode(4));
    }

    @Test
    void toString_returnsCorrectString_whenModeIsRemote() {
        JobWorkingMode jobWorkingMode = new JobWorkingMode(1);
        assertEquals("Remote", jobWorkingMode.toString());
    }

    @Test
    void toString_returnsCorrectString_whenModeIsOnSite() {
        JobWorkingMode jobWorkingMode = new JobWorkingMode(2);
        assertEquals("On site", jobWorkingMode.toString());
    }

    @Test
    void toString_returnsCorrectString_whenModeIsHybrid() {
        JobWorkingMode jobWorkingMode = new JobWorkingMode(3);
        assertEquals("Hybrid", jobWorkingMode.toString());
    }
}
