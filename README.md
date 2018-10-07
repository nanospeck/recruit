

#Starting the application

1. Checkout the code and go to the root folder
2. **mvn spring-boot:run**
3. Open the Swagger UI at : **http://localhost:8080/swagger-ui.html#/**
4. Try out the queries right from the browser using sample data from swagger

#Connection to H2 Database

1. Go to url http://localhost:8080/h2-console/login.jsp
2. Change the JDBC URL to : jdbc:h2:mem:testdb
3. Click on Connect button
4. You can see all the tables listed in the dashboard

# Questions, Solutions and Approach


Following are questions required in the challenge. 
Corresponding api endpoints are mentioned below each task and can be tried thru swagger:

**user has to be able to create a job offer**
POST http://localhost:8080/recruit-service/v1/offers

**user has to read a single job**
GET http://localhost:8080/recruit-service/v1/offers/{id}

**user has to list all offers**
GET http://localhost:8080/recruit-service/v1/offers

**Candidate has to be able to apply for an offer**
POST http://localhost:8080/recruit-service/v1/applications
*// VALIDATES OFFER ID AND UNIQUE EMAIL ADDRESS*

**user has to be able to read one application**
**GET http://localhost:8080/recruit-service/v1/applications/{id}**

**user has to to be able to list all applications per offer**
GET http://localhost:8080/recruit-service/v1/applications/offer/{offerId}

**user has to be able to progress the status of an application**
PUT http://localhost:8080/recruit-service/v1/applications/{id}
*// VALIDATES STATUS VALUE IS ONE AMONG APPLIED/ INVITED/ REJECTED/ HIRED*

**user has to be able to track the number of applications**
GET http://localhost:8080/recruit-service/v1/applications/count

**(*) a log output will suffice as a notification here, but you should design it as if each status change triggers a completely different business case.**
*// Implemented* **Factory Pattern** *in updateApplication() method*


# Future Enhancements

*Test coverage: Add 100% test coverage to the code for the ease of maintenance and code quality. This is skipped now due to time constrains.
*Add service later between the controller and repo to handle all business logic
