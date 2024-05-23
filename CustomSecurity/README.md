## Custom Authentication Application
This is a Spring Boot application that provides a custom authentication and authorization system using JSON Web Tokens (JWT) and Spring 
Security. It also includes support for OAuth2 authentication with Google.

### Features
- User registration and login with JWT authentication
- Role-based access control (RBAC) for different user roles (e.g., USER, ADMIN, MANAGER, WAITER)
- OAuth2 authentication with Google
- Secure endpoints based on user roles

### Technologies Used
- Spring Boot
- Spring Security
- JSON Web Tokens (JWT)
- MySQL (or any other relational database)
- Lombok
- OAuth2 (with Google Sign-In)

### Prerequisites

- Java Development Kit (JDK) installed
- MySQL (or any other relational database) installed and running
- Google Cloud Console project with Google Sign-In API enabled and OAuth client credentials configured

### Installation

1. Clone the repository:
```
git clone https://github.com/your-username/CustomSecurity
```
2. Navigate to the project directory:
```
cd CustomSecurity
```
3. Update the application.properties file with your database credentials and Google OAuth client credentials:
```
spring.application.name=CustomaAuthentication
spring.datasource.url=jdbc:mysql://localhost:3306/restaurant_db
spring.datasource.username=root
spring.datasource.password=port
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


spring.security.oauth2.client.registration.google.client-id=paste_your_client_id
spring.security.oauth2.client.registration.google.client-secret=paste_your_client_secret
spring.security.oauth2.client.registration.google.scope=profile, email
spring.security.oauth2.client.registration.google.redirect-uri=http://localhost:8080/login/oauth2/code/google
spring.security.oauth2.client.registration.google.authorization-grant-type=authorization_code
spring.security.oauth2.client.registration.google.client-name=Google
app.jwtSecret=gd7%Qs2&Hn9Bx6Uw
app.jwtExpirationInMs=86400000
```
The application will be available at http://localhost:8080.

Usage

Register a new user by sending a POST request to ```/api/auth/signup``` with a JSON payload containing the ```username```, ```password```, and optional ```roles``` (e.g., ```ROLE_USER```, ```ROLE_ADMIN```, ```ROLE_MANAGER```, ```ROLE_WAITER```).
Log in by sending a POST request to ```/api/auth/login``` with a JSON payload containing the ```username``` and ```password```. The response will contain the JWT access token.
Access secured endpoints by including the JWT access token in the ```Authorization``` header with the ```Bearer``` prefix (e.g., ```Authorization: Bearer <access_token>```).
For OAuth2 authentication with Google, follow the instructions in the application logs or documentation to complete the Google Sign-In flow.
