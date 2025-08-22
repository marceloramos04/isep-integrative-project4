# US 1007

## 1. Context

*In terms of functionality, this user story is about setting up the phases of the process for a job opening. The Customer Manager wants to be able to define the different phases that a job opening will go through, such as "open for applications", "shortlisting candidates", "interviewing candidates", etc.*

*The Customer Manager should be able to define these phases and the order in which they will occur. The system should then be able to track the progress of the job opening through these phases.*

*This user story implies the need for a user interface for setting up the phases of the process for a job opening, as well as a backend service to save these details in a database.*


## 2. Requirements

**US 1007** As Customer Manager, I want to setup the phases of the process for a job opening.

The functionality being developed is the ability for a Customer Manager to define the different phases that a job opening will go through. This involves setting up the different phases that a job opening will go through, such as "open for applications", "shortlisting candidates", "interviewing candidates", etc., and defining the order in which these phases will occur.

Understanding:
This feature is crucial for the job recruitment process. It allows the Customer Manager to define the different phases that a job opening will go through, such as "open for applications", "shortlisting candidates", "interviewing candidates", etc. The system should then be able to track the progress of the job opening through these phases. This feature implies the need for a user interface for setting up the phases of the process for a job opening, as well as a backend service to save these details in a database.

**Dependencies/References:**
This feature could be related to other features such as register a job opening ([us_1002](../us_1002/readme.md)), list job openings ([us_1003](../us_1003/readme.md)), "register an application of a candidate for a job opening" ([us_2002](../us_2002/readme.md)), " list all applications for a job opening" ([us_1005](../us_1005/readme.md)), "setup the phases of the process for a job opening" ([us_1007](../us_1007/readme.md)), "select the requirements specification to be used for a job opening" ([us_1009](../us_1009/readme.md)) and "select the interview model to use for the interviews of a job opening (for their evaluation/grading)" ([us_1011](../us_1011/readme.md)). These features would also need to interact with the job opening data in the system.

**Acceptance Criteria:**
- G002.1. The system should allow the costumer manager to setup the phases of the process for a job opening such as application, screening, interview, analysis and result.
- G002.2. The system should allow the costumer manager to define the dates in which the phases will start and end.
- G002.3. The system should allow the costumer manager to define if the job opening will have interviews or not.


## 3. Analysis

The analysis for this requirement involves understanding the need for a new job opening to have defined dates for each of the phases of the process. This feature is essential for the job recruitment process, as it allows the Customer Manager to define dates for the phases of each job opportunity in the system. The job opening phases' details should be saved in the system so that they can be tracked and managed throughout the recruitment process.

## 4. Design

[//]: # (*In this sections, the team should present the solution design that was adopted to solve the requirement. This should include, at least, a diagram of the realization of the functionality &#40;e.g., sequence diagram&#41;, a class diagram &#40;presenting the classes that support the functionality&#41;, the identification and rational behind the applied design patterns and the specification of the main tests used to validade the functionality.*)

The sequence diagram below shows the interaction between the Customer Manager and the system to setup the phases of a job openings.
![uc10 sequence diagram](/docs/sprintB/uc/uc10/diagrams/svg/SD.svg "uc10 Sequence Diagram")

The program will display the job openings in a clear and organized manner. The user will be able to select a job opening and define the phases of the process for that job opening. The system will save the job opening details in the database.


### 4.1. Realization

The realization of this functionality involves creating a user interface for the Customer Manager to input the job opening details. The system should validate the input data and save the job opening details in the database.

### 4.2. Class Diagram

![uc10 class diagram](/docs/sprintB/uc/uc10/diagrams/svg/CD.svg "uc10 Class Diagram")

### 4.3. Applied Patterns

* **Repository Pattern:** The JobOpeningRepository class could be an implementation of the Repository pattern. This pattern provides a way to work with a data source in a more abstract way, providing a collection-like interface for accessing domain objects.
* **Dependency Injection Pattern:** The use of @InjectMocks and @Mock annotations from Mockito in the test classes indicates the use of the Dependency Injection pattern. This pattern allows the system to be more flexible, testable and modular.
* **Facade Pattern:** The SetupPhasesController and RegisterJobOpeningController classes could be seen as implementations of the Facade pattern. They provide a simplified interface to a complex subsystem.

## 4.4. Tests

The main tests used to validate the functionality of setting up the phases of the process for a job opening are focused on how they relate to the acceptance criteria.

**Test 1:** Verifies that the system allows the Customer Manager to setup the phases of the process for a job opening such as application, screening, interview, analysis and result.

**Refers to Acceptance Criteria:** G002.1

```java
@Test
@DisplayName("Should allow the Customer Manager to setup the phases of the process for a job opening")
public void shouldSetupPhasesOfProcess() {
    // Create a new instance of SetupPhasesController
    SetupPhasesController setupPhasesController = new SetupPhasesController();

    // Define the phases of the process for a job opening
    setupPhasesController.setPhases(Arrays.asList("application", "screening", "interview", "analysis", "result"));

    // Verify that the phases of the process were set correctly
    assertEquals(Arrays.asList("application", "screening", "interview", "analysis", "result"), setupPhasesController.getPhases());
}
```

**Test 2:** Verifies that the system allows the Customer Manager to define the dates in which the phases will start and end.

**Refers to Acceptance Criteria:** G002.2

```java
@Test
@DisplayName("Should allow the Customer Manager to define the dates in which the phases will start and end")
public void shouldDefineDatesForPhases() {
    // Create a new instance of SetupPhasesController
    SetupPhasesController setupPhasesController = new SetupPhasesController();

    // Define the start and end dates for the phases
    setupPhasesController.setStartDate(LocalDate.of(2022, 1, 1));
    setupPhasesController.setEndDate(LocalDate.of(2022, 12, 31));

    // Verify that the start and end dates were set correctly
    assertEquals(LocalDate.of(2022, 1, 1), setupPhasesController.getStartDate());
    assertEquals(LocalDate.of(2022, 12, 31), setupPhasesController.getEndDate());
}
```

**Test 3:** Verifies that the system allows the Customer Manager to define if the job opening will have interviews or not.

**Refers to Acceptance Criteria:** G002.3

```java
@Test
@DisplayName("Should allow the Customer Manager to define if the job opening will have interviews or not")
public void shouldDefineIfJobOpeningWillHaveInterviews() {
    // Create a new instance of SetupPhasesController
    SetupPhasesController setupPhasesController = new SetupPhasesController();

    // Define if the job opening will have interviews
    setupPhasesController.setHasInterviews(true);

    // Verify that the job opening will have interviews
    assertTrue(setupPhasesController.getHasInterviews());
}
```

## 5. Implementation

The implementation of this functionality involves creating a method in the `SetupPhasesController` class to set up the phases of the process for a job opening. This method is then used by the user interface to display the phases to the Customer Manager.

Here is the implementation of the `setPhases` method in the `SetupPhasesController` class:

```java
public class SetupPhasesController {

    private List<String> phases;

    public void setPhases(List<String> phases) {
        this.phases = phases;
    }

    public List<String> getPhases() {
        return this.phases;
    }
}
```

This method sets the phases of the process for a job opening. The phases are stored in a list, which can be retrieved using the `getPhases` method.


## 6. Integration/Demonstration

To integrate and demonstrate this functionality, we need to ensure that the `SetupPhasesController` is properly set up and able to interact with the `JobOpeningRepository`. This involves setting up the necessary dependencies and running the application.

Here are the steps to demonstrate this functionality:

1. Ensure that the `JobOpeningRepository` is properly set up and connected to the database. This involves setting up the necessary database connection parameters in the application's configuration files.

2. Run the application. If you're using an IDE like IntelliJ IDEA, you can do this by right-clicking on the main application class and selecting 'Run'. If you're running the application from the command line, you can use the command `mvn spring-boot:run`.

3. Once the application is running, you can use the `SetupPhasesController` to set up the phases of a job opening. This can be done through the user interface or through an API if one is set up.

4. To verify that the phases have been set up, you can check the user interface or use the `JobOpeningRepository` to retrieve the job opening and its phases.

Here is a sample code snippet that demonstrates how to use the `SetupPhasesController` to set up the phases of a job opening:

```java
public static void main(String[] args) {
    // Create a new instance of SetupPhasesController
    SetupPhasesController setupPhasesController = new SetupPhasesController();

    // Set the phases for the job opening
    setupPhasesController.setPhases(Arrays.asList("application", "screening", "interview", "analysis", "result"));

    // Print the phases for the job opening
    List<String> phases = setupPhasesController.getPhases();
    for (String phase : phases) {
        System.out.println(phase);
    }
}
```

This code snippet demonstrates how to use the `SetupPhasesController` to set up the phases of a job opening. It first creates a new instance of `SetupPhasesController`, sets the phases for the job opening, and then prints each phase.

## 7. Observations

[//]: # (*This section should be used to include any content that does not fit any of the previous sections.*)

[//]: # (*The team should present here, for instance, a critical prespective on the developed work including the analysis of alternative solutioons or related works*)

[//]: # (*The team should include in this section statements/references regarding third party works that were used in the development this work.*)

The login functionality was implemented after this, so note that the costumer manager will be able to setup the phases of every job opening, not only the ones created by him/her. This is a security issue that will be addressed in the next sprint.