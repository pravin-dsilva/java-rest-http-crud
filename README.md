# Example Java SpringBoot CRUD Application 

## Getting Started

To build the application as a Java JAR file, execute this command:

`mvn package`

## Running Locally

A Postgres DB is needed, so if you are using Docker, then you can start a postgres db easily.

`docker run --name os-postgres-db -e POSTGRESQL_USER=luke -e POSTGRESQL_PASSWORD=secret -e POSTGRESQL_DATABASE=my_data -d -p 5432:5432 centos/postgresql-10-centos7`

In this example, the db user is `luke`, the password is `secret` and the database is `my_data`

You can then start the application like this:

`JDBC_URL="jdbc:postgresql://localhost:5432/postgres" DB_USERNAME=luke DB_PASSWORD=secret java -jar target/postgress-0.0.1-SNAPSHOT.jar`

Then go to http://localhost:8080

