/*
package candidate.ListCandidateDetails;

import application.domain.Application;
import candidate.ListCandidateData.ListCandidateDataUI;
import candidate.domain.Candidate;
import application.listapplications.ListApplicationsForJobOfferController;
import candidate.ListCandidateData.ListCandidateDataController;
import jobOpening.domain.JobOpening;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import utils.PositiveInteger;
import utils.Title;
import utils.Utils;
import utils.WiderDescription;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class ListCandidateDataTest {

    @Mock
    private ListCandidateDataController candidateDataController;

    @Mock
    private ListApplicationsForJobOfferController listApplicationsForJobOfferController;

    @InjectMocks
    private ListCandidateDataUI listCandidateDataUI;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldListCandidateDataById() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\n1\n".getBytes());
        System.setIn(in);
        Utils.resetScanner();

        Candidate candidate = new Candidate("Test", 123456789L, "test@example.com");
        candidate.setID(1L); // Set the ID to 1

        when(candidateDataController.listCandidateData(1)).thenReturn(candidate);

        when(listApplicationsForJobOfferController.findApplicationsByCandidateID(anyLong())).thenReturn(Collections.emptyList());

        listCandidateDataUI.run();

        verify(candidateDataController, times(1)).listCandidateData(1);

        verify(listApplicationsForJobOfferController, times(1)).findApplicationsByCandidateID(anyLong());

        System.setIn(System.in);
    }

    @Test
    public void shouldListCandidateDataByEmail() {
        ByteArrayInputStream in = new ByteArrayInputStream("2\ntest@example.com\n".getBytes());
        System.setIn(in);
        Utils.resetScanner();

        Candidate candidate = new Candidate("Test", 123456789L, "test@example.com");
        candidate.setID(1L);
        candidate.setEmail("test@example.com"); // Set the ID to 1

        when(candidateDataController.listCandidateDataByEmail("test@example.com")).thenReturn(candidate);

        when(listApplicationsForJobOfferController.findApplicationsByCandidateID(anyLong())).thenReturn(Collections.emptyList());

        listCandidateDataUI.run();

        verify(candidateDataController, times(1)).listCandidateDataByEmail("test@example.com");

        verify(listApplicationsForJobOfferController, times(1)).findApplicationsByCandidateID(anyLong());

        System.setIn(System.in);
    }

    @Test
    public void shouldHandleInvalidChoice() {
        ByteArrayInputStream in = new ByteArrayInputStream("3\n".getBytes());
        System.setIn(in);
        Utils.resetScanner();

        listCandidateDataUI.run();

        verify(candidateDataController, times(0)).listCandidateData(anyInt());
        verify(candidateDataController, times(0)).listCandidateDataByEmail(anyString());
        verify(listApplicationsForJobOfferController, times(0)).findApplicationsByCandidateID(anyLong());

        System.setIn(System.in);
    }

    @Test
    public void shouldListCandidateDataByIdWithApplication() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\n1\n".getBytes());
        System.setIn(in);
        Utils.resetScanner();

        Candidate candidate = new Candidate("Test", 123456789L, "test@example.com");
        candidate.setID(1L);

        JobOpening.JobType s = JobOpening.JobType.valueOf("FULL_TIME");
        JobOpening.WorkingMode w = JobOpening.WorkingMode.valueOf("remote");
        Title a = new Title("sdfdsf");
        Title b = new Title("sdfdsfs");
        PositiveInteger c = new PositiveInteger(5);
        WiderDescription d = new WiderDescription("sdfdsf");
        JobOpening jobOpening = new JobOpening(a, s, w, "fdfdf", b, c, d);
        Application application = new Application(jobOpening, "dsadsdas", candidate, "dsad.csv");;
        application.setId(1L);

        when(candidateDataController.listCandidateData(1)).thenReturn(candidate);
        when(listApplicationsForJobOfferController.findApplicationsByCandidateID(anyLong())).thenReturn(Collections.singletonList(application));

        listCandidateDataUI.run();

        verify(candidateDataController, times(1)).listCandidateData(1);
        verify(listApplicationsForJobOfferController, times(1)).findApplicationsByCandidateID(anyLong());

        System.setIn(System.in);
    }

    @Test
    public void shouldListCandidateDataByIdWithTwoApplication() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\n1\n".getBytes());
        System.setIn(in);
        Utils.resetScanner();

        Candidate candidate = new Candidate("Test", 123456789L, "test@example.com");
        candidate.setID(1L);

        JobOpening.JobType s = JobOpening.JobType.valueOf("FULL_TIME");
        JobOpening.WorkingMode w = JobOpening.WorkingMode.valueOf("remote");
        Title a = new Title("sdfdsf");
        Title b = new Title("sdfdsfs");
        PositiveInteger c = new PositiveInteger(5);
        WiderDescription d = new WiderDescription("sdfdsf");
        JobOpening jobOpening = new JobOpening(a, s, w, "fdfdf", b, c, d);
        Application application = new Application(jobOpening, "dsadsdas", candidate, "dsad.csv");;
        application.setId(1L);

        JobOpening.JobType s1 = JobOpening.JobType.valueOf("FULL_TIME");
        JobOpening.WorkingMode w1 = JobOpening.WorkingMode.valueOf("remote");
        Title a1 = new Title("sdfdsf");
        Title b1 = new Title("sdfdsfs");
        PositiveInteger c1 = new PositiveInteger(5);
        WiderDescription d1 = new WiderDescription("sdfdsf");
        JobOpening jobOpening1 = new JobOpening(a1, s1, w1, "fdfdf", b1, c1, d1);
        Application application2 = new Application(jobOpening1, "dsadsdas", candidate, "dsad.csv");;
        application2.setId(2L);

        when(candidateDataController.listCandidateData(1)).thenReturn(candidate);
        when(listApplicationsForJobOfferController.findApplicationsByCandidateID(anyLong())).thenReturn(Arrays.asList(application, application2));

        listCandidateDataUI.run();

        verify(candidateDataController, times(1)).listCandidateData(1);
        verify(listApplicationsForJobOfferController, times(1)).findApplicationsByCandidateID(anyLong());

        System.setIn(System.in);
    }
}
*/
