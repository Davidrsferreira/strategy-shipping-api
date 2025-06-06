# Strategy Shipping API

A study project demonstrating the application of the **Strategy Design Pattern** in a real-world scenario using a Java Spring Boot REST API for shipping cost calculation. The project includes progressive refactoring: from basic conditional logic to a full Strategy pattern implementation.

## 🚀 Features

- **Strategy Pattern Implementation**: Encapsulates various shipping cost calculation strategies.
- **Spring Boot REST API**: Provides endpoints to calculate shipping costs based on delivery types.
- **Progressive Refactoring**: Transforms naive conditional logic into a scalable and maintainable strategy-based approach.
- **Unit and Integration Tests**: Ensures reliability and correctness of each component.

## 📦 Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.8 or higher

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/Davidrsferreira/strategy-shipping-api.git
   cd strategy-shipping-api

2. **Build the project**:
   ```bash
   ./mvnw clean install

3. **Run the application**:
   ```bash
   ./mvnw spring-boot:run

The API will be accessible at `http://localhost:8080`.

## 📫 API Usage

### Calculate Shipping Cost

**Endpoint**:  
`POST /shipping/calculate`

### Example Request

**Request Body**:
```json
{
  "deliveryType": "NORMAL",
  "weight": 5.0
}
```
**Response**:
```json
{
  "cost": 2.50
}
```
### Supported `deliveryType` values

| Type     | Description             | Cost          |
|----------|-------------------------|---------------|
| NORMAL   | Standard delivery       | weight * 0.50 |
| EXPRESS  | Express delivery        | weight * 1.00 |
| (others) | Unsupported types       | Exception     |

> 🚫 Any unsupported `deliveryType` will result in a IllegalArgumentException.

**The project includes**:
- **Unit Tests**: For individual strategy implementations.
- **Integration Tests**: For API endpoints and overall application flow.

## 📚 Learnings
### This project serves as a practical example of:

- Applying the Strategy design pattern to replace complex conditional logic.
- Leveraging Spring Boot for building RESTful APIs.
- Writing clean, maintainable, and testable code.

## License

This project is licensed under the [MIT License](LICENSE).


