# Project Jobs4U

## Description

Jobs4U is a fictional company specialized in talent acquisition. The company provides recruitment services for job positions in its clients. The aim of this project is to develop, in an exploratory way, a solution that allows automating the main activities of the company. Therefore, a minimum viable product should be developed in 3 months.

The company’s clients are other companies or entities that need to recruit human resources. In response to requests from its clients, Jobs4U develops all activities that allow it to select a set of candidates for job offers (from its clients). At the end of the process, Jobs4U must deliver to its client an ordered list of candidates for each job offer. The final recruitment decision is the responsibility of the client.

[System Specifications](docs/projeto-integrado-sys-spec-v8.pdf)

## Purpose

This project was required by the LAPR4 curricular unit/subject (Laboratory/Project IV) in the fourth semester of the Bachelor’s in Computer Engineering at ISEP. The objective of the curricular unit is to integrate the content from the various subjects of that semester and to simulate a real-world collaborative development environment as found in the software industry.

## Technologies/Tools Used

- **Java**
- **Spring Boot**
- **Maven**
- **C language**
- **Domain-Driven-Design**
- **GitHub** for version control and project management
- **GitHub Actions** for continuous-integration

## Global Artifacts

[Global Artifacts](docs/sprintC/global-artifacts/Readme.md)

## How to Build

The application.properties of the project jobs4u.backoffice must be configured with the correct path for the plugins config files and jar files.

To build the project the JAVA_HOME must be configured as a system environment variable in the user's computer. That said, to build the project and produce the executable files, the user must run these commands in the project root directory:

```
cd jobs4u.utils
mvn clean install
cd ../requirem-specs
mvn clean package
cd ../interv-model
mvn clean package
cd ../jobs4u.backoffice
mvn clean install
cd ../jobs4u.customer
mvn clean package
cd ../jobs4u.candidate
mvn clean package
 
```

## How to Run

### Jobs4u Backoffice

In project root run:

```
java -jar jobs4u.backoffice/target/backoffice-0.1.0.jar
```

### Jobs4u Customer

In project root run:

```
java -jar jobs4u.customer/target/customer-0.1.0.jar
```

### Jobs4u Candidate

In project root run:

```
java -jar jobs4u.candidate/target/candidate-0.1.0.jar
```

Caso o utilizador pretenda limpar os artefatos produzidos em builds anteriores, basta introduzir a expressão `clean` entre as instruções, por exemplo: `mvn clean install`

## How to Generate PlantUML Diagrams

To generate plantuml diagrams for documentation execute the script (for the moment, only for linux/unix/macos):

`./generate-plantuml-diagrams.sh`
