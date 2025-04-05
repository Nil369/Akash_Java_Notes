# Object-Oriented Programming in Java

Object-Oriented Programming (OOP) is a programming paradigm that uses "objects" to design applications and computer programs. It utilizes several techniques including inheritance, modularity, polymorphism, and encapsulation.

## Core OOP Concepts

### 1. Class and Object
- **Class**: A blueprint or template that defines the properties and behaviors that objects of its type will have.
- **Object**: An instance of a class that contains state (fields) and behavior (methods).

```java
// Class definition
public class Car {
    // Fields (state)
    String model;
    String color;
    int year;
    
    // Constructor
    public Car(String model, String color, int year) {
        this.model = model;
        this.color = color;
        this.year = year;
    }
    
    // Methods (behavior)
    public void start() {
        System.out.println(model + " is starting...");
    }
    
    public void drive() {
        System.out.println("Driving the " + color + " " + model);
    }
}

// Creating objects
Car myCar = new Car("Toyota Camry", "Blue", 2022);
myCar.start();  // Toyota Camry is starting...
myCar.drive();  // Driving the Blue Toyota Camry
```

### 2. Encapsulation
- Bundling data (fields) and methods that operate on the data within a single unit (class).
- Hiding internal state and requiring interaction through well-defined interfaces.
- Implemented using access modifiers (private, protected, public) and getter/setter methods.

```java
public class BankAccount {
    // Private fields (encapsulated data)
    private String accountNumber;
    private double balance;
    
    // Constructor
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    // Getter methods
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public double getBalance() {
        return balance;
    }
    
    // Methods that operate on the encapsulated data
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount");
        }
    }
}
```

### 3. Inheritance
- Mechanism where a new class (subclass/child) derives or inherits properties and behaviors from an existing class (superclass/parent).
- Enables code reuse and establishes "is-a" relationships between classes.
- Implemented using the `extends` keyword in Java.

```java
// Parent class (superclass)
public class Animal {
    protected String name;
    protected int age;
    
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void eat() {
        System.out.println(name + " is eating");
    }
    
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
}

// Child class (subclass)
public class Dog extends Animal {
    private String breed;
    
    public Dog(String name, int age, String breed) {
        super(name, age);  // Calling superclass constructor
        this.breed = breed;
    }
    
    public void bark() {
        System.out.println(name + " is barking");
    }
    
    // Method overriding
    @Override
    public void eat() {
        System.out.println(name + " the " + breed + " is eating dog food");
    }
}
```

### 4. Polymorphism
- Ability of an object to take many forms.
- Allows methods to do different things based on the object it is acting upon.
- Two types: Compile-time (method overloading) and Runtime (method overriding).

#### Compile-time Polymorphism (Method Overloading)
```java
public class Calculator {
    // Method overloading - same name, different parameters
    public int add(int a, int b) {
        return a + b;
    }
    
    public double add(double a, double b) {
        return a + b;
    }
    
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

#### Runtime Polymorphism (Method Overriding)
```java
// Parent class
public class Shape {
    public double calculateArea() {
        return 0.0;  // Default implementation
    }
}

// Child classes
public class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

public class Rectangle extends Shape {
    private double length;
    private double width;
    
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    public double calculateArea() {
        return length * width;
    }
}

// Using polymorphism
public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);
        
        System.out.println("Circle area: " + circle.calculateArea());
        System.out.println("Rectangle area: " + rectangle.calculateArea());
        
        // We can store different shapes in an array
        Shape[] shapes = {circle, rectangle, new Circle(3.0)};
        
        // And process them uniformly
        for (Shape shape : shapes) {
            System.out.println("Area: " + shape.calculateArea());
        }
    }
}
```

### 5. Abstraction
- Process of hiding implementation details and showing only functionality.
- Achieved through abstract classes and interfaces.
- Focuses on what an object does rather than how it does it.

#### Abstract Classes
```java
// Abstract class
public abstract class Vehicle {
    private String brand;
    
    public Vehicle(String brand) {
        this.brand = brand;
    }
    
    // Concrete method
    public void start() {
        System.out.println("Starting the " + brand);
    }
    
    // Abstract method (no implementation)
    public abstract void drive();
}

// Concrete subclass
public class Car extends Vehicle {
    public Car(String brand) {
        super(brand);
    }
    
    @Override
    public void drive() {
        System.out.println("Driving the car on the road");
    }
}
```

#### Interfaces
```java
// Interface
public interface Drawable {
    void draw();  // Abstract method
    
    // Default method (Java 8+)
    default void display() {
        System.out.println("Displaying the drawable");
    }
}

// Implementing the interface
public class Circle implements Drawable {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius " + radius);
    }
}
```

## Difference Between OOP and Procedural Programming

| Feature | Object-Oriented Programming | Procedural Programming |
|---------|----------------------------|------------------------|
| **Basic Unit** | Object (data + methods) | Function |
| **Data Access** | Restricted through encapsulation | Typically global, accessible by functions |
| **Focus** | Data and manipulation of data | Steps and procedures |
| **Approach** | Bottom-up | Top-down |
| **Data Security** | High (through encapsulation) | Low |
| **Code Reusability** | High (through inheritance) | Low |
| **Modification** | Easy to extend through inheritance | Difficult to modify existing code |
| **Real-world Modeling** | Easy (objects reflect real-world entities) | Difficult (focuses on procedures) |
| **Example Languages** | Java, C++, Python | C, FORTRAN, Pascal |

## Advantages of OOP

1. **Modularity**: Code is divided into self-contained objects, making development and maintenance easier.
2. **Reusability**: Through inheritance and composition, code can be reused across different parts of an application or in different applications.
3. **Flexibility and Extensibility**: Objects can be modified independently and new features can be added without changing existing code.
4. **Data Security**: Encapsulation provides control over access to data and prevents unintended modifications.
5. **Modeling Real-world Entities**: Objects closely resemble real-world entities, making the design of complex systems more intuitive.
6. **Maintainability**: OOP code is generally easier to understand and maintain.
7. **Troubleshooting**: Objects are self-contained, making it easier to isolate and fix issues.

## Disadvantages of OOP

1. **Learning Curve**: OOP concepts can be more complex to learn and implement for beginners.
2. **Size**: OOP programs may require more code and memory compared to procedural programs.
3. **Performance**: The abstraction and indirection in OOP can lead to slower execution in certain scenarios.
4. **Design Complexity**: Designing a good object model requires careful planning and can be challenging.
5. **Not Suitable for All Problems**: Some problems are better solved using procedural or functional approaches.

## Message Passing in OOP

Message passing is a fundamental concept in OOP where objects communicate with each other by sending and receiving messages. In Java, this is implemented through method calls.

```java
public class MessageSender {
    public void sendMessage(MessageReceiver receiver, String message) {
        System.out.println("Sending message: " + message);
        receiver.receiveMessage(message);  // Message passing
    }
}

public class MessageReceiver {
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
        // Process the message
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        MessageSender sender = new MessageSender();
        MessageReceiver receiver = new MessageReceiver();
        
        sender.sendMessage(receiver, "Hello, OOP World!");
    }
}
```

In this example, the `sender` object passes a message to the `receiver` object by calling its `receiveMessage` method. This is a form of communication between objects, demonstrating message passing in OOP.

## Constructors and Object Creation

Constructors are special methods that initialize objects when they are created. They have the same name as the class and do not have a return type.

### Types of Constructors

1. **Default Constructor**: No parameters, provides default values.
2. **Parameterized Constructor**: Accepts parameters to initialize object with specific values.
3. **Copy Constructor**: Creates a new object as a copy of an existing object.

```java
public class Student {
    private String name;
    private int age;
    
    // Default constructor
    public Student() {
        name = "Unknown";
        age = 0;
    }
    
    // Parameterized constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Copy constructor
    public Student(Student other) {
        this.name = other.name;
        this.age = other.age;
    }
    
    // Getters and setters
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
}
```

### Constructor Chaining

Constructor chaining is the process of calling one constructor from another constructor. This is done using the `this()` keyword.

```java
public class Employee {
    private String name;
    private int id;
    private String department;
    
    // Primary constructor
    public Employee(String name, int id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }
    
    // Calls the primary constructor with a default department
    public Employee(String name, int id) {
        this(name, id, "General");
    }
    
    // Calls the second constructor with a default id
    public Employee(String name) {
        this(name, 0);
    }
}
```

## The `this` Keyword

The `this` keyword refers to the current object instance. It is used to:

1. **Differentiate between instance variables and parameters with the same name**.
2. **Call another constructor in the same class**.
3. **Return the current object from a method**.
4. **Pass the current object as a parameter to another method**.

```java
public class Rectangle {
    private double length;
    private double width;
    
    // Using 'this' to refer to instance variables
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    // Using 'this' to call another constructor
    public Rectangle(double side) {
        this(side, side);  // Creates a square
    }
    
    // Using 'this' to return the current object
    public Rectangle setLength(double length) {
        this.length = length;
        return this;  // Method chaining
    }
    
    public Rectangle setWidth(double width) {
        this.width = width;
        return this;  // Method chaining
    }
    
    // Using 'this' as a parameter
    public void compareWith(Rectangle other) {
        if (this.calculateArea() > other.calculateArea()) {
            System.out.println("This rectangle is larger");
        } else {
            System.out.println("The other rectangle is larger or equal");
        }
    }
    
    public double calculateArea() {
        return length * width;
    }
}

// Method chaining example
Rectangle rect = new Rectangle(2, 3);
rect.setLength(5).setWidth(4);  // Chain method calls
```

## Static Members

Static members belong to the class rather than instances of the class. They are shared among all instances of the class.

### Static Variables

```java
public class Counter {
    // Static variable shared by all instances
    private static int count = 0;
    
    // Instance variable unique to each instance
    private int id;
    
    public Counter() {
        count++;
        id = count;
    }
    
    public int getId() {
        return id;
    }
    
    public static int getCount() {
        return count;
    }
}

// Usage
Counter c1 = new Counter();  // id=1, count=1
Counter c2 = new Counter();  // id=2, count=2
Counter c3 = new Counter();  // id=3, count=3

System.out.println("Count: " + Counter.getCount());  // Output: Count: 3
```

### Static Methods

```java
public class MathUtil {
    // Static method - can be called without creating an instance
    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }
    
    // Static method that uses a static variable
    private static double PI = 3.14159;
    
    public static double calculateCircleArea(double radius) {
        return PI * radius * radius;
    }
}

// Usage
int maximum = MathUtil.max(10, 15);  // Call without creating an instance
double area = MathUtil.calculateCircleArea(5.0);
```

## Nested and Inner Classes

Java allows classes to be defined within other classes, creating a hierarchical structure.

### Types of Nested Classes

1. **Static Nested Class**: A static class defined within another class.
2. **Non-static Nested Class (Inner Class)**: A non-static class defined within another class.
3. **Local Inner Class**: A class defined within a method.
4. **Anonymous Inner Class**: A class defined without a name, often used for creating instances on the fly.

```java
public class OuterClass {
    private int outerField = 10;
    private static int staticOuterField = 20;
    
    // Static nested class
    public static class StaticNestedClass {
        public void display() {
            // Cannot access non-static members of the outer class
            System.out.println("Static field: " + staticOuterField);
        }
    }
    
    // Inner class (non-static)
    public class InnerClass {
        private int innerField = 30;
        
        public void display() {
            // Can access both static and non-static members of the outer class
            System.out.println("Outer field: " + outerField);
            System.out.println("Static outer field: " + staticOuterField);
            System.out.println("Inner field: " + innerField);
        }
    }
    
    // Method with local inner class
    public void displayLocal() {
        int localVariable = 40;  // Effectively final (Java 8+)
        
        // Local inner class
        class LocalInnerClass {
            public void display() {
                System.out.println("Outer field: " + outerField);
                System.out.println("Local variable: " + localVariable);
            }
        }
        
        LocalInnerClass local = new LocalInnerClass();
        local.display();
    }
    
    // Method demonstrating anonymous inner class
    public void displayAnonymous() {
        // Anonymous inner class implementing an interface
        Runnable runner = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running in anonymous class");
                System.out.println("Outer field: " + outerField);
            }
        };
        
        runner.run();
    }
}

// Usage
OuterClass.StaticNestedClass staticNested = new OuterClass.StaticNestedClass();
staticNested.display();

OuterClass outer = new OuterClass();
OuterClass.InnerClass inner = outer.new InnerClass();
inner.display();

outer.displayLocal();
outer.displayAnonymous();
```

## Garbage Collection and Memory Management

Java's garbage collector automatically reclaims memory occupied by objects that are no longer reachable (referenced).

### Garbage Collection Process

1. **Mark**: Identify and mark all objects that are still reachable from GC roots.
2. **Sweep**: Remove unmarked objects (garbage).
3. **Compact**: Rearrange memory to eliminate fragmentation (some GC algorithms).

### The `finalize()` Method

The `finalize()` method is called by the garbage collector before reclaiming an object's memory. It can be overridden to perform cleanup operations, but its use is discouraged in modern Java (it's deprecated in Java 9+).

```java
public class ResourceHolder {
    private Resource resource;
    
    public ResourceHolder() {
        resource = new Resource();
    }
    
    @Override
    protected void finalize() throws Throwable {
        try {
            if (resource != null) {
                resource.close();  // Clean up resources
                System.out.println("Resource closed in finalize()");
            }
        } finally {
            super.finalize();  // Always call superclass finalize
        }
    }
    
    // Better approach: use try-with-resources or explicit close methods
    public void close() {
        if (resource != null) {
            resource.close();
            resource = null;
        }
    }
}
```

### Triggering Garbage Collection

The garbage collection process is automatically managed by the JVM, but it can be suggested (not guaranteed) using `System.gc()`.

```java
public class Main {
    public static void main(String[] args) {
        ResourceHolder holder = new ResourceHolder();
        holder = null;  // Object becomes eligible for garbage collection
        
        System.gc();  // Suggest garbage collection
        System.runFinalization();  // Suggest running finalization of eligible objects
        
        // But there's no guarantee these objects will be cleaned up immediately
    }
}
```

## Access Modifiers

Access modifiers control the visibility and accessibility of classes, methods, and fields.

| Modifier | Class | Package | Subclass | World |
|----------|-------|---------|----------|-------|
| public | Yes | Yes | Yes | Yes |
| protected | Yes | Yes | Yes | No |
| default (no modifier) | Yes | Yes | No | No |
| private | Yes | No | No | No |

```java
public class AccessModifiersDemo {
    public int publicField = 1;        // Accessible everywhere
    protected int protectedField = 2;  // Accessible in same package and subclasses
    int defaultField = 3;              // Accessible only in same package
    private int privateField = 4;      // Accessible only in this class
    
    public void publicMethod() {
        // Accessible everywhere
        System.out.println("Public method");
    }
    
    protected void protectedMethod() {
        // Accessible in same package and subclasses
        System.out.println("Protected method");
    }
    
    void defaultMethod() {
        // Accessible only in same package
        System.out.println("Default method");
    }
    
    private void privateMethod() {
        // Accessible only in this class
        System.out.println("Private method");
    }
}
``` 