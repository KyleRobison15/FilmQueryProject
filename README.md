# Film Query Project

## Overview of Project
This project is a simple menu-based application that allows the user to retrieve data related to a film. The data for the films is held in an SQL database. The user can choose to display the details of the film by inputing the film's unique ID, or they can do a keyword search to look up a film. When the user chooses to look up a specific film by ID, they are taken to a sub menu where they can choose to view additional film details or view the number of copies a video store has in stock (new and used).

### Object-Relational Mapping
The most important concept featured in this project is object-relational mapping (ORM). This application relies on an SQL database running in the background that contains all the data the user may request to see from the user interface. I translated the entities and attributes of the database information into Java classes that could then be used in my application.

For example, the relational database used for this project has a table called "Film." The film table has attributes (columns of data) such as ID, title, and description. So I created a Java class called Film which has the fields ID, title, and description and all the other attributes contained in the database. From there I utilized the film class to construct java objects which was absolutely essential for the application to work. When the user requests to see a film's information, I could retrieve the data from the database and construct a Film object for display to the user.

### MySQL and Java Database Connection (JDBC)
In this project MySQL was used as the relational database management system (RDBMS). An RDBMS is...

As I mentioned earlier, when the user requests to see a film's information, I was able to retrieve the data related to that film from the database and construct a Film object for display to the user. The tool I used to connect to the database so I could retrieve data is called Java Database Connection (JDBC).

The JDBC...
connection
prepared statements and binding (avoidance of SQL injection)
result set


### Technologies Used
In addition to MySQL and Java Database Connection, I also used the following technologies:
* Maven - Dependencies Manager
* MAMP - ???

### Other Java Specific Features
* Object Oriented Design
* Loops (Standard and Advanced)
* List Interface
* Switches

### Other SQL Specific Features
* Queries
* Joining
