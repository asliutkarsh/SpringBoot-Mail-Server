# Spring Boot Mail Server

## Overview
This project is a Spring Boot application that provides RESTful APIs to send emails. It supports sending both plain text and HTML emails, as well as bulk emails.

## Features
- Send plain text emails
- Send HTML emails
- Send bulk emails

## Technologies Used
- Java
- Spring Boot
- Maven
- Lombok
- Spring Mail

## Installation and Setup (Local)
To run the application, execute the following command:

1. Clone this repository to your local machine.
2. Make sure you have Java Development Kit (JDK) installed. You can download it from the Oracle website or use OpenJDK.
3. Make sure you have Maven installed. You can download it from the Apache Maven website.
4. Open a terminal and navigate to the project directory.
5. Install the required dependencies by running the following command: ```mvn clean install```
6. Run the application by executing the following command: ```mvn spring-boot:run```
7. The application will start, and you can access it at `http://localhost:8080`. You can configure the port in the `application.yaml` file if needed.

## Configuration
### application.yaml
The main configuration file for the application. It includes settings for the mail server.

```yaml
spring:
  application:
    name: mail-server
  mail:
    host: smtp.gmail.com
    port: 587
    username: ${MAIL_USERNAME:username}
    password: ${MAIL_PASSWORD:password}
    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: true
```


## Deployment

### Docker
To deploy the application using Docker, follow these steps:

1. Clone this repository to your local machine.
2. Make sure you have Docker installed. You can download it from the Docker website.
3. Open a terminal and navigate to the project directory.
4. Build the Docker image by running the following command: ```docker build -t mail-server .```
5. Run the Docker container by executing the following command: ```docker run -d -p 8080:8080 mail-server -e MAIL_USERNAME=<your_email> -e MAIL_PASSWORD=<your_password>```
6. The application will start, and you can access it at `http://localhost:8080`. You can configure the port in the `application.yaml` and `DockerFile` file if needed.
7. To stop the container, run the following command: ```docker stop <container_id>```
8. To remove the container, run the following command: ```docker rm <container_id>```
9. To remove the image, run the following command: ```docker rmi mail-server```
10. To deploy the application to a cloud provider, you can push the Docker image to a container registry and deploy it using a container orchestration service like Kubernetes.
11. To push the Docker image to Docker Hub, follow these steps:
    - Log in to Docker Hub by running the following command: ```docker login```
    - Tag the Docker image with your Docker Hub username and repository name by running the following command: ```docker tag mail-server <username>/mail-server```
    - Push the Docker image to Docker Hub by running the following command: ```docker push <username>/mail-server```

## Usage

### Sending Plain Text Emails
To send a plain text email, use the following endpoint:

```http
POST /api/mail/send
```

Request Body:

```json
{
  "to": "dummy@gmail.com",
  "subject": "Test Email",
  "content": "This is a test email."
}
```

### Sending HTML Emails
To send an HTML email, use the following endpoint:

```http
POST /api/mail/send
```

Request Body:

```json
{
  "to": "dummy@gmail.com",
  "subject": "Test Email",
  "content": "<h1>This is a test email.</h1>",
  "isHtml": true
}
```

### Sending Bulk Emails
To send bulk emails, use the following endpoint:

```http
POST /api/mail/send/bulk
```

Request Body:

```json
{
  "to": ["dummy@gmail.com", "dummy@gmail.com"],
  "subject": "Test Email",
  "content": "This is a test email."
}
```

## Contributing
Contributions are welcome! If you have any ideas for new features, bug fixes, or improvements, please submit a pull request. Ensure that your code follows the project's coding conventions and is thoroughly tested.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
