# Dojo - Development Sandbox

This project is a personal development sandbox.

Its purpose is to:
- explore new development patterns,
- reinforce what I already know,
- experiment safely with ideas before applying them elsewhere.

This repository is intentionally not dedicated to a single methodology or feature.
It is a space for iterative experiments across architecture, testing, design, and delivery practices.

## Current Project Stack

- Java 25
- Spring Boot 4 (MVC)
- Maven Wrapper
- JUnit 5 + Spring test support

## Current Focus (First Experiment)

The current experiment is to build a web service that returns the Fibonacci number at the index provided by the user.
This is only one learning track among many future tracks.

Example target behavior:
- Request: `GET /api/fibonacci?index=7`
- Response: `13`

You can choose to return plain text or JSON first, then evolve the API in later refactors.

### TDD Approach (Red -> Green -> Refactor)

TDD is currently used as a practice approach for this experiment.

For each small behavior:

1. Red: write a failing test.
2. Green: write the minimal code to pass.
3. Refactor: improve design while keeping tests green.

Recommended progression for Fibonacci:

1. Return `0` for index `0`.
2. Return `1` for index `1`.
3. Return correct values for `2`, `3`, `4`, etc.
4. Handle invalid input (for example negative index).
5. Decide and document behavior for large indexes and potential overflow.

### Suggested Implementation Steps

1. Start with a focused test for the HTTP endpoint.
2. Add a small service class for Fibonacci logic.
3. Keep the controller thin and delegate computation to the service.
4. Add validation and explicit error responses.
5. Refactor internal algorithm only when covered by tests.

## Run the Project

### On Windows (PowerShell)

Run tests:

```powershell
.\mvnw.cmd test
```

Run the app:

```powershell
.\mvnw.cmd spring-boot:run
```

Build:

```powershell
.\mvnw.cmd clean verify
```

## Quick Manual Check (after implementation)

```bash
GET http://localhost:8080/api/fibonacci?index=10
```

Expected result:

```text
55
```