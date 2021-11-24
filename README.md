# Expense Reimbursement System

## Project Description

The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. 
All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. 
Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers 
are authorized to approve and deny requests for expense reimbursement. 

## Technologies Used

* Java Version 8
* JavaScript 
* HTML 
* CSS 
* JDBC 
* Amazon RDS PostgreSQL
* Javalin 
* Maven 
* JUnit4 
* Log4J

## Features

List of features ready and TODOs for future development
* Navigation between home page, employee list, create employee, expense reimbursement list, and create reimbursement
* Create Reimbursement
* Create Employee
* View List of Reimbursements
* View List of Employees
* Delete Employee or Reimbursement
* Update Employee or Reimbursement
* Delete or approve Reimbursement

To-do list: 
* Work on creating a more secure login process, such as hiding url query param and add authentication guards 

## Getting Started

Follow these steps to get started: 

* First, start by cloning the repository with the following command in your terminal: git clone https://github.com/AustinWayneSanders/project1.git 
* The database instance that was used when creating this project may not be avaible by the time of cloning this project, resulting in a null pointer exception. In this case, please follow the instructions regarding setting up the database environment with AWS. 
> Once you have logged into your AWS console root account, click on services in the top left corner. This button is circled in white with the image below. 
![Click Services](https://github.com/AustinWayneSanders/project1/blob/main/Project1_Demo_Images/project1_Image1.png)
>
> After clicking services, a new menu will appear with a list of Amazon's services. Click the one that is title "RDS." It is circled in the image below.
> 
![Click RDS](https://github.com/AustinWayneSanders/project1/blob/main/Project1_Demo_Images/project1_Image2.png)
>
>Once on the RDS page, there is an option near the bottom the screen that says "Create Database". Click this option to start the process of creating a new instance. 
>
![Click Create Database](https://github.com/AustinWayneSanders/project1/blob/main/Project1_Demo_Images/project1_Image3.png)
>
>This project is configured to communicate with postgreSQL, so select that database. Make sure to select postreSQL ll.13-R1 as the version number. 
>
![Select PostreSQL](https://github.com/AustinWayneSanders/project1/blob/main/Project1_Demo_Images/project1_Image4.PNG)
>
>Keep the database instance identifier as database-1, keep the master name as postgres, and create the password to be "password". It is acceptable to change other settings, however the default settings will leave you in the free tier. 
>
![Edit the Settings](https://github.com/AustinWayneSanders/project1/blob/main/Project1_Demo_Images/project1_image5.PNG)
>
> Make sure that you enable public access to the database. Without this option enabled, the application will not be able to communicate with your database instance. 
>
![Select Public Access](https://github.com/AustinWayneSanders/project1/blob/main/Project1_Demo_Images/project1_image6.PNG)
>
> You can find the endpoint and port number for you database when you click the link to your database instance. This information will be used to establish the connection with PGadmin. 
>
![Database Access Endpoint for Database Connection](https://github.com/AustinWayneSanders/project1/blob/main/Project1_Demo_Images/project1_image7.png)
>
> In PgAdmin, create a new server. Copy and past your Amazon database instance endpoint to the host text box on the connection tab. The default port number should be the port number for postgreSQL. If not, change the port number to 5432. 
>
![Use the Access Endpoint from AWS to Configure Server Setting in PgAdmin](https://github.com/AustinWayneSanders/project1/blob/main/Project1_Demo_Images/project1_image8.PNG)


> Next, we will create the database tables. You may create the tables manually by continuing the instructions or by executing "projectoneDBScript.sql" located in this repository. 

> Create an Employee and Reimbursement table in the following location: 

![Create Employee and Reimbursement Table in the Following Location](https://github.com/AustinWayneSanders/project1/blob/main/Project1_Demo_Images/project1_image9.PNG)
>
> Create an employee table.
>
![Employee Table](https://github.com/AustinWayneSanders/project1/blob/main/Project1_Demo_Images/project1_image10.PNG)
>
> Create the following employee column properties. The application is case sensitive. Ensure that the column names and data types match exactly as displayed in the image below:
>
![Employee Table Column Properties](https://github.com/AustinWayneSanders/project1/blob/main/Project1_Demo_Images/project1_image11.PNG)
>
> Repeat the process above with the reimbursement table. 
>
![Reimbursement Table Column Properties](https://github.com/AustinWayneSanders/project1/blob/main/Project1_Demo_Images/project1_image12.PNG)
>
> Open project1_5 in Maven and right click on the project name. Select "run as java project". You will likely be prompted to select a starter class. Select the one highlighted in the image below. 
>
![Select Startup Class](https://github.com/AustinWayneSanders/project1/blob/main/Project1_Demo_Images/project1_image13.PNG)
>
> After starting the application. Navigate to http://localhost:7090 in you browser. You should see the start up page as illustrated below:
>
![Home Page](https://github.com/AustinWayneSanders/project1/blob/main/Project1_Demo_Images/project1_image14.PNG)

## Usage

![](https://github.com/AustinWayneSanders/project1/blob/main/Project1_Demo_Images/project1_image19.PNG)
![](https://github.com/AustinWayneSanders/project1/blob/main/Project1_Demo_Images/project1_image20.PNG)
![](https://github.com/AustinWayneSanders/project1/blob/main/Project1_Demo_Images/project1_image21.PNG)
![](https://github.com/AustinWayneSanders/project1/blob/main/Project1_Demo_Images/project1_image22.PNG)
![](https://github.com/AustinWayneSanders/project1/blob/main/Project1_Demo_Images/project1_image23.PNG)
![](https://github.com/AustinWayneSanders/project1/blob/main/Project1_Demo_Images/project1_image24.PNG)
![](https://github.com/AustinWayneSanders/project1/blob/main/Project1_Demo_Images/project1_image25.PNG)
![](https://github.com/AustinWayneSanders/project1/blob/main/Project1_Demo_Images/project1_image26.PNG)
![](https://github.com/AustinWayneSanders/project1/blob/main/Project1_Demo_Images/project1_image27.PNG)
![](https://github.com/AustinWayneSanders/project1/blob/main/Project1_Demo_Images/project1_image28.PNG)
![](https://github.com/AustinWayneSanders/project1/blob/main/Project1_Demo_Images/project1_image29.PNG)

## Contributors and Tasks

This was individual project. The process consisted of full stack development tasks including: 
* Setting up the development environment which involved creating an AWS postgreSQL database instance with database connections in the application, downloading and installing Javalin, downloading and installing Maven along with configuring necessary dependencies in the POM.xml file: JUnit4, Log4J, and JDBC, Javalin. 
* Setting up project directory files and packages to conform to RESTful framework standards: DAOs, entities, controllers, untils, services. 
* Configuring hibernate to communicate with the Amazon database instance
* Creating entity beans for each database table
* Creating services with database processing methods (CRUD operations)
* Creating controllers to call services and establish endpoints for front-end communication
* Starting a Javalin server with routing
* Creating html pages that corresponds to the end-points, along with styling with CSS and Bootstrap. 

## License

This application does not use any license.
