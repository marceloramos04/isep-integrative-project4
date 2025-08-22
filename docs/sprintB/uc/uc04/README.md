# UC04 #

## 1.Requirements Engineering ##

     This section describes the requirements of the use case.

### Use Case Description ###

     UC04: List users of the backoffice

### Client Specifications and Clarifications ###

     N/A

---

### Acceptence Acceptance Criteria ###

    N/A

---

### Dependencies ###

    The users must be already registered at the system (UC01).

---

### Input and Output Data ###

**Typed Data**: 

    * N/A
    

**Selected Data**:


    * N/A

**Output Data**:
    
    * User List

---

### System Sequence Diagram (SSD) ###

![SYSTEM SEQUENCE DIAGRAM](diagrams%2Fsvg%2FSSD.svg)

---

## 2.Analysis

### Classes identified ###

 - ListUsersUI
 - ListUsersController
 - UserRepository
 - ListUsersService
---

### Class Diagram ###

![CD.svg](diagrams%2Fsvg%2FCD.svg)

---

## 3.Design

### Sequence Diagram (SD) ###

![SD.svg](diagrams%2Fsvg%2FSD.svg)

---

## 4.Tests

[ListUsersTest.java](..%2F..%2F..%2F..%2Fjobs4u.backoffice%2Fsrc%2Ftest%2Fjava%2Feapli%2Fjobs4u%2Fapp%2Fbackoffice%2FuserManagement%2Fdomain%2FlisUsers%2FListUsersTest.java)

---