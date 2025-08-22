# Project Jobs4U

## Description of the Project

[System Specifications](docs/projeto-integrado-sys-spec-v8.pdf)

## Planning and Technical Documentation

[Planning and Technical Documentation](docs/readme.md)

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

## Global Artifacts

[Global Artifacts](docs/sprintC/global-artifacts/Readme.md)
