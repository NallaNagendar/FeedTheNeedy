# Feed the Needy

Feed the Needy is a web-based food donation platform developed using Java (Servlets & JSP), designed to connect donors, NGOs, and recipients. The system promotes efficient food redistribution, reducing waste while ensuring timely support to those in need.

## Tech Stack

- Backend: Java Servlets, JSP  
- Frontend: HTML, CSS, JavaScript  
- IDE: Eclipse  
- Database: MySQL (or any RDBMS used)  
- Server: Apache Tomcat

## Key Features

- Role-based access: separate logins for Donors, NGOs, and Admins  
- Secure user authentication and session management  
- Food donation posting and request workflows  
- Real-time inventory of available donations  
- Admin dashboard for monitoring users and food transactions  
- Simple, responsive user interface for easy access

## Security & Best Practices

- Role-Based Access Control (RBAC)  
- Secure data transmission and validation  
- Session tracking and logout functionality  
- Input sanitization to prevent injection attacks

## Project Structure

FeedTheNeedy/
### ├── src/
## │ └── com.feeddtheneedy.servlets/
## │ ├── LoginServlet.java
## │ ├── RegisterServlet.java
## │ ├── DonationServlet.java
## │ └── ...
### ├── WebContent/
## │ ├── index.jsp
## │ ├── login.jsp
## │ ├── dashboard.jsp
## │ └── ...
### ├── WEB-INF/
## │ └── web.xml
## ├── lib/
## │ └── (JDBC drivers, if needed)

## Getting Started

1. Clone the repository or download the source code.
2. Open the project in Eclipse IDE.
3. Configure Apache Tomcat server and add the project.
4. Set up the database:
   - Create the schema and tables (SQL scripts can be included if available).
   - Update DB credentials in your DAO or utility class.
5. Run the project on the server and access it via:  
   `http://localhost:8080/FeedTheNeedy/`

