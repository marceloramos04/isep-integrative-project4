package eapli.jobs4u.app.backoffice.application.listApplicationsForJobOpening;

import application.ApplicationRepository;
import application.domain.Application;
import application.listapplications.ListApplicationsService;
import candidate.domain.Candidate;
import jobOpening.JobOpeningRepository;
import jobOpening.domain.JobOpening;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import utils.PositiveInteger;
import utils.Title;
import utils.WiderDescription;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class ListApplicationsForJobOpeningTest {
    @Mock
    private ApplicationRepository repo;
    @Mock
    private JobOpeningRepository jobOpeningRepository;
    @Mock
    private ListApplicationsService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /*@Test
    @DisplayName("Ensure List Applications For Job Opening Works")
    void testListApplicationsForJobOpening() {

        Candidate candidate = new Candidate("Candidate", 987654321L, "candidate@example.com");

        JobOpening.JobType jobType = JobOpening.JobType.valueOf("FULL_TIME");
        JobOpening.WorkingMode mode = JobOpening.WorkingMode.valueOf("remote");

        Title title1 = new Title("title1");
        Title title2 = new Title("title2");

        PositiveInteger c = new PositiveInteger(5);

        WiderDescription description = new WiderDescription("Descripton");

        JobOpening jobOpening = new JobOpening(title1, jobType, mode, "Porto", title2, c, description);

        jobOpeningRepository.save(jobOpening);

        Application application = new Application(jobOpening, "data", candidate, "data.csv");

        List<Application> expectedList = new ArrayList<>();

        expectedList.add(application);

        List<Application> actualList = service.listApplications(1L);

        //assertEquals(expectedList, actualList);

        //verify(repo).findApplicationsByJobOfferID(1L);
    }*/
}
