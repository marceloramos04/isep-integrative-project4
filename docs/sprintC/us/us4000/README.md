# US 4000

## 1. Requirements

**US 4000** As a Customer Manager, when displaying the candidate data, I expect the system
to present a top 20 list of the most frequently referenced words from files uploaded by a
candidate. Additionally, I require a comprehensive list of the files in which these words
appear.


---
## 2. Use Case Diagram 
---
## 3. Affected Use Cases

| USE CASE |                   DOCUMENT                   |
|:--------:|:--------------------------------------------:|
|   UC09   | [README.md](..%2F..%2Fuc%2Fuc09%2FREADME.md) |

## 4. US Implementation
[Word.java](..%2F..%2F..%2F..%2Fjobs4u.backoffice%2Fsrc%2Fmain%2Fjava%2Fcandidate%2FcountTopNWords%2FWord.java)
[TopNWordCountController.java](..%2F..%2F..%2F..%2Fjobs4u.backoffice%2Fsrc%2Fmain%2Fjava%2Fcandidate%2FcountTopNWords%2FTopNWordCountController.java)
[TopNWordCountUI.java](..%2F..%2F..%2F..%2Fjobs4u.backoffice%2Fsrc%2Fmain%2Fjava%2Fcandidate%2FcountTopNWords%2FTopNWordCountUI.java)
[WordCountThread.java](..%2F..%2F..%2F..%2Fjobs4u.backoffice%2Fsrc%2Fmain%2Fjava%2Fcandidate%2FcountTopNWords%2FWordCountThread.java)