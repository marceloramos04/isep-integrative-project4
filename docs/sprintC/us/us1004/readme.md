# US 1004

## 1. Context

This user story is about the creation of a function that allows the customer manager to edit a job opening. This is the 
first time this task is assigned to be developed.

## 2. Requirements

The customer manager should be able to edit a job opening. The system should allow the customer manager to change the 
attributes of a job opening.

**US 1004** As a costumer manager I want to edit a job opening.

**Acceptance Criteria:**

- G002.1. The system should allow the customer manager to change the attributes of a job opening.

- G002.2. The system should save the changes made by the customer manager.

**Dependencies/References:**

*Regarding this requirement, we understand that it relates to use case 17.*

## 3. Analysis

This user story corresponds to use case 17.

The customer manager should be able to select a job opening from the database and change its attributes. The system should
save the changes made.

### system sequence diagram :

![System Sequence Diagram uc_17](/docs/sprintC/uc/uc17/diagrams/svg/SSD.svg "System Sequence Diagram uc_17")

## 4. Design

### 4.1. Realization

![Sequence Diagram uc_17](/docs/sprintC/uc/uc17/diagrams/svg/SD.svg "Sequence Diagram uc_17")

![Sequence Diagram uc_17](/docs/sprintC/uc/uc17/diagrams/svg/SD-recruitmentProcess.svg "Sequence Diagram for changing the recruitment process uc_17")

### 4.2. Class Diagram

![a class diagram](/docs/sprintC/uc/uc17/diagrams/svg/SSD.svg "System Sequence Diagram uc_17")

### 4.3. Applied Patterns

### 4.4. Tests

**Test 1:** *Verifies that the changes made by the customer manager are saved*

- **Refers to Acceptance Criteria:** G002.2

## 5. Implementation

To implement this requirement, the team created a new Ui and Controller responsible for this use case, to separate the 
responsibilities of the other controllers and Ui's. The controller is responsible for receiving the information from the 
Ui and sending it to the service, which is responsible for executing the business rules. The service is responsible for 
receiving the information from the controller, executing the business rules and sending the information to the repository, 
which is responsible for saving the information in the database. The repository is responsible for receiving the 
information from the service, through the controller, and saving it in the database.

Classes that were used to implement this requirement:
- **EditJobOpeningUi.java** - The Ui responsible for receiving the information from the user.
- **EditJobOpeningController.java** - The controller responsible for receiving the information from the Ui and sending it to the service.
- **EditJobOpeningService.java** - The service responsible for executing the business rules.
- **JobOpeningRepository.java** - The repository responsible for saving the information in the database.
- **JobOpening.java** - The class that represents a job opening.
- **SetupPhasesService.java** - The service responsible for setting up the phases of the process for a job opening. Was reused
due to its ability to set up/change the phases of the process for a job opening.

## 6. Integration/Demonstration

The integration of this functionality with the other parts/components of the system was done by creating a new Ui and
Controller responsible for this use case, to separate the responsibilities of the other controllers and Ui's. The controller
is responsible for receiving the information from the Ui and sending it to the service, which is responsible for executing
the business rules. The service is responsible for receiving the information from the controller, executing the business rules
and sending the information to the repository, which is responsible for saving the information in the database. The repository
is responsible for receiving the information from the service, through the controller, and saving it in the database.

To use this functionality, the customer manager must access the system, select the menu option to edit a job opening, select
the job opening to be edited, change the attributes of the job opening, and the system will save the changes.
