# US 1003

## 1. Context

*In terms of functionality, this user story is about listing all the job openings already existing in the system. The costumer manager wants to be able to list all the job openings.*

## 2. Requirements

**US 1003** As Customer Manager, I want to list job openings.

The functionality being developed is the ability for a Customer Manager to list all the job openings already existing in the system.


Understanding:
This feature is crucial for the job recruitment process. It allows the Customer Manager to list all the job openings already existing in the system. This feature implies the need for a user interface for listing the job openings, as well as a backend service to retrieve these details from the database.

**Dependencies/References:**
This feature could be related to other features such as "register a job opening", "Editing a job opening", "Deleting a job opening", and "Applying for a job opening". These features would also need to interact with the job opening data in the system.

**Acceptance Criteria:**
- G003.1. The system should allow the Customer Manager to list all the job openings already existing in the system.
- G003.2. The system should display the job openings in a clear and organized manner.


## 3. Analysis

*In this section, the team should report the study/analysis/comparison that was done in order to take the best design decisions for the requirement. This section should also include supporting diagrams/artifacts (such as domain model; use case diagrams, etc.),*

## 4. Design

[//]: # (*In this sections, the team should present the solution design that was adopted to solve the requirement. This should include, at least, a diagram of the realization of the functionality &#40;e.g., sequence diagram&#41;, a class diagram &#40;presenting the classes that support the functionality&#41;, the identification and rational behind the applied design patterns and the specification of the main tests used to validade the functionality.*)

The sequence diagram below shows the interaction between the Customer Manager and the system to list the job openings.
![uc07 sequence diagram](/docs/sprintB/uc/uc07/diagrams/svg/SD.svg "uc07 Sequence Diagram")

The program will display the job openings in a clear and organized manner. The system will retrieve the job openings from the database and display them in a list.

### 4.1. Realization

The realization of this functionality involves creating a user interface for the Customer Manager to list the job openings. The system should retrieve the job openings from the database and display them in a clear and organized manner.

### 4.2. Class Diagram

![uc07 class diagram](/docs/sprintB/uc/uc07/diagrams/svg/CD.svg "uc07 Class Diagram")

### 4.3. Applied Patterns

* **Repository Pattern:** The JobOpeningRepository class could be an implementation of the Repository pattern. This pattern provides a way to work with a data source in a more abstract way, providing a collection-like interface for accessing domain objects.
* **Dependency Injection Pattern:** The use of @InjectMocks and @Mock annotations from Mockito in the test classes indicates the use of the Dependency Injection pattern. This pattern allows the system to be more flexible, testable and modular.

## 4.4. Tests

The main tests used to validate the functionality of listing all job openings are focused on how they relate to the acceptance criteria.

**Test 1:** Verifies that the system retrieves all job openings from the database.

**Refers to Acceptance Criteria:** G003.1

```java
@Test
@DisplayName("Should retrieve all job openings from the database")
public void shouldRetrieveAllJobOpenings() {
    // Create a list of job openings
    List<JobOpening> jobOpenings = new ArrayList<>();
    jobOpenings.add(new JobOpening(new Title("Software Engineer"), JobOpening.JobType.FULL_TIME, JobOpening.WorkingMode.remote, "123 Main St, Anytown, USA", new Title("Acme Corp"), new PositiveNumber(5), new WiderDescription("Develop and maintain software applications.")));
    jobOpenings.add(new JobOpening(new Title("Data Analyst"), JobOpening.JobType.PART_TIME, JobOpening.WorkingMode.remote, "456 Oak St, Anytown, USA", new Title("Beta Corp"), new PositiveNumber(3), new WiderDescription("Analyze and interpret complex data sets.")));

    // Mock the behavior of jobOpeningRepository to return the list of job openings
    when(jobOpeningRepository.findAll()).thenReturn(jobOpenings);

    // Call the method to test
    List<JobOpening> retrievedJobOpenings = jobOpeningController.getAllJobOpenings();

    // Verify the behavior and the result
    verify(jobOpeningRepository, times(1)).findAll();
    assertEquals(jobOpenings, retrievedJobOpenings);
}
```

**Test 2:** Verifies that the system handles the scenario where there are no job openings in the database.

**Refers to Acceptance Criteria:** G003.2

```java
@Test
@DisplayName("Should handle no job openings in the database")
public void shouldHandleNoJobOpenings() {
    // Mock the behavior of jobOpeningRepository to return an empty list
    when(jobOpeningRepository.findAll()).thenReturn(Collections.emptyList());

    // Call the method to test
    List<JobOpening> retrievedJobOpenings = jobOpeningController.getAllJobOpenings();

    // Verify the behavior and the result
    verify(jobOpeningRepository, times(1)).findAll();
    assertTrue(retrievedJobOpenings.isEmpty());
}
```

## 5. Implementation

[//]: # (*In this section the team should present, if necessary, some evidencies that the implementation is according to the design. It should also describe and explain other important artifacts necessary to fully understand the implementation like, for instance, configuration files.*)
The system will show a list with all the existing job openings in the database. The system will retrieve the job openings from the database and display them in a clear and organized manner.


## 6. Integration/Demonstration

To integrate and demonstrate this functionality, we need to ensure that the `JobOpeningController` is properly set up and able to interact with the `JobOpeningRepository`. This involves setting up the necessary dependencies and running the application.

Here are the steps to demonstrate this functionality:

1. Ensure that the `JobOpeningRepository` is properly set up and connected to the database. This involves setting up the necessary database connection parameters in the application's configuration files.

2. Run the application. If you're using an IDE like IntelliJ IDEA, you can do this by right-clicking on the main application class and selecting 'Run'. If you're running the application from the command line, you can use the command `mvn spring-boot:run`.

3. Once the application is running, you can use the `JobOpeningController` to list all job openings. This can be done through the user interface or through an API if one is set up.

4. To verify that the job openings are listed, you can check the user interface or use the `JobOpeningRepository` to retrieve the job openings.

Here is a sample code snippet that demonstrates how to use the `JobOpeningController` to list all job openings:

```java
public static void main(String[] args) {
    // Create a new instance of JobOpeningController
    JobOpeningController jobOpeningController = new JobOpeningController();

    // List all job openings
    List<JobOpening> jobOpenings = jobOpeningController.getAllJobOpenings();

    // Print all job openings
    for (JobOpening jobOpening : jobOpenings) {
        System.out.println(jobOpening);
    }
}
```

This code snippet demonstrates how to use the `JobOpeningController` to list all job openings. It first creates a new instance of `JobOpeningController`, retrieves all job openings, and then prints each job opening.

[//]: # (## 7. Observations)

[//]: # ()
[//]: # (*This section should be used to include any content that does not fit any of the previous sections.*)

[//]: # ()
[//]: # (*The team should present here, for instance, a critical prespective on the developed work including the analysis of alternative solutioons or related works*)

[//]: # ()
[//]: # (*The team should include in this section statements/references regarding third party works that were used in the development this work.*)