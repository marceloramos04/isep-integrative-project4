# US G005

## 1. Context

This US requires that scripts are implemented to allow processes such as build and execute, per example, to be executed in an easy and practical way.

This is the first US about this task. Since this is a global task, it can be tackled later in further sprints to update the scripts as the characteristics of the project change.

## 2. Requirements

> **G005** - As Project Manager, I want the team to add to the project the necessary scripts, so that build/executions/deployments/... can be executed effortlessly.

**Acceptance Criteria:**

- **AC01** - running scripts must allow the user to build the project and generate the executable files
- **AC02** - the scripts must allow the user to run the project unit tests all at once
- **AC03** - the user must be able to run the executable files after building the project (AC01)
- **AC04** - using the scripts the user must be able automatically deploy/install the project in another machine

## 3. Observations

In order for the build scripts to work, the user must have the JAVA_HOME configured as the system environment variable on the computer, as well as having Maven installed and its environment variable configured.