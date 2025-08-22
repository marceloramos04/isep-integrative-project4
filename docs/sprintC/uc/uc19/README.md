# UC19 #

## 1.Requirements Engineering ##

     This section describes the requirements of the use case.

### Use Case Description ###

     UC19: Disable candidate.

### Client Specifications and Clarifications ###

     N/A

---

### Acceptence Acceptance Criteria ###

    AC01: The user list shown must be activated candidates.

---

### Dependencies ###

    The candidate must be already registered at the system (UC11).

---

### Input and Output Data ###

**Typed Data**: 

    * N/A

**Selected Data**:

    * Candidate Email

**Output Data**:
    
    * Candidate List
    * Operation Success

---

### System Sequence Diagram (SSD) ###

![SSD.png](diagrams%2Fpng%2FSSD.png)

---

## 2.Analysis

### Classes identified ###

 - DeactivateCandidateUI
 - DeactivateCandidateController
 - ListActivatedCandidatesService
 - UserDeactivationService
 - UserRepository
---

### Class Diagram ###

![CD.png](diagrams%2Fpng%2FCD.png)

---

## 3.Design

### Sequence Diagram (SD) ###

![SD.png](diagrams%2Fpng%2FSD.png)

---

## 4.Tests

### Test Case 01 ###
```
    Test Case ID: TC01
    Test Case Name: Deactivate candidate
    Test Case Description: The user deactivates a candidate.
    Test Case Precondition: The candidate must be already registered at the system.
    Test Case Steps: 
        1. The user selects a candidate.
        2. The user deactivates the candidate.
    Test Case Post Condition: The candidate is deactivated.
    Test Case Expected Result: The candidate is deactivated.
```

---

