# QUIZ APP - Spring Boot RESTful API

<h3 align="center">(Monolithic Version)</h3>


## Project Summary

A standalone backend application developed using ***Spring Boot*** and ***PostgreSQL***. It exposes ***RESTful API*** for students to take quizzes on programming topics such as Java, Python, and related technical knowledge. Students receive a score upon submission. Admin users can manage the question bank, create quizzes, and review existing content.



## Features

- Add quiz questions
- Get questions by category
- Create quizzes from question pool
- Retrieve quiz questions
- Submit answers and receive a score


## Architecture
This project uses a monolithic Spring Boot architecture with a clear separation of concerns:
- Controller Layer – handles HTTP requests (QuestionController, QuizController)
- Service Layer – contains business logic (QuestionService, QuizService)
- Repository Layer – manages data access using Spring Data JPA
- Model Layer – defines entities and DTOs (Question, Quiz, Response, QuestionWrapper)
- Database – PostgreSQL, accessed via JPA

A microservices version of this project is also available, where the Question and Quiz services are split into independent Spring Boot applications with their own APIs and databases: add github link here

## Endpoints Summary

###  Question Service

| Method | Endpoint                         | Description               |
|--------|----------------------------------|---------------------------|
| GET    | `/question/allQuestions`         | Get all quiz questions    |
| GET    | `/question/category/{category}`  | Get questions by category |
| POST   | `/question/add`                  | Add a new question        |


### Quiz Service

| Method | Endpoint                   | Description                         |
|--------|----------------------------|-------------------------------------|
| POST   | `/quiz/create`             | Create a new quiz                   |
| GET    | `/quiz/get/{id}`           | Retrieve quiz by id                 |
| POST   | `/quiz/submit/{id}`        | Submit quiz responses and get score |


