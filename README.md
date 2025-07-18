# ManageHospitalEasy -HMS

A comprehensive hospital management system built with Spring Boot that provides RESTful APIs for managing patients, doctors, appointments, and billing operations.

## 🏥 Project Overview

ManageHospitalEasy is a backend application designed to streamline hospital operations by providing a robust API for managing core hospital entities. The system supports complete CRUD operations for patients, doctors, appointments, and billing with proper logging and error handling.

## 🚀 Features

- **Patient Management**: Complete patient registration and management system
- **Doctor Management**: Doctor profile management with specialization tracking
- **Appointment Scheduling**: Appointment booking system linking patients with doctors
- **Billing System**: Comprehensive billing management with multiple payment status tracking
- **RESTful APIs**: Well-structured REST endpoints for all operations
- **Database Integration**: MySQL database with Flyway migrations
- **Logging**: Comprehensive logging using SLF4J with Logback
- **Error Handling**: Proper exception handling across all service layers

## 🛠️ Technical Stack

### Backend Technologies
- **Java 17+**
- **Spring Boot 3.x**
- **Spring Web** (REST API development)
- **Spring Data JPA** (Data persistence)
- **Hibernate** (ORM)

### Database
- **MySQL 8.0+**
- **Flyway** (Database migrations)

### Development Tools
- **Lombok** (Code generation)
- **SLF4J + Logback** (Logging framework)
- **Maven** (Build tool)

### Skills Demonstrated
- **RESTful API Design**
- **Layered Architecture Pattern**
- **Database Design & Relationships**
- **Exception Handling**
- **Logging Best Practices**
- **Database Migration Management**
- **ORM Implementation**
- **Dependency Injection**

## 📁 Project Structure

```
src/main/java/com/managehospitaleasy/managehospitaleasy/
├── controllers/
│   ├── AppointmentController.java
│   ├── BillController.java
│   ├── DoctorController.java
│   └── PatientControllers.java
├── Service/
│   ├── AppointmentService.java
│   ├── BillService.java
│   ├── DoctorService.java
│   └── PatientService.java
├── Repository/
│   ├── AppointmentRepo.java
│   ├── BillRepo.java
│   ├── DoctorRepo.java
│   └── PatientRepo.java
├── models/
│   ├── Appointment.java
│   ├── Bill.java
│   ├── BillStatus.java
│   ├── Doctor.java
│   └── Patient.java
└── ManageHospitalEasyApplication.java

src/main/resources/
├── db/migration/
│   └── V1__initial_creation.sql
└── application.properties
```

## 🏗️ Architecture

The application follows a **3-layered architecture**:

1. **Controller Layer**: Handles HTTP requests and responses
2. **Service Layer**: Contains business logic and validation
3. **Repository Layer**: Handles data persistence operations

## 📊 Database Schema

### Core Entities

#### Patient
- `id` (Primary Key)
- `name` (VARCHAR)
- `gender` (VARCHAR)
- `age` (VARCHAR)

#### Doctor
- `id` (Primary Key)
- `name` (VARCHAR)
- `specialty` (VARCHAR)

#### Appointment
- `id` (Primary Key)
- `patient_id` (Foreign Key)
- `doctor_id` (Foreign Key)
- `date` (DATE)

#### Bill
- `id` (Primary Key)
- `patient_id` (Foreign Key)
- `amount` (DOUBLE)
- `status` (ENUM)

### Bill Status Types
- `SUCCESSFUL` - Payment completed
- `ON_PROCESS` - Payment in progress
- `HALF_DONE` - 50% payment completed
- `QUARTER_DONE` - 25% payment completed
- `NOT_COMPLETE` - Payment pending
- `SPECIAL_PATIENT` - No payment required (doctor relatives)

## 🔧 API Endpoints

### Patient Management
- `GET /api/v1/patients` - Get all patients
- `POST /api/v1/patients` - Create new patient
- `GET /api/v1/patients/{id}` - Get patient by ID
- `DELETE /api/v1/patients/{id}` - Delete patient
- `POST /api/v1/patients/{id}` - Update patient

### Doctor Management
- `GET /api/v1/doctor` - Get all doctors
- `POST /api/v1/doctor` - Create new doctor
- `GET /api/v1/doctor/{id}` - Get doctor by ID
- `DELETE /api/v1/doctor/{id}` - Delete doctor
- `POST /api/v1/doctor/{id}` - Update doctor

### Appointment Management
- `GET /api/v1/appointments` - Get all appointments
- `POST /api/v1/appointments` - Create new appointment
- `GET /api/v1/appointments/{id}` - Get appointment by ID
- `DELETE /api/v1/appointments/{id}` - Delete appointment
- `POST /api/v1/appointments/{id}` - Update appointment

### Bill Management
- `GET /api/v1/bill` - Get all bills
- `POST /api/v1/bill` - Create new bill
- `GET /api/v1/bill/{id}` - Get bill by ID
- `DELETE /api/v1/bill/{id}` - Delete bill
- `POST /api/v1/bill/{id}` - Update bill

## 📝 Logging Implementation

The application uses **SLF4J** (Simple Logging Facade for Java) with **Logback** as the logging framework:

### Logging Features
- **Structured Logging**: Consistent log format across all services
- **Error Tracking**: Comprehensive error logging with stack traces
- **Performance Monitoring**: Method execution logging
- **Debug Information**: Detailed debugging information in development

### Logger Configuration
```java
private static final Logger logger = LoggerFactory.getLogger(ServiceClass.class);
```

### Log Levels Used
- **INFO**: General application flow
- **DEBUG**: Detailed debugging information
- **ERROR**: Error conditions with detailed context

### Logging Examples
```java
logger.error("An error occurred while updating patient: {}", e.getMessage());
logger.info("Patient not found with id {}", id);
logger.debug("Service method execution details");
```

## ⚙️ Setup and Installation

### Prerequisites
- Java 17 or higher
- Gradle
- MySQL 8.0+
- IDE (IntelliJ IDEA, VS Code)

### Installation Steps

1. **Clone the repository**
```bash
git clone https://github.com/Monudhakad1/manageHospitalEasy
cd ManageHospitalEasy
```

2. **Configure Database**
```sql
CREATE DATABASE hospitalManagement;
```

3. **Update application.properties**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hospitalManagement
spring.datasource.username=root
spring.datasource.password=********
```

4. **Build the project**
```bash
./gradlew clean build
```

5. **Run the application**
```bash
./gradlew bootrun
```

The application will start on `http://localhost:8080` -> Works on postmanApi

## 🧪 Testing

### Manual Testing
Use tools like Postman or curl to test the API endpoints:
I have Used Postman

```bash
# Get all patients
curl -X GET http://localhost:8080/api/v1/patients

# Create a new patient
curl -X POST http://localhost:8080/api/v1/patients \
  -H "Content-Type: application/json" \
  -d '{"name":"John Doe","gender":"Male","age":"30"}'
```

## 📈 Future Enhancements
- [ ] Working on Better UI 
- [ ] Add authentication and authorization
- [ ] Implement proper foreign key relationships
- [ ] Add input validation


## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## 👨‍💻 Author

**Your Name**
- GitHub: [@monudhakad1](https://github.com/monudhakad1)
- LinkedIn: ([https://linkedin.com/in/](https://www.linkedin.com/in/monu-dhakad-42b525276/))
- Email: monudhakad055@gmail.com


*Built with ❤️ using Spring Boot and modern Java technologies*
