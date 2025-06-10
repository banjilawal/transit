
# Package: `com.lawal.transitcraft.infrastructure.avenue.exception`

---
## Purpose
Exceptions unique to classes/components in package: `com.lawal.transitcraft.infrastructure.avenue`.

---
## Contents
- **Exceptions** thrown by:
    - `Avenue`
    - `AvenueService`
    - `AvenueRepo`

---
## Package Structure
```
com.lawal.transitcraft.infrastructure.avenue.exception/
├── AvenueServiceDeleteOperationFailedException.java
├── AvenueSetCurbOperationFailedException.java
└── ... other exception classes
```

---
## Dependencies
- Nested inside `avenue` package. Should have access to classes and components in `avenue`.
- `com.lawal.transitcraft.infrastructure.road.*`

---
## Usage Guidelines

### Best Practices
1. Minimize the number of exceptions.
2. Conditions that throw an exception should be unique to:
    - classes/components
    - methods
    - fields
      inside package `com.lawal.transitcraft.infrastructure.avenue`.
3. An exception should have a concise, default `MESSAGE` field that is
    - `public`
    - `static`
    - `final`
4. Exception names should:
    - Indicate the class which threw the exception
    - The condition/operation that caused the exception

### Code Examples
#### Defining an Exception
```java
public class AvenueServiceDeleteOperationFailedException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "Avenue is null";

    public AvenueServiceDeleteOperationFailedException(String message) {
        super(message);
    }
}
```

#### Using an Exception with its Default Message
```java
if (curb.getAvenue() == null) {
    throw new AvenueSetCurbOperationFailedException(AvenueSetCurbOperationFailedException.MESSAGE);
}
```