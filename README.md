
![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-brightgreen)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
![Docker](https://img.shields.io/badge/Docker-Supported-blue)
![Render](https://img.shields.io/badge/Deployment-Render-purple)
![Swagger](https://img.shields.io/badge/API%20Docs-Swagger-green)


# Travel Booking System

A simple **Spring Boot backend** for booking trains and flights with dummy payments.  
Static data is used for trains/flights. The project is Docker-ready and is deployed on the cloud platform "Render".

---

## 1️⃣ Travel Options (Dummy Data)

| ID  | Type   | From    | To      | Price (₹) | Departure Time |
|-----|--------|---------|---------|------------|----------------|
| 1   | TRAIN  | Delhi   | Mumbai  | 1500       | 10:00 AM       |
| 2   | FLIGHT | Delhi   | Pune    | 5500       | 6:00 PM        |
| 3   | TRAIN  | Noida   | Jaipur  | 800        | 9:00 AM        |
| 4   | FLIGHT | Pune    | Delhi   | 5200       | 8:00 PM        |
| 5   | TRAIN  | Mumbai  | Pune    | 1300       | 10:30 AM       |
| 6   | FLIGHT | Bangalore | Delhi | 6400       | 1:00 PM        |

---

## 2️⃣ API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/api/v1/trains/all` | Get all trains |
| GET    | `/api/v1/trains/search?from={from}&to={to}` | Search trains by route |
| GET    | `/api/v1/flights/all` | Get all flights |
| GET    | `/api/v1/flights/search?from={from}&to={to}` | Search flights by route |
| GET    | `/api/v1/bookings` | Get all bookings |
| POST   | `/api/v1/bookings` | Create a new booking |
| GET    | `/api/v1/bookings/{bookingId}` | Check booking status |
| POST   | `/api/v1/payments` | Make a payment for a booking |
| GET    | `/api/v1/health` | Health check endpoint |

---

## 3️⃣ Sample JSON for POST Requests

### **Create Booking**
```json
{
  "travelOptionId": 1,
  "passengerName": "Akshat Kumar"
}
```
### **Making Payment**
```json
{
  "bookingId": 1,
  "amount": 1500.0,
  "cardNumber": "1234567812345678"
}
```
⚠️ Make sure amount matches the price of the travel option.
Card number must be 16 digits.

## 4️⃣ How to Run the Project Locally

Follow the steps below to run the project on your local machine.

---

### 🔹 Step 1: Clone the Repository

Open **Terminal / Git Bash** and run:

```bash
git clone https://github.com/Akshat-Kumar31/Travel-Booking-Assignment.git
cd travelbooking
```

---

### 🔹 Step 2: Verify Java Installation

Ensure **Java 17 or higher** is installed.

Run:

```bash
java -version
javac -version
```

Expected output:

```bash
openjdk version "17.x.x"
javac 17.x.x
```

If Java is not installed, download **JDK 17** and configure the `JAVA_HOME` environment variable.

---

### 🔹 Step 3: Verify Maven Installation

Run the following command:

```bash
mvn -version
```

Expected output should show Maven and Java version.

Example:

```bash
Apache Maven 3.x.x
Java version: 17.x.x
```

---

### 🔹 Step 4: Run the Application

Run the Spring Boot application using Maven:

```bash
mvn spring-boot:run
```

Spring Boot will start the server.

---

### 🔹 Step 5: Access the Application

Once the application starts, it will run on:

```
http://localhost:8080
```

---

### 🔹 Step 6: Test the APIs

You can test the APIs using:

- **Postman**
- **Insomnia**
- **Browser (for GET APIs)**

Example API call:

```bash
GET http://localhost:8080/api/v1/flights/all
```

---

## 📘 API Documentation (Swagger UI)

This project includes **Swagger UI** for easy API exploration and testing.

Once the application is running, you can access the interactive API documentation at:

http://localhost:8080/swagger-ui.html

Swagger UI allows you to:

- View all available API endpoints
- Check request and response formats
- Execute API calls directly from the browser
- Test the complete booking and payment flow without using Postman


## 🌐 Live Deployment

The application is deployed on **Render** and is publicly accessible.

| Service | URL |
|-------|------|
| Base API URL | https://travel-booking-app-6683.onrender.com |
| Swagger UI (API Documentation & Testing) | https://travel-booking-app-6683.onrender.com/swagger-ui/index.html |

### Example API URLs

| Endpoint | Description |
|--------|-------------|
| GET `/api/v1/trains/all` | Get all available trains |
| GET `/api/v1/flights/all` | Get all available flights |
| POST `/api/v1/bookings` | Create a booking |
| POST `/api/v1/payments` | Make a payment |

Example:
https://travel-booking-app-6683.onrender.com/api/v1/trains/all


⚠️ Note: The application is hosted on Render's free tier.
If the service has been idle, it may take **30–60 seconds to start** when the API is accessed for the first time.

## 📌 Notes

- This project uses **static in-memory data**.
- **No database setup is required.**
- Restarting the application will **reset all bookings and payments**.
- APIs follow **RESTful design principles**.
