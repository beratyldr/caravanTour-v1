Below is a refined and developer-friendly version for your GitHub README file:

Caravantour Project Setup

This document provides step-by-step instructions to set up and run the Caravantour project locally. Please follow the guidelines below to configure the backend, frontend, and Elasticsearch components.

Prerequisites

Before starting, ensure you have the following installed on your system:
	•	Java 17 or later
	•	MySQL
	•	Node.js and npm
	•	Elasticsearch (version specified in the pom.xml file)
	•	IntelliJ IDEA (or any preferred IDE)

Backend Setup
	1.	Configure MySQL
	•	Create a new database for the project (e.g., projectName).
	•	Update the database credentials in the application.properties or application.yml file:
```
spring.datasource.url=jdbc:mysql://localhost:3306/projectName
spring.datasource.username=YourUserName
spring.datasource.password=YourPassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```


	2.	Start the Backend
	•	Open the project in IntelliJ IDEA.
	•	Run the project in debug mode.
	•	Upon starting, initial data (e.g., user and userRole) will be automatically inserted into the database.
	Note: You can log in with the following default admin credentials:
Email: admin@gmail.com
Password: admin

Frontend Setup
	1.	Install Dependencies
	•	Navigate to the frontend folder in your terminal.
	•	Run the following command to install all dependencies:

npm install


	2.	Start the Frontend
	•	After installing dependencies, start the frontend using:

npm start


	•	The frontend will be accessible at http://localhost:3000.

Elasticsearch Setup
	1.	Install Elasticsearch
	•	Install the version of Elasticsearch specified in the pom.xml file.
	2.	Start Elasticsearch
	•	Navigate to the Elasticsearch installation folder.
	•	Start the server with the following command:

./bin/elasticsearch

Notes
	•	Ensure that all services (MySQL, Backend, Frontend, and Elasticsearch) are running before using the application.
	•	The application uses specific versions of dependencies as defined in the pom.xml file and package.json. Please verify compatibility during setup.

Feel free to reach out for any issues or additional support!

This version improves clarity and organization, making it easier for developers to follow.
