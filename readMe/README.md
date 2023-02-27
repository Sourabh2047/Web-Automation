# Doxzilla Test Automation

* **GOAL**: Provide automated web browsing to validate doxzilla web.
* **HOW**: By leveraging Selenium web automation, TestNG as the execution test framework, and MAven for Building
  Project.

## References

* Manual Test Cases Included in Excel Spreadsheet,
  https://docs.google.com/spreadsheets/d/1qtt9_o5Pk4igaNz1nETfI242CAU3cyc51SkzjSiGS2A/edit?usp=share_link

### General Architecture

* Selenium 4.0
* TestNG 7.7.1
* Extent Reports
* Maven M2E 3.8.7
* Java SDK 8 or above
* Java JRE 1.7 and above
* WebDriver Manager 4.3.1
* Log4J for Logs collection
* Page Object Model Implementation
* ChromeWebDriver, Firefox, Edge (need to download geko driver@ C:/)

### Developer Environment Setup and Build Instructions

* Install Java 8 or above in local machine, setup environment variable as JAVA_HOME,
* Install Maven in local machine, and GIT if using CMD for Cloning the project.

### Test Setup and Execution Instructions

* The instructions to install and run the web automation suite can be found [here].
* Install IntelliJ or Eclipse IDE with M2E Intgeration.
* Connet GIT and clone the project and creat one local branch.
* Define VM Option as -Denv="QA/UAT/PROD"
* Edit run/debug config and select TestNG Suite if wanna run from Testng.xml else select TestNG/runner package to run
  all test_Doxzilla.