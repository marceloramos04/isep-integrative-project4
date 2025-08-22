# US 1002

## 1. Context

*In terms of functionality, this user story is about creating a new job opening in the system. The Customer Manager wants to be able to input details about a new job opening, such as the job title, job description, job requirements, location, salary, etc., and save this information in the system.*

*This user story implies the need for a user interface for inputting the job opening details, as well as a backend service to save these details in a database.*

## 2. Requirements

**US 1002** As Customer Manager, I want to register a job opening.

The functionality being developed is the ability for a Customer Manager to register a job opening. This involves creating a new job opening in the system where the Customer Manager can input details such as the job title, job description, job requirements, location, etc., and save this information in the system.

Understanding:
This feature is crucial for the job recruitment process. It allows the Customer Manager to create new job opportunities in the system, which can then be published or advertised for potential candidates to apply. The system should then be able to track these applications against the registered job opening. This feature implies the need for a user interface for inputting the job opening details, as well as a backend service to save these details in a database.

**Dependencies/References:**
This feature could be related to other features such as list job openings ([us_1003](../us_1003/readme.md)), "register an application of a candidate for a job opening" ([us_2002](../us_2002/readme.md)), " list all applications for a job opening" ([us_1005](../us_1005/readme.md)), "setup the phases of the process for a job opening" ([us_1007](../us_1007/readme.md)), "select the requirements specification to be used for a job opening" ([us_1009](../us_1009/readme.md)) and "select the interview model to use for the interviews of a job opening (for their evaluation/grading)" ([us_1011](../us_1011/readme.md)). These features would also need to interact with the job opening data in the system.

**Acceptance Criteria:**
- G002.1. The system should allow the Customer Manager to input all necessary details for a job opening (job title, job description, job requirements, location, salary, etc.).
- G002.2. The system should validate the input data to ensure it meets certain criteria (e.g., job title and job description are not empty).
- G002.3. The system should save the job opening details in the database.
- G002.4. The system should provide a confirmation to the Customer Manager that the job opening has been successfully registered.
- G002.5. The system should allow the Customer Manager to view the registered job opening after it has been saved.


## 3. Analysis

The analysis for this requirement involves understanding the need for a new job opening to be registered in the system. This feature is essential for the job recruitment process, as it allows the Customer Manager to create new job opportunities in the system. The job opening details should be saved in the system so that they can be tracked and managed throughout the recruitment process.

## 4. Design

[//]: # (*In this sections, the team should present the solution design that was adopted to solve the requirement. This should include, at least, a diagram of the realization of the functionality &#40;e.g., sequence diagram&#41;, a class diagram &#40;presenting the classes that support the functionality&#41;, the identification and rational behind the applied design patterns and the specification of the main tests used to validade the functionality.*)

The sequence diagram below illustrates the interaction between the Customer Manager, the User Interface, and the backend service when registering a new job opening.
![Uc 06 sequence diagram](/docs/sprintB/uc/uc06/diagrams/svg/SD.svg "Uc 06 sequence diagram")

The program will ask the Customer Manager to input the job opening details. The system will validate the input data to ensure it meets certain criteria. If the input data is valid, the system will save the job opening details in the database and provide a confirmation to the Customer Manager that the job opening has been successfully registered. The Customer Manager will then be able to view the registered job opening after it has been saved.

### 4.1. Realization

The realization of this functionality involves creating a user interface for the Customer Manager to input the job opening details. The system should validate the input data and save the job opening details in the database.

### 4.2. Class Diagram

![uc06 class diagram](/docs/sprintB/uc/uc06/diagrams/svg/CD.svg "uc06 class diagram")

### 4.3. Applied Patterns

* **Repository Pattern:** The JobOpeningRepository class could be an implementation of the Repository pattern. This pattern provides a way to work with a data source in a more abstract way, providing a collection-like interface for accessing domain objects.  
* **Dependency Injection Pattern:** The use of @InjectMocks and @Mock annotations from Mockito in the test classes indicates the use of the Dependency Injection pattern. This pattern allows the system to be more flexible, testable and modular.  
* **Factory Pattern:** If the creation of JobOpening objects involves complex logic, a Factory pattern could be used to encapsulate this logic and provide a clean and clear way to create these objects.  
* **Facade Pattern:** The SetupPhasesController and RegisterJobOpeningController classes could be seen as implementations of the Facade pattern. They provide a simplified interface to a complex subsystem.

### 4.4. Tests

Include here the main tests used to validate the functionality. Focus on how they relate to the acceptance criteria.

**Test 1:** Verifies that the job opening is saved to da database.

**Refers to Acceptance Criteria:** G002.3


```
    @Test
    @DisplayName("Should register a job opening with provided details")
    public void shouldRegisterJobOpeningWithProvidedDetails() {
        JobOpening jobOpening = new JobOpening(new Title("Job Title"), JobOpening.JobType.FULL_TIME, JobOpening.WorkingMode.remote, "address", new Title("Company name"), new PositiveNumber(1), new WiderDescription("jobDescription"));

        registerJobOpeningController.registerJobOpening(jobOpening);

        verify(jobOpeningRepository, times(1)).save(jobOpening);
    }

````

## 5. Implementation

[//]: # (*In this section the team should present, if necessary, some evidencies that the implementation is according to the design. It should also describe and explain other important artifacts necessary to fully understand the implementation like, for instance, configuration files.*)

Values that are inputted by the user are validated by the system to ensure that they are not empty and not invalid. The system also generates a unique identifier for each job opening that is created. The job opening details are then saved in the database.

[//]: # (*It is also a best practice to include a listing &#40;with a brief summary&#41; of the major commits regarding this requirement.*)

## 6. Integration/Demonstration

To integrate and demonstrate this functionality, we need to ensure that the `RegisterJobOpeningController` is properly set up and able to interact with the `JobOpeningRepository`. This involves setting up the necessary dependencies and running the application.

Here are the steps to demonstrate this functionality:

1. Ensure that the `JobOpeningRepository` is properly set up and connected to the database. This involves setting up the necessary database connection parameters in the application's configuration files.

2. Run the application. If you're using an IDE like IntelliJ IDEA, you can do this by right-clicking on the main application class and selecting 'Run'. If you're running the application from the command line, you can use the command `mvn spring-boot:run`.

3. Once the application is running, you can use the `RegisterJobOpeningController` to register a new job opening. This can be done through the user interface or through an API if one is set up.

4. To verify that the job opening has been registered, you can check the database directly or use the `JobOpeningRepository` to retrieve the job opening.

Here is a sample code snippet that demonstrates how to use the `RegisterJobOpeningController` to register a new job opening:

```java
public static void main(String[] args) {
    // Create a new instance of RegisterJobOpeningController
    RegisterJobOpeningController registerJobOpeningController = new RegisterJobOpeningController();

    // Set the details for the new job opening
    registerJobOpeningController.setJobTitle("Software Engineer");
    registerJobOpeningController.setJobType(JobOpening.JobType.FULL_TIME);
    registerJobOpeningController.setWorkingMode(JobOpening.WorkingMode.remote);
    registerJobOpeningController.setAddress("123 Main St, Anytown, USA");
    registerJobOpeningController.setCompanyName("Acme Corp");
    registerJobOpeningController.setNumberVacancies(5);
    registerJobOpeningController.setJobDescription("Develop and maintain software applications.");

    // Register the new job opening
    registerJobOpeningController.registerJobOpening();
}
```

This code snippet demonstrates how to use the `RegisterJobOpeningController` to register a new job opening. It first creates a new instance of `RegisterJobOpeningController`, sets the details for the new job opening, and then calls the `registerJobOpening()` method to register the new job opening.

[//]: # (## 7. Observations)

[//]: # ()
[//]: # (*This section should be used to include any content that does not fit any of the previous sections.*)

[//]: # ()
[//]: # (*The team should present here, for instance, a critical prespective on the developed work including the analysis of alternative solutioons or related works*)

[//]: # ()
[//]: # (*The team should include in this section statements/references regarding third party works that were used in the development this work.*)