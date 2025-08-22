# US 1018

**US 1018** - As Customer Manager, I want to execute the process that evaluates (grades) the interviews for a job opening.

## AFFECTED USE CASES

| USE CASE |               DOCUMENT               |
|:--------:|:------------------------------------:|
|   UC23   | [README.md](..%2F..%2Fuc%2Fuc24%2FREADME.md) |

---

## REQUIREMENTS AND ANALYSIS

US corresponds directly to **UC23** requirements and analysis, so refer to **UC23** documentation for more information.

---
### RUNTIME TESTS

- Run UC24 and check if it correctly grades the interviews answers.

---

## IMPLEMENTATION

- [GradeIntervController.java](../../../../jobs4u.backoffice/src/main/java/application/use_cases/grade_interv_answers/GradeIntervController.java)
- [GradeIntervUI.java](../../../../jobs4u.backoffice/src/main/java/application/use_cases/grade_interv_answers/GradeIntervUI.java)
- [JobOpeningRepository.java](../../../../jobs4u.backoffice/src/main/java/jobOpening/JobOpeningRepository.java)
- [ApplicationRepository.java](../../../../jobs4u.backoffice/src/main/java/application/ApplicationRepository.java)
- [ApplicationManagementService.java](../../../../jobs4u.backoffice/src/main/java/application/ApplicationManagementService.java)
- [IntervModel.java](../../../../jobs4u.utils/src/main/java/requirem_specs/IntervModel.java)
- [Application.java](../../../../jobs4u.backoffice/src/main/java/application/domain/Application.java)
- [Interview.java](../../../../jobs4u.backoffice/src/main/java/application/domain/Interview.java)

