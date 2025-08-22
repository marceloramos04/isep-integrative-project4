# US 1015

## 1. Context

This user story is about the creation of a function that allows the customer manager to execute the process of verification 
of requirements from applications of a selected job opening, from the existing ones in the screening process. This is the 
first time this task is assigned to be developed.

## 2. Requirements

The customer manager should be able to execute the process of verification the requirements from the applications of a 
job opening. The system should compare the requirements of the applications with the requirements of the job opening and 
verify which applications meet the requirements. After the verification, the system approves/disapproves the applications.

**US 1015** As Customer Manager, I want to execute the process of verification of requirements of applications for a job opening.

**Acceptance Criteria:**

- G002.1. The system should compare the requirements of the applications with the requirements of the job opening and 
approve/disapprove the applications.

## 3. Analysis

This user story corresponds to use case 20.

The costumer manager should be able to select a job opening in a group of job openings with active phases (so that is
possible to execute the verification of the requirements from th applications). The system should compare the requirements
of the applications with the requirements of the job opening and verify which applications meet the requirements. After the
verification, the system approves/disapproves the applications.

### system sequence diagram :
![System Sequence Diagram uc_20](/docs/sprintC/uc/uc20/diagrams/svg/SSD.svg "System Sequence Diagram uc_20")

This diagram was made based on use case 20, which is the use case that corresponds to this user story. The class diagram
shows the classes that are involved in this use case, the system sequence diagram shows the sequence of messages that are 
exchanged between the system and the actors in this use case.

## 4. Design

### 4.1. Realization

![Sequence Diagram uc_20](/docs/sprintC/uc/uc20/diagrams/svg/SD.svg "Sequence Diagram uc_20")


### 4.2. Class Diagram

![Class Diagram uc_20](/docs/sprintC/uc/uc20/diagrams/svg/CD.svg "Class Diagram uc_20")

### 4.3. Applied Patterns

### 4.4. Tests

Include here the main tests used to validate the functionality. Focus on how they relate to the acceptance criteria.

**Test 1:** *Verifies that the applications get approved/disapproved*

**Refers to Acceptance Criteria:** G002.1

## 5. Implementation

The implementation of this requirement was done by creating a new Ui and Controller responsible for this use case, to 
separate the responsibilities of the other controllers and Ui's. The controller will be responsible for receiving the 
information from the Ui and sending it to the service, which will be responsible for executing the business rules. The 
service will be responsible for receiving the information from the controller, executing the business rules and sending 
the information to the repository, which will be responsible for saving the information in the database. The repository 
will be responsible for receiving the information from the service, through the controller, and saving it in the database.

Classes that were used in the implementation of this requirement:
- **VerificationRequirementsUI.java :** This class is responsible for receiving the information from the user.
- **VerificationRequirementsController.java :** This class is responsible for receiving the information from the Ui and 
sending it to the services, and is also responsible for sending the information to the Ui.
- **VerificationRequirementsService.java :** This class is responsible for receiving the information from the controller, 
executing the business rules and sending the information to the repository.
- **GetJobOpeningsOnScreeningPhaseService.java :** This class is responsible for filtering the job openings that are in the
screening phase from the repository.
- **JobOpeningRepository.java :** This class is responsible for receiving the information from the service, and saving 
it in the database.
- **ApplicationRepository.java :** This class is responsible for receiving the information from the service, and saving
it in the database.
- **Application.java :** This class is responsible for representing the application object.


## 6. Integration/Demonstration

The integration of this functionality with the other parts/components of the system was done by creating a new Ui and
Controller responsible for this use case, to separate the responsibilities of the other controllers and Ui's. The controller
is responsible for receiving the information from the Ui and sending it to the service, which is responsible for executing
the business rules. The service is responsible for receiving the information from the controller, executing the business rules
and sending the information to the repository, which is responsible for saving the information in the database. The repository
is responsible for receiving the information from the service, through the controller, and saving it in the database.

To use this functionality, the customer manager must select a job opening in a group of job openings on the screening
phase. The system will compare the requirements of the applications with the requirements of the job opening and verify
which applications meet the requirements. After the verification, the system will approve/disapprove the applications.

## 7. Observations

The system will compare the requirements of the applications with the requirements of the job opening and verify which
applications meet the requirements. After the verification, the system will approve/disapprove the applications, by 
changing its attribute. The system will also save the information in the database.