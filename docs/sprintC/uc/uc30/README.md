# UC30 #

## 1.Requirements Engineering ##

     This section describes the requirements of the use case.

### Use Case Description ###

     UC30:  As Customer, I want to list all my job openings, including job reference, position,active since, number of applicants.
### Client Specifications and Clarifications ###

> **Question:** Job Openings Clarifications - You stated that one of the this to show in the listing of job openings is "active since". You've clarified that an active job opening is the one where its recruitment process is on-going. Are the job openings listed in this funcionality only the ones with recruitment process on-going? Or also the ones without recruitment processes, the ones with processes that haven't yet started or have ended?
> 
> **Answer:** 2 In the context of this US, “active since” means the date from the start of the process, the “application” phase (since that date, candidates can apply). This functionality should include all the “active” job openings

---

### Input and Output Data ###

**Typed Data**: 


**Selected Data**:
 -option
**Output Data**:

-All the job opening from the Customer
-Operation Success

---

## 2.Analysis

### Classes identified ###

-TcpCliChat
-TcpSrvSum
-CustomerRepository
-JobOpeningInfo

---

### Class Diagram ###

![CD-UC030_CLASS_DIAGRAM.png](diagrams%2Fpng%2FCD-UC030_CLASS_DIAGRAM.png)
---

## 3.Design

### Sequence Diagram (SD) ###

![SD-UC30_SEQUENCE_DIAGRAM.png](diagrams%2Fpng%2FSD-UC30_SEQUENCE_DIAGRAM.png)


---

