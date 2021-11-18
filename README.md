# Expense Reimbursement System

## Project Description

The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. 
All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. 
Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers 
are authorized to approve and deny requests for expense reimbursement. 

## Technologies Used

* Java Version 1.8
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

To-do list:
* Expand to include delete (deny), update (approve) reimbursements
* Expand to include delete and update employee 
* Finish integration with Login page. 

## Getting Started

Follow these steps to get started: 

* First, start by cloning the repository with the following command in your terminal: git clone https://github.com/AustinWayneSanders/project1.git 
* The database instance that was used when creating this project may not be avaible by the time of cloning this project, resulting in a null pointer exception. In this case, please follow the instructions regarding setting up the database environment with AWS: 
* Once you have logged into your AWS console root account, click on services in the top right corner. This button is circled in white with the image below. 
![Click Servies](project1_Image1.png)
*
*
*
![Click RDS](project1_Image2.png)
*
*
*
![Click Create Database](project1_Image3.png)
*
*
*
![Select PostreSQL](project1_Image4.PNG)
*
*
*
![Edit the Settings](project1_image5.PNG)
*
*
*
![Select Public Access](project1_image6.PNG)
*
*
*
![Database Access Endpoint for Database Connection](project1_image7.png)
*
*
*
![Use the Access Endpoint from AWS to Configure Server Setting in PgAdmin](project1_image8.PNG)
*
*
*
![Create Employee and Reimbursement Table in the Following Location](project1_image9.PNG)
*
*
*
![Employee Table](project1_image10.PNG)
*
*
*
![Employee Table Column Properties](project1_image11.PNG)
*
*
*
![Reimbursement Table Column Properties](project1_image12.PNG)
*
*
*
![Select Startup Class](project1_image13.PNG)
*
*
*
![Home Page](project1_image14.PNG)

## Usage

> Here, you instruct other people on how to use your project after they’ve installed it. This would also be a good place to include screenshots of your project in action.

## Contributors

> Here list the people who have contributed to this project. (ignore this section, if its a solo project)

## License

This project uses the following license: [<license_name>](<link>).
