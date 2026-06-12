# AKQA Booking Assessment - Flight Search Automation

## Overview

This project automates flight search functionality on Agoda using Selenium WebDriver, Java, and TestNG.

The framework follows the Page Object Model (POM) design pattern to improve maintainability, readability, and scalability.

## Technology Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* Page Object Model (POM)

## Project Structure

```text
src
├── main
│   └── java
│       ├── pages
│       │   └── AgodaFlightPage.java
│       └── utils
│
└── test
    └── java
        ├── base
        │   └── BaseTest.java
        └── tests
            └── AgodaFlightSearchTest.java
```

## Automated Test Scenarios

### Test Case 1: Verify Flight Search Result

**Objective:**
Verify that users can search for flights from Mumbai to New Delhi and view the correct search results.

**Steps:**

1. Launch Agoda website.
2. Navigate to Flights section.
3. Select Mumbai as Origin.
4. Select New Delhi as Destination.
5. Select tomorrow's travel date.
6. Increase passenger count to 2.
7. Click Search.
8. Verify the search result title.

**Expected Result:**
The search result page should display:

```text
Flights from Mumbai to New Delhi
```

---

### Test Case 2: Verify Search Without Selecting Any Fields

**Objective:**
Verify that mandatory field validations are displayed when the user clicks Search without providing flight details.

**Steps:**

1. Launch Agoda website.
2. Navigate to Flights section.
3. Do not enter Origin.
4. Do not enter Destination.
5. Do not select travel date.
6. Click Search.

**Expected Result:**
Appropriate validation message should be displayed and search should not proceed.

---

### Test Case 3: Verify Cross Browser Testing

**Objective:**
Verify that flight search functionality works consistently across supported browsers.

**Browsers Covered:**

* Chrome
* Firefox
* Edge

**Steps:**

1. Execute flight search test on Chrome.
2. Execute flight search test on Firefox.
3. Execute flight search test on Edge.
4. Verify successful execution on all browsers.

**Expected Result:**
Flight search should work successfully across all supported browsers without functional issues.

---

## Framework Features

* Page Object Model (POM)
* Reusable Browser Factory
* Explicit Waits
* Cross Browser Support
* TestNG Execution
* Maven Dependency Management

## Execution Steps

### Run Through TestNG

Execute:

```text
testng.xml
```

### Run Through Maven

```bash
mvn clean test
```

## Assumptions

* Agoda website is available and accessible.
* Flight search service is operational.
* Internet connection is available during execution.
* Browser drivers are configured through BrowserFactory.

## Future Enhancements

* Data Driven Testing using TestNG DataProvider
* Extent Reports Integration
* Screenshot Capture on Failure
* Jenkins / GitHub Actions Integration
* Retry Mechanism for Failed Tests

## Author
Saloni Khandelwal
