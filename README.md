# Universal Modeling Language Software Development Kit

* v1.2.69
* How to read version # Version main branch.release branch.pull request changes'
* What's New

## Table of Contents
1. [Overview](#overview)
2. [Features](#features)
3. [Getting Started](#getting-started)
4. [Installation](#installation)
5. [Running the Application](#running-the-application)
6. [Usage](#usage)
7. [Testing](#testing)
8. [Contributing](#contributing)
9. [License](#license)
10. [Contact](#contact)
11. [Project Details](#Project-Details)
---

## Overview

DevKitUML is a unified modeling language (UML) software development kit (SDK) designed to simplify the process of generating, managing, and interacting with UML diagrams for developers. This project integrates a console-based interface for UML Editor functionality.

This SDK is intended to streamline the experience of creating class diagrams, modifying them, and saving/loading project data using JSON format for persistence.


---

## Features

- **Command-Line Interface (CLI):** Provides a terminal-like environment where users can execute commands within the JavaFX terminal window.
- **JSON Integration:** Uses Gson for saving/loading the project data in JSON format.
- **Multi-platform Support:** Designed to work on Windows, macOS, and Linux with cross-platform capabilities.

---

## Getting Started

### Prerequisites

Ensure that the following software is installed on the target machine:

- **Java Runtime Environment (JRE)** or **Java Development Kit (JDK)** version 17 or higher.  
  You can download it from the [Oracle Java Downloads page](https://www.oracle.com/java/technologies/javase-downloads.html) or from [AdoptOpenJDK](https://adoptopenjdk.net/).

## Steps to Run the UML Editor

### 1. Obtain the JAR File
Download the package https://github.com/hbarton2/cscd350-f24-TeamNull.git

Under root diretory folder <folder name>
Make sure you have the `umleditor-1.jar` file, which contains the application.

Run the Program
Use the java -jar command to run the JAR file:

java -jar umleditor-1.jar

### Dependencies

The project uses the following dependencies, which are defined in the `pom.xml` file:


See the `pom.xml` file for full details on dependencies.

### Building the Project

<!--You can build the project using Maven. From the project root directory, run:

```bash
mvn clean install
```
-->
---

## Installation

### Prerequisites

Before running the project, ensure you have the following installed:

- **Java JDK 22** or later
- **Maven 3.6** or later

### Step-by-Step Instructions

## Due to issue with Gson not being able to compile correctly please run the application "umleditor.EntryPoint.java" in the IDE prefer IntelliJ IDEA

```angular2html
src/main/java/proj/TeamNull/UMLdevkit/umleditor.EntryPoint.java
```

1. Clone the repository:
   ```bash
   git clone https://github.com/hbarton2/cscd350-f24-TeamNull.git
   cd projectname
2. Build the project using Maven:
   ```bash
   mvn clean install
3. Run the project:
   ```bash
   mvn javafx:run

---

## Running the Application
To run the project, execute the following command:

```bash
mvn javafx:run
```
Alternatively, you can use your favorite IDE, such as IntelliJ IDEA, with Maven integration.

## Usage
### Console Interaction 
The application includes an in-app terminal/console feature, allowing users to input commands within the JavaFX interface. Users can enter specific commands for various operations such as creating, renaming, and removing classes, attributes, and methods.

- Help Menu: Users can access the help menu for detailed guidance.
- Command-Line Operations: Integration of the command-line terminal where you can execute operations directly without leaving the graphical interface.

### JSON Integration
The project uses Gson for storing and loading UML project data as JSON files. The data includes class names, attributes, and methods, allowing for an easily shareable format.

### Unit Testing
JUnit is used for unit testing throughout the project. To run the tests, use:

```bash
mvn test
```
---



## Testing
To run unit tests, execute the following command:
```bash
mvn test
```
Testing is performed using JUnit 5 and includes:
- Unit tests for core functionalities.
- Integration tests for external API calls.

You can find tests under the src/test directory.

---

## Contributing

<!--
We welcome contributions! Here's how you can help:
1. Fork the repository.
2. Create a new branch:
   ```bash
   git checkout -b feature-name
3. Commit your changes:
   ```bash
   git commit -m 'Add some feature'
4. Push to the branch:
   ```bash
   git push origin feature-name
5.Open a Pull Request.

Please follow our contribution guidelines for more details.
-->
---

## License
Please see LICENSE.md

---

## Contact

For any inquiries, feel free to reach out to:

- TEAM NULL 
- GitHub: https://github.com/hbarton2/cscd350-f24-TeamNull

---

## Acknowledgments
- Special thanks to Jimmy, Kate, Colton, Muhammad, and Shane!! :)

---

## Project Details

For known issues and project explaination please see: FinalTechnicalSpecification.md under project_root_folder/documentation/


