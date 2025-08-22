# UC08 #

## 1.Requirements Engineering ##

     This section describes the requirements of the use case.

### Use Case Description ###

     UC08: List applications for a job opening.

### Client Specifications and Clarifications ###

     N/A

---

### Acceptance Acceptance Criteria ###

    AC01: If the specified job opening is not registered at the system, the system should give some warnning and not procced.

---

### Dependencies ###

    Job openings must be regitered first (UC06).

---

### Input and Output Data ###

**Typed Data**: 

    * N/A
    

**Selected Data**:


    * Job Offer Id

**Output Data**:
    
    * List of applications

---

## 2.Analysis

### Classes identified ###

 - ListApplicationsUI
 - ListApplicationsController
 - ApplicationRepository
---

### Class Diagram ###

![CD.svg](diagrams%2Fsvg%2FCD.svg)

---

## 3.Design

### Sequence Diagram (SD) ###

![SEQUENCE DIAGRAM](diagrams%2Fsvg%2FSD.svg)

---

## 4.Tests

[ListApplicationsForJobOpeningTest.java](..%2F..%2F..%2F..%2Fjobs4u.backoffice%2Fsrc%2Ftest%2Fjava%2Feapli%2Fjobs4u%2Fapp%2Fbackoffice%2Fapplication%2FlistApplicationsForJobOpening%2FListApplicationsForJobOpeningTest.java)

---