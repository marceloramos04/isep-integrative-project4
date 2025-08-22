# UC12 #

## 1.Requirements Engineering ##

     This section describes the requirements of the use case.

### Use Case Description ###

     UC12: List all candidates

### Client Specifications and Clarifications ###

> **Question:** Order of candidates. In US 2000c we are asked to implement the function of listing all candidates. Is it necessary to order the candidates (for example in alphabetical order of name)? If so, what criteria should we follow?
> 
> **Answer:** Yes, the listing can be in alphabetical order by name.

---

### Acceptance Acceptance Criteria ###

    AC01: The listing must be sorted alphabetically

---

### Dependencies ###

    A set of candidates have to be already be registered in the system or else it will be returned a empty list.

---

### Input and Output Data ###

**Typed Data**: 

    *None
    

**Selected Data**:

    *None

**Output Data**:
    
    * Sorted List of all candidates

---

### System Sequence Diagram (SSD) ###

[SSD.puml](diagrams%2Fuml%2FSSD.puml)

---

## 2.Analysis

### Classes identified ###

 - ListAllCandidateUI
 - ListAllCandidatesController
 - CandidateRepository
 - 
---

### Class Diagram ###

[CD.puml](diagrams%2Fuml%2FCD.puml)
---

## 3.Design

### Sequence Diagram (SD) ###

[SD.puml](diagrams%2Fuml%2FSD.puml)

---

