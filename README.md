# Test Automation Framework

* **GOAL**: Provide automated web browsing to validate web application.
* **HOW**: By leveraging Selenium web automation, TestNG as the execution test framework, Maven for Building Project and ExtentReport for Detailed Report.

## General Architecture

* Selenium 4.0
* TestNG 7.7.1
* Extent Reports
* Maven M2E 3.8.7
* Java SDK 8 or above
* Java JRE 1.7 and above
* WebDriver Manager 4.3.1
* Log4J for Logs collection
* Page Object Model Implementation
* ChromeWebDriver, Firefox, Opera, Edge.

## Developer Environment Setup and Build Instructions

* Install Java 8 or above in local machine, setup environment variable as JAVA_HOME,
* Install Maven in local machine, and GIT Bash if using Terminal for Cloning the project.

## Test Setup and Execution Instructions

* The instructions to install and run the web automation suite can be found [here].
* Install IntelliJ or Eclipse IDE with M2E Intgeration.
* Connet GIT and clone the project and creat one local branch.
* Define VM Option as -Denv="QA/UAT/PROD"
* Mention TestNG.xml runner and configure by clicking on Edit run/debug config and select TestNG Suite.
  if wanna run custom class select TestNG/runner class and mention which class to run.
