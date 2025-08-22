package application.interview;

import application.domain.Interview;
import application.domain.InterviewStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class InterviewTest {

    private LocalDateTime validInterviewDateTime;
    private LocalDate validEndDate;
    private InterviewStatus interviewStatus ;

    @BeforeEach
    void setUp() {
        validInterviewDateTime = LocalDateTime.now().plusDays(1);
        validEndDate = LocalDate.now().plusDays(2);
        interviewStatus = InterviewStatus.Pending;
    }

    @Test
    void shouldCreateInterviewWithValidDateAndStatus() {

        Interview interview = new Interview(validInterviewDateTime, validEndDate, interviewStatus );
        assertEquals(validInterviewDateTime, interview.getInterviewDateTime());
        assertEquals(interviewStatus , interview.getStatus());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenInterviewDateIsInThePast() {
        LocalDateTime pastInterviewDateTime = LocalDateTime.now().minusDays(1);
        assertThrows(IllegalArgumentException.class, () -> new Interview(pastInterviewDateTime, validEndDate, interviewStatus ));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenInterviewDateIsAfterEndDate() {
        LocalDateTime futureInterviewDateTime = LocalDateTime.now().plusDays(3);
        assertThrows(IllegalArgumentException.class, () -> new Interview(futureInterviewDateTime, validEndDate, interviewStatus ));
    }
}
