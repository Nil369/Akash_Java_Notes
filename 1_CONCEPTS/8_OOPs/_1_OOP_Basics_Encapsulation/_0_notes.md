# OOP Basics
- Object-Oriented Programming (OOP) tries to **map code instructions with real-world**, making the code short and easier to understand.
  
- With the help of OOPs, we try to **implement real-world entities such as object, inheritance, abstraction**, etc.
  
- OOPs helps us to follow the `DRY(Don't Repeat Yourself)` approach of programming, which in turn increases the ***reusability of the code***.

<br>

## 1. What are Classes & Objects ??
1.  ***`Class`***: 
- Templates/Blueprint for creating Objects.
- Classes do not consume any space in the memory.
- Objects inherit methods and variables from the class.
- It is a logical component.
  
    <img src="https://cwh-full-next-space.fra1.digitaloceanspaces.com/videos/java-tutorials-for-beginners-36/Oops1.png"  style="width:500px;border-radius:20px" alt="class_img">

<br>

2. ***`Objects`***: 
- These are **instances of Classes**. It means they are entities made from the class.
- Every object has some address, and it occupies some space in the memory.
- It is a physical entity.

    <img src="https://cwh-full-next-space.fra1.digitaloceanspaces.com/videos/java-tutorials-for-beginners-36/Oops2.jfif" style="width:500px; border-radius:30px"  alt="obj_img">

### ***`How to model a problem in OOPs???`***

**We identify the following:**

| Object Oriented Programming Concept | Description                                                        | Example                      |
| ----------------------------------- | ------------------------------------------------------------------ | ---------------------------- |
| **Noun**                            | Represents a class, which is a blueprint for creating objects.     | `Employee`                   |
| **Adjective**                       | Represents the attributes or characteristics of a class or object. | `name`, `age`, `salary`      |
| **Verb**                            | Represents the methods or actions that an object can perform.      | `getSalary()`, `increment()` |

---
<br><br><br>


## 2. Four Pillars of OOP:

1. ***`Abstraction`*** :
- Let's suppose you want to turn on the bulb in your room. What do you do to switch on the bulb. You simply press the button and the light bulb turns on. Right? Notice that here you're only concerned with your final result, i.e., turning on the light bulb. You do not care about the circuit of the bulb or how current flows through the bulb. **The point here is that you press the switch, the bulb turns on! You don't know how the bulb turned on/how the circuit is made because all these details are hidden from you. This phenomenon is known as `abstraction`**. 
  
- More formally, data abstraction is the way through which only the essential info is shown to the user, and all the internal details remain hidden from the user.
- Example:\
    <img src="https://cwh-full-next-space.fra1.digitaloceanspaces.com/videos/java-tutorials-for-beginners-37/base64.webp" style="width:500px; border-radius:30px"  alt="abstraction_img">

<br>

2. ***`Polymorphism`*** :
- It basically means ***One entity many forms***.
  
- The word polymorphism comprises of  two words, *poly* which means *many*, and *morph*, which means *forms*.

- In OOPs, polymorphism is the property that helps to perform a  single task in different ways.

- Let's take another example, a smartphone can work like a camera as well as like a calculator. So, you can see the a smartphone is an entity having different forms. Also :
- Example:\
    <img src="https://cwh-full-next-space.fra1.digitaloceanspaces.com/videos/java-tutorials-for-beginners-37/base64_jra6bvf.webp" style="width:500px; border-radius:30px"  alt="poly_img">
<br>

3. ***`Encapsulation`*** :
- The act of putting various components together (in a capsule).

- In java, the variables and methods are the components that are wrapped inside a single unit named class.

- All the methods and variables of a class remain hidden from any other class.

- A automatic cold drink vending machine is an example of encapsulation.

- Cold drinks inside the machine are data that is wrapped inside a single unit cold drink vending machine.

<br>

4. ***`Inheritance`*** :
- The act of **deriving new things from existing things**.
- In Java, one class can acquire all the properties and behaviours of other some other class
  
- The class which inherits some other class is known as child class or sub class.
  
- The class which is inherited is known as parent class or super class.
- Inheritance helps us to write more efficient code because it increases the reusablity of the code.
  
- Example :
   
    Rickshaw      →        E-Rickshaw\
    Phone        →        Smart Phone

<br>

### 3. Constructors & Access Modifiers

1. ***`Constructors`***:
- Constructors are similar to methods,, but they are used to initialize an object.
- Constructors do not have any return type(not even void).
- Every time we create an object by using the new() keyword, a constructor is called.
- If we do not create a constructor by ourself, then the default constructor(created by Java compiler) is called.
  
    **Rules for creating a Constructor:**
    - The class name and constructor name should be the same.
    - It must have no explicit return type.
    - It can not be abstract, static, final, and synchronized.
  
    **Types of Constructors:**
    - Default Constructor:
        ```java
        class Demo {
            Demo(){
                System.out.println("This is the default constructor of Demo class.");
            }
        }
        public class _constructors {
            public static void main(String[] args) {
                CWH obj1 = new Demo();
            }
        }

        //Output: This is the default constructor of Demo class.
        ```
    - Parameterized constructor:
        ```java
        class Example {
            Example(String s, int b){
                System.out.println("This is the " +b+ "nd example of "+ " "+ s);
            }

        }

        public class _constructors1 {
            public static void main(String[] args) {
                CWH obj1 = new Example("OOPs Notes",2);

            }
        }
        // Output: This is the 2nd example of  OOPs Notes
        ```


1. ***`Access Modifiers`***:
Access Modifiers specify where a property/method is accessible. There are four types of access modifiers in java :

* private
* default
* protected
* public

| Access Modifier | within class | within package | outside package by subclass only | outside package |
| --------------- | ------------ | -------------- | -------------------------------- | --------------- |
| public          | Y            | Y              | Y                                | Y               |
| protected       | Y            | Y              | Y                                | N               |
| default         | Y            | Y              | N                                | N               |
| private         | Y            | N              | N                                | N               |

From the above table, notice that the private access modifier can only be accessed within the class. So, let's try to access private modifiers outside the class :

```java
class Employee {

    private int id;
    private  String name;
}

public  class Demo {
    public static void main(String[] args) {
        Employee emp1 = new Employee();
        emp1.id = 3; // This line will cause an error because id is private
        emp1.name = "Luffy";

    }
}