## Test Driven Development with JUnit & Mockito
# Project Description
This repository contains example code that demonstrates the application of Test Driven Development (TDD) principles using the JUnit and Mockito testing frameworks. The two key components of this project are the GradeCalculatorService and GroupControllerService, each having corresponding test classes GradeCalculatorServiceTest and GroupControllerServiceTest.

GradeCalculatorService is a simple service designed to calculate the classification of a grade based on the mark input it receives. It throws exceptions if the mark is negative or above 100.

GroupControllerService is a service that manages operations related to a group of trainees, such as retrieving all trainees and adding or removing a trainee. It interacts with DatabaseReader and DatabaseWriter interfaces, which are mocked during testing.

# Test Driven Development
TDD is a software development approach where the developer creates tests before writing the implementation code. The steps are as follows:

1. Write a test for a small piece of functionality.
2. Run the test, which should fail because the functionality isn't implemented yet.
3. Write the minimum amount of code necessary to make the test pass.
4. Refactor the code and make sure the test still passes.
5. Repeat for the next piece of functionality.
The test classes GradeCalculatorServiceTest and GroupControllerServiceTest contain several test cases following TDD approach, demonstrating different scenarios that the system should handle.

## Testing Tools
# JUnit
JUnit is a widely-used testing framework for Java applications. It provides assertions to identify test method, test the expected results, setup and tear down test environments, and test whether a certain part of code throws expected exception.

# Mockito
Mockito is a mocking framework used in conjunction with testing frameworks such as JUnit. It allows you to write tests with a clean and simple API. Mockito lets you 'mock' dependencies, or objects that your code under test interacts with. By using mocks, you can isolate your code from the rest of the system to ensure that your tests are fast and reliable.
