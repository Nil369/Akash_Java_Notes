# Exception Handling

## Errors & Exceptions:
No matter how smart we are, errors are our constant comparisons.
With practice, we keep getting better at finding & correcting them.

There are three types of errors in java:
> 1) Syntax errors
> 2) Logical errors
> 3) Runtime errors

🔸`Syntax Error`:\
When the compiler finds something wrong with our program(ex. maybe a semicolon is mising / we have used duplicated classes/ we have note declared variables), it throws a syntax error

```java
int   a = 9  // No semicolon, syntax errors!
a =   a + 3;
d = 4; // Variable not declared, syntax errors
```

🔸`Logical Error`:\
A logical error or a bug occurs when a program compiles and run correctly but does the wrong thing.

- Message delivered wrongly
- Wrong time of chats being displayed
- Incorrect redirects!
  
🔸`Runtime Error`:
- Java may sometimes encounter an error while the program is running.
- These are also called Exceptions!
- These are encountered due to circumstances like bad input and (or) resource constraints.

    Ex: User supplies 'S' + 8 to a program that adds 2 numbers.

> ***Syntax errors and logical errors are encountered by the programmers, whereas Run-time errors are encountered by the users.***



---
### 1. **Basics of Exception Handling**
#### **Explanation**:
- **Exception**: An event that disrupts the normal flow of a program.
- **Exception Handling**: Mechanism to handle runtime errors gracefully, ensuring the program continues running or fails gracefully.
- Java uses a **try-catch** mechanism to handle exceptions.

#### **Key Points**:
- Exceptions are objects of classes derived from `java.lang.Throwable`.
- Two types of exceptions:
  1. **Checked Exceptions**: Checked at compile time (e.g., `IOException`, `SQLException`).
  2. **Unchecked Exceptions**: Occur at runtime (e.g., `NullPointerException`, `ArithmeticException`).

#### **Example**:
```java
public class ExceptionExample {
    public static void main(String[] args) {
        try {
            int result = 10 / 0; // This causes ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero!");
        }
    }
}
```

---

### 2. **Different Types of Exception Classes**
#### **Explanation**:
1. **Checked Exceptions**:
   - Must be handled using `try-catch` or declared using `throws`.
   - Examples: `IOException`, `SQLException`.

2. **Unchecked Exceptions**:
   - Occur during runtime and do not require handling at compile time.
   - Examples: `NullPointerException`, `ArrayIndexOutOfBoundsException`.

3. **Error**:
   - Serious problems that should not be caught or handled by the application.
   - Examples: `StackOverflowError`, `OutOfMemoryError`.

#### **Hierarchy**:
- `Throwable` (Base Class)
  - `Exception` (Recoverable issues)
    - Checked Exceptions
    - Unchecked Exceptions (Runtime)
  - `Error` (Serious system-level issues)

#### **Example**:
```java
import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptionExample {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("nonexistent.txt");
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }
}
```

---

### 3. **Use of `try` & `catch` Block**
#### **Explanation**:
- **try**: Code that may throw an exception is placed in the `try` block.
- **catch**: Handles exceptions that occur in the `try` block.

#### **Key Points**:
- You can have multiple `catch` blocks to handle different exceptions.
- A general `Exception` catch should always be last.

#### **Example**:
```java
public class TryCatchExample {
    public static void main(String[] args) {
        try {
            int[] arr = new int[5];
            System.out.println(arr[10]); // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of bounds!");
        } catch (Exception e) {
            System.out.println("General exception occurred!");
        }
    }
}
```

---

### 4. **`throw`, `throws`, and `finally`**
#### **`throw`**:
- Used to explicitly throw an exception.
- Typically used for user-defined exceptions.

#### **`throws`**:
- Used to declare exceptions that might be thrown by a method.
- Checked exceptions must be declared with `throws`.

#### **`finally`**:
- Block that always executes after the `try-catch`, regardless of whether an exception occurs or not.
- Commonly used to release resources (e.g., closing files or database connections).

#### **Example**:
```java
public class ThrowThrowsFinallyExample {
    // Throws declaration
    public static void checkAge(int age) throws IllegalArgumentException {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or above!");
        }
    }

    public static void main(String[] args) {
        try {
            checkAge(16); // Throws IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        } finally {
            System.out.println("Execution completed.");
        }
    }
}
```

---

### 5. **Creation of User-defined Exception Classes**
#### **Explanation**:
- Java allows developers to create their own exception classes by extending `Exception` or `RuntimeException`.

#### **Steps to Create**:
1. Create a class extending `Exception` (for checked) or `RuntimeException` (for unchecked).
2. Define a constructor to pass the exception message.

#### **Key Points**:
- Useful for custom error scenarios like validating user input or business logic.

#### **Example**:
```java
// User-defined exception class
class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String message) {
        super(message);
    }
}

public class UserDefinedExceptionExample {
    public static void validateSalary(double salary) throws InvalidSalaryException {
        if (salary < 3000) {
            throw new InvalidSalaryException("Salary must be at least 3000!");
        }
    }

    public static void main(String[] args) {
        try {
            validateSalary(2000); // Throws InvalidSalaryException
        } catch (InvalidSalaryException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}
```

---

### 6. **Common Exceptions and Use Cases**
#### **Key Examples**:
1. **ArithmeticException**: Dividing by zero.
2. **NullPointerException**: Accessing a null object.
3. **IOException**: File not found.
4. **ClassNotFoundException**: Trying to load a non-existent class.
5. **NumberFormatException**: Invalid conversion from string to number.

---

### Summary Table:

| **Concept**                  | **Key Explanation**                                                                                              |
|------------------------------|------------------------------------------------------------------------------------------------------------------|
| **Exception**                | Disrupts normal program flow.                                                                                    |
| **Checked Exception**        | Compile-time exceptions (e.g., IOException).                                                                    |
| **Unchecked Exception**      | Runtime exceptions (e.g., ArithmeticException).                                                                 |
| **try-catch**                | Handles exceptions; `try` contains risky code, and `catch` handles specific exceptions.                          |
| **throw**                    | Used to explicitly throw exceptions.                                                                             |
| **throws**                   | Declares that a method may throw specific exceptions.                                                            |
| **finally**                  | Always executes, typically used for cleanup.                                                                    |
| **User-defined Exceptions**  | Custom exceptions created by extending `Exception` or `RuntimeException`.                                        |

