<p align="center">
  <img src="https://github.com/TEWgijon/README-examples/blob/main/img/logo-epigijon.png" alt="EPI Gijón logo" width="200"/>
</p>


# Deploying the Application

This project demonstrates an implementation of the well-known *gestioneitor* application using the Spring Boot framework. 

To deploy the application, navigate to the root directory (where the `pom.xml` file is located) and run the following command:

```bash
mvn spring-boot:run
```

Once deployed, the application will be accessible on the Spring server at [http://localhost:8080](http://localhost:8080).  
Please note, the application also requires the HSQL server to be running with the original *gestioneitor* schema and data.
