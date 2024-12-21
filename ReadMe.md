# **ReadMe**

#  -- **POC for Your Car Your Way** --

POC for the chat functionality </br>
The frontend of the app uses Angular framework to run.</br>
The backend of the app uses Java and Spring Boot framework to run.

## **Getting Started**

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

##  - **Backend of the app** -

### **Prerequisites**

You need to install :
* Java 17
* Maven 4.0.0
* MySQL 8.0.31

### **Installing**

* [Install Java](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)
* [Install Maven](https://maven.apache.org/install.html)
* [Install MySQL](https://dev.mysql.com/downloads/mysql/)

After downloading the mysql 8 installer and installing it, you will be asked to configure the password for the default root account.

#### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.2/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#web)

#### Guides

The following guides illustrate how to use some features concretely:

* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)

### **Running the app**

First, get [this repository](https://github.com/Solau92/DevFS-Projet-13-Definissez-une-solution-fonctionnelle-et-une-architecture-back.git) and import the project on your computer.

Post installation of MySQL, Java and Maven, you must create the database.

The default name of the database is "yourcaryourway", but if you want to change it, modify the *application.properties* file (in the *./back/src/main/resources* folder) and replace "yourcaryourway" in the property "spring.datasource.url" by the name you choose for your database.

For demonstration purpose, data will be inserted in the database at the lauching of the app.

To run the app, go to the folder that contains the pom.xml file (*./back*) and execute the following command in which you have to replace "*%username%*" by your username and "%*password*%" by your password required to access your database :
`mvn spring-boot:run "-Dspring-boot.run.arguments=--spring.datasource.username=%username% --spring.datasource.password=%password%"`


## - **Front part of the app** -
 
The front part of the app can be found here : [repository](https://github.com/Solau92/DevFS-Projet-13-Definissez-une-solution-fonctionnelle-et-une-architecture-front.git)