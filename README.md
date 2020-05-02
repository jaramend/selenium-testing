# Starter kit for Selenium Grid tests using Maven

## Requirements
* Java 11
* Maven 3.6

## Used tools
* TestNG
* ExtentReports
* Maven
* Selenium Grid

## Description
This starter kit allows you to create an automated functional test project based on Selenium. These tests are based on the use of Selenium Grid.
Selenium Grid is a service allowing to use remote webdrivers, and thus avoids the installation of local webdrivers.

The kit was designed with the idea that the test cases are generated using Selenium IDE.
Selenium IDE is a Chrome or Firefox plugin, allowing to script functional scenarios according to the actions performed in the browser. The scenarios are then exportable in Java code, which can be directly integrated into this project.

The project also generates a test report using ExtentReports.

The launch and scheduling of tests is managed using TestNG.

## Use
### Configuration
Edit the **test.properties** file to indicate the following information:
* Selenium Grid URL
* App to test URL
* Browser to use (chrome or firefox)

### Add tests
Test templates are present in the **tests** package, containing examples of the use of test groups and dependencies.

Each test class must extend the **BaseTest** class, which is responsible for carrying out the necessary actions before and after the tests, in particular the management of the RemoteWebDriver.

Classes must have a name ending with *Test* so that they are recognized by maven-surefire.

Each new test must be declared in the file **testng.xml** in order to schedule the execution of the methods.
Groups can be created in order to be able to condition the execution of certain groups of tests on the success of other groups.

When exporting tests from Selenium IDE, simply copy / paste the test method (without the *@Before* and *@After* methods) into your test class.

### Use of TestNG
The execution of the tests is managed by the **TestNG** module. All the documentation relating to its use is available here:
[TestNG documentation](https://testng.org/doc/documentation-main.html)