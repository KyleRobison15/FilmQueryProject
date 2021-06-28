# Film Query Project

## Overview of Project
This project is a simple menu-based application that allows the user to retrieve data related to a film. The data for the films is held in an SQL database. The user can choose to display the details of the film by inputing the film's unique ID, or they can do a keyword search to look up a film. When the user chooses to look up a specific film by ID, they are taken to a sub menu where they can choose to view additional film details or view the number of copies a video store has in stock (new and used).

### Object-Relational Mapping
The most important concept featured in this project is object-relational mapping (ORM). This application relies on an SQL database running in the background that contains all the data the user may request to see from the user interface. I translated the entities and attributes of the database information into Java classes that could then be used in my application.

For example, the relational database used for this project has a table called "Film." The film table has attributes (columns of data) such as ID, title, and description. So I created a Java class called Film which has the fields ID, title, and description and all the other attributes contained in the database. From there I utilized the film class to construct java objects which was absolutely essential for the application to work. When the user requests to see a film's information, I could retrieve the data from the database and construct a Film object for display to the user.

### MySQL, Java Database Connectivity (JDBC) and Maven
This entire project would not be possible without a few very important technologies:

#### MySQL
In this project MySQL was used as the relational database management system (RDBMS). Using MySQL allowed me to implement the database containing all the data needed for the application to work.

#### Java Database Connectivity (JDBC) and Maven
As I mentioned earlier, when the user requests to see a film's information, I was able to retrieve the data related to that film from the database and construct a Film object for display to the user. The tool I used to connect to the database so I could retrieve data is called Java Database Connectivity (JDBC).

The JDBC is a powerful API that allowed me to run SQL commands from my application code. This is what allowed me to bridge the gap from user requests for data into an SQL command that actually retrieves that information from the data base.

The JDBC works by first allowing us to connect to the database and then generate what are called prepared statements to query the database and retrieve the information we need. The prepared statements are standard SQL commands. When a prepared statement is executed, the resulting data is retrieved and stored in a result set that we can then proceed to utilize through object relational mapping.

The JDBC also allowed me to bind specific input from the user to a specific part of the SQL command. For example, when the user requests to look up a film by that film's unique ID, I can bind the unique ID to the SQL command in the prepared statement. This prevents SQL injection which can lead to unexpected and potentially malicious results from executing the query.

Finally, I also utilized a tool called Maven as the dependencies manager for the JDBC.

### Other Java Specific Features
* Object Oriented Design
* Loops (Standard and Advanced)
* List Interface
* Switches

### Other SQL Specific Features
* Queries
* Joining
