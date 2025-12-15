# 🧠 Smart Orders
## 📌 Descripción del proyecto
**Smart Orders** es un sistema de **microservicios event-driven** diseñado para gestionar órdenes y stock de forma **desacoplada, escalable y resiliente**.

El proyecto está construido con **Java y Spring Boot**, aplicando **Domain-Driven Design (DDD)** y **Arquitectura Hexagonal (Ports & Adapters)**, y utiliza **Apache Kafka** para la comunicación asíncrona entre servicios. Todo el sistema puede ejecutarse fácilmente mediante **Docker y Docker Compose**.

## 🏗️ Arquitectura

El sistema sigue una **arquitectura hexagonal**, donde:

- El **dominio** es completamente independiente de frameworks y tecnologías externas.
- Los **casos de uso** se definen mediante **ports** (interfaces) que establecen los contratos de entrada y salida.
- La **infraestructura** implementa dichos ports mediante **adapters** específicos (por ejemplo, controladores web, repositorios de base de datos, clientes externos, etc.).
- **No existen dependencias** desde el dominio hacia la infraestructura, garantizando que la lógica de negocio permanezca pura y testable.

### Principios aplicados

- **Domain-Driven Design (DDD)**
  - Bounded contexts claros (order, product)
  - Entidades ricas en comportamiento

- **Hexagonal Architecture (Ports & Adapters)**
  - Ports de entrada (Use Cases)
  - Ports de salida (Repositories, Publishers, Clients)

- **Event-Driven Architecture**
  - Comunicación asíncrona mediante Kafka
  - Consistencia eventual

- **Alta cohesión y bajo acoplamiento**

## 🔁 Flujo principal del sistema

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

## 🔗 Comunicación entre servicios

- **Kafka** se utiliza para:
  - Flujos de negocio
  - Cambios de estado
  - Comunicación asíncrona y desacoplada

- **Feign Client** se utiliza **únicamente** para:
  - Consultas síncronas necesarias (ej. obtención de precio del producto)

Esta combinación permite mantener un equilibrio entre **consistencia eventual** y **simplicidad en consultas**.

## 🎯 Objetivo del proyecto
El objetivo de **Smart Orders** es servir como un proyecto práctico para **explorar y aplicar buenas prácticas de arquitectura de software** en un entorno de microservicios.

El foco principal está en:

- Diseñar microservicios **orientados al dominio**, aplicando **Domain-Driven Design (DDD)** con bounded contexts bien definidos
- Implementar **arquitectura hexagonal (Ports & Adapters)** para aislar la lógica de negocio de los detalles técnicos
- Utilizar **Apache Kafka** para la comunicación asíncrona y basada en eventos entre servicios
- Construir un sistema **mantenible, extensible y fácilmente testeable**

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

## 🔧 Estado del proyecto
Proyecto en desarrollo como parte de un proceso de aprendizaje avanzado en arquitectura de software.
