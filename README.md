#E-Notes Web Application Description
 
Project Overview
The E-Notes Web Application is a full-stack project that allows users to manage their personal notes efficiently. 
It provides functionalities such as user authentication, creating, reading, updating, and deleting notes.
The application is developed using Angular for the front end, Spring Boot for the back end, and MySQL as the database.
Key features include user management, note management, and seamless integration between components using REST APIs.



Technologies and Frameworks
Frontend: Angular
Features: Data Binding, Dependency Injection, Component-based architecture
Backend: Spring Boot
Features: REST APIs, Data JPA, Lombok
Database: MySQL
Relational database with entity mappings
Frontend Modules (Angular)
Components

LoginComponent
Functionality: Handles user authentication (login).
Features: Form-based login using two-way data binding.

AddNotesComponent
Functionality: Allows users to add a new note.
Features: Data binding for input fields.

DetailsComponent
Functionality: Displays a detailed list of user notes.

MoreInfoComponent
Functionality: Provides additional details for a selected note.

AddUserComponent
Functionality: Handles user registration.

HeaderComponent
Functionality: Displays a header with navigation links.

Angular Features Used
Data Binding: Two-way binding for form inputs and component data.
Dependency Injection: Services are injected into components to handle data.
Routing: Navigation between components (e.g., Login → AddNotes).

Backend Modules (Spring Boot)

Flow of Data
Angular (Frontend) → Controller Layer (Spring Boot)
Frontend sends HTTP requests (e.g., POST, GET) to the backend using REST APIs.

Controller Layer → Service Layer
The controller passes the request to the service layer for business logic processing.

Service Layer → DAO (Data Access Object)
The service interacts with the DAO to perform database operations.

DAO Layer → Database
DAO uses JPA methods to query/update data in MySQL.
Spring Boot Features Used

Entity Classes:
User
Columns: id, email, password, age.

Notes
Columns: nid, title, content, createdDate, updatedDate.
Mapping: Many-to-One mapping between Notes and User using the id field.
Annotations: @Entity, @Table, @ManyToOne, @JoinColumn.

Repository Layer:
Interfaces extending JpaRepository for CRUD operations.

Service Layer:
Contains business logic for user and note operations..

Controller Layer:
Exposes REST APIs for handling requests from the Angular frontend.

Lombok:
Used for boilerplate code reduction (e.g., @Getter, @Setter, @NoArgsConstructor).
