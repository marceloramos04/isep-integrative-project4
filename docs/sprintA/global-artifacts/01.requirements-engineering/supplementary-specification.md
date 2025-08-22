# Supplementary Specification (FURPS+)

## Functionality

_Specifies functionalities that:  
&nbsp; &nbsp; (i) are common across several US/UC;  
&nbsp; &nbsp; (ii) are not related to US/UC, namely: Audit, Reporting and Security._

## Usability

_Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._

## Reliability

_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._



## Performance

_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._


## Supportability

_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and more._

## +

### Design Constraints

_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._

- **NFR01 - Programming language:** The solution should be implemented using Java as the main language. Other languages can be used in accordance with more specific requirements.
- **NFR02 - Technical Documentation:** Project documentation should be always available on the project repository ("docs" folder, markdown format) and, when applicable, in accordance to the UML notation. The development process of every US (e.g.: analysis, design, testing, etc.) must be reported (as part of the documentation).
- **NFR04 - Source Control:** The source code of the solution as well as all the documentation and related artifacts should be versioned in a GitHub repository to be provided to the students. Only the main (master/main) branch will be used (e.g., as a source for releases).
- **NFR05 - Continuous Integration:** The Github repository will provide night builds with publishing of results and metrics.
- **NFR06 - Deployment and Scripts:** The repository should include the necessary scripts to build and deploy the solution in a variety of systems (at least Linux and Windows). It should also include a readme.md file in the root folder explaining how to build, deploy and execute the solution.
- **NFR15(LAPR4):** This project has some specific requirements regarding communication and presentation of the project and its results. This is a concern of the project and its related to the presentations for the sprint reviews in the context of the LAPR4 TP classes (i.e., skills module). LAPR4 will provide further specification for this requirement.

### Implementation Constraints

_Specifies or constraints the code or construction of a system such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._

- **NFR03 - Test-driven development:** The team should develop a relevant set of automated tests for every US / Class / Method. The team should aim to adopt a test-driven development approach.
- **NFR08 - Authentication and Authorization:** The system must support and apply authentication and authorization for all its users and functionalities.
- **NFR09(LPROG) - Requirement Specifications and Interview Models:** The support for this functionality must follow specific technical requirements, specified in LPROG. The ANTLR tool should be used (https://www.antlr.org/) 
- **NFR11(RCOMP):** The solution should be deployed using several network nodes. It is expected that, at least, the relational database server and the Follow Up Server be deployed in nodes different from localhost, preferably in the cloud. The email notification tasks must be executed in background by the Follow Up Server.
- **NFR12(SCOMP):** The base solution for the upload of files must be implemented following specific technical requirements such as the use of the C programming language with processes, signals and pipes. Specific requirements will be provided in SCOMP.
- **NFR14(SCOMP):** The process to count words of very large files should follow specific technical requirements such as implementing parallelism and concurrency using Java and threads. Specific requirements will be provided in SCOMP.

### Interface Constraints

_Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems._

- **NFR07 - Database:** By configuration, the system must support that data persistence is done either "in memory" or in a relational database (RDB). Although in-memory database solutions can be used during development and testing, the solution must include a final deployment where a persistent relational database is used. The system should have the ability to initialize some default data.
- **NFR10(RCOMP) - Functionalities related to the candidate and Customer Apps and to the Follow Up Server:** It must follow a client-server architecture, where a client application is used to access a server. Communications between these two components must follow specific protocol described in a document from RCOMP ("Application Protocol"). Also, the client applications can not access the relational database, they can only access the server application.
- **NFR13(SCOMP):** An alternative solution for the upload of files must be implemented following specific technical requirements such as the use of the C programming language with shared memory and semaphores. Specific requirements will be provided in SCOMP.

### Physical Constraints

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

