# US G004

## 1. Context

This task consists in the setup of a continuous integration server, in this case, one that will be used to validate the project's build everytime a commit is made to the repository and every day at 00:00.

## 2. Requirements

**US G004** As Project Manager, I want the team to setup a continuous integration server.

**Acceptance Criteria:**

- **G004.1.** Every commit made to the repository should trigger a build in the continuous integration server.

- **G004.2.** Every day at 00:00, the continuous integration server should trigger a build.

**Dependencies/References:**

*Regarding this requirement we understand that it relates to making sure that the project, after each alteration still continues to work as normal.*


## 3. Implementation

[Continuous Integration Server File](../../../.github/workflows/maven.yml)

## 4. Integration/Demonstration

The scripts used in the file above are used to build the project and run the tests. The file is configured to run the build every time a commit is made to the repository and every day at 00:00.

## 5. Observations

In the description of the project, given by the client, it was requested that the project should have a continuous integration server. This server should be used to validate the project's build every day at 00:00, but in the (Questions (and Answers) to the Product Owner (from the online sessions with the product owner)) the client said that the server should validate the project's build every time a commit is made to the repository. So, we decided to implement both of the requirements. 

This workflow will build a Java project with Maven, and cache/restore any dependencies to improve the workflow execution time
For more information see: https://docs.github.com/en/actions/automating-builds-and-tests/building-and-testing-java-with-maven

This workflow uses actions that are not certified by GitHub.
They are provided by a third-party and are governed by
separate terms of service, privacy policy, and support
documentation.