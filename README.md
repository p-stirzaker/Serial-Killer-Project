src/main/java coverage: 84.7%
# Serial-Killer-Project

A Spring Boot web application used for storing information on British serial killers allowing you to create new serial killers, update exisiting serial killers if you know information on them had changed, read information on each serial killer in the database by utilizing get all and get by functionality to view by specifics like first name and last, and allowing for the ability to delete serial killers from the database with the use of functioning front end web page.

## Getting Started

These instructions will help you get a copt of the project running on your local machine for development and testing purposes. 

### Prerequisites

#### Java
Use this link to download [java](https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html)

Click the Download link that corresponds to the current .exe for your version of windows.

Run the installer using admin privelages and follow the instructions given.

Check that the installer set the _PATH_ variable ofr you.

To set the _PATH_ variable, go to your **control pannel** and then click **system**.

Click **Advanced** and then **Environment Variables**.

Add the location of the _bin_ folder of your JDK installation to the **PATH** variable in **System Variables**.

The full path should look something like this:

_C:\Program files\Java\jdk-16\bin_

### Eclipse
Use this link to download [Eclipse](https://www.eclipse.org/downloads/)

Download the X84_64 executable.

Run the .exe and complete the setup wizard to install eclipse, all default options are suitable left as they are.

### MySQL Server
Use this link to to download [MySQL](https://dev.mysql.com/downloads/installer/)

Complete the setup wizard, making sure to select **MySQL server**.

All default options given are fine as they are, with a default passowrd of **root** for the server.

If you create different login detail, make sure these values are changed in the _application-prod.properties_ file in your project so you can connect to your database.

### Postman
Use this link to download [Postman](https://www.postman.com/downloads/)

Complete the set up with any given options being fine as they are.

## Installing
Here is a step by step guide of examples to explain how to get a development environment running.

### Clone the project from Github
Use the following command line to clone the repository to your local machine.

`https://github.com/p-stirzaker/Serial-Killer-Project.git`

### Import the project to Eclipse as an existing Maven project
In Eclipse, choose _file_ > _import_.

Then, under **Maven** choose **Existing Maven Project**.

Select the previously imported repository as the root directory.

Ensure the _pom.xml_ file is visible and selected, then click **import**.

### Run the Application
To run the application from Eclipse:

Right click the project folder in hierarchial view on the **left** and _Right click > Run as > Spring Boot app_.

Once the server has started, you will be able to browse to http://localhost:8082/index.html and begin interacting with the application.

By default, port 8082 is what is being used by this application. If you need to set a different port, navigate to the application-prod.properties file in _src/main/resources_ and change/set a new value:

`server.port=XXX`

Furthermore, if your MySQL database is running on a port other than 3306, be sure to change the spring.datasource.url value in the same file.

## Running the tests
To run all of the different types of tests that are in this system, right click the project and _Run as . JUnit Test_

See: 
![JUnit](https://github.com/p-stirzaker/Serial-Killer-Project/blob/dev/Documentation/JUnit.png)

### Unit Tests
To test only the functionality of the SerialKillerController class:

Go to the _src/test/java/com.bae.main_ **contoller** package.

Locate the SerialKillerControllerUnitTest file and _Right click > Run as > JUnit Test_.

See: 
![ControllerUnitTest](https://github.com/p-stirzaker/Serial-Killer-Project/blob/dev/Documentation/ControllerUnitTestGuide.png)

This will unit test the Serial Killer controller in isolation, by testing eadch of the method functions correctly.

### Integration Tests
To run an integration test:

Go to the _src/test/java/com.bae.main_ **controller** package.

Locate the SerialKillerControllerIntergrationTest file and _Right click > Run as > JUnit Test_.

See:
![IntergationTest](https://github.com/p-stirzaker/Serial-Killer-Project/blob/dev/Documentation/IntegrationTest.png)

This will integration test the controller, service and repo layers of the application using a MockMVC to make API calls.

### Postman testing
By using postman you can see if all the CRUD functions are working correctly.

To do this you need to start running your API, by Right clicking on the project in Eclipse and choosing _Run as > Spring Boot App_.

See: 
![springbootstart](https://github.com/p-stirzaker/Serial-Killer-Project/blob/dev/Documentation/Spring%20boot%20start.png)

Next go to postman and enter the local host into the search bar followed by the function you would like to call, for example `localhost:8082/SerialKiller/creat` and test you get back the results you are expecting.

Here I will add some examples:

**Create**:
![createpostman](https://github.com/p-stirzaker/Serial-Killer-Project/blob/dev/Documentation/Postman-create.png)

**Update**:
![update[postman](https://github.com/p-stirzaker/Serial-Killer-Project/blob/dev/Documentation/Postman-update.png)

**Get All**:
![getallpostman](https://github.com/p-stirzaker/Serial-Killer-Project/blob/dev/Documentation/Postman-getAll.png)

**Get By ID**:
 ![getbyidpostman](https://github.com/p-stirzaker/Serial-Killer-Project/blob/dev/Documentation/Postman-getByID.png)
  
 **Get By First Name**:
![getbyfirstnamepostman](https://github.com/p-stirzaker/Serial-Killer-Project/blob/dev/Documentation/Postman-getByFirstName.png)
 
 **Get By Last Name**:
![getbylastnamepostman](https://github.com/p-stirzaker/Serial-Killer-Project/blob/dev/Documentation/Postman-getByLasyName.png)
 
 **Update**:
![updatepostman]( https://github.com/p-stirzaker/Serial-Killer-Project/blob/dev/Documentation/Postman-update.png)

**Delete**:
![deletepostman](https://github.com/p-stirzaker/Serial-Killer-Project/blob/dev/Documentation/Postman-delete-part1.png)
![deletepostman](https://github.com/p-stirzaker/Serial-Killer-Project/blob/dev/Documentation/Postman-delete-part2.png)

## Swagger API Endpoints

This image shows the API endpoints for the application.
![swagger](https://github.com/p-stirzaker/Serial-Killer-Project/blob/dev/Documentation/Swagger%20API%20screenshot.png)

If you would like to view this yourself, go to `http:localhost:8082/swagger-ui/index.html` when the application is running.

## Project Management Board 
* Follow this link to [Jira Board](https://pstirzaker.atlassian.net/jira/software/projects/SKP/boards/6)

Using this board allowed for easier recognition of tasks that needed to be completed and laid out a prioritisation that I could follow to help manage time for the workflow.

## Built With
* [Spring Boot](https://spring.io/projects/spring-boot/)
* [VS Code](https://code.visualstudio.com/)

## Author
* [Phoebe Stirzaker](https://github.com/p-stirzaker)

## License
This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments/References
* [Bootstrap](https://getbootstrap.com/)
* [Axios](https://axios-http.com/docs/intro)
