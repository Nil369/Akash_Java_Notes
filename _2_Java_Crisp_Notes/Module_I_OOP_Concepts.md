# Module I: Object Oriented Concepts

## Difference between OOP and Other Conventional Programming

| Feature | Object-Oriented Programming | Conventional Programming (Procedural) |
|---------|----------------------------|--------------------------------------|
| **Focus** | Data and objects | Functions and procedures |
| **Organization** | Classes and objects | Top-down approach with functions |
| **Data Security** | Encapsulation provides data hiding | Limited data security |
| **Code Reusability** | High via inheritance | Limited, mainly through functions |
| **Modularity** | High (objects are self-contained) | Medium to low |
| **Complexity** | Can handle complex real-world problems | Better for simpler, linear tasks |
| **Maintenance** | Easier to maintain and extend | More difficult to maintain as size grows |
| **Examples** | Java, C++, Python, C# | C, FORTRAN, Pascal |

### Advantages of OOP:
1. **Reusability**: Code can be reused through inheritance
2. **Modularity**: Programs are divided into objects
3. **Maintainability**: Easier to modify without affecting other parts
4. **Security**: Encapsulation protects data from direct access
5. **Real-world modeling**: Closely resembles real-world entities
6. **Extensibility**: Easy to add new features

### Disadvantages of OOP:
1. **Performance overhead**: More resource-intensive
2. **Larger program size**: Can require more memory
3. **Steep learning curve**: More complex conceptually
4. **Not suitable for all problems**: Some problems are better solved procedurally
5. **Development time**: May take longer to design properly

## Core OOP Concepts

### 1. Class
- A blueprint or template that defines the properties and behaviors for objects
- Contains data (fields/attributes) and functions (methods)
- Serves as a user-defined data type

```java
class Student {
    // Fields/Attributes
    String name;
    int rollNumber;
    
    // Methods/Behaviors
    void attendClass() {
        System.out.println(name + " is attending class");
    }
    
    void submitAssignment() {
        System.out.println(name + " is submitting assignment");
    }
}
```

### 2. Object
- An instance of a class
- Has state (attributes) and behavior (methods)
- Occupies memory space when created

```java
// Creating objects of Student class
Student student1 = new Student();
student1.name = "John";
student1.rollNumber = 101;

Student student2 = new Student();
student2.name = "Alice";
student2.rollNumber = 102;
```

### 3. Message Passing
- Objects communicate by sending messages to each other
- Messages are implemented as method calls in Java
- Allows objects to request services from other objects

```java
class Teacher {
    void askQuestion(Student student) {
        System.out.println("Teacher asks a question");
        student.answerQuestion();  // Message passing
    }
}

class Student {
    void answerQuestion() {
        System.out.println("Student answers the question");
    }
}
```

### 4. Inheritance
- Mechanism where a new class derives properties from an existing class
- Promotes code reuse and establishes "is-a" relationship
- Types: Single, Multilevel, Hierarchical, Multiple (through interfaces in Java)

```java
// Parent class
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

// Child class inheriting from Animal
class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

// Usage
Dog dog = new Dog();
dog.eat();  // Inherited method
dog.bark(); // Own method
```

### 5. Encapsulation
- Bundling of data and methods that operate on the data within a single unit (class)
- Hiding internal state and requiring interaction through methods
- Implemented using access modifiers (private, protected, public)

```java
class BankAccount {
    // Private data (encapsulated)
    private double balance;
    
    // Public methods to access the data
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    
    public double getBalance() {
        return balance;
    }
}
```

### 6. Polymorphism
- Ability of an object to take many forms
- Types: Compile-time (method overloading) and Runtime (method overriding)
- Enables flexibility and extensibility

```java
// Method Overloading (Compile-time polymorphism)
class Calculator {
    int add(int a, int b) {
        return a + b;
    }
    
    double add(double a, double b) {
        return a + b;
    }
}

// Method Overriding (Runtime polymorphism)
class Shape {
    void draw() {
        System.out.println("Drawing shape");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing circle");
    }
}
``` 