# UC15 #

## 1.Requirements Engineering ##

     This section describes the requirements of the use case.

### Use Case Description ###

     UC15: Support and apply authentication and authorization for all its users and functionalities.

### Client Specifications and Clarifications ###

     N/A

---

### Acceptence Acceptance Criteria ###

    AC01: Each user is required to login before using the application.
    AC02: According to the login credencials, the system should present the functionalities.

---

### Dependencies ###

    N/A

---

### Input and Output Data ###

**Typed Data**: 

    * User E-mail
    * User Passoword


**Selected Data**:

    * N/A

**Output Data**:
    
    * N/A

---

## 2.Analysis

### Classes identified ###

 - LoginUI
 - AuthenticationController
 - AuthenticationService
 - SecurityConfig
 - TokenService
---

### Class Diagram ###

![CLASS DIAGRAM]()

---

## 3.Design

### Sequence Diagram (SD) ###

![SEQUENCE DIAGRAM]()

---

### 4.Tests

**Refers to Acceptance Criteria:** AC01

**Test 1:** *Verifies that it is not possible to use any functionality from the system without login*

- If we run the application, it shows only 2 options, therefore, every user has to login first.


**Refers to Acceptance Criteria:** AC02

**Test 2:** *Verifies that administrator has access to administrator functionalities after the login*

- When we login with the correct credentials (as an administrator), the menu for administrator is shown.

**Test 3:** *Verifies that Operator has access to Operator functionalities after the login*

- When we login with the correct credentials (as an Operator), the menu for operator is shown.

**Test 4:** *Verifies that Customer Manager has access to Customer Manager functionalities after the login*

- When we login with the correct credentials (as an customer manager), the menu for customer manager is shown.

---