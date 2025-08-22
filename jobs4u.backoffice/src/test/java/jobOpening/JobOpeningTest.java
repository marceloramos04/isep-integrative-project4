package jobOpening;


import customer.domain.Customer;
import jobOpening.domain.JobOpening;
import jobOpening.domain.jobOpeningAttributes.*;
import jobOpening.domain.recruitmentPhases.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.PositiveInteger;
import utils.domain.address.Address;
import utils.domain.ranking.Ranking;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class JobOpeningTest {

    private JobOpening jobOpening;

    @BeforeEach
    void setUp() {
        JobTitle jobTitle = new JobTitle("Software Engineer");
        JobType jobType = new JobType(1);
        JobWorkingMode workingMode = new JobWorkingMode(2);
        Address address = new Address("123 Main St", 12, "1111-111", "Porto");
        CompanyName companyName = new CompanyName("Company");
        PositiveInteger numberVacancies = new PositiveInteger(5);
        JobDescription jobDescription = new JobDescription("Job Description");

        Customer customer = new Customer("Customer", "costumer@teste2.com", "co", new Address("Rua", 1, "1111-111", "Porto"));

        jobOpening = new JobOpening(jobTitle, jobType, workingMode, address, companyName, numberVacancies, jobDescription, customer);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSetupPhasesWithNull() {
        assertThrows(IllegalArgumentException.class, () -> jobOpening.setupPhases(null));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenAddNullRanking() {
        assertThrows(IllegalArgumentException.class, () -> jobOpening.addRanking(null));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenAddDuplicateRanking() {
        Ranking ranking = new Ranking();
        jobOpening.addRanking(ranking);
        assertThrows(IllegalArgumentException.class, () -> jobOpening.addRanking(ranking));
    }

    @Test
    void shouldAddRankingCorrectly() {
        Ranking ranking = new Ranking();
        jobOpening.addRanking(ranking);
        assertTrue(jobOpening.getRankings().contains(ranking));
    }

    @Test
    void shouldReturnFalseWhenNoActivePhase() {
        assertFalse(jobOpening.isActive());
    }

    @Test
    void shouldReturnTrueWhenActivePhaseExists() {
        ApplicationPhase applicationPhase = new ApplicationPhase(LocalDate.now().minusDays(5), LocalDate.now().plusDays(5));
        ScreeningPhase screeningPhase = new ScreeningPhase(LocalDate.now().plusDays(5), LocalDate.now().plusDays(10));
        InterviewsPhase interviewsPhase = new InterviewsPhase(LocalDate.now().plusDays(10), LocalDate.now().plusDays(15));
        AnalysisPhase analysisPhase = new AnalysisPhase(LocalDate.now().plusDays(15), LocalDate.now().plusDays(20));
        ResultPhase resultPhase = new ResultPhase(LocalDate.now().plusDays(20), LocalDate.now().plusDays(25));

        RecruitmentProcess recruitmentProcess = new RecruitmentProcess(applicationPhase, screeningPhase, interviewsPhase, analysisPhase, resultPhase);
        jobOpening.setupPhases(recruitmentProcess);
        assertTrue(jobOpening.isActive());
    }

    @Test
    void shouldCloseApplicationPhaseAndOpenScreeningPhase() {
        ApplicationPhase applicationPhase = new ApplicationPhase(LocalDate.now().minusDays(5), LocalDate.now().plusDays(5));
        ScreeningPhase screeningPhase = new ScreeningPhase(LocalDate.now().plusDays(5), LocalDate.now().plusDays(10));
        InterviewsPhase interviewsPhase = new InterviewsPhase(LocalDate.now().plusDays(10), LocalDate.now().plusDays(15));
        AnalysisPhase analysisPhase = new AnalysisPhase(LocalDate.now().plusDays(15), LocalDate.now().plusDays(20));
        ResultPhase resultPhase = new ResultPhase(LocalDate.now().plusDays(20), LocalDate.now().plusDays(25));

        RecruitmentProcess recruitmentProcess = new RecruitmentProcess(applicationPhase, screeningPhase, interviewsPhase, analysisPhase, resultPhase);
        jobOpening.setupPhases(recruitmentProcess);
        jobOpening.closeActivePhase();
        assertEquals(jobOpening.activePhase(), "Screening phase");
    }

    @Test
    void shouldCloseScreeningPhaseAndOpenAnalysisPhase() {
        ApplicationPhase applicationPhase = new ApplicationPhase(LocalDate.now().minusDays(15), LocalDate.now().minusDays(10));
        ScreeningPhase screeningPhase = new ScreeningPhase(LocalDate.now().minusDays(5), LocalDate.now().plusDays(10));
        AnalysisPhase analysisPhase = new AnalysisPhase(LocalDate.now().plusDays(15), LocalDate.now().plusDays(20));
        ResultPhase resultPhase = new ResultPhase(LocalDate.now().plusDays(20), LocalDate.now().plusDays(25));

        RecruitmentProcess recruitmentProcess = new RecruitmentProcess(applicationPhase, screeningPhase, null, analysisPhase, resultPhase);
        jobOpening.setupPhases(recruitmentProcess);
        jobOpening.closeActivePhase();
        assertEquals(jobOpening.activePhase(), "Analysis phase");
    }
}