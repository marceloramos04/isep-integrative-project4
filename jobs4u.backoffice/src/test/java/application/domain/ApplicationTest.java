package application.domain;

import candidate.domain.Candidate;
import customer.domain.Customer;
import eapli.framework.general.domain.model.EmailAddress;
import jobOpening.domain.JobOpening;
import jobOpening.domain.jobOpeningAttributes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import userManagement.domain.Name;
import utils.PhoneNumber;
import utils.PositiveInteger;
import utils.domain.address.Address;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {
    private JobOpening jobOpening;
    private Candidate candidate;

    @BeforeEach
    void setUp() {

        Name validName = new Name("John Doe");
        PhoneNumber validPhoneNumber = new PhoneNumber("123456789");
        EmailAddress validEmail = EmailAddress.valueOf("john.doe@example.com");

        candidate = new Candidate(validName, validPhoneNumber, validEmail);

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
    public void testApplicationCreationWithInterview() {

        Interview interview = new Interview();
        List<File> files = new ArrayList<>();

        // Act
        Application application = new Application(jobOpening, interview, candidate, files);

        // Assert
        assertEquals(jobOpening, application.getJobOffer());
        assertEquals(interview, application.getInterview());
        assertEquals(candidate, application.getCandidate());
        assertEquals(files, application.getFile());
    }

    @Test
    public void testApplicationCreationWithoutInterview() {
       ;
        List<File> files = new ArrayList<>();

        // Act
        Application application = new Application(jobOpening, candidate, files);

        // Assert
        assertEquals(jobOpening, application.getJobOffer());
        assertNull(application.getInterview());
        assertEquals(candidate, application.getCandidate());
        assertEquals(files, application.getFile());
    }

    @Test
    public void testIsApproved() {
        // Arrange
        Application application = new Application(jobOpening, candidate, new ArrayList<>());
        ScreeningResult screeningResult = new ScreeningResult();
        screeningResult.setValue(1);
        application.setScreeningResult(screeningResult);

        // Act & Assert
        assertTrue(application.isApproved());

        // Change screening result
        screeningResult.setValue(0);
        assertFalse(application.isApproved());
    }

    @Test
    public void testCompareTo() {
        // Arrange
        Interview interview1 = new Interview();
        Interview interview2 = new Interview();
        interview2.setInterviewResult(85);
        interview1.setInterviewResult(90);
        Application application1 = new Application(jobOpening
                , interview1, candidate, new ArrayList<>());

        Application application2 = new Application(jobOpening
                , interview2, candidate, new ArrayList<>());



        // Act & Assert
        assertEquals(0, application1.compareTo(interview1));
        assertEquals(-1, application1.compareTo(interview2));
        assertEquals(1, application2.compareTo(interview1));
    }

    @Test
    public void testToString() {
        Interview interview = new Interview();
        interview.setInterviewResult(90);
        ScreeningResult screeningResult = new ScreeningResult();
        screeningResult.setValue(1);
        List<File> files = new ArrayList<>();
        Application application = new Application(jobOpening, interview, candidate, files);
        application.setScreeningResult(screeningResult);

        // Act
        String result = application.toString();

        // Assert
        assertTrue(result.contains("JobOffer:" + jobOpening));
        assertTrue(result.contains("Candidate:" + candidate));
        assertTrue(result.contains("ScreeningResult:" + screeningResult.retrieveDescription()));
        assertFalse(result.contains("Interview:'" + interview));
        assertTrue(result.contains("Files:'" + files));
    }

    @Test
    public void testUploadInterviewAnswers() {
        // Arrange
        Interview interview = new Interview();
        List<File> files = new ArrayList<>();

        Application application = new Application(jobOpening, interview, candidate, files);

        // Act
        application.uploadInterviewAnswers("answerFile");

        // Assert
        assertEquals("answerFile", interview.getIntervAnswersFile());
    }
}
