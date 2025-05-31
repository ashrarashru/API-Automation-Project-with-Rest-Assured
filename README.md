# API Automation Testing Project with Rest Assured

## Project Description
This project focuses on end-to-end API testing for the [**Daily Finance**](https://dailyfinance.roadtocareer.net) application, covering core features like user and item management. Initial testing was done using Postman, followed by automation with Rest Assured. Both positive and negative scenarios were covered to ensure API reliability and stability.

## Prerequisites
Ensure the following tools and libraries are installed:
- Java JDK (version 8 or later)
- Maven (for dependency management)
- IntelliJ IDEA or any Java IDE of your choice
- Postman (to inspect and test API requests)
- Browser Developer Tools (to capture API details)

## What I Have Done
The following steps were automated and tested successfully:

Step 1: API Inspection with Postman Created a Postman collection to test and document the following API endpoints:
- User Registration
  - Register a new user (Post)
- Login
  - Login with admin credentials (Post)
  - Login with user credentials (Post)
- Management
  - Get user list (Get)
  - Search user (Get)
  - Edit user information (Put)
  - Add cost list (Post)
  - Get list (Get)
  - Update cost list (Put)
  - Delete List (Delete) 

Step 2: Automation Using Rest Assured
- Automated the above API requests with necessary assertions.

## How to Run the Tests
Step 1: Clone the Repository Clone this project using: git clone <repository-url>

Step 2: Open the Project Open the project in IntelliJ IDEA or any Java IDE.

Step 3: Run the Tests Execute the tests using TestNG:

- Right-click on the src/test/java folder.
- Select Run All Tests.
Step 4: Analyze the Results The test results will show detailed logs and validations for each API request and response.

## Postman Collection Documentation
https://documenter.getpostman.com/view/27163024/2sB2qgdduB
## Test Case
https://docs.google.com/spreadsheets/d/1M6Mnu3Qf_CMD1Y1yravksYtWx-an-v1a/edit?usp=sharing&ouid=107234482738036161269&rtpof=true&sd=true
## Allure Report
![01](https://github.com/user-attachments/assets/40274566-6a20-45d8-9c43-da8009202ea4)
![02](https://github.com/user-attachments/assets/64270246-aa02-44ae-ab17-7b91400f8ac3)

