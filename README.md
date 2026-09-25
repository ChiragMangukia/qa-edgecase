# qa-edgecase

A Java toolkit for generating, mutating, and explaining edge cases for automated tests.

> Don't just generate more test data. Generate test data and scenarios that deliberately challenge application assumptions.

## Why qa-edgecase?

Most automated tests start with valid, expected input:

```json
{
  "name": "Test User",
  "age": 30,
  "email": "user@example.com"
}
```

Real systems also receive:

```text
Empty values
Null values
Whitespace
Boundary values
Out-of-range values
Malformed values
Unexpected data types
Unicode and emoji
Very long input
Missing fields
Additional fields
Duplicate requests
Invalid state transitions
```

QA engineers already know these cases matter. The problem is that identifying, creating, explaining, and maintaining them can become repetitive.

`qa-edgecase` aims to make this process systematic.

## Vision

The long-term goal is to build a reusable Java QA toolkit that can:

```text
Understand input constraints
        ↓
Generate meaningful edge cases
        ↓
Explain why each case was generated
        ↓
Generate automation-ready tests
        ↓
Challenge application assumptions
```

## Core Principle

Every generated edge case should answer:

> **What assumption are we deliberately challenging?**

For example:

```text
Value:      101
Category:   BOUNDARY
Reason:     maximum + 1
Constraint: age <= 100
```

The project is not intended to become another random test-data generator.

The goal is **useful and explainable test conditions**.

## Current Status

**Version:** `0.1.0-SNAPSHOT`

The project is currently at the foundation stage.

Current work:

- Maven project setup
- Java 17 configuration
- Project documentation

Next:

- Core domain model
- Edge-case categories
- Strategy abstraction
- First edge-case generator

## Technology

### Current

- Java 17+
- Maven

### Planned

- JUnit 5
- TestNG
- REST Assured
- JSON Schema
- OpenAPI
- GitHub Actions

The core library should remain independent of specific testing frameworks.

## Planned Capabilities

### Primitive Edge Cases

```text
String
Integer
Boolean
Email
URL
Date/Time
Phone
```

### Input Strategies

```text
Boundary
Empty
Null
Whitespace
Unicode
Length
Format
Type mutation
Missing fields
Additional fields
Duplicate values
```

### Structured Data

```text
JSON mutation
JSON Schema analysis
Nested objects
Arrays
```

### API Testing

```text
OpenAPI analysis
Request mutation
Endpoint-aware edge-case generation
REST Assured integration
```

### Automation Integration

```text
JUnit 5
TestNG
REST Assured
GitHub Actions
```

### Advanced QA Scenarios

```text
Business-rule mutation
State transitions
Workflow mutation
Concurrency scenarios
```

## Project Structure

The initial structure is intentionally small:

```text
qa-edgecase/
│
├── pom.xml
├── README.md
├── .gitignore
│
└── src/
    ├── main/
    │   └── java/
    │
    └── test/
        └── java/
```

The structure will evolve as the project grows.

The planned source structure is:

```text
src/main/java/io/qaedgecase/

├── core/
├── generator/
├── strategy/
├── mutation/
├── schema/
├── openapi/
├── output/
└── cli/
```

## Development Philosophy

This project is being built incrementally.

The implementation should favor:

- Small, focused classes
- Clear interfaces
- Generics where they add value
- Immutability where practical
- Composition over unnecessary inheritance
- Deterministic behavior by default
- Strong unit tests
- Meaningful names
- Minimal dependencies

The project is also intended to be a practical way to strengthen Java skills through real development.

The implementation will deliberately provide opportunities to practice:

```text
Classes and Objects
Interfaces
Generics
Enums
Collections
Exceptions
Records
Streams
Lambdas
Composition
SOLID principles
Design patterns
JUnit
Maven
API design
CLI design
```

## Roadmap

### 0.1 - Foundation

- [x] Maven project
- [x] Java 17 configuration
- [x] README
- [x] Core domain model
- [x] Edge-case categories
- [x] Strategy abstraction

### 0.2 - Primitive Generators

- [ ] String
- [ ] Integer
- [ ] Boolean
- [ ] Email
- [ ] URL
- [ ] Date/time
- [ ] Phone

### 0.3 - Structured Data

- [ ] JSON mutation
- [ ] JSON Schema
- [ ] Nested objects
- [ ] Arrays

### 0.4 - API Testing

- [ ] OpenAPI parsing
- [ ] Endpoint-aware generation
- [ ] Request mutation

### 0.5 - Automation Integrations

- [ ] REST Assured
- [ ] JUnit 5
- [ ] TestNG

### 0.6 - CI/CD

- [ ] CLI
- [ ] JSON/YAML output
- [ ] GitHub Action
- [ ] CI-friendly exit codes

### 0.7 - Advanced QA Scenarios

- [ ] Business-rule mutation
- [ ] State-transition testing
- [ ] Workflow mutation
- [ ] Concurrency scenarios

## Example

The eventual user experience should look something like:

```bash
qa-edgecase integer --min 18 --max 100
```

Output:

```text
QA EdgeCase Generator

INTEGER EDGE CASES
----------------------------------------

17           BOUNDARY        minimum - 1
18           BOUNDARY        minimum
19           BOUNDARY        minimum + 1
99           BOUNDARY        maximum - 1
100          BOUNDARY        maximum
101          BOUNDARY        maximum + 1
0            INVALID         zero is below the configured minimum
-1           INVALID         -1 is below the configured minimum
```

Another example:

```bash
qa-edgecase string
```

Output:

```text
QA EdgeCase Generator

STRING EDGE CASES
----------------------------------------

[EMPTY]
Value: ""
Why:   Empty string

[WHITESPACE]
Value: " "
Why:   Single whitespace character

[WHITESPACE]
Value: "\t"
Why:   Tab character

[WHITESPACE]
Value: "\n"
Why:   Newline character

[UNICODE]
Value: "😀"
Why:   Emoji input

[UNICODE]
Value: "हिन्दी"
Why:   Devanagari input

[UNICODE]
Value: "ગુજરાતી"
Why:   Gujarati input
```

## Explainability

Every generated edge case should have a reason.

Bad:

```text
101
```

Good:

```text
Value:      101
Category:   BOUNDARY
Reason:     maximum + 1
Constraint: maximum = 100
```

This allows QA engineers to understand the purpose of the generated value instead of treating it as unexplained random data.

## Deterministic by Default

The initial version should produce deterministic results.

Running:

```bash
qa-edgecase integer --min 18 --max 100
```

multiple times should produce the same edge cases.

Randomized generation may be introduced later, but it must support a seed so that generated cases can be reproduced.

Example:

```bash
qa-edgecase integer \
    --min 18 \
    --max 100 \
    --random \
    --seed 12345
```

## Future JSON Mutation

Given:

```json
{
  "name": "Test User",
  "age": 30,
  "email": "test@example.com"
}
```

future versions may generate mutations such as:

### Null Mutation

```json
{
  "name": null,
  "age": 30,
  "email": "test@example.com"
}
```

### Empty Mutation

```json
{
  "name": "",
  "age": 30,
  "email": ""
}
```

### Missing Field

```json
{
  "name": "Test User",
  "age": 30
}
```

### Additional Field

```json
{
  "name": "Test User",
  "age": 30,
  "email": "test@example.com",
  "unexpectedField": "value"
}
```

### Type Mutation

```json
{
  "name": 123,
  "age": "thirty",
  "email": true
}
```

## Future OpenAPI Support

A future version should support:

```bash
qa-edgecase openapi openapi.yaml
```

The tool should analyze:

- Endpoints
- Parameters
- Request bodies
- Data types
- Required fields
- Minimum and maximum values
- String lengths
- Formats
- Patterns
- Enumerations

For example:

```yaml
age:
  type: integer
  minimum: 18
  maximum: 100
```

could produce:

```text
17  -> minimum - 1
18  -> minimum
19  -> minimum + 1

99  -> maximum - 1
100 -> maximum
101 -> maximum + 1
```

## Future REST Assured Integration

The core library should eventually work with REST Assured without making REST Assured a dependency of the core module.

Example target usage:

```java
List<EdgeCase<Integer>> cases =
        EdgeCases.forInteger()
                .minimum(18)
                .maximum(100)
                .generate();

for (EdgeCase<Integer> edgeCase : cases) {

    given()
        .body(Map.of("age", edgeCase.value()))
    .when()
        .post("/users")
    .then()
        .statusCode(400);
}
```

## Future JUnit 5 Integration

Generated edge cases should eventually work naturally with JUnit 5 parameterized tests.

Example:

```java
@ParameterizedTest
@MethodSource("edgeCases")
void shouldValidateAge(EdgeCase<Integer> edgeCase) {
    // test
}
```

## Future TestNG Integration

The same edge cases should eventually be usable with TestNG data providers.

Example:

```java
@DataProvider
public Object[][] edgeCases() {
    return EdgeCases.forInteger()
            .minimum(18)
            .maximum(100)
            .generate()
            .stream()
            .map(edgeCase -> new Object[]{edgeCase})
            .toArray(Object[][]::new);
}
```

## Future Business-Rule Testing

Eventually the project should support relationships between fields.

Example:

```yaml
rules:
  - field: checkOut
    mustBeAfter: checkIn

  - field: quantity
    maximum: availableStock

  - field: discount
    maximum: orderTotal
```

Possible generated scenarios:

```text
checkOut < checkIn
checkOut == checkIn
quantity > availableStock
discount > orderTotal
```

These are semantic edge cases rather than simple format or type checks.

## Future Workflow Mutation

The project may eventually generate edge cases involving workflow and application state.

For example:

```text
Login
  ↓
Search
  ↓
Select product
  ↓
Checkout
  ↓
Payment
```

Potential scenarios:

```text
Checkout without login
Payment twice
Checkout after session expiry
Checkout after product removal
Two users attempting the same limited-stock operation
```

## Future Localization Support

Localization and Unicode testing will be an important area of the project.

Potential supported data:

```text
Hindi
Gujarati
Arabic
Chinese
Japanese
German
French
Emoji
Combining characters
Right-to-left text
Long translated text
Mixed scripts
```

Example:

```bash
qa-edgecase string --locale hi
qa-edgecase string --locale gu
qa-edgecase string --locale ar
```

Future UI integrations may help identify issues such as:

```text
Text overflow
Unexpected truncation
Encoding problems
RTL layout problems
Unicode normalization issues
```

## Design Principles

### 1. Explainability

Every generated case should have a reason.

### 2. Determinism

The same configuration should produce reproducible results.

### 3. Framework Independence

The core library should not depend on Selenium, REST Assured, JUnit, TestNG, or any other specific testing framework.

### 4. Extensibility

New edge-case strategies should be easy to add without modifying unrelated code.

### 5. Simplicity

Avoid unnecessary frameworks and abstractions.

### 6. Testability

Every important behavior should have automated tests.

### 7. QA First

Features should solve a real QA problem rather than exist simply to demonstrate a technical concept.

## Development Approach

Implementation will progressively introduce and reinforce:

```text
Classes and Objects
Interfaces
Generics
Enums
Collections
Exceptions
Records
Streams
Lambdas
Composition
SOLID Principles
Design Patterns
JUnit 5
Maven
API Design
CLI Design
```

## Contributing

Before adding a new generator or strategy, ask:

1. What QA problem does it solve?
2. What assumption does it challenge?
3. Why is the generated case interesting?
4. Can the reason be explained?
5. Can the behavior be tested deterministically?

Contributions should include appropriate tests and documentation.

## License

This project is licensed under the MIT License.