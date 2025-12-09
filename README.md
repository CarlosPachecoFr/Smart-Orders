# 🧠 Smart Orders
## 📌 Descripción del proyecto
**Sistema de microservicios diseñado para gestionar órdenes y stock de forma desacoplada, asíncrona y event-driven**, utilizando **Java**,**Spring Boot**, **DDD**, **Kafka** y **Docker**. Smart Orders es una arquitectura basada en eventos donde los microservicios se comunican a través de **Apache Kafka**, logrando un alto nivel de desacoplamiento entre servicios.
### Flujo principal

1. **Order Service**  
   - El cliente crea una orden.  
   - Se guarda la orden en estado `PENDING`.  
   - Se publica el evento **`order_created_topic`** en Kafka.

2. **Product Service**  
   - Consume el evento `order_created_topic`.  
   - Verifica y reserva el stock de los productos solicitados.  
   - Publica uno de los siguientes eventos:  
     - `stock_order_confirmed` → si hay suficiente stock  
     - `stock_order_rejected` → si falta stock en algún producto

3. **Order Service** (continuación)  
   - Escucha los eventos `stock_order_confirmed` y `stock_order_rejected`.  
   - Actualiza el estado de la orden:  
     - `CONFIRMED` → si se recibe confirmación de stock  
     - `REJECTED` → si el stock fue rechazado

## 🎯 Objetivo del proyecto
Aprender y demostrar la construcción de un sistema **completamente desacoplado**, **escalable** y **resiliente** mediante:

- Aplicación de **Domain-Driven Design (DDD)** con bounded contexts claros
- Comunicación **asíncrona** y **event-driven** usando Apache Kafka
- Despliegue con **Docker** y **Docker Compose** para facilitar la ejecución local

## 🚀 Cómo ejecutar el proyecto con Docker

### 1️⃣ Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/smart-orders.git
cd smart-orders
```

### 2️⃣ Levantar toda la infraestructura

```bash
docker-compose up --build
```
