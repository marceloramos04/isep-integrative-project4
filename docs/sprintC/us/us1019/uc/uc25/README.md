# UC25 #

## 1.Requirements Engineering ##

     This section describes the requirements of the use case.

### Use Case Description ###

     UC25:  As Customer Manager, I want to get an ordered list of candidates, using the job interview points (grades), to help me analyze the candidates.

### Client Specifications and Clarifications ###

> **Question:** Relativamente a esta user story, "US 1019 - As Customer Manager, I want to get an ordered list of candidates, using the job interview points (grades), to help me analyze the candidates.", a lista que pretende é relacionada a uma job opening correto? A maneira de ordenação é ascendente ou quer uma opção que inclua ascendente e descendente?>
>
> **Answer:** Sim, a ordenação é relativa a candidaturas para um job opening. A ordenação deve ser descendente, do que tem maior pontuação para o que tem menor pontuação.


> **Question** Na US 1019: As Customer Manager, I want to get an ordered list of candidates, using the job interview points (grades), to help me analyze the candidates. Pretende que para uma determinada Job Opening de um cliente meu, retorno uma lista ordenada de candidatos e suas notas da entrevista. Penso implementar essa funcionalidade da seguinte forma:
Job Opening : XXX
Nome | Email | Grade
Jane Doe| jane@doe.pt | 85
John Doe | john@doe.pt | 70
Ou seja com ordenação descendente.
Conforme refere Q153 consegue ver numa instancia esta lista, e noutra instancia faz o ranking que achar pertinente.
> 
> **Answer:** Penso que queira fazer referência a Q163. Relativamente ao exemplo que apresenta parece-me que satisfaz o que pretendo.

> **Question**Na questao Q169 é mencionado para a listagem ser ordenada descendentemente da nota da entrevista (como mencionado tambem na própria US), no entanto, a questão é, como idealiza a ordenação caso a job opening não possua entrevista?
> 
> **Answer:**Esta US não faz sentido para processos que não tenham entrevista
>

> **Question**segundo a resposta A197, devemos então apenas permitir a listagem de job openings que tenham entrevista?
> 
> **Answer:**Penso que não percebi bem a referência à listagem de job openings. Esta US não faz sentido para job openings que não tenham entrevista, uma vez que assenta na listagem dos candidatos e dos seus pontos nas entrevista.
>
> 
---

### Acceptance Acceptance Criteria ###

    AC01: 
    AC02: 
---

### Dependencies ###


---

### Input and Output Data ###

**Typed Data**: 

   

**Selected Data**:
  * job Offer

**Output Data**:
    
    * Ordered list of candidates
    * Operation Success

---

### System Sequence Diagram (SSD) ###

[SSD.puml](diagrams%2Fuml%2FSSD.puml)

---

## 2.Analysis

### Classes identified ###

 - RetrieveOrderedListOfCandidatesUI
 - RetrieveOrderedListOfCandidatesController
 - RetrieveOrderedListOfCandidatesService
 - Application
 - Interview
 - InterviewStatus
 - CandidateRepository
 - Candidate
---

### Class Diagram ###

[CD.puml](diagrams%2Fuml%2FCD.puml)

---

## 3.Design

### Sequence Diagram (SD) ###

[SD.puml](diagrams%2Fuml%2FSD.puml)


---

