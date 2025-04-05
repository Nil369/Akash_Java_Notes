# Module III: Reusability Properties

## Inheritance

### Super Class & Sub-Classes
- **Inheritance** is a mechanism where a new class (subclass) acquires properties of an existing class (superclass).
- Implemented using the `extends` keyword in Java.
- Promotes code reuse and establishes IS-A relationship between classes.

```java
// Superclass / Parent class / Base class
class Animal {
    String name;
    
    void eat() {
        System.out.println(name + " is eating");
    }
    
    void sleep() {
        System.out.println(name + " is sleeping");
    }
}

// Subclass / Child class / Derived class
class Dog extends Animal {
    void bark() {
        System.out.println(name + " is barking");
    }
}

// Another subclass
class Cat extends Animal {
    void meow() {
        System.out.println(name + " is meowing");
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.name = "Max";
        dog.eat();   // Inherited method
        dog.sleep(); // Inherited method
        dog.bark();  // Dog-specific method
        
        Cat cat = new Cat();
        cat.name = "Luna";
        cat.eat();   // Inherited method
        cat.sleep(); // Inherited method
        cat.meow();  // Cat-specific method
    }
}
```

### Multilevel Inheritance
- A class inherits from another class which itself inherits from another class.
- Forms a chain of inheritance.

```java
// Grandparent class
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

// Parent class
class Mammal extends Animal {
    void breathe() {
        System.out.println("Mammal is breathing");
    }
}

// Child class
class Dog extends Mammal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

public class MultilevelDemo {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();    // From Animal class
        dog.breathe(); // From Mammal class
        dog.bark();    // From Dog class
    }
}
```

### Process of Constructor Calling in Inheritance
- When a subclass object is created, the constructor of the superclass is called first, followed by the constructor of the subclass.
- If the superclass has a parameterized constructor and no default constructor, the subclass constructor must explicitly call the superclass constructor using `super()`.

```java
class Parent {
    Parent() {
        System.out.println("Parent constructor called");
    }
    
    Parent(String message) {
        System.out.println("Parent constructor called with: " + message);
    }
}

class Child extends Parent {
    Child() {
        // Implicitly calls super() (the default constructor of Parent)
        System.out.println("Child constructor called");
    }
    
    Child(String message) {
        super(message); // Explicitly call parameterized constructor of Parent
        System.out.println("Child constructor called with: " + message);
    }
}

public class ConstructorCallingDemo {
    public static void main(String[] args) {
        // Output: "Parent constructor called" followed by "Child constructor called"
        Child child1 = new Child();
        
        // Output: "Parent constructor called with: Hello" followed by "Child constructor called with: Hello"
        Child child2 = new Child("Hello");
    }
}
```

## Super and Final Keywords

### Super Keyword
- `super` refers to the superclass (parent) object.
- Used to:
  1. Call superclass methods
  2. Access superclass fields
  3. Call superclass constructor

```java
class Animal {
    String name = "Generic Animal";
    
    void makeSound() {
        System.out.println("Generic animal sound");
    }
}

class Dog extends Animal {
    String name = "Dog";
    
    void display() {
        System.out.println("Child name: " + name);          // Displays "Dog"
        System.out.println("Parent name: " + super.name);   // Displays "Generic Animal"
    }
    
    void makeSound() {
        super.makeSound();  // Calls the parent's method
        System.out.println("Woof woof");
    }
}
```

### Super() Method
- `super()` is used to call the constructor of the superclass.
- Must be the first statement in the subclass constructor.

```java
class Parent {
    Parent() {
        System.out.println("Parent constructor");
    }
    
    Parent(int value) {
        System.out.println("Parent constructor with value: " + value);
    }
}

class Child extends Parent {
    Child() {
        super(); // Calls default constructor of Parent (optional as it's implicit)
        System.out.println("Child constructor");
    }
    
    Child(int value) {
        super(value); // Calls parameterized constructor of Parent
        System.out.println("Child constructor with value: " + value);
    }
}
```

### Final Keyword
- `final` can be applied to variables, methods, and classes.

1. **final variable**: Cannot be changed after initialization (constant)
2. **final method**: Cannot be overridden by subclasses
3. **final class**: Cannot be extended (inherited)

```java
// Final variable
final double PI = 3.14159;

// Final method
class Parent {
    final void showMessage() {
        System.out.println("This method cannot be overridden");
    }
}

// Child class can't override showMessage
class Child extends Parent {
    // Error: Cannot override the final method from Parent
    // void showMessage() { ... }
}

// Final class
final class FinalClass {
    void display() {
        System.out.println("This is a final class");
    }
}

// Error: Cannot inherit from final class
// class AnotherClass extends FinalClass { ... }
```

## Dynamic Method Dispatch

- Runtime polymorphism achieved through method overriding.
- The determination of which overridden method to call is made at runtime rather than compile time.
- The reference variable of a superclass can be used to refer to an object of the subclass.

```java
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Cat meows");
    }
}

public class DynamicMethodDispatchDemo {
    public static void main(String[] args) {
        // Parent reference for Child objects
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();
        
        animal1.makeSound(); // Outputs: "Dog barks"
        animal2.makeSound(); // Outputs: "Cat meows"
        
        // Dynamic dispatch in action
        Animal[] animals = {new Animal(), new Dog(), new Cat()};
        for (Animal animal : animals) {
            animal.makeSound(); // The correct method is called based on the actual object type
        }
    }
}
```

## Abstract Classes & Methods

### Abstract Class
- A class that cannot be instantiated and may contain abstract methods.
- Used to declare common characteristics of subclasses.
- Created using the `abstract` keyword.
- Can contain both abstract and concrete (defined) methods.

### Abstract Method
- A method without a body (implementation).
- Must be implemented by non-abstract subclasses.
- Declared using the `abstract` keyword.

```java
abstract class Shape {
    // Abstract method (no implementation)
    abstract double calculateArea();
    
    // Concrete method (with implementation)
    void display() {
        System.out.println("This is a shape");
    }
}

class Circle extends Shape {
    double radius;
    
    Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double length, width;
    
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    double calculateArea() {
        return length * width;
    }
}

public class AbstractClassDemo {
    public static void main(String[] args) {
        // Shape shape = new Shape(); // Error: Cannot instantiate abstract class
        
        Shape circle = new Circle(5);
        System.out.println("Circle area: " + circle.calculateArea());
        
        Shape rectangle = new Rectangle(4, 5);
        System.out.println("Rectangle area: " + rectangle.calculateArea());
    }
}
```

## Interfaces

- A collection of abstract methods.
- Used to achieve full abstraction and multiple inheritance.
- All methods are implicitly `public` and `abstract`.
- All fields are implicitly `public`, `static`, and `final`.
- A class can implement multiple interfaces.

```java
interface Drawable {
    void draw(); // Implicitly public and abstract
    
    // Constant (implicitly public, static, final)
    String LABEL = "Drawable Object";
}

interface Resizable {
    void resize(int percent);
}

// Implementing a single interface
class Circle implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

// Implementing multiple interfaces
class Rectangle implements Drawable, Resizable {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
    
    @Override
    public void resize(int percent) {
        System.out.println("Resizing rectangle by " + percent + "%");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        Drawable circle = new Circle();
        circle.draw();
        
        Rectangle rectangle = new Rectangle();
        rectangle.draw();
        rectangle.resize(50);
        
        System.out.println(Drawable.LABEL); // Accessing interface constant
    }
}
```

### Default Methods in Interfaces (Java 8+)
- Methods with implementation in interfaces.
- Added to allow backward compatibility when evolving interfaces.
- Keyword `default` is used.

```java
interface Animal {
    void makeSound(); // Abstract method
    
    // Default method (with implementation)
    default void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
    
    // No need to implement eat() as it has a default implementation
}

class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }
    
    // Override the default method
    @Override
    public void eat() {
        System.out.println("Cat is eating fish");
    }
}
```

### Interface vs Abstract Class

| Feature | Interface | Abstract Class |
|---------|-----------|----------------|
| **Methods** | All methods are implicitly abstract (except default and static methods) | Can have both abstract and concrete methods |
| **Variables** | All variables are implicitly public, static, and final | Can have instance and static variables with any access modifier |
| **Constructor** | Cannot have constructors | Can have constructors |
| **Inheritance** | A class can implement multiple interfaces | A class can extend only one abstract class |
| **Access Modifiers** | All methods are implicitly public | Can have any access modifier |
| **Instantiation** | Cannot be instantiated | Cannot be instantiated |
| **Implementation** | Focuses on "what" a class does | Focuses on "what" and "how" a class does |

## Packages

### Creation of Packages
- Packages are used to group related classes, interfaces, and sub-packages.
- Helps in avoiding name conflicts and provides access control.
- Created using the `package` keyword at the top of the file.

```java
// File: com/example/math/Calculator.java
package com.example.math;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
}
```

### Importing Packages
- The `import` statement is used to access classes and interfaces from other packages.
- Can import a specific class or all classes in a package using the wildcard (`*`).

```java
// Importing a specific class
import java.util.ArrayList;

// Importing all classes from a package
import java.util.*;

// Static import for accessing static members directly
import static java.lang.Math.PI;

public class ImportExample {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        
        System.out.println(PI); // Using static import
    }
}
```

### Member Access for Packages
- Access to package members is controlled by access modifiers.

| Access Modifier | Same Class | Same Package | Subclass (different package) | Different Package |
|-----------------|------------|--------------|------------------------------|------------------|
| `public`        | Yes        | Yes          | Yes                          | Yes              |
| `protected`     | Yes        | Yes          | Yes                          | No               |
| `default` (no modifier) | Yes | Yes          | No                           | No               |
| `private`       | Yes        | No           | No                           | No               |

```java
// File: com/example/base/Base.java
package com.example.base;

public class Base {
    public int publicVar = 1;        // Accessible everywhere
    protected int protectedVar = 2;  // Accessible in same package and subclasses
    int defaultVar = 3;              // Accessible only in same package
    private int privateVar = 4;      // Accessible only in same class
    
    public void publicMethod() { }
    protected void protectedMethod() { }
    void defaultMethod() { }
    private void privateMethod() { }
}

// File: com/example/derived/Derived.java
package com.example.derived;

import com.example.base.Base;

public class Derived extends Base {
    void accessTest() {
        System.out.println(publicVar);      // OK
        System.out.println(protectedVar);   // OK (accessible in subclass)
        // System.out.println(defaultVar);   // Error: not accessible
        // System.out.println(privateVar);   // Error: not accessible
        
        publicMethod();      // OK
        protectedMethod();   // OK (accessible in subclass)
        // defaultMethod();   // Error: not accessible
        // privateMethod();   // Error: not accessible
    }
}

// File: com/example/other/Other.java
package com.example.other;

import com.example.base.Base;

public class Other {
    void accessTest() {
        Base base = new Base();
        
        System.out.println(base.publicVar);    // OK
        // System.out.println(base.protectedVar); // Error: not accessible
        // System.out.println(base.defaultVar);   // Error: not accessible
        // System.out.println(base.privateVar);   // Error: not accessible
        
        base.publicMethod();    // OK
        // base.protectedMethod(); // Error: not accessible
        // base.defaultMethod();   // Error: not accessible
        // base.privateMethod();   // Error: not accessible
    }
}
``` 