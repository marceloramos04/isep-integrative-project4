# UC08 #

## 1.Requirements Engineering ##

     This section describes the requirements of the use case.

### Use Case Description ###

     UC09 : Display data of a candidate

### Client Specifications and Clarifications ###

> Q: Na us 1006, seria aceitavel perguntar ao costumer manager o id do candidato de que deseja visualizar os dados, ou seria mais pertinente dar uma lista de todos os candidos e deixa-lo escolher dessa lista, assumindo que este não tem maneira de saber o id do candidato de que quer obter dados.

> A:Note-se que a US1005 permite obter as candidaturas para uma job opening. Esta US é para mostrar os dados de um candidato. Portanto parece existir forma de aceder ao id do candidato, caso não se saiba qual é.
---

### Acceptance Acceptance Criteria ###

    N/A

---

### Dependencies ###

    The candidate has to be registered in the system (UC08).

---

### Input and Output Data ###

**Typed Data**:

    * candidate id


**Output Data**:

    * candidate Details (email,name,phone number)

---

## 2.Analysis

### Classes identified ###

- ShowCandidateUI
- ShowCandidateController
- ShowCandidateRepository
---

### Class Diagram ###

![CD-UC09_CLASS_DIAGRAM.svg](diagrams%2Fsvg%2FCD-UC09_CLASS_DIAGRAM.svg)

---

## 3.Design

### Sequence Diagram (SD) ###

![SD-UC09_SEQUENCE_DIAGRAM.svg](diagrams%2Fsvg%2FSD-UC09_SEQUENCE_DIAGRAM.svg)

---

