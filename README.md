# Playbook Demo

This project is a demonstration of the Playbook framework, which provides a set of tools and libraries to accelerate the development of Quarkus applications.

## Description

This demo showcases a simple GraphQL API with filtering and pagination capabilities. The API is built using Quarkus, and it leverages the following Playbook libraries:

- **playbook-base:** Provides base classes and utilities for building Playbook applications.
- **playbook-postgresql:** Provides a pre-configured PostgreSQL integration, including a generic repository (`PlaybookRepo`) that simplifies data access.

The demo application exposes a single GraphQL endpoint that allows you to query a list of `DemoEntity` objects. The query supports filtering by various criteria and pagination.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## GraphQL API

The GraphQL API is available at <http://localhost:8080/graphql>. You can use the GraphiQL interface to explore the API and run queries.

Here's an example query that retrieves a list of `DemoEntity` objects with some filters:

```graphql
query {
  find(
    filters: {
      or: [
        {
          name: { iregex: "test" }
          typeValue: { equalTo: RESIDENTIAL }
        }
        {
          address: {
            singleLine: { iregex: "street" }
            apartmentsNo: { contains: [1.0, 2.0] }
          }
        }
      ]
    }
    page: 0
    size: 10
  ) {
    id
    name
    type
    address {
      id
      singleLine
      apartmentsNo
    }
  }
}
```

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/playbook-demo-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.
