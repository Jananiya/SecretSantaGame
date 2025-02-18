# SecretSantaGame
Welcome to the SecretSantaGame project!
This is the full-stack web SecretSantaGame Application built using React.js and Spring Boot.
# Table Of Contents
1.Project Description
2.Features
3.Tech Stack
4.Installation
5.Usage
6.Constraints
7.Notes
8.Contributing
9.License
# Project Description
This project is a full-stack web based SecretSantaGame Application that assigns each partipant a secret child, to whom they will anonymously give a gift.
# Features
1.User-friendly interface
2.Secret Santa game logic
3.Random assignment of secret child
# Tech Stack
Frontend: React.js
Backend : SpringBoot
# Installation
1.Clone the repository              : git clone https://github.com/Jananiya/SecretSantaGame.git
2.Install the dependencies          : npm install (for React) and mvn clean install (for SpringBoot)
3.Start the SpringBoot application  : mvn spring-boot:run 
4.Start the React application       : npm start
# Usage
1.Access the application: http://localhost:3000
2.Upload the employee CSV file and previous assignment CSV file to generate the Secret Santa assignments
3.The Output will be a new CSV file containing the Secret Santa assignments ,which can be downloaded.
# Constraints
1.An employee cannot be assigned to themselves as their secret file
2.An employee cannot be assigned to the same secret child as in the previous year's SecretSanta game,if applicable.
3.Each employee must have exactly one secret child.
4.Each secret child should be assigned to only one employee.
# Notes
Duplicate employees in the input CSV file will be removed before generating the Secret Santa assignments.
# Contributing
Contributions are Welcome! Please submit a pull request with your changes.
# License
This Project is licensed under MIT License.See the License File for details.


