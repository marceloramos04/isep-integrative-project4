# UC27 #

## 1.Requirements Engineering ##

        This section describes the requirements of the use case.

### Use Case Description ###

        UC27: Display all the data of an application.

### Client Specifications and Clarifications ###

        N/A

---

### Acceptance Acceptance Criteria ###

    AC01: The system should display all the data of an application.

---

### Dependencies ###

    The application must be previously at the system. (UC13)

---

### Input and Output Data ###

**Typed Data**: 

    * N/A

**Selected Data**:

    * Application
    * Job Opening

**Output Data**:
        
        * Application data
        * Job Opening list

---

## 2.Analysis

### Classes identified ###

 - DisplayApplicationUI
 - DisplayApplicationController
 - ListJobOpeningsService
 - ListApplicationsService
 - ApplicationDataService
 - ApplicationRepository
 - JobOpeningRepository

---

### Class Diagram ###

![CD.png](diagrams%2Fpng%2FCD.png)

---

## 3.Design ##

### Sequence Diagram ###

![SD.png](diagrams%2Fpng%2FSD.png)

---

## 4.Implementation ##

|   |   |   |   |   |   |   |
|---|---|---|---|---|---|---|

---

## 5.Tests ##

---