package jobOpening;

import jobOpening.domain.recruitmentPhases.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RecruitmentPhasesTest {

    // AnalysisPhase
    @Test
    void isActive_shouldReturnTrue_whenCurrentDateIsWithinAnalysisPhase() {
        AnalysisPhase analysisPhase = new AnalysisPhase(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
        assertTrue(analysisPhase.isActive());
    }

    @Test
    void isActive_shouldReturnFalse_whenCurrentDateIsBeforeAnalysisPhase() {
        AnalysisPhase analysisPhase = new AnalysisPhase(LocalDate.now().plusDays(1), LocalDate.now().plusDays(2));
        assertFalse(analysisPhase.isActive());
    }

    @Test
    void isActive_shouldReturnFalse_whenCurrentDateIsAfterAnalysisPhase() {
        AnalysisPhase analysisPhase = new AnalysisPhase(LocalDate.now().minusDays(2), LocalDate.now().minusDays(1));
        assertFalse(analysisPhase.isActive());
    }

    @Test
    void open_shouldSetStartDateToCurrentDate() {
        AnalysisPhase analysisPhase = new AnalysisPhase(LocalDate.now().plusDays(2), LocalDate.now().plusDays(5));
        analysisPhase.open();
        assertTrue(analysisPhase.isActive());
    }

    @Test
    void close_shouldSetStartDateToCurrentDate() {
        AnalysisPhase analysisPhase = new AnalysisPhase(LocalDate.now().minusDays(2), LocalDate.now().plusDays(1));
        analysisPhase.close();
        assertFalse(analysisPhase.isActive());
    }

    // ApplicationPhase
    @Test
    void isActive_shouldReturnTrue_whenCurrentDateIsWithinApplicationPhase() {
        ApplicationPhase applicationPhase = new ApplicationPhase(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
        assertTrue(applicationPhase.isActive());
    }

    @Test
    void isActive_shouldReturnFalse_whenCurrentDateIsBeforeApplicationPhase() {
        ApplicationPhase applicationPhase = new ApplicationPhase(LocalDate.now().plusDays(1), LocalDate.now().plusDays(2));
        assertFalse(applicationPhase.isActive());
    }

    @Test
    void isActive_shouldReturnFalse_whenCurrentDateIsAfterApplicationPhase() {
        ApplicationPhase applicationPhase = new ApplicationPhase(LocalDate.now().minusDays(2), LocalDate.now().minusDays(1));
        assertFalse(applicationPhase.isActive());
    }

    @Test
    void open_shouldSetStartDateToCurrentDateApplicationPhases() {
        ApplicationPhase applicationPhase = new ApplicationPhase(LocalDate.now().plusDays(2), LocalDate.now().plusDays(5));
        applicationPhase.open();
        assertTrue(applicationPhase.isActive());
    }

    @Test
    void close_shouldSetStartDateToCurrentDateApplicationPhases() {
        ApplicationPhase applicationPhase = new ApplicationPhase(LocalDate.now().minusDays(2), LocalDate.now().plusDays(1));
        applicationPhase.close();
        assertFalse(applicationPhase.isActive());
    }

    // InterviewsPhase
    @Test
    void isActive_shouldReturnTrue_whenCurrentDateIsWithinInterviewsPhase() {
        InterviewsPhase interviewsPhase = new InterviewsPhase(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
        assertTrue(interviewsPhase.isActive());
    }

    @Test
    void isActive_shouldReturnFalse_whenCurrentDateIsBeforeInterviewsPhase() {
        InterviewsPhase interviewsPhase = new InterviewsPhase(LocalDate.now().plusDays(1), LocalDate.now().plusDays(2));
        assertFalse(interviewsPhase.isActive());
    }

    @Test
    void isActive_shouldReturnFalse_whenCurrentDateIsAfterInterviewsPhase() {
        InterviewsPhase interviewsPhase = new InterviewsPhase(LocalDate.now().minusDays(2), LocalDate.now().minusDays(1));
        assertFalse(interviewsPhase.isActive());
    }

    @Test
    void open_shouldSetStartDateToCurrentDateInterviewsPhases() {
        InterviewsPhase interviewsPhase = new InterviewsPhase(LocalDate.now().plusDays(2), LocalDate.now().plusDays(5));
        interviewsPhase.open();
        assertTrue(interviewsPhase.isActive());
    }

    @Test
    void close_shouldSetStartDateToCurrentDateInterviewsPhases() {
        InterviewsPhase interviewsPhase = new InterviewsPhase(LocalDate.now().minusDays(2), LocalDate.now().plusDays(1));
        interviewsPhase.close();
        assertFalse(interviewsPhase.isActive());
    }

    // ScreeningPhase
    @Test
    void isActive_shouldReturnTrue_whenCurrentDateIsWithinScreeningPhase() {
        ScreeningPhase screeningPhase = new ScreeningPhase(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
        assertTrue(screeningPhase.isActive());
    }

    @Test
    void isActive_shouldReturnFalse_whenCurrentDateIsBeforeScreeningPhase() {
        ScreeningPhase screeningPhase = new ScreeningPhase(LocalDate.now().plusDays(1), LocalDate.now().plusDays(2));
        assertFalse(screeningPhase.isActive());
    }

    @Test
    void isActive_shouldReturnFalse_whenCurrentDateIsAfterScreeningPhase() {
        ScreeningPhase screeningPhase = new ScreeningPhase(LocalDate.now().minusDays(2), LocalDate.now().minusDays(1));
        assertFalse(screeningPhase.isActive());
    }

    @Test
    void open_shouldSetStartDateToCurrentDateScreeningPhases() {
        ScreeningPhase screeningPhase = new ScreeningPhase(LocalDate.now().plusDays(2), LocalDate.now().plusDays(5));
        screeningPhase.open();
        assertTrue(screeningPhase.isActive());
    }

    @Test
    void close_shouldSetStartDateToCurrentDateScreeningPhases() {
        ScreeningPhase screeningPhase = new ScreeningPhase(LocalDate.now().minusDays(2), LocalDate.now().plusDays(1));
        screeningPhase.close();
        assertFalse(screeningPhase.isActive());
    }

    // ResultPhase
    @Test
    void isActive_shouldReturnTrue_whenCurrentDateIsWithinResultPhase() {
        ResultPhase resultPhase = new ResultPhase(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
        assertTrue(resultPhase.isActive());
    }

    @Test
    void isActive_shouldReturnFalse_whenCurrentDateIsBeforeResultPhase() {
        ResultPhase resultPhase = new ResultPhase(LocalDate.now().plusDays(1), LocalDate.now().plusDays(2));
        assertFalse(resultPhase.isActive());
    }

    @Test
    void isActive_shouldReturnFalse_whenCurrentDateIsAfterResultPhase() {
        ResultPhase resultPhase = new ResultPhase(LocalDate.now().minusDays(2), LocalDate.now().minusDays(1));
        assertFalse(resultPhase.isActive());
    }

    @Test
    void open_shouldSetStartDateToCurrentDateResultPhases() {
        ResultPhase resultPhase = new ResultPhase(LocalDate.now().plusDays(2), LocalDate.now().plusDays(5));
        resultPhase.open();
        assertTrue(resultPhase.isActive());
    }

    @Test
    void close_shouldSetStartDateToCurrentDateResultPhases() {
        ResultPhase resultPhase = new ResultPhase(LocalDate.now().minusDays(2), LocalDate.now().plusDays(1));
        resultPhase.close();
        assertFalse(resultPhase.isActive());
    }


}