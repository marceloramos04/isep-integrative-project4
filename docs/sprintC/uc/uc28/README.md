# USE CASE 28 #

## 1.Description ##

- UC28 - Upload a text file with the data fields of a candidate for its verification.

---

## 2.Acceptance Criteria ##

- The uploaded file must be verified by the system.

---

## 3.NFR09(LPROG) ##

- Requirement Speciations and Interview Models The support for this functionality must follow specific technical
  requirements, specied in LPROG.
- The ANTLR tool should be used (https://www.antlr.org/)

---

## 4.Dependencies ##

- The system must have the ANTLR tool installed.

---

## 5.Input and Output Data ##

**Typed Data**:

- Text file with the data fields of a candidate.

**Selected Data**:

- N/A

**Output Data**:

- ANTLR output.

---

## 6.Sequence Diagram (SD) ##

![SD.png](diagrams%2Fpng%2FSD.png)

---

## 7.Classes Identified ##

- UploadRequirementsFileUI
- UploadRequirementsFileController
- UploadRequirementsFileService

---

## 8.Class Diagram ##

![CD.png](diagrams%2Fpng%2FCD.png)

---

## 9.Tests ##

### Test 01 ###

**Title**: Upload a text file with the data fields of a candidate for its verification.

**Description**: The user uploads a text file with the data fields of a candidate for its verification.

**Preconditions**: The user is logged in the system.

**Test Steps**: Type de directory of the file and click enter.

**Expected Result**: The system must verify the file and return the ANTLR output.

---