# Employee Management System

A comprehensive Java-based desktop application designed to streamline the management of employee records. This system allows administrators to perform essential CRUD operations through a user-friendly graphical interface.

# Features

 * **Add Employee:** Register new employees with details including ID, Name, Contact, and Designation.
 * **View Details:** Search and display employee records from the database in a structured table format.
 * **Update Information:** Modify existing employee data easily.
 * **Remove Employee:** Securely delete employee records from the system.
 * **Print Functionality:** Generate physical or PDF copies of employee records.

# Tech Stack

 * **Language:** Java
 * **GUI Framework:** Java Swing & AWT
 * **Database:** MySQL
 * **IDE:** Apache NetBeans

# Screenshots

<img width="1149" height="640" alt="Screenshot (1)" src="https://github.com/user-attachments/assets/cb847b47-7e1f-4fe9-9920-238f90668862" />
<img width="581" height="294" alt="Screenshot (2)" src="https://github.com/user-attachments/assets/62dbcb6e-e1dd-41aa-8cd3-e17897c07f19" />
<img width="1111" height="620" alt="Screenshot (3)" src="https://github.com/user-attachments/assets/a85cd47d-a250-427c-a25a-df649176863e" />
<img width="879" height="689" alt="Screenshot (4)" src="https://github.com/user-attachments/assets/83a80f39-7b31-4108-b77d-e280964916c4" />
<img width="1034" height="692" alt="Screenshot (5)" src="https://github.com/user-attachments/assets/ff937497-3267-4d2d-b4d3-7d032f99ca8c" />
<img width="879" height="687" alt="Screenshot (6)" src="https://github.com/user-attachments/assets/5743654f-ef9e-4480-ad0a-d4c4eda511bb" />
<img width="1034" height="484" alt="Screenshot (7)" src="https://github.com/user-attachments/assets/b4ea2aaa-db0b-4fad-8f55-3a366a903822" />

# Getting started

**Prerequisites**

 * **JDK:** Ensure you have Java Development Kit (JDK 8 or higher) installed.
 * **MySQL:** Install MySQL Server and MySQL Workbench.
 * **JDBC Driver:** Download the mysql-connector-java.jar file.

**Installation**

* **Clone the Repository:**

  git clone https://github.com/Sou-127/employee-management-system.git

* **Databse setup:**

   * Open MySQL Workbench and create a database named ems.
   * Run the provided SQL script (if you have one) or create a table with the fields: EmployeeID, Name, Father's name, Address, Phone, Email, Education, Designation, DateofBirth, Aadhaar No.

* **Configure Connection:**

   * Update the Conn.java (or equivalent) file with your MySQL username and password.
 
* **Run the Application:**

   * Open the project in your preferred IDE.
   * Add the mysql-connector-java.jar to your project libraries.
   * Run Splash.java to start the application.
 
#  Project Structure

   * **src/:** Contains the Java source files.
     * **Splash.java:** Initial loading screen.
     * **Login.java:** Admin authentication.
     * **Home.java:** Main dashboard with navigation buttons.
     * **AddEmployee.java:** Form for adding new records.
     * **ViewEmployee.java:** Table view and search functionality.
     * **UpdateEmployee.java:** Modification interface.
     * **RemoveEmployee.java:** Deletion interface.
   * **icons/:** Images and assets used in the GUI.

   
