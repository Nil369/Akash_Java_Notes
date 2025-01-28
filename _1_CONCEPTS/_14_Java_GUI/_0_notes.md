# **GUI in Java**

Graphical User Interface (GUI) in Java allows developers to create visually rich applications. Java provides two primary libraries for GUI: **AWT (Abstract Window Toolkit)** and **Swing**.

---

### **1. Introduction to AWT Programming**
- **AWT**(Abstract Window Toolkit) is Java's original platform-independent windowing and graphical interface toolkit.
- It includes components like buttons, labels, and text fields for creating simple GUIs.

#### Example of AWT:
```java
import java.awt.*;
import java.awt.event.*; // Required for event handling

public class AWTExample {
    public static void main(String[] args) {
        Frame frame = new Frame("AWT Example"); // Create a Frame
        Button button = new Button("Click Me!"); // Create a Button

        // Set the button's position and size
        button.setBounds(50, 100, 80, 30);

        // Add event handling for the button
        button.addActionListener(e -> System.out.println("Button clicked!"));

        frame.add(button); // Add button to frame
        frame.setSize(300, 200); // Set frame size
        frame.setLayout(null); // Use no layout manager
        frame.setVisible(true); // Make frame visible

        // Close the frame on clicking the close button
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }
}
```

### Key Points:
- `Frame`: Represents a window.
- `Button`: Represents a clickable button.
- `addActionListener`: Handles button clicks.

---

### **2. Layout and Component Managers**
Layout managers are used to arrange components inside containers (like `Frame` or `Panel`). 

#### Types of Layout Managers:
1. **FlowLayout**: Arranges components in a line.
2. **BorderLayout**: Divides the container into 5 regions: North, South, East, West, Center.
3. **GridLayout**: Arranges components in a grid.

#### Example: Using `FlowLayout`
```java
import java.awt.*;

public class LayoutExample {
    public static void main(String[] args) {
        Frame frame = new Frame("FlowLayout Example");
        frame.setLayout(new FlowLayout());

        frame.add(new Button("Button 1"));
        frame.add(new Button("Button 2"));
        frame.add(new Button("Button 3"));

        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
```

---

### **3. Event Handling**
Event handling allows GUI components to respond to user actions like clicks or typing.

#### Key Components:
- **Event Source**: The component that triggers the event (e.g., button).
- **Event Object**: Encapsulates information about the event.
- **Event Listener**: Handles the event.

#### Example: Handling Button Click
```java
import java.awt.*;
import java.awt.event.*;

public class EventExample {
    public static void main(String[] args) {
        Frame frame = new Frame("Event Handling Example");
        Button button = new Button("Click Me");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button was clicked!");
            }
        });

        frame.add(button);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }
}
```

---

### **4. Swing Components**
**Swing** is a more advanced and flexible GUI toolkit than AWT. Swing components are lightweight and provide a richer set of features.

#### Common Swing Components:
1. **JButton**: A clickable button.
2. **JFrame**: A window.
3. **JLabel**: Displays text or an image.
4. **JTextField**: Accepts user input.

---

### **Example 1: Swing with `JButton` and `JLabel`**
```java
import javax.swing.*;

public class SwingExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing Example"); // Create a JFrame
        JButton button = new JButton("Click Me"); // Create a JButton
        JLabel label = new JLabel("Hello, Swing!"); // Create a JLabel

        button.setBounds(100, 150, 120, 30);
        label.setBounds(100, 50, 200, 30);

        button.addActionListener(e -> label.setText("Button Clicked!"));

        frame.add(button);
        frame.add(label);
        frame.setSize(400, 300); // Set window size
        frame.setLayout(null); // No layout manager
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close on exit
        frame.setVisible(true); // Make visible
    }
}
```

### **Key Features in Swing**:
- **JFrame**: Represents a window with a title bar.
- **JButton**: Button to trigger actions.
- **JLabel**: Used to display text or images.

---

### **5. Sample Swing Program: Login Form**
```java
import javax.swing.*;

public class LoginForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Form");

        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");
        JTextField userField = new JTextField();
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        userLabel.setBounds(50, 50, 100, 30);
        userField.setBounds(150, 50, 150, 30);
        passLabel.setBounds(50, 100, 100, 30);
        passField.setBounds(150, 100, 150, 30);
        loginButton.setBounds(100, 150, 100, 30);

        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());
            JOptionPane.showMessageDialog(frame, "Username: " + username + "\nPassword: " + password);
        });

        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(loginButton);

        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
```

---
> ### **`Difference Between AWT and Swing`**

| **Feature**                | **AWT (Abstract Window Toolkit)**                          | **Swing**                                        |
|----------------------------|-----------------------------------------------------------|------------------------------------------------|
| **Lightweight vs. Heavyweight** | AWT components are heavyweight (OS-dependent).           | Swing components are lightweight (OS-independent). |
| **Platform Dependency**    | Depends on the native OS for rendering components.         | Fully written in Java and platform-independent.  |
| **Look and Feel**          | Provides OS-specific look and feel.                       | Supports a pluggable look and feel (customizable). |
| **Components**             | Limited set of components (e.g., `Button`, `Label`).      | Richer set of components (e.g., `JButton`, `JLabel`). |
| **Event Handling**         | Follows an old event model (less efficient).              | Follows a newer and more robust event model.    |
| **Threading Model**        | Single-threaded for painting components.                  | Supports a better threading model via the `SwingUtilities.invokeLater()` method. |
| **Customizability**        | Harder to customize components.                           | Highly customizable components.                |
| **Performance**            | Faster due to native code execution.                      | Slightly slower due to being purely Java-based. |
| **Package**                | Classes are in `java.awt` package.                        | Classes are in `javax.swing` package.          |
| **Example Component**      | `Button`, `TextField`, `Checkbox`.                        | `JButton`, `JTextField`, `JCheckBox`.          |

---

### **Key Points**
- AWT is older, while Swing is a more advanced toolkit.
- Swing offers more features and flexibility, making it better suited for modern applications.
- AWT depends on the operating system, whereas Swing is fully Java-based and cross-platform.
