<p align="center">
  <img src="https://github.com/TEWgijon/README-examples/blob/main/img/logo-epigijon.png" alt="EPI Gijón logo" width="200"/>
</p>

# Deploying the Application

The application is deployed on Node.js, can be installed from the following [url](https://nodejs.org/en/download/prebuilt-installer). 
To verify how it works, you can test it using the following command:

```bash
npm install
```
And then deploy it with:
```bash
node [file.js]
```
Some of the examples are:

- Simple HelloWorld application using HTTP:
  ```bash
  node BasicoHTTP.js
  ```
  The application is made accesible through [https://localhost:3000](https://localhost:3000)

- Basic express backed with "Helloworld"
  ```bash
  node BasicoExpress.js
  ```
  The application is made accesible in the same [URI](https://localhost:3000)

- Simple application using Swig with a fronted and a list of students
  ```bash
  node BasicoSwig.js
  ```
  The application is made accesible in the same [URI](https://localhost:3000)

- Students API with a simple on-memory sqlite database
  ```bash
  node index.js
  ```
  The API endpoint is made accesible through [https://localhost:3000/api/alumnos](https://localhost:3000/api/alumnos)