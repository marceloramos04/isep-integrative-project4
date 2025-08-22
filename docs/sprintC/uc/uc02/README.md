# UC02 #

## 1.Requirements Engineering ##

     This section describes the requirements of the use case.

### Use Case Description ###

     UC02: Enable users of the backoffice.

### Client Specifications and Clarifications ###

     N/A

---

### Acceptence Acceptance Criteria ###

    AC01: The user list shown must be deactivated users.

---

### Dependencies ###

    The user must be already registered at the system (UC01).

---

### Input and Output Data ###

**Typed Data**: 

    * N/A

**Selected Data**:

    * UserId

**Output Data**:
    
    * User List
    * Operation Success

---

### System Sequence Diagram (SSD) ###

![SYSTEM SEQUENCE DIAGRAM](diagrams%2Fsvg%2FSSD.svg)

---

## 2.Analysis

### Classes identified ###

 - EnableUserUI
 - EnableUserController
 - UserRepository
---

### Class Diagram ###

![CD.png](diagrams%2Fpng%2FCD.png)

---

## 3.Design

### Sequence Diagram (SD) ###

![SD.svg](diagrams%2Fsvg%2FSD.svg)

---

## 4.Tests

[ActivateUserTest.java](..%2F..%2F..%2F..%2Fjobs4u.backoffice%2Fsrc%2Ftest%2Fjava%2Feapli%2Fjobs4u%2Fapp%2Fbackoffice%2FuserManagement%2Fdomain%2FactivateUser%2FActivateUserTest.java)

---
