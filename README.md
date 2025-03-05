# Farming Services 🚜🌱 - Microservices-based Smart Farming System

## Overview 🏞️

Farming Services is a microservices-based system designed to **automate** and **manage** various aspects of smart farming. This innovative platform provides multiple services for user management, crop monitoring, bot automation, inventory management, task scheduling, notifications, and payments. Enjoy seamless integration and a robust tech stack that propels farming into the future!

## Key Features ✨

- **User Management** 👥: Secure authentication, registration, and role-based access.
- **Crop Monitoring** 🌾: Real-time sensor data (temperature, humidity, soil moisture, etc.) for smart decision-making.
- **Bot Management** 🤖: Autonomous bots to assist with essential farming tasks.
- **Warehouse & Inventory Management** 📦: Efficient tracking of harvested crops, fertilizers, and tools.
- **Task Scheduling** 📅: Automated assignment of farming tasks based on schedules and sensor data.
- **Notification Service** 🔔: Timely alerts for low inventory, plant health issues, and system events.
- **Payment & Subscription** 💳: Secure processing for subscription-based services.
- **API Gateway** 🚪: Intelligent routing of requests to the appropriate microservices.
- **Service Discovery** 🔍: Eureka Server for dynamic microservice management.
- **Event-driven Communication** 📡: Powered by Kafka/RabbitMQ for efficient service interaction.

## Tech Stack 🛠️

- **Backend:** Java (Spring Boot, Spring JPA, Lombok, Hibernate)
- **Database:** MySQL/PostgreSQL, Redis (for caching)
- **Messaging:** Kafka/RabbitMQ
- **API Management:** Spring Cloud Gateway
- **Service Discovery:** Eureka Server
- **Security:** JWT Authentication, OAuth2
- **Containerization & Deployment:** Docker, Kubernetes (K8s), AWS/GCP

## Microservices Breakdown 🔎

### 1. User Service 👤

**Responsibilities:** Manages user authentication, roles, and accounts.  
**APIs:**
- `POST /users/register` - Register a new user
- `POST /users/login` - Authenticate and generate JWT
- `GET /users/{id}` - Retrieve user details

### 2. Crop Monitoring Service 🌱

**Responsibilities:** Collects and analyzes live sensor data from the fields.  
**APIs:**
- `POST /sensor-data` - Receive data from IoT sensors
- `GET /sensor-data/latest/{farmId}` - Fetch the latest sensor readings

### 3. Bot Management Service 🤖

**Responsibilities:** Oversees bot tasks like watering, fertilizing, and more.  
**APIs:**
- `POST /bots/register` - Register a new bot
- `GET /bots/status/{botId}` - Get current bot status

### 4. Warehouse & Inventory Service 📦

**Responsibilities:** Tracks inventory and manages warehouse stock efficiently.  
**APIs:**
- `POST /inventory/add` - Add new items to inventory
- `GET /inventory/{farmId}` - Retrieve available stock
- `POST /stock-movement/transfer` - Transfer stock between warehouses

### 5. Task Scheduling Service 📅

**Responsibilities:** Automates the assignment of farming tasks to bots.  
**APIs:**
- `POST /tasks/create` - Create a new farming task
- `GET /tasks/{farmId}` - Retrieve scheduled tasks

### 6. Notification Service 🔔

**Responsibilities:** Sends alerts for critical system events and updates.  
**APIs:**
- `POST /notifications/send` - Trigger a notification
- `GET /notifications/{userId}` - Retrieve past notifications

### 7. Payment & Subscription Service 💳

**Responsibilities:** Processes payments and manages subscription plans.  
**APIs:**
- `POST /payments/subscribe` - Subscribe to a plan
- `POST /payments/process` - Process a payment

## API Gateway Configuration 🚪

The API Gateway efficiently routes requests to the corresponding microservices.

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: user-service
          uri: http://user-service:8081
          predicates:
            - Path=/api/users/**
        - id: inventory-service
          uri: http://inventory-service:8084
          predicates:
            - Path=/api/inventory/**
        - id: warehouse-service
          uri: http://warehouse-service:8085
          predicates:
            - Path=/api/warehouse/**
```

## Deployment Guide

### 1. Local Deployment with Docker

1. Clone the repository:
   ```sh
   git clone https://github.com/DhruvParmar10/FarmingService.git
   cd farming-services
   ```
2. Build and run the services with Docker:
   ```sh
   docker-compose up --build
   ```

### 2. Kubernetes Deployment

1. Apply Kubernetes manifests:
   ```sh
   kubectl apply -f k8s/
   ```
2. Verify running services:
   ```sh
   kubectl get pods
   ```

## Future Enhancements

- **AI-powered Plant Health Detection** - Use ML models to detect diseases from images.
- **Blockchain for Crop Sales** - Store transactions on a decentralized ledger.
- **Mobile App for Farmers** - Monitor farm data via mobile.

## License

This project is licensed under the MIT License.

## Contributing

Contributions are welcome! Feel free to fork the repository and submit a pull request.

## Contact

For any inquiries, reach out to [**dhruv.jparmar0@gmail.com**](mailto\:dhruv.jparmar0@gmail.com).

