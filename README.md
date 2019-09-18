# Example Java SpringBoot CRUD Application

## Getting Started

To build the application as a Java JAR file, execute this command:

```shell
mvn package
```

## Running Locally

A running instance of PostgreSQL DB is needed for the application to function properly, so if you are using a container engine (such as [Podman](https://podman.io/) or [Docker](https://www.docker.com/)), then you can start a PostgreSQL DB easily.

NOTE: If the DB is not available, the application still runs while it does not function fully.

### Podman

```shell
podman run --name os-postgres-db -e POSTGRESQL_USER=luke -e POSTGRESQL_PASSWORD=secret -e POSTGRESQL_DATABASE=my_data -d -p 5432:5432 centos/postgresql-10-centos7
```

### Docker

```shell
docker run --name os-postgres-db -e POSTGRESQL_USER=luke -e POSTGRESQL_PASSWORD=secret -e POSTGRESQL_DATABASE=my_data -d -p 5432:5432 centos/postgresql-10-centos7
```

In this example, the db user is `luke`, the password is `secret` and the database is `my_data`

You can then start the application like this:

```shell
JDBC_URL="jdbc:postgresql://localhost:5432/my_data" DB_USER=luke DB_PASSWORD=secret java -jar target/java-rest-http-crud-0.0.1-SNAPSHOT.jar
```

Then go to [http://localhost:8080](http://localhost:8080)
