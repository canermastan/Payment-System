# Payment System

This project is a Payment System prepared for the ArkSigner "Payment on Mobile with T.C. Identity Card and Face Recognition Technologies Hackathon Event". It includes RESTful APIs for payment processing, credit card information management, and product management. The application is developed using Spring Boot and provides functionalities such as payment processing, credit card information management, and product information management.

## Features

- **Payment Processing**: Allows users to make payments for products.
- **Credit Card Management**: Supports adding, retrieving, and listing credit card information.
- **Product Management**: Supports creating, updating, and retrieving product information.

## Endpoints

### Payment

- **POST /api/payments**
   - Processes payment for a product.
   - **Request Body**:
     ```json
     {
       "productId": 1,
       "creditCardDto": {
         "number": "1234567890123456",
         "expMonth": "12",
         "expYear": "2025",
         "ccv": "123"
       },
       "quantity": 2
     }
     ```
   - **Response**: Payment result.

### Credit Card

- **GET /api/cc/get-all**
   - Retrieves all saved credit card information.
- **POST /api/cc**
   - Adds a new credit card.
   - **Request Body**:
     ```json
     {
       "number": "1234567890123456",
       "expMonth": "12",
       "expYear": "2025",
       "ccv": "123"
     }
     ```
   - **Response**: Saved credit card details.
- **GET /api/cc/{number}**
   - Retrieves credit card information by card number.

### Product

- **GET /api/products/get-all**
   - Retrieves all products.
- **POST /api/products**
   - Adds a new product.
   - **Request Body**:
     ```json
     {
       "name": "Product Name",
       "description": "Product Description",
       "stock": 100,
       "price": 99.99
     }
     ```
   - **Response**: Saved product details.
- **PUT /api/products/{id}**
   - Updates an existing product.
   - **Request Body**:
     ```json
     {
       "name": "Updated Product Name",
       "description": "Updated Product Description",
       "stock": 100,
       "price": 99.99
     }
     ```
   - **Response**: Updated product details.

## Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/username/payment-system.git
   cd payment-system
   ```

2. **Run the Application**:
   - Ensure Java 17 is installed.
   - Run the application using Maven:

```bash
./mvnw spring-boot:run
```
