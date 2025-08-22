# US 1010

## 1. Context

This user story is about the creation of a function that allows the customer manager to open or close phases of the 
process for a job opening. This is the first time this task is assigned to be developed

## 2. Requirements

The customer manager should be able to open or close phases of the process for a job opening. And when 
closing the phase, the system should start the next phase of the process.

**US 1010** As Customer Manager, I want to open or close phases of the process for a job opening.

**Acceptance Criteria:**

- G002.1. The system should allow the customer manager to open or close phases of the process for a job opening.

- G002.2. The system should open the next phase of the process when the customer manager closes the current phase.

## 3. Analysis

This user story corresponds to use case 21.

The costumer manager should be able to select a job opening in a group of job openings with active phases (so that is 
possible to open or close a phase). The system should open the next phase of the process when the customer manager 
closes the current phase.

### system sequence diagram :
![System Sequence Diagram uc_21](/docs/sprintC/uc/uc21/diagrams/svg/SSD.svg "System Sequence Diagram uc_21")

These diagrams were made based on use case 21, which is the use case that corresponds to this user story. The class 
diagram shows the classes that are involved in this use case, the sequence diagram shows the sequence of messages that 
are exchanged between the objects in this use case, and the system sequence diagram shows the sequence of messages that 
are exchanged between the system and the actors in this use case.

## 4. Design

### 4.1. Realization

![Sequence Diagram uc_21](/docs/sprintC/uc/uc21/diagrams/svg/SD.svg "Sequence Diagram uc_21")

To solve the requirement, the team decided to create a new Ui and controller responsible for this use case, in order to separate the responsibilities of the other controllers and Ui's. The controller will be responsible for receiving the information from the Ui and sending it to the service, which will be responsible for executing the business rules. The service will be responsible for receiving the information from the controller, executing the business rules and sending the information to the repository, which will be responsible for saving the information in the database. The repository will be responsible for receiving the information from the service, through the controller, and saving it in the database.

### 4.2. Class Diagram

![Class Diagram uc_21](/docs/sprintC/uc/uc21/diagrams/svg/CD.svg "Class Diagram uc_21")

### 4.3. Applied Patterns

In the solution of this requirement, the team decided to use the MVC pattern, in order to separate the responsibilities of the classes. The Ui will be responsible for receiving the information from the user, the controller will be responsible for receiving the information from the Ui and sending it to the service, which will be responsible for executing the business rules. The service will be responsible for receiving the information from the controller, executing the business rules and sending the information to the repository, which will be responsible for saving the information in the database. The repository will be responsible for receiving the information from the service, through the controller, and saving it in the database.

### 4.4. Tests

**Test 1:** *Verifies that the phase gets closed*

- **Refers to Acceptance Criteria:** G002.1

**Test 2:** *Verifies that when closing a phase, the next one is started*

- **Refers to Acceptance Criteria:** G002.2

## 5. Implementation

The implementation of this requirement was done by creating a new Ui and Controller responsible for this use case, to 
separate the responsibilities of the other controllers and Ui's. The controller is responsible for receiving the 
information from the Ui and sending it to the service, which is responsible for executing the business rules. The service 
is responsible for receiving the information from the controller, executing the business rules and sending the information 
to the repository, which is responsible for saving the information in the database. The repository is responsible for 
receiving the information from the service, through the controller, and saving it in the database.

Classes were used to represent the Ui, Controller, Service and Repository : 
- **ClosePhaseUI.java :** This class is responsible for receiving the information from the user.
- **ClosePhaseController.java :** This class is responsible for receiving the information from the Ui and sending it to the service.
- **ClosePhaseService.java :** This class is responsible for receiving the information from the controller, executing the business rules and sending the information to the repository.
- **GetActiveJobOpeningsService :** This class is responsible for receiving the job opening from the data base and filtering the active ones, then returning them to the controller.
- **JobOpeningRepository.java :** This class is responsible for receiving the information from the service, and saving it in the database.

## 6. Integration/Demonstration

The integration of this functionality with the other parts/components of the system was done by creating a new Ui and
Controller responsible for this use case, to separate the responsibilities of the other controllers and Ui's. The controller
is responsible for receiving the information from the Ui and sending it to the service, which is responsible for executing
the business rules. The service is responsible for receiving the information from the controller, executing the business rules
and sending the information to the repository, which is responsible for saving the information in the database. The repository
is responsible for receiving the information from the service, through the controller, and saving it in the database.

To use this functionality, the customer manager must log in the system, select the menu to close a phase, select the job
opening that he wants to close the phase, and then click on the button to close the phase. The system will close the phase
and start the next one, by changing the phase's dates.

## 7. Observations

To close the phase, the system changes the dates of the necessary phases to the current date, so that the next phase is
started and the active phase is closed.
