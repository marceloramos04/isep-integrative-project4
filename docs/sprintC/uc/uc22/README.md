# UC16 #

## 1.Requirements Engineering ##

     This section describes the requirements of the use case.

### Use Case Description ###

     UC16: Record the time and date for an interview with a candidate.

### Client Specifications and Clarifications ###

 > Q182 Clarifications -  In the us "US 1014 - As Customer Manager, I want to record the time and date for an interview with a candidate." Is it possible to schedule interviews for any day and time, or we must take into account weekends, working hours and holidays, for example?
 
 > A182 The system should display the day of the week for the selected date. But the system should accept any valid date.  maybe is not the best. Maybe “rank not recorded” or something similar could be more appropriated.
---
> Q145 -  Em relação à marcação da intervista, só deve ser possível marcar esta data quando? Só será possível marcar a entrevista quando a fase de recrutamento se encontrar na fase de intervista? Ou será possivel marcar noutras fases anteriores?

> A145 Por mim pode ser possível marcar as entrevistas antes mas deve-se ter em atenção se o candidato “passou” o screening. Não faz sentido marcar uma entrevista para um candidato que não foi aceite. Tenham em atenção este tipo de aspetos.
---

> Algo como indicar o dia e a hora (ex: 23 de abril pelas 14:00). Em relação à marcação de entrevistas “sobrepostas” (com a mesma data de inicio), neste momento, seria algo a permitir (pode, por exemplo, o customer manager delegar noutra pessoa a condução da entrevista). Isso não invalida que devam validar se as entrevistas ocorrem dentro da fase das entrevistas.

### Acceptence Acceptance Criteria ###

    AC01: Candidate Application must have passed the screening phase.
    AC02: Interview Date and time must be within the Interview phase dates of the job opening.

---

### Dependencies ###

    The candidates must have applications registered in the system.

---

### Input and Output Data ###

**Typed Data**:

    * Candidates Email
    * Date and Time of the Interview


**Selected Data**:

    * Job opening

**Output Data**:

    * Scheduled Interview

---

## 2.Analysis

### Classes identified ###

- ScheduleInterviewUI
- ScheduleInterviewController
---

### Class Diagram ###

![CD.svg](diagrams%2FCD.svg)

---

## 3.Design

### Sequence Diagram (SD) ###

![SD.svg](diagrams%2FSD.svg)

---

### 4.Tests

**Refers to Acceptance Criteria:** AC01

**Test 1:** *Verifies candidate application screening result status*

- Candidate applications that didnt pass the screening phase should not be able to schedule an interview.


**Refers to Acceptance Criteria:** 

**Test 2:** *Verifies that the date and time is a valid one*

- Its not allowed to input a date on the past or thats not within the interview phase dates.

---