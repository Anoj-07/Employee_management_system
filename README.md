# Employee Management System

## Project Overview

The **Employee Management System** is a web application built with Spring Boot, Spring Data JPA, MySQL, and React. The application allows users to manage employee data, including adding, updating, viewing, and deleting employee records. The system provides a RESTful API that can be consumed by the front-end, which is built using React and styled with Tailwind CSS.

### Technologies Used
- **Backend:**
  - Spring Boot
  - Spring Data JPA
  - MySQL
  - REST API
  - Postman (for API testing)
- **Frontend:**
  - React
  - Tailwind CSS

## Features

- **Create Employee:** Add a new employee with details like first name, last name, and email.
- **Get All Employees:** Fetch a list of all employees.
- **Get Employee by ID:** View an employee's details by their unique ID.
- **Update Employee:** Modify an existing employee's details.
- **Delete Employee:** Remove an employee from the system.

## API Endpoints

Below are the available API endpoints for the Employee Management System.

### 1. Create Employee
- **URL:** `/api/v1/employees`
- **Method:** `POST`
- **Description:** Creates a new employee by sending employee details in the request body.
  
#### Request Body:
- `firstName` (String): The first name of the employee.
- `lastName` (String): The last name of the employee.
- `emailId` (String): The email address of the employee.

#### Response:
- **Status:** 201 (Created)
- **Body:** The newly created employee object with an auto-generated `id`.

---

### 2. Get All Employees
- **URL:** `/api/v1/employees`
- **Method:** `GET`
- **Description:** Retrieves a list of all employees.

#### Response:
- **Status:** 200 (OK)
- **Body:** A list of all employee objects.

---

### 3. Get Employee by ID
- **URL:** `/api/v1/employees/{id}`
- **Method:** `GET`
- **Description:** Retrieves the details of a specific employee based on their ID.

#### Request Parameter:
- `id` (Long): The unique identifier of the employee.

#### Response:
- **Status:** 200 (OK)
- **Body:** The employee object corresponding to the given `id`.

---

### 4. Update Employee
- **URL:** `/api/v1/employees/{id}`
- **Method:** `PUT`
- **Description:** Updates an existing employee’s details by providing the `id` and sending the new data in the request body.

#### Request Parameter:
- `id` (Long): The unique identifier of the employee.

#### Request Body:
- `firstName` (String): The updated first name of the employee.
- `lastName` (String): The updated last name of the employee.
- `emailId` (String): The updated email address of the employee.

#### Response:
- **Status:** 200 (OK)
- **Body:** The updated employee object.

---

### 5. Delete Employee
- **URL:** `/api/v1/employees/{id}`
- **Method:** `DELETE`
- **Description:** Deletes an employee from the system by specifying their `id`.

#### Request Parameter:
- `id` (Long): The unique identifier of the employee.

#### Response:
- **Status:** 200 (OK)
- **Body:** A confirmation message indicating whether the employee was successfully deleted. The response will contain a `delete` field, which will be `true` if the employee was successfully deleted.

---

### Notes:
- **CORS Support:** The API has CORS enabled for frontend interaction with a React app running locally (http://localhost:3000).
- **Validation:** The `Employee` entity class includes validation annotations (`@NotBlank`, `@Email`) to ensure that the incoming data meets the required format.

## Installation and Setup

This section covers the steps to set up and run the **Employee Management System** project for both the **backend (Spring Boot)** and **frontend (React and Tailwind CSS)**.

---

### Backend Setup (Spring Boot)

Follow these steps to set up the backend of the project:

#### Prerequisites:
- Java 11 or higher
- Maven or Gradle (Maven is recommended)
- MySQL Database

#### Steps:
1. **Clone the repository:**
  ```
git clone https://github.com/your-username/employee-management-system.git
   cd employee-management-system
```

2. **Set up MySQL Database:**
```
spring.datasource.url=jdbc:mysql://localhost:3306/employee_management_system
spring.datasource.username=root
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
```
3. **Build and Run the Backend:**
- Using Maven
```
mvn clean install
mvn spring-boot:run
```
4. **Run the Application:**
- The backend will be running on http://localhost:8080. You can now access the API endpoints.

## Frontend Setup (React and Tailwind CSS)

Follow these steps to set up the frontend of the **Employee Management System** using **React** and **Tailwind CSS**.

---

### Prerequisites:
- Node.js (v14 or higher)
- npm (Node Package Manager)

---

### Steps to Set Up the Frontend:

1. **Clone the Repository:** First, clone the repository for the frontend application.
```
git clone https://github.com/your-username/employee-management-system-frontend.git
cd employee-management-system-UI
```
2. **Install Dependencies:**
The frontend project relies on several npm packages. Install the necessary dependencies using the following command:
```
npm install
```
3. **Set up the API URL:**
```
const API_URL = 'http://localhost:8080/api/v1';
```
4.**Configure Tailwind CSS**

## Common Issues and Troubleshooting:
- CORS Issues: If you encounter any CORS issues, ensure that the backend has CORS enabled for http://localhost:3000, as mentioned in the backend setup.
- API Errors: If the frontend is not fetching data from the backend, double-check the API URL configuration in the frontend code and ensure that the backend is running correctly.
-Tailwind CSS not applying styles: Make sure that Tailwind CSS is properly set up in your project. Verify that src/index.css has the correct Tailwind imports.


### Explanation:
1. **Prerequisites**: This section outlines the required software: Node.js and npm.
2. **Steps to Set Up the Frontend**: It provides a step-by-step guide, starting with cloning the repository, installing dependencies, and configuring the API URL to point to the backend.
3. **Tailwind CSS Setup**: If Tailwind CSS isn't set up yet, this section provides the necessary steps to install and configure it for styling the application.
4. **Running the Frontend**: It explains how to start the React development server and test the frontend in the browser.
5. **Common Issues and Troubleshooting**: This section lists potential issues (like CORS problems or incorrect API URLs) and provides solutions to fix them.

This setup guide should provide your users with a smooth experience when setting up the frontend of your Employee Management System.

