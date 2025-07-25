# Feedback API

A simple Spring Boot REST API for submitting and retrieving feedback.

## How to Run the Project

Make sure you have Maven and Java installed.

1. Clone the repository and navigate to the project folder.
2. Start the application using:

```sh
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`.

## Sample API Requests

### Submit Feedback (POST)

**cURL:**
```sh
curl -X POST http://localhost:8080/feedback \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe",
    "email": "john@example.com",
    "message": "This is a feedback message."
  }'
```

### Get All Feedbacks (GET)

**cURL:**
```sh
curl http://localhost:8080/feedbacks
```

## How to Run Tests

Run the following command in the project directory:

```sh
mvn test
```

This will execute all unit tests, including service and controller tests.

---

**Tip:**  
You can also use tools like Postman or Insomnia to interact with the API endpoints.
