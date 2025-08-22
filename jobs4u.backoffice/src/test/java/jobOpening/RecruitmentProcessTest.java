package jobOpening;

import jobOpening.domain.recruitmentPhases.*;
import jobOpening.domain.jobOpeningAttributes.RecruitmentProcess;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class RecruitmentProcessTest {

    @Test
    void getActivePhase_returnsCorrectPhase_withNoActivePhases() {
        ApplicationPhase applicationPhase = new ApplicationPhase(LocalDate.now().plusDays(1), LocalDate.now().plusDays(5));
        ScreeningPhase screeningPhase = new ScreeningPhase(LocalDate.now().plusDays(5), LocalDate.now().plusDays(10));
        InterviewsPhase interviewsPhase = new InterviewsPhase(LocalDate.now().plusDays(10), LocalDate.now().plusDays(15));
        AnalysisPhase analysisPhase = new AnalysisPhase(LocalDate.now().plusDays(15), LocalDate.now().plusDays(20));
        ResultPhase resultPhase = new ResultPhase(LocalDate.now().plusDays(20), LocalDate.now().plusDays(25));
        RecruitmentProcess recruitmentProcess = new RecruitmentProcess(applicationPhase, screeningPhase, interviewsPhase, analysisPhase, resultPhase);
        assertNull(recruitmentProcess.getActivePhase());
    }

    @Test
    void getActivePhase_returnsCorrectPhase_withActivePhase() {
        ApplicationPhase applicationPhase = new ApplicationPhase(LocalDate.now().minusDays(1), LocalDate.now().plusDays(5));
        ScreeningPhase screeningPhase = new ScreeningPhase(LocalDate.now().plusDays(5), LocalDate.now().plusDays(10));
        InterviewsPhase interviewsPhase = new InterviewsPhase(LocalDate.now().plusDays(10), LocalDate.now().plusDays(15));
        AnalysisPhase analysisPhase = new AnalysisPhase(LocalDate.now().plusDays(15), LocalDate.now().plusDays(20));
        ResultPhase resultPhase = new ResultPhase(LocalDate.now().plusDays(20), LocalDate.now().plusDays(25));
        RecruitmentProcess recruitmentProcess = new RecruitmentProcess(applicationPhase, screeningPhase, interviewsPhase, analysisPhase, resultPhase);
        assertNotNull(recruitmentProcess.getActivePhase());
    }

    @Test
    void getActivePhase_returnsCorrectPhase_applicationPhaseIsActive() {
        ApplicationPhase applicationPhase = new ApplicationPhase(LocalDate.now().minusDays(1), LocalDate.now().plusDays(5));
        ScreeningPhase screeningPhase = new ScreeningPhase(LocalDate.now().plusDays(5), LocalDate.now().plusDays(10));
        InterviewsPhase interviewsPhase = new InterviewsPhase(LocalDate.now().plusDays(10), LocalDate.now().plusDays(15));
        AnalysisPhase analysisPhase = new AnalysisPhase(LocalDate.now().plusDays(15), LocalDate.now().plusDays(20));
        ResultPhase resultPhase = new ResultPhase(LocalDate.now().plusDays(20), LocalDate.now().plusDays(25));
        RecruitmentProcess recruitmentProcess = new RecruitmentProcess(applicationPhase, screeningPhase, interviewsPhase, analysisPhase, resultPhase);

        assertEquals("Application phase", recruitmentProcess.getActivePhase());
    }

    @Test
    void closeActivePhase_correctlyTransitionsBetweenPhases() {
        ApplicationPhase applicationPhase = new ApplicationPhase(LocalDate.now().minusDays(1), LocalDate.now().plusDays(5));
        ScreeningPhase screeningPhase = new ScreeningPhase(LocalDate.now().plusDays(5), LocalDate.now().plusDays(10));
        InterviewsPhase interviewsPhase = new InterviewsPhase(LocalDate.now().plusDays(10), LocalDate.now().plusDays(15));
        AnalysisPhase analysisPhase = new AnalysisPhase(LocalDate.now().plusDays(15), LocalDate.now().plusDays(20));
        ResultPhase resultPhase = new ResultPhase(LocalDate.now().plusDays(20), LocalDate.now().plusDays(25));
        RecruitmentProcess recruitmentProcess = new RecruitmentProcess(applicationPhase, screeningPhase, interviewsPhase, analysisPhase, resultPhase);
        recruitmentProcess.closeActivePhase();

        assertEquals("Screening phase", recruitmentProcess.getActivePhase());
    }

    @Test
    void closeActivePhase_correctlyTransitionsBetweenPhases_WithoutInterviews() {
        ApplicationPhase applicationPhase = new ApplicationPhase(LocalDate.now().minusDays(10), LocalDate.now().minusDays(5));
        ScreeningPhase screeningPhase = new ScreeningPhase(LocalDate.now().minusDays(5), LocalDate.now().plusDays(1));
        AnalysisPhase analysisPhase = new AnalysisPhase(LocalDate.now().plusDays(1), LocalDate.now().plusDays(10));
        ResultPhase resultPhase = new ResultPhase(LocalDate.now().plusDays(10), LocalDate.now().plusDays(15));
        RecruitmentProcess recruitmentProcess = new RecruitmentProcess(applicationPhase, screeningPhase, null, analysisPhase, resultPhase);
        recruitmentProcess.closeActivePhase();

        assertEquals("Analysis phase", recruitmentProcess.getActivePhase());
    }

    @Test
    void closeActivePhase_correctlyClosesFinalPhase() {
        ApplicationPhase applicationPhase = new ApplicationPhase(LocalDate.now().minusDays(20), LocalDate.now().minusDays(15));
        ScreeningPhase screeningPhase = new ScreeningPhase(LocalDate.now().minusDays(15), LocalDate.now().minusDays(10));
        AnalysisPhase analysisPhase = new AnalysisPhase(LocalDate.now().minusDays(10), LocalDate.now().minusDays(5));
        ResultPhase resultPhase = new ResultPhase(LocalDate.now().minusDays(5), LocalDate.now().plusDays(1));
        RecruitmentProcess recruitmentProcess = new RecruitmentProcess(applicationPhase, screeningPhase, null, analysisPhase, resultPhase);
        recruitmentProcess.closeActivePhase();
        assertNull(recruitmentProcess.getActivePhase());
    }

}
