# UC01 #

## 1.Requirements Engineering ##

     This section describes the requirements of the use case.

### Use Case Description ###

     UC01: Register users of the backoffice.

### Client Specifications and Clarifications ###

     N/A

---

### Acceptence Acceptance Criteria ###

    AC01: All the fields must be filled
    AC02: E-mail must have '@'

---

### Dependencies ###

    A set of roles have to be already regsterd at the system.

---

### Input and Output Data ###

**Typed Data**: 

    * User Name
    * User E-mail
    

**Selected Data**:

    * Role

**Output Data**:
    
    * New user data
    * Operation Success

---

### System Sequence Diagram (SSD) ###

![SYSTEM SEQUENCE DIAGRAM](/diagrams/svg/SSD.svg)

---

## 2.Analysis

### Classes identified ###

 - RegisterUserUI
 - RegisterUserController
 - UserRepository
 - UserFactory
 - PasswordGeneratorService
 - User
---

### Class Diagram ###

![CLASS DIAGRAM](/diagrams/svg/CD.svg)
---

## 3.Design

### Sequence Diagram (SD) ###

![SEQUENCE DIAGRAM](/diagrams/svg/SD.svg)


---


## 4. Tests

[RegisterUserTest.java](..%2F..%2F..%2F..%2Fjobs4u.backoffice%2Fsrc%2Ftest%2Fjava%2Feapli%2Fjobs4u%2Fapp%2Fbackoffice%2FuserManagement%2Fdomain%2FregisterUser%2FRegisterUserTest.java)

---