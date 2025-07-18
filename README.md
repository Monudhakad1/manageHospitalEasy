# ManageHospitalEasy - Hospital Management System

A comprehensive full-stack hospital management system built with Spring Boot backend and vanilla JavaScript frontend, providing complete CRUD operations for managing patients, doctors, appointments, and billing operations.

## 🏥 Project Overview

ManageHospitalEasy is a modern web-based hospital management system that streamlines healthcare operations through an intuitive web interface and robust RESTful APIs. The system provides comprehensive management capabilities for core hospital entities with real-time data updates and professional UI/UX design.

## 🚀 Features

### Core Management Modules
- **Patient Management**: Complete patient registration, profile management, and medical records
- **Doctor Management**: Doctor profile management with specialization tracking and availability
- **Appointment Scheduling**: Intelligent appointment booking system with patient-doctor mapping
- **Billing System**: Comprehensive billing management with multiple payment status tracking
- **Real-time Updates**: Dynamic data refresh and form validation
- **Responsive Design**: Mobile-friendly interface with modern UI components

### Technical Features
- **RESTful APIs**: Well-structured REST endpoints for all operations
- **Database Integration**: MySQL database with automated migrations
- **CORS Configuration**: Cross-origin resource sharing for frontend-backend communication
- **Exception Handling**: Comprehensive error handling across all layers
- **Logging Framework**: Professional logging with SLF4J and Logback

## 🛠️ Technology Stack

### Backend Technologies
- **Java** - Core programming language
- **Spring Boot** - Application framework
- **Spring Web** - REST API development
- **Spring Data JPA** - Data persistence layer
- **Hibernate** - Object-relational mapping
- **Lombok** - Code generation and boilerplate reduction

### Frontend Technologies
- **HTML5** - Semantic markup structure
- **CSS3** - Modern styling with Flexbox and Grid
- **JavaScript (ES6+)** - Dynamic functionality and API integration
- **Font Awesome** - Professional icon library
- **Responsive Design** - Mobile-first approach

### Database & Tools
- **MySQL** - Primary database system
- **Flyway** - Database migration management
- **SLF4J + Logback** - Logging framework
- **Gradle** - Build automation and dependency management
- **Postman** - API testing and documentation

### Development Skills Demonstrated
- **Full-Stack Development** - Complete frontend and backend integration
- **RESTful API Design** - Professional API architecture
- **Database Design** - Normalized schema with proper relationships
- **Responsive Web Design** - Cross-device compatibility
- **Error Handling** - Comprehensive exception management
- **Code Organization** - Clean architecture and separation of concerns

## 📁 Project Architecture

```
managehospitaleasy/
├── src/main/java/com/managehospitaleasy/managehospitaleasy/
│   ├── config/
│   │   └── WebConfig.java                 # CORS and MVC configuration
│   ├── controllers/
│   │   ├── AppointmentController.java     # Appointment REST endpoints
│   │   ├── BillController.java            # Billing REST endpoints
│   │   ├── DoctorController.java          # Doctor REST endpoints
│   │   └── PatientControllers.java        # Patient REST endpoints
│   ├── Service/
│   │   ├── AppointmentService.java        # Appointment business logic
│   │   ├── BillService.java               # Billing business logic
│   │   ├── DoctorService.java             # Doctor business logic
│   │   └── PatientService.java            # Patient business logic
│   ├── Repository/
│   │   ├── AppointmentRepo.java           # Appointment data access
│   │   ├── BillRepo.java                  # Bill data access
│   │   ├── DoctorRepo.java                # Doctor data access
│   │   └── PatientRepo.java               # Patient data access
│   ├── models/
│   │   ├── Appointment.java               # Appointment entity
│   │   ├── Bill.java                      # Bill entity
│   │   ├── BillStatus.java                # Payment status enum
│   │   ├── Doctor.java                    # Doctor entity
│   │   └── Patient.java                   # Patient entity
│   └── ManageHospitalEasyApplication.java # Main application class
├── src/main/resources/
│   ├── static/
│   │   ├── index.html                     # Main web interface
│   │   ├── script.js                      # Frontend JavaScript logic
│   │   └── styles.css                     # Application styling
│   ├── db/migration/
│   │   └── V1__initial_creation.sql       # Database schema
│   └── application.properties             # Application configuration
└── README.md
```

## 🏗️ System Architecture

### Three-Tier Architecture
1. **Presentation Layer** (Frontend)
    - Modern web interface with HTML5, CSS3, and JavaScript
    - Responsive design with mobile-first approach
    - Real-time form validation and data updates

2. **Business Logic Layer** (Backend Services)
    - Spring Boot application with RESTful APIs
    - Service layer containing business rules and validation
    - Exception handling and logging mechanisms

3. **Data Access Layer** (Database)
    - MySQL database with normalized schema
    - JPA repositories for data operations
    - Flyway migrations for version control

## 📊 Database Schema

### Entity Relationship Model

#### Core Entities

**Patient Entity**
```sql
- id (BIGINT, Primary Key, Auto Increment)
- name (VARCHAR)
- gender (VARCHAR) 
- age (VARCHAR)
```

**Doctor Entity**
```sql
- id (BIGINT, Primary Key, Auto Increment)
- name (VARCHAR)
- specialty (VARCHAR)
```

**Appointment Entity**
```sql
- id (BIGINT, Primary Key, Auto Increment)
- patient_id (BIGINT, Foreign Key → Patient.id)
- doctor_id (BIGINT, Foreign Key → Doctor.id)
- date (DATE)
```

**Bill Entity**
```sql
- id (BIGINT, Primary Key, Auto Increment)
- patient_id (BIGINT, Foreign Key → Patient.id)
- amount (DOUBLE)
- status (ENUM)
```

### Payment Status Management
The system supports comprehensive billing status tracking:

- **SUCCESSFUL** - Payment completed successfully
- **ON_PROCESS** - Payment currently being processed
- **HALF_DONE** - 50% payment completed
- **QUARTER_DONE** - 25% payment completed
- **NOT_COMPLETE** - Payment pending or incomplete
- **SPECIAL_PATIENT** - No payment required (staff relatives, etc.)

## 🔧 API Documentation

### Patient Management Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/patients` | Retrieve all patients |
| POST | `/api/v1/patients` | Create new patient |
| GET | `/api/v1/patients/{id}` | Get patient by ID |
| POST | `/api/v1/patients/{id}` | Update patient |
| DELETE | `/api/v1/patients/{id}` | Delete patient |

### Doctor Management Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/doctor` | Retrieve all doctors |
| POST | `/api/v1/doctor` | Create new doctor |
| GET | `/api/v1/doctor/{id}` | Get doctor by ID |
| POST | `/api/v1/doctor/{id}` | Update doctor |
| DELETE | `/api/v1/doctor/{id}` | Delete doctor |

### Appointment Management Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/appointments` | Retrieve all appointments |
| POST | `/api/v1/appointments` | Create new appointment |
| GET | `/api/v1/appointments/{id}` | Get appointment by ID |
| POST | `/api/v1/appointments/{id}` | Update appointment |
| DELETE | `/api/v1/appointments/{id}` | Delete appointment |

### Bill Management Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/bill` | Retrieve all bills |
| POST | `/api/v1/bill` | Create new bill |
| GET | `/api/v1/bill/{id}` | Get bill by ID |
| POST | `/api/v1/bill/{id}` | Update bill |
| DELETE | `/api/v1/bill/{id}` | Delete bill |

## 🎨 Frontend Features

### User Interface Components
- **Navigation System**: Tab-based navigation with active state indicators
- **Data Tables**: Sortable tables with action buttons for each record
- **Forms**: Dynamic forms with validation and real-time feedback
- **Modal System**: Inline forms for adding and editing records
- **Status Indicators**: Color-coded status badges for bill tracking
- **Responsive Layout**: Mobile-optimized design with collapsible elements

### JavaScript Functionality
- **API Integration**: Fetch-based HTTP client for backend communication
- **Real-time Updates**: Automatic data refresh after CRUD operations
- **Form Management**: Dynamic form population and validation
- **Error Handling**: User-friendly error messages and notifications
- **State Management**: Client-side state synchronization

## 📝 Logging & Monitoring

### Comprehensive Logging Strategy
```java
private static final Logger logger = LoggerFactory.getLogger(ServiceClass.class);

// Error logging with context
logger.error("An error occurred while updating patient: {}", e.getMessage());

// Info logging for business events  
logger.info("Patient not found with id {}", id);

// Debug logging for development
logger.debug("Processing patient update request");
```

### Log Levels Implementation
- **ERROR**: Exception tracking with full stack traces
- **INFO**: Business operation logging and audit trails
- **DEBUG**: Detailed development and troubleshooting information

## ⚙️ Installation & Setup

### Prerequisites
- **Java Development Kit (JDK)**
- **MySQL Database Server**
- **Gradle Build Tool**
- **IDE** (IntelliJ IDEA)
- **Web Browser** (Chrome, Firefox, Safari)

### Quick Start Guide

1. **Clone the Repository**
```bash
git clone https://github.com/Monudhakad1/managehospitaleasy.git
cd managehospitaleasy
```

2. **Database Setup**
```sql
CREATE DATABASE hospitalManagement;
CREATE USER 'hospital_user'@'localhost' IDENTIFIED BY 'your_password';
GRANT ALL PRIVILEGES ON hospitalManagement.* TO 'hospital_user'@'localhost';
FLUSH PRIVILEGES;
```

3. **Configure Application Properties**
```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/hospitalManagement
spring.datasource.username=hospital_user
spring.datasource.password=your_password

# Server Configuration
server.port=8080

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Flyway Configuration
spring.flyway.enabled=true
spring.flyway.baseline-on-migrate=true
```

4. **Build and Run**
```bash
# Build the project
./gradlew build

# Run the application
./gradlew bootRun
```

5. **Access the Application**
- Web Interface: `http://localhost:8080`
- API Base URL: `http://localhost:8080/api/v1`

## 🧪 Testing & Quality Assurance

### Manual Testing Approaches
- **API Testing**: Use Postman or curl for endpoint validation
- **Frontend Testing**: Browser-based testing across different devices
- **Integration Testing**: End-to-end workflow validation

### Sample API Requests
```bash
# Create a new patient
curl -X POST http://localhost:8080/api/v1/patients \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe",
    "gender": "Male", 
    "age": "35"
  }'

# Schedule an appointment
curl -X POST http://localhost:8080/api/v1/appointments \
  -H "Content-Type: application/json" \
  -d '{
    "patientId": 1,
    "doctorId": 2,
    "date": "2025-08-15"
  }'
```

## 🤝 Contributing

We welcome contributions to ManageHospitalEasy! Here's how you can help:

1. **Fork the Repository**
2. **Create a Feature Branch** (`git checkout -b feature/amazing-feature`)
3. **Commit Changes** (`git commit -m 'Add amazing feature'`)
4. **Push to Branch** (`git push origin feature/amazing-feature`)
5. **Open a Pull Request**


## 👨‍💻 Author & Contact

**Monu Dhakad**
- **GitHub**: [@Monudhakad1](https://github.com/Monudhakad1)
- **LinkedIn**: [Monu Dhakad](https://www.linkedin.com/in/monu-dhakad-42b525276/)
- **Email**: monudhakad055@gmail.com


*Built with ❤️ using Spring Boot, JavaScript, and modern web technologies*
