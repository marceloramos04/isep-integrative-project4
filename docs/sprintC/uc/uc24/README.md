# UC24 #

## 1.Requirements Engineering ##

     This section describes the requirements of the use case.

### Use Case Description ###

     UC24:  As Customer Manager, I want to execute the process that evaluates (grades) the interviews for a job opening.

### Dependencies ###
 
     Found dependency with US 1023 Upload a text file with the candidates answers for an interview, because the 
     answers need to be uploaded before the evaluation process.

---

### Input and Output Data ###

**Typed Data**: 

   

**Selected Data**:
  * job Offer

**Output Data**:
    
    * Graded Interviews
    * Operation Success

---

### System Sequence Diagram (SSD) ###

[SSD.puml](diagrams/uml%2FSSD.puml)

---

## 2.Analysis

### Classes identified ###

 - GradeIntervController
 - GradeIntervUI
 - Application
 - ApplicationRepository
 - JobOpeningRepository
 - IntervRunner
---

### Class Diagram ###

[CD.puml](diagrams/uml/CD.puml)

---

## 3.Design

### Sequence Diagram (SD) ###

[SD.puml](diagrams/uml/SD.puml)


---

