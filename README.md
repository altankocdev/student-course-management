# Student-Course Management System

A Spring Boot REST API demonstrating Many-to-Many relationship implementation with clean architecture principles.

## 🛠️ Tech Stack

- **Java** 21
- **Spring Boot** 4.0.2
- **Spring Data JPA** - ORM and database operations
- **PostgreSQL** 15+ - Relational database
- **Lombok** - Reduce boilerplate code
- **Maven** - Dependency management

## ✨ Features

- **Many-to-Many Relationship** - Student ↔ Enrollment ↔ Course
- **Layered Architecture** - Controller → Service → Repository
- **DTO Pattern** - Separate Request/Response DTOs
- **Global Exception Handling** - Centralized error management
- **Bean Validation** - Input validation with custom messages
- **Mapper Pattern** - Entity ↔ DTO conversion

## 📁 Project Structure
```
com.altankoc
├── controller/          # REST API endpoints
├── service/            # Business logic
├── repository/         # Database access
├── entity/             # JPA entities
├── dto/
│   ├── request/       # Request DTOs
│   └── response/      # Response DTOs
├── mapper/            # DTO ↔ Entity mappers
└── exception/         # Custom exceptions & handler
```

## 🚀 Getting Started

### Prerequisites

- Java 21 or higher
- Maven 3.6+
- PostgreSQL 15+

### Installation

1. **Clone the repository**
```bash
   git clone https://github.com/altankocdev/student-course-management.git
   cd student-course-management
```

2. **Create PostgreSQL database**
```sql
   CREATE DATABASE student_course_db;
```

3. **Configure database connection**
```bash
   cp src/main/resources/application.properties.example src/main/resources/application.properties
```
   
   Update `application.properties` with your database credentials:
```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/student_course_db
   spring.datasource.username=YOUR_USERNAME
   spring.datasource.password=YOUR_PASSWORD
```

4. **Run the application**
```bash
   mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## 📋 API Endpoints

### Students

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/students` | Get all students |
| GET | `/api/students/{id}` | Get student by ID |
| POST | `/api/students` | Create new student |
| DELETE | `/api/students/{id}` | Delete student |

**Request Body (POST):**
```json
{
  "name": "John Doe"
}
```

**Response:**
```json
{
  "id": 1,
  "name": "John Doe",
  "courseNames": ["Data Structures", "Algorithms"]
}
```

### Courses

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/courses` | Get all courses |
| GET | `/api/courses/{id}` | Get course by ID |
| POST | `/api/courses` | Create new course |
| DELETE | `/api/courses/{id}` | Delete course |

**Request Body (POST):**
```json
{
  "courseName": "Data Structures",
  "credits": 6
}
```

**Response:**
```json
{
  "id": 1,
  "courseName": "Data Structures",
  "credits": 6,
  "studentNames": ["John Doe", "Jane Smith"],
  "enrolledStudentCount": 2
}
```

### Enrollments

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/enrollments` | Get all enrollments |
| GET | `/api/enrollments/{id}` | Get enrollment by ID |
| POST | `/api/enrollments` | Create new enrollment |
| DELETE | `/api/enrollments/{id}` | Delete enrollment |

**Request Body (POST):**
```json
{
  "studentId": 1,
  "courseId": 1,
  "enrollmentDate": "2025-02-08"
}
```

## 🗄️ Database Schema
```
┌─────────────┐         ┌──────────────┐         ┌─────────────┐
│  students   │         │ enrollments  │         │   courses   │
├─────────────┤         ├──────────────┤         ├─────────────┤
│ student_id  │◄───────┤ student_id   │         │ course_id   │
│ name        │         │ course_id    ├────────►│ course_name │
└─────────────┘         │ enrollment_  │         │ credits     │
                        │   date       │         └─────────────┘
                        │ enrollment_id│
                        └──────────────┘
```

## 🔧 Configuration

### application.properties.example
```properties
# Application name
spring.application.name=StudentManagement

# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/yourdatabase
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=org.postgresql.Driver

# JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# Server Configuration
server.port=8080

# Logging Configuration
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
```

### Configuration Properties Explained

- `spring.jpa.hibernate.ddl-auto=update` - Automatically update database schema
- `spring.jpa.show-sql=true` - Show SQL queries in console
- `spring.jpa.properties.hibernate.format_sql=true` - Format SQL for readability
- `logging.level.org.hibernate.SQL=DEBUG` - Enable SQL logging

## 🧪 Testing with Postman

### Create Student
```bash
POST http://localhost:8080/api/students
Content-Type: application/json

{
  "name": "John Doe"
}
```

### Get All Students
```bash
GET http://localhost:8080/api/students
```

### Create Course
```bash
POST http://localhost:8080/api/courses
Content-Type: application/json

{
  "courseName": "Data Structures",
  "credits": 6
}
```

### Enroll Student to Course
```bash
POST http://localhost:8080/api/enrollments
Content-Type: application/json

{
  "studentId": 1,
  "courseId": 1,
  "enrollmentDate": "2025-02-08"
}
```

## 🎓 Learning Outcomes

This project demonstrates:

- ✅ Many-to-Many relationship implementation in JPA
- ✅ Layered architecture pattern
- ✅ DTO pattern for API design
- ✅ Global exception handling
- ✅ Input validation
- ✅ RESTful API design principles
- ✅ Clean code practices

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👤 Author

**Altan Koç**

- GitHub: [@altankocdev](https://github.com/altankocdev)

## 🙏 Acknowledgments

- Spring Boot Documentation
- Baeldung Spring Tutorials
- Stack Overflow Community
```

---

## **2. LICENSE (MIT License)**

**GitHub'da:** Create new file → `LICENSE`
```
MIT License

Copyright (c) 2025 Altan Koç

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
