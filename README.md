# NFL Team Data Server

- This is a Spring Boot Kotlin application that allows you to store and manage information about NFL teams. 

- The application stores information about teams' head coaches, locations, colors, and stadiums. 

- It uses an embedded H2 database to store all the data.

## Installation
To run this application locally, you will need to have the following tools installed on your machine:

- JDK 17 or later
- Gradle 7.6 or later
- Docker (optional, if you want to run the application in a container)

### Install and run using Gradle:

To install the application, follow these steps:
1. Clone the application: ```git clone https://github.com/your-username/nfl-team-data.git```
2. Build the applicaiton using gradle: ```./gradlew build```
3. Run the application using gradle: ```./gradlew bootRun```

### Install and run using Docker:
1. Build using docker: ```docker build -t sports-data-server .```
2. Run the docker image: ```docker run -p 8081:8081 sports-data-server```

## Usage
Once the application is running, you can use the following endpoints to manage NFL team data:
- ```GET /api/v1/teams/``` - Get a list of all teams
- ```GET /api/v1/teams/{teamId}/``` - Get information about a specific team
