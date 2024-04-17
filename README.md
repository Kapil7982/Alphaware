# Blog Application
This is a Spring Boot application that provides a RESTful API for a blog platform. Users can create, read, update, and delete blog posts, categories, and comments.Maintaining the Login and Signup with the Jwt token. With the help of the Jwt token maintaining the authority and authorization between Admin and User.

## Tech Stack
- Java
- Hibernate
- Spring Framework
- Spring Boot with JPA
- MySQL
- Maven
- Lombak

## Modules
- User
- Post
- Category
- Comments

## MySql database details

Install and connect with database

```bash
#changing the server port
server.port=8888
#db specific properties
spring.datasource.url=jdbc:mysql://localhost:3306/blogApp
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=port

#ORM s/w specific properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
## Features
1. User Management: Users can register and log in to the application.
2. Post Management: Users can create, read, update, and delete blog posts.
3. Category Management: Administrators can create, read, update, and delete categories for blog posts.
4. Comment Management: Users can add, update, and delete comments on blog posts.
5. Feed: Users can fetch all posts created on the current day.

## Installation
 1. Clone this repository
```bash
git clone https://github.com/Kapil7982/Alphaware
```
2. Navigate to the project directory:
```
cd BlogApp
```
## API Endpoints
### User Endpoints
- ```POST /api/user/register:``` Register a new user.
- Payload
  ```
  {
  "custId": 0,
  "name": "Kapil",
  "email": "Kapil@gmail.com",
  "password": "Kapil@123",
  "role": "User"
  }
  ```
- ```GET /api/user/login:``` Log in an existing user.
#### Post Endpoints
- ```GET /api/posts:``` Retrieve all posts.
- ```GET /api/posts/{id}:``` Retrieve a specific post by ID.
- ```GET /api/posts/feed:``` Retrieve all posts created on the current day.
- ```POST /api/posts:``` Create a new post.
- Payload
  ```
  {
    "title": "New Post Title",
    "content": "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
    "customer": {
      "custId":1
    },
    "category": {
        "id": 1
    }
  }
  ```
- ```PUT /api/posts/{id}:``` Update an existing post.
- ```DELETE /api/posts/{id}:``` Delete a post.
#### Category Endpoints
- ```GET /api/categories:``` Retrieve all categories.
- ```GET /api/categories/{id}:``` Retrieve a specific category by ID.
- ```POST /api/categories:``` Create a new category.```
- Payload
   ```
   {
   "name": "Technology"
   }
   ```
   
- ```PUT /api/categories/{id}:``` Update an existing category.
- ```DELETE /api/categories/{id}:``` Delete a category.
#### Comment Endpoints
- ```GET /api/comments/post/{postId}:``` Retrieve all comments for a specific post.
- ```POST /api/comments/post/{postId}:``` Create a new comment for a post.
- Payload
   ```
   {
   "content": "string"
   }
   ```
- ```PUT /api/comments/{id}:``` Update an existing comment.
- ```DELETE /api/comments/{id}:``` Delete a comment.
