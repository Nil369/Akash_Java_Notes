# Module IV: Exception Handling & Multithreading

## Exception Handling

### Basics of Exception Handling
- An **exception** is an event that disrupts the normal flow of program execution.
- **Exception handling** is a mechanism to handle runtime errors gracefully.
- Java provides a robust exception handling framework through the `try`, `catch`, `throw`, `throws`, and `finally` keywords.

#### Why Exception Handling?
1. **Separates Error-Handling Code**: Keeps error handling separate from regular code logic
2. **Propagates Errors Up the Call Stack**: Allows errors to be handled at appropriate levels
3. **Groups and Differentiates Error Types**: Categorizes different types of errors
4. **Prevents Program Termination**: Handles errors gracefully without crashing

### Different Types of Exception Classes

#### Hierarchy of Exception Classes
- **Throwable**: Root class for all errors and exceptions
  - **Error**: Represents serious problems that an application should not try to catch (e.g., `OutOfMemoryError`)
  - **Exception**: Represents exceptional conditions that can be caught and handled
    - **RuntimeException**: Exceptions that occur during runtime (e.g., `NullPointerException`, `ArithmeticException`)
    - **Other Exceptions**: Checked exceptions that must be caught or declared (e.g., `IOException`, `SQLException`)

```
                          ┌───────────┐
                          │ Throwable │
                          └─────┬─────┘
                   ┌─────────────┴───────────┐
                   ▼                         ▼
             ┌───────────┐             ┌───────────┐
             │   Error   │             │ Exception │
             └───────────┘             └─────┬─────┘
                                 ┌───────────┴───────────┐
                                 ▼                       ▼
                     ┌─────────────────────┐      ┌──────────────────┐
                     │  RuntimeException   │      │ Checked Exception│
                     └─────────────────────┘      └──────────────────┘
```

#### Common Exceptions
1. **Checked Exceptions** (Must be caught or declared):
   - `IOException`: Input/output operations
   - `SQLException`: Database access
   - `ClassNotFoundException`: When a class is not found
   - `InterruptedException`: Thread interruption

2. **Unchecked Exceptions** (Runtime Exceptions):
   - `ArithmeticException`: Division by zero
   - `NullPointerException`: Accessing null object's methods/fields
   - `ArrayIndexOutOfBoundsException`: Accessing invalid array index
   - `IllegalArgumentException`: Invalid argument passed to a method
   - `NumberFormatException`: Invalid string conversion to number

### Try & Catch Block

The basic structure for exception handling includes:
1. **try**: Contains code that might throw an exception
2. **catch**: Handles the exception if it occurs
3. **finally**: Executes regardless of whether an exception occurs

```java
try {
    // Code that may throw an exception
    int result = 10 / 0; // This will throw ArithmeticException
    System.out.println("Result: " + result); // This won't be executed
} catch (ArithmeticException e) {
    // Handle the exception
    System.out.println("Error: Division by zero");
    System.out.println("Exception: " + e.getMessage());
} finally {
    // This block always executes
    System.out.println("Finally block executed");
}

// Code continues here
System.out.println("Program continues after exception handling");
```

#### Multiple catch blocks
```java
try {
    int[] arr = new int[5];
    arr[10] = 50; // ArrayIndexOutOfBoundsException
    int result = 10 / 0; // ArithmeticException (won't be reached)
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Array index out of bounds");
} catch (ArithmeticException e) {
    System.out.println("Arithmetic exception");
} catch (Exception e) {
    // Catches any other exceptions
    System.out.println("Generic exception: " + e.getMessage());
}
```

#### Multi-catch block (Java 7+)
```java
try {
    // Code that may throw multiple exceptions
} catch (IOException | SQLException e) {
    // Handles both IOException and SQLException
    System.out.println("I/O or SQL Exception: " + e.getMessage());
}
```

### Throw, Throws & Finally

#### throw
- Used to explicitly throw an exception.
- Can throw a new exception or re-throw a caught exception.

```java
public void validateAge(int age) {
    if (age < 0) {
        throw new IllegalArgumentException("Age cannot be negative");
    }
    if (age > 120) {
        throw new IllegalArgumentException("Invalid age: " + age);
    }
    // Continue processing if age is valid
}
```

#### throws
- Used in method declaration to indicate that the method might throw certain exceptions.
- Passes the responsibility of handling the exception to the calling method.

```java
// This method declares that it might throw IOException
public void readFile(String filename) throws IOException {
    FileReader file = new FileReader(filename);
    BufferedReader reader = new BufferedReader(file);
    // Process file...
    reader.close();
}

// The calling method must handle the exception
public void processFile() {
    try {
        readFile("data.txt");
    } catch (IOException e) {
        System.out.println("Error reading file: " + e.getMessage());
    }
}
```

#### finally
- The `finally` block always executes, whether an exception is thrown or not.
- Typically used for clean-up operations like closing resources.

```java
FileReader reader = null;
try {
    reader = new FileReader("file.txt");
    // Process file...
} catch (IOException e) {
    System.out.println("Error reading file: " + e.getMessage());
} finally {
    // This will always execute
    try {
        if (reader != null) {
            reader.close();
        }
    } catch (IOException e) {
        System.out.println("Error closing file");
    }
}
```

#### Try-with-resources (Java 7+)
- Automatically closes resources that implement `AutoCloseable` interface.
- Simplifies resource management and eliminates the need for explicit `finally` blocks.

```java
try (FileReader reader = new FileReader("file.txt");
     BufferedReader bufferedReader = new BufferedReader(reader)) {
    // Process file...
    String line = bufferedReader.readLine();
    System.out.println(line);
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
// Resources are automatically closed, even if an exception occurs
```

### Creation of User-Defined Exception Classes
- Custom exceptions are created by extending the `Exception` class (for checked exceptions) or `RuntimeException` class (for unchecked exceptions).
- Allows for more specific exception handling tailored to application needs.

```java
// Custom checked exception
class InsufficientFundsException extends Exception {
    private double amount;
    
    public InsufficientFundsException(double amount) {
        super("Insufficient funds: Deficit of $" + amount);
        this.amount = amount;
    }
    
    public double getAmount() {
        return amount;
    }
}

// Custom unchecked exception
class InvalidProductException extends RuntimeException {
    public InvalidProductException(String message) {
        super(message);
    }
}

// Using custom exceptions
class BankAccount {
    private double balance;
    
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            double deficit = amount - balance;
            throw new InsufficientFundsException(deficit);
        }
        balance -= amount;
        System.out.println("Withdrawal successful. New balance: " + balance);
    }
}

// Using the custom exception
public class CustomExceptionDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100.00);
        
        try {
            account.withdraw(150.00);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
            System.out.println("Deficit amount: $" + e.getAmount());
        }
    }
}
```

## Multithreading

### Basics of Multithreading
- **Thread**: A lightweight subprocess, the smallest unit of processing.
- **Multithreading**: The ability of a program to run multiple threads concurrently.
- Advantages:
  1. **Improved Performance**: Better CPU utilization
  2. **Responsiveness**: UI remains responsive while background tasks run
  3. **Resource Sharing**: Threads share memory and resources
  4. **Parallelism**: Execution of multiple tasks simultaneously

### Main Thread
- Every Java program has at least one thread - the main thread.
- Created automatically when the program starts.
- Executes the `main()` method.
- Can spawn additional threads.

```java
public class MainThreadDemo {
    public static void main(String[] args) {
        // Get reference to the current thread (main thread)
        Thread mainThread = Thread.currentThread();
        
        // Print thread information
        System.out.println("Current Thread: " + mainThread.getName());
        System.out.println("Priority: " + mainThread.getPriority());
        System.out.println("Thread Group: " + mainThread.getThreadGroup().getName());
        
        // Change main thread's name
        mainThread.setName("MyMainThread");
        System.out.println("After name change: " + mainThread.getName());
    }
}
```

### Thread Life Cycle
A thread goes through various states during its lifetime:

1. **New**: Thread is created but not started yet
2. **Runnable**: Thread is ready to run and waiting for CPU time
3. **Running**: Thread is currently executing
4. **Blocked/Waiting**: Thread is temporarily inactive (waiting for resources or other threads)
5. **Terminated**: Thread has completed execution or was stopped

```
        ┌─────────┐                              
        │   New   │                              
        └────┬────┘                              
             │ start()                           
             ▼                                   
     ┌───────────────┐   scheduler    ┌─────────┐
     │   Runnable    │───────────────▶│ Running │
     └───┬───────┬───┘                └────┬────┘
         │       ▲                         │     
         │       │                         │     
         │       │   sleep() ends          │     
         │       │   wait() notified       │     
         │       │   blocked I/O completed │     
         │       │   suspended thread      │     
         │       │   resumed               │     
         │       │                         │     
         │       │                         │     
         ▼       │                         ▼     
┌────────────────┴────────────┐      ┌──────────┐
│ Non-Runnable (Blocked/      │      │Terminated│
│ Waiting/Sleeping/Suspended) │      └──────────┘
└─────────────────────────────┘               
```

### Creation of Multiple Threads
There are two main ways to create threads in Java:

#### 1. Extending the Thread class
```java
class MyThread extends Thread {
    @Override
    public void run() {
        // Thread task goes here
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + ": " + i);
            try {
                Thread.sleep(500); // Pause for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class ThreadExtendDemo {
    public static void main(String[] args) {
        // Create thread objects
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        
        // Set thread names
        thread1.setName("Thread-1");
        thread2.setName("Thread-2");
        
        // Start threads
        thread1.start(); // Calls run() method
        thread2.start();
        
        System.out.println("Main thread continues execution");
    }
}
```

#### 2. Implementing the Runnable interface
```java
class MyRunnable implements Runnable {
    @Override
    public void run() {
        // Thread task goes here
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class RunnableDemo {
    public static void main(String[] args) {
        // Create Runnable object
        MyRunnable runnable = new MyRunnable();
        
        // Create thread objects using the Runnable
        Thread thread1 = new Thread(runnable, "Thread-1");
        Thread thread2 = new Thread(runnable, "Thread-2");
        
        // Start threads
        thread1.start();
        thread2.start();
        
        System.out.println("Main thread continues execution");
    }
}
```

#### 3. Using Lambda Expressions (Java 8+)
```java
public class LambdaThreadDemo {
    public static void main(String[] args) {
        // Create and start a thread using lambda expression
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                }
            }
        }, "Lambda-Thread");
        
        thread1.start();
    }
}
```

### Thread Priorities
- Thread priorities define the importance of threads.
- Range from 1 (lowest) to 10 (highest), with 5 as the default.
- Higher priority threads are generally executed before lower priority threads.
- Priorities are hints to the scheduler, not guarantees.

```java
public class ThreadPriorityDemo {
    public static void main(String[] args) {
        // Create threads
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Low Priority: " + i);
            }
        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("High Priority: " + i);
            }
        });
        
        // Set priorities
        t1.setPriority(Thread.MIN_PRIORITY); // 1
        t2.setPriority(Thread.MAX_PRIORITY); // 10
        
        // Start threads
        t1.start();
        t2.start();
    }
}
```

### Thread Synchronization
- Ensures that only one thread can access a shared resource at a time.
- Prevents race conditions and ensures data consistency.
- Achieved using the `synchronized` keyword.

#### 1. Synchronized Methods
```java
class Counter {
    private int count = 0;
    
    // Synchronized method - only one thread can execute this method at a time
    public synchronized void increment() {
        count++;
    }
    
    public synchronized int getCount() {
        return count;
    }
}

public class SynchronizedMethodDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        
        // Create threads that increment the counter
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        
        // Start threads
        t1.start();
        t2.start();
        
        // Wait for threads to complete
        t1.join();
        t2.join();
        
        System.out.println("Final count: " + counter.getCount()); // Should be 2000
    }
}
```

#### 2. Synchronized Blocks
```java
class BankAccount {
    private int balance = 0;
    
    public void deposit(int amount) {
        // Synchronized block - locks on 'this' object
        synchronized (this) {
            balance += amount;
        }
    }
    
    public void withdraw(int amount) {
        synchronized (this) {
            if (balance >= amount) {
                balance -= amount;
            }
        }
    }
    
    public int getBalance() {
        synchronized (this) {
            return balance;
        }
    }
}
```

### Inter-thread Communication
- Allows threads to coordinate their activities.
- Implemented using `wait()`, `notify()`, and `notifyAll()` methods.
- These methods must be called from within a synchronized context.

```java
class SharedResource {
    private boolean dataProduced = false;
    private int data = 0;
    
    public synchronized void produce(int value) throws InterruptedException {
        // Wait if data has already been produced but not consumed
        while (dataProduced) {
            wait(); // Thread releases lock and waits
        }
        
        // Produce data
        data = value;
        System.out.println("Produced: " + data);
        dataProduced = true;
        
        // Notify waiting consumer thread
        notify();
    }
    
    public synchronized int consume() throws InterruptedException {
        // Wait if no data has been produced yet
        while (!dataProduced) {
            wait(); // Thread releases lock and waits
        }
        
        // Consume data
        System.out.println("Consumed: " + data);
        dataProduced = false;
        
        // Notify waiting producer thread
        notify();
        
        return data;
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        
        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    resource.produce(i);
                    Thread.sleep(100); // Simulate work
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    resource.consume();
                    Thread.sleep(100); // Simulate work
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        // Start threads
        producer.start();
        consumer.start();
    }
}
```

### Deadlocks
- A situation where two or more threads are blocked forever, waiting for each other.
- Each thread holds a resource that the other thread needs, creating a circular wait.

```java
public class DeadlockDemo {
    public static void main(String[] args) {
        // Create two resources
        Object resource1 = new Object();
        Object resource2 = new Object();
        
        // Thread 1 - tries to lock resource1 then resource2
        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: Locked resource 1");
                
                try {
                    Thread.sleep(100); // Delay to ensure both threads are running
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                // Now try to lock resource2
                synchronized (resource2) {
                    System.out.println("Thread 1: Locked resource 2");
                }
            }
        });
        
        // Thread 2 - tries to lock resource2 then resource1
        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: Locked resource 2");
                
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                // Now try to lock resource1
                synchronized (resource1) {
                    System.out.println("Thread 2: Locked resource 1");
                }
            }
        });
        
        // Start threads
        t1.start();
        t2.start();
    }
}
```

#### Deadlock Prevention:
1. **Lock Ordering**: Always acquire locks in the same order
2. **Lock Timeout**: Use `tryLock()` with a timeout (available in `java.util.concurrent.locks.Lock`)
3. **Deadlock Detection**: Use tools to detect potential deadlocks
4. **Thread Interruption**: Use interruption to break deadlocks

### Suspending & Resuming Threads
- In modern Java, the methods `suspend()` and `resume()` are deprecated due to potential deadlocks.
- Instead, use flags and interrupts for thread coordination.

```java
class WorkerThread implements Runnable {
    private volatile boolean suspended = false;
    
    public void suspend() {
        suspended = true;
        System.out.println("Thread suspended");
    }
    
    public void resume() {
        suspended = false;
        synchronized (this) {
            notify(); // Wake up the thread if it's waiting
        }
        System.out.println("Thread resumed");
    }
    
    @Override
    public void run() {
        System.out.println("Thread started");
        
        try {
            for (int i = 1; i <= 10; i++) {
                // Check if thread should be suspended
                synchronized (this) {
                    while (suspended) {
                        wait(); // Wait until resumed
                    }
                }
                
                // Thread work
                System.out.println("Count: " + i);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
        
        System.out.println("Thread terminated");
    }
}

public class ThreadSuspendResumeDemo {
    public static void main(String[] args) throws InterruptedException {
        WorkerThread worker = new WorkerThread();
        Thread thread = new Thread(worker);
        
        // Start the thread
        thread.start();
        
        // Let it run for a while
        Thread.sleep(1000);
        
        // Suspend the thread
        worker.suspend();
        
        // Keep it suspended for a while
        Thread.sleep(2000);
        
        // Resume the thread
        worker.resume();
    }
}
``` 