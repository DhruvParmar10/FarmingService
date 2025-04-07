# SmartFarm Management System

A distributed, microservices-based agricultural management system with IoT integration.

---

## 📚 Table of Contents 
- [📌 Overview](#overview)
- [✨ Features](#features)
- [🧱 Architecture](#architecture)
- [🛠 Technologies](#technologies)
- [⚙️ Prerequisites](#prerequisites)
- [🚀 Installation](#installation)
- [🔧 Services](#services)
- [📡 API Endpoints](#api-endpoints)
- [📦 Deployment](#deployment)
- [🔧 Configuration](#configuration)
- [🔐 Security](#security)
- [🐞 Troubleshooting](#troubleshooting)
- [📄 License](#license)

---

## 📌 Overview
SmartFarm empowers farmers and agricultural managers to monitor and control various farm operations using a robust microservices architecture. Real-time data is captured through IoT sensors and used for monitoring and automated scheduling.

---

## ✨ Features
- ✅ User authentication & role-based access control
- 🌾 Farm & farmer management
- 🌱 Crop growth monitoring
- 💧 Automated irrigation scheduling
- 🌍 Soil condition monitoring
- 🔍 Centralized service discovery
- 🐳 Containerized deployment
- 🕒 Scheduled data injection

---

## 🧱 Architecture
```
+-----------------+       +---------------+       +-----------------+
|   Web/Mobile    |<----->|  API Gateway  |<----->|   Microservices |
|    Client       |       |               |       | (Auth, Farm,    |
+-----------------+       +-------+-------+       |  Crops, Soil,   |
                                   |               |  Irrigation,    |
                                   v               |  Scheduler)     |
                             +-------------+       +--------+--------+
                             | Eureka Server|                |
                             | (Discovery)  |<---------------+ 
                             +------+-------+
                                    ^
                                    |
                            +-------+-------+
                            |   Database    |
                            |   (MySQL)     |
                            +---------------+
```

---

## 🛠 Technologies
- **Core**: Java 17, Spring Boot 3.x, Spring Cloud
- **Persistence**: Spring Data JPA, MySQL
- **Service Discovery**: Eureka Server
- **API Gateway**: Spring Cloud Gateway
- **Scheduling**: Spring Scheduler
- **Containerization**: Docker, Kubernetes
- **Monitoring**: Spring Boot Actuator

---

## ⚙️ Prerequisites
- JDK 17+
- Maven 3.8+
- Docker 20.10+
- Kubernetes (Minikube recommended)
- MySQL 8.0+

---

## 🚀 Installation

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/dhruvparmar10/smartfarm-system.git
cd smartfarm-system
```

### 2️⃣ Build All Services
```bash
mvn clean package -DskipTests
```

### 3️⃣ Start with Docker Compose
```bash
docker-compose -f docker/docker-compose.yml up --build
```

### 4️⃣ Deploy on Kubernetes
```bash
kubectl apply -f kubernetes/
```

---

## 🔧 Services
| Service             | Port  | Description                           |
|---------------------|-------|---------------------------------------|
| Eureka Server       | 8761  | Service discovery & registration      |
| API Gateway         | 9090  | Central entry point & routing         |
| Auth Service        | 8080  | User authentication & authorization   |
| Farm Service        | 8081  | Farm and farmer management            |
| Crop Service        | 8082  | Crop lifecycle tracking & analytics   |
| Irrigation Service  | 8083  | Smart irrigation scheduler            |
| Soil Service        | 8084  | Real-time soil monitoring             |
| Scheduler Service   | 8085  | Automated data simulation             |

---

## 📡 API Endpoints
See individual service documentation:
- [🔐 Auth Service](auth-service/README.md)
- [🌾 Farm Service](farm-service/README.md)
- [🌱 Crop Service](crop-service/README.md)
- [🌍 Soil Service](soil-service/README.md)

---

## 📦 Deployment

### 🐳 Docker Compose Sample
```yaml
version: '3.8'

services:
  eureka-server:
    image: smartfarm/eureka-server:latest
    ports:
      - "8761:8761"

  api-gateway:
    image: smartfarm/api-gateway:latest
    ports:
      - "8080:8080"
    depends_on:
      - eureka-server

  auth-service:
    image: smartfarm/auth-service:latest
    environment:
      - EUREKA_URI=http://eureka-server:8761/eureka
    depends_on:
      - eureka-server
      - mysql-db

  mysql-db:
    image: mysql:8.0
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: smartfarm
    ports:
      - "3306:3306"
```

### ☸️ Kubernetes Deployment
```bash
kubectl apply -f mysql-deployment.yaml
kubectl apply -f eureka-deployment.yaml
kubectl apply -f auth-deployment.yaml
kubectl apply -f farm-deployment.yaml
# Continue with other services
```

---

## 🔧 Configuration
Key environment variables:
```properties
# Eureka Server
EUREKA_SERVER_PORT=8761

# API Gateway Routes
SPRING_CLOUD_GATEWAY_ROUTES_AUTH_URI=lb://auth-service
SPRING_CLOUD_GATEWAY_ROUTES_FARM_URI=lb://farm-service

# Database
SPRING_DATASOURCE_URL=jdbc:mysql://mysql-db:3306/smartfarm
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=root
```

---

## 🔐 Security
- 🔒 HTTPS (enable in production)
- 👤 Role-based access (OWNER, FARMER)
- 🔑 BCrypt password hashing
- 🛡️ Optional JWT integration
- 🔐 Secure service-to-service calls

---

## 🐞 Troubleshooting
### 🔍 Common Issues
1. **Service Discovery Fails**
   - Ensure Eureka is running
   - Verify correct registration intervals

2. **Database Connection Fails**
   - Check MySQL credentials & container status
   - Validate container networking

3. **Docker Networking**
   ```bash
   docker network create smartfarm-net
   docker-compose --network smartfarm-net up
   ```

4. **Kubernetes Pod Issues**
   ```bash
   kubectl get pods
   kubectl logs <pod-name>
   kubectl describe pod <pod-name>
   ```

---

## 📄 License
Licensed under the **Apache License 2.0**.

---

## 📬 Contact
**Support**: dhruv.jparmar0@gmail.com  
