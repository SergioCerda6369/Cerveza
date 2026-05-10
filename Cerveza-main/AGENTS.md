# AGENTS

## Project Overview
- Java Spring Boot application using Maven wrapper (`mvnw`, `mvnw.cmd`).
- Target Java version: 21.
- Spring Boot version: 4.0.6.
- Uses Spring Data JPA with MySQL connector, Spring MVC/Web services, validation, and Lombok.

## Recommended Commands
- Build: `./mvnw clean package`
- Run: `./mvnw spring-boot:run`
- Test: `./mvnw test`
- Windows: use `mvnw.cmd` instead of `./mvnw`.

## Key Source Structure
- `src/main/java/com/cerveza/cerveza`
  - `controller/` - REST controllers
  - `service/` - service layer and business logic
  - `repository/` - Spring Data JPA repositories
  - `model/` - JPA entity classes
  - `dto/` - data transfer objects
- `src/main/resources/application.properties` - application configuration
- `src/test/java/...` - unit and integration tests

## Conventions for AI Coding Agents
- Respect the existing Spring layered architecture:
  - controllers -> services -> repositories
- Maintain Spanish domain naming and entity names.
- Prefer using Spring Boot starter dependencies already in the project.
- Avoid introducing new runtime frameworks unless required by a clear feature need.

## Notes for Language/Stack
- This repository is Java-first and uses Spring Boot conventions.
- The most useful files for understanding behavior are in `controller`, `service`, `repository`, and `model` packages.
- There is no `README.md` or existing agent customization file in the repository.
