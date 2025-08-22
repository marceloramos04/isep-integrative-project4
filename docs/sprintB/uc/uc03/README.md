# UC03 #

## 1.Requirements Engineering ##

     This section describes the requirements of the use case.

### Use Case Description ###

     UC02: Disable users of the backoffice.

### Client Specifications and Clarifications ###

     N/A

---

### Acceptence Acceptance Criteria ###

    AC01: The user list shown must be activated users.

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

 - DeactivateUserUI
 - DeactivateUserController
 - UserDeactivationService
 - UserRepository
---

### Class Diagram ###

![CLASS DIAGRAM](diagrams%2Fsvg%2FCD.svg)

---

## 3.Design

### Sequence Diagram (SD) ###

![SEQUENCE DIAGRAM](diagrams%2Fsvg%2FSD.svg)

---

## 4.Tests

[DeactivateUserTest.java](..%2F..%2F..%2F..%2Fjobs4u.backoffice%2Fsrc%2Ftest%2Fjava%2Feapli%2Fjobs4u%2Fapp%2Fbackoffice%2FuserManagement%2Fdomain%2FdeactivateUser%2FDeactivateUserTest.java)

---

