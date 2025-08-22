# UC18 #

## 1.Requirements Engineering ##

     This section describes the requirements of the use case.

### Use Case Description ###

     UC18: Enable candidate.

### Client Specifications and Clarifications ###

     N/A

---

### Acceptence Acceptance Criteria ###

    AC01: The user list shown must be deactivated candidates.

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

 - ActivateCandidateUI
 - ActivateCandidateController
 - UserActivationService
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

### Test Case TC01 ###

    * Title: Enable Candidate
    * Description: Test the enable candidate feature.
    * Pre-conditions: The candidate must be already registered at the system.
    * Assumptions: N/A
    * Test Steps:
        1. The user selects the candidate to be enabled.
        2. The user clicks on the enable button.
    * Expected Result: The candidate is enabled.

---
