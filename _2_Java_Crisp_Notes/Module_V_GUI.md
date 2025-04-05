# Module V: GUI Programming in Java

## Introduction to AWT Programming

### Abstract Window Toolkit (AWT)
- The **Abstract Window Toolkit** (AWT) is Java's original GUI toolkit.
- It's a part of the Java Foundation Classes (JFC).
- AWT components are **heavyweight** - they're implemented using native platform components.
- Uses the host operating system's GUI components, which makes the look and feel vary across platforms.

### Key AWT Components
1. **Component**: The abstract base class for all AWT components
2. **Container**: A component that can contain other components
3. **Window**: A top-level window with no borders or menu bar
4. **Frame**: A top-level window with a title, border, and menu bar
5. **Panel**: A container that can group related components
6. **Button**: A push button
7. **Label**: Displays text
8. **TextField**: Single-line text input
9. **TextArea**: Multi-line text input
10. **Checkbox**: Toggle button
11. **Choice**: Drop-down list
12. **List**: List box

### Creating a Basic AWT Window
```java
import java.awt.*;
import java.awt.event.*;

public class BasicAWTExample {
    public static void main(String[] args) {
        // Create a frame (window)
        Frame frame = new Frame("My First AWT Program");
        
        // Set frame size and layout
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());
        
        // Create components
        Label label = new Label("Welcome to AWT!");
        Button button = new Button("Click Me");
        TextField textField = new TextField(20);
        
        // Add components to the frame
        frame.add(label);
        frame.add(textField);
        frame.add(button);
        
        // Handle window close event
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });
        
        // Display the frame
        frame.setVisible(true);
    }
}
```

## Layout and Component Managers

### Layout Managers
- Layout managers determine the size and position of components within a container.
- Provide a flexible way to arrange components regardless of platform or screen resolution.

### Types of Layout Managers

#### 1. FlowLayout
- The simplest layout manager.
- Arranges components in a row, from left to right.
- When one row is filled, it moves to the next row.
- Default layout for Panel.

```java
Panel panel = new Panel();
panel.setLayout(new FlowLayout());
// or
panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20)); // align, hgap, vgap
```

#### 2. BorderLayout
- Arranges components in five regions: North, South, East, West, and Center.
- Default layout for Frame.

```java
Frame frame = new Frame();
frame.setLayout(new BorderLayout(10, 20)); // hgap, vgap

frame.add(new Button("North"), BorderLayout.NORTH);
frame.add(new Button("South"), BorderLayout.SOUTH);
frame.add(new Button("East"), BorderLayout.EAST);
frame.add(new Button("West"), BorderLayout.WEST);
frame.add(new Button("Center"), BorderLayout.CENTER);
```

#### 3. GridLayout
- Arranges components in a grid of rows and columns.
- All components are given the same size.

```java
Panel panel = new Panel();
panel.setLayout(new GridLayout(3, 2, 10, 5)); // rows, columns, hgap, vgap

panel.add(new Button("1"));
panel.add(new Button("2"));
panel.add(new Button("3"));
panel.add(new Button("4"));
panel.add(new Button("5"));
panel.add(new Button("6"));
```

#### 4. CardLayout
- Shows only one component at a time from a group of components.
- Like a deck of cards where only the top card is visible.

```java
Panel cards = new Panel();
CardLayout cardLayout = new CardLayout();
cards.setLayout(cardLayout);

Panel card1 = new Panel();
card1.add(new Label("Card 1"));
Panel card2 = new Panel();
card2.add(new Label("Card 2"));

cards.add(card1, "CARD1");
cards.add(card2, "CARD2");

// To display a specific card
cardLayout.show(cards, "CARD2");
```

#### 5. GridBagLayout
- The most flexible but complex layout manager.
- Allows precise component placement and sizing.

```java
Frame frame = new Frame();
frame.setLayout(new GridBagLayout());
GridBagConstraints constraints = new GridBagConstraints();

// Configure constraints for component placement
constraints.gridx = 0;
constraints.gridy = 0;
constraints.gridwidth = 2;
constraints.gridheight = 1;
constraints.fill = GridBagConstraints.HORIZONTAL;

frame.add(new Button("Button 1"), constraints);

// Different constraints for another component
constraints.gridx = 0;
constraints.gridy = 1;
constraints.gridwidth = 1;
constraints.weightx = 0.5;

frame.add(new Button("Button 2"), constraints);
```

### Component Managers
- Classes that manage UI components and their arrangement.
- Includes layout managers and container components.

#### Common Container Components
1. **Panel**: A simple container used to group related components
2. **ScrollPane**: A container that provides scrollable view of a component
3. **Dialog**: A pop-up window for user input or messages

```java
// Panel example
Panel panel = new Panel();
panel.add(new Button("OK"));
panel.add(new Button("Cancel"));

// ScrollPane example
TextArea textArea = new TextArea(20, 50);
ScrollPane scrollPane = new ScrollPane();
scrollPane.add(textArea);

// Dialog example
Dialog dialog = new Dialog(frame, "Dialog Title", true); // true for modal
dialog.setSize(300, 200);
dialog.setLayout(new FlowLayout());
dialog.add(new Label("This is a dialog box"));
```

## Event Handling

### Event Model
- Events occur when the user interacts with GUI components.
- The event model in Java follows the Observer pattern.
- Components (sources) generate events, and listeners respond to these events.

### Event Handling Steps
1. Implement the appropriate event listener interface
2. Register the listener with the component
3. Implement the event handling methods

### Common Event Listeners

#### 1. ActionListener
- For button clicks, menu selections, etc.

```java
Button button = new Button("Click Me");
button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked!");
    }
});
```

#### 2. MouseListener
- For mouse events: click, press, release, enter, exit.

```java
Panel panel = new Panel();
panel.addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked at: " + e.getX() + ", " + e.getY());
    }
});
```

#### 3. KeyListener
- For keyboard events.

```java
TextField textField = new TextField(20);
textField.addKeyListener(new KeyAdapter() {
    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed: " + e.getKeyChar());
    }
});
```

#### 4. WindowListener
- For window events: open, close, minimize, etc.

```java
frame.addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
        frame.dispose();
        System.exit(0);
    }
});
```

### Example: Complete Event Handling
```java
import java.awt.*;
import java.awt.event.*;

public class EventHandlingExample {
    public static void main(String[] args) {
        Frame frame = new Frame("Event Handling");
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());
        
        // Text field and result label
        TextField textField = new TextField(20);
        Label resultLabel = new Label("Enter text and press the button");
        Button button = new Button("Submit");
        
        // Add action listener to button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                resultLabel.setText("You entered: " + input);
            }
        });
        
        // Add window listener
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });
        
        // Add components
        frame.add(textField);
        frame.add(button);
        frame.add(resultLabel);
        frame.setVisible(true);
    }
}
```

## Swing Components

### Introduction to Swing
- **Swing** is a more advanced GUI toolkit built on top of AWT.
- Swing components are **lightweight** - they're written entirely in Java.
- Provides a consistent look and feel across platforms.
- Swing components start with 'J' (e.g., JButton, JFrame).

### Advantages of Swing over AWT
1. **Lightweight**: Swing components don't rely on native peers
2. **Platform Independence**: Consistent appearance across platforms
3. **More Components**: Richest collection of GUI components
4. **Customizable Look and Feel**: Can change appearance at runtime
5. **Advanced Features**: Double-buffering, keyboard mnemonics, tooltips, etc.

### Key Swing Components

#### 1. JFrame
- Top-level window with a title bar, border, and other features.

```java
JFrame frame = new JFrame("Swing Example");
frame.setSize(400, 300);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
```

#### 2. JButton
- Standard push button.

```java
JButton button = new JButton("Click Me");
button.addActionListener(e -> System.out.println("Button clicked!"));
```

#### 3. JLabel
- Displays text or images.

```java
JLabel label = new JLabel("This is a label");
JLabel imageLabel = new JLabel(new ImageIcon("image.png"));
```

#### 4. JTextField & JTextArea
- For text input.

```java
JTextField textField = new JTextField(20);
JTextArea textArea = new JTextArea(5, 20); // rows, columns
```

#### 5. JCheckBox & JRadioButton
- Toggle buttons.

```java
JCheckBox checkBox = new JCheckBox("I agree");

// Radio buttons require ButtonGroup for exclusivity
ButtonGroup group = new ButtonGroup();
JRadioButton radio1 = new JRadioButton("Option 1", true); // selected by default
JRadioButton radio2 = new JRadioButton("Option 2");
group.add(radio1);
group.add(radio2);
```

#### 6. JComboBox
- Drop-down list.

```java
String[] options = {"Apple", "Orange", "Banana"};
JComboBox<String> comboBox = new JComboBox<>(options);
```

#### 7. JList
- List box that allows multiple selections.

```java
String[] items = {"Item 1", "Item 2", "Item 3"};
JList<String> list = new JList<>(items);
JScrollPane scrollPane = new JScrollPane(list); // Add scrolling
```

#### 8. JTable
- Displays data in a tabular format.

```java
String[] columnNames = {"Name", "Age", "City"};
Object[][] data = {
    {"John", 25, "New York"},
    {"Alice", 30, "Boston"},
    {"Bob", 22, "Chicago"}
};
JTable table = new JTable(data, columnNames);
JScrollPane scrollPane = new JScrollPane(table);
```

#### 9. JPanel
- Container for grouping components.

```java
JPanel panel = new JPanel();
panel.setLayout(new FlowLayout());
panel.add(new JButton("OK"));
panel.add(new JButton("Cancel"));
```

### Basic Swing Application Structure
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingExample {
    public static void main(String[] args) {
        // Create and set up the window
        JFrame frame = new JFrame("Swing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Create panel with components
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        JLabel label = new JLabel("Enter your name:");
        JTextField textField = new JTextField(15);
        JButton button = new JButton("Greet");
        
        // Add action listener
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                JOptionPane.showMessageDialog(frame, "Hello, " + name + "!");
            }
        });
        
        // Add components to panel
        panel.add(label);
        panel.add(textField);
        panel.add(button);
        
        // Add panel to frame
        frame.add(panel);
        
        // Display the window
        frame.setVisible(true);
    }
}
```

## Sample Swing Programs

### 1. Simple Login Form
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Login Form");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create panel
        JPanel panel = new JPanel();
        panel.setLayout(null); // Using absolute positioning
        
        // Username components
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(30, 30, 80, 25);
        panel.add(userLabel);
        
        JTextField userText = new JTextField(20);
        userText.setBounds(120, 30, 150, 25);
        panel.add(userText);
        
        // Password components
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 70, 80, 25);
        panel.add(passwordLabel);
        
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(120, 70, 150, 25);
        panel.add(passwordText);
        
        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 120, 80, 30);
        panel.add(loginButton);
        
        // Add action listener
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());
                
                if (username.equals("admin") && password.equals("password")) {
                    JOptionPane.showMessageDialog(frame, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password",
                                                "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        // Add panel to frame
        frame.add(panel);
        frame.setVisible(true);
    }
}
```

### 2. Form with Event Handling
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrationForm extends JFrame {
    // Form components
    private JTextField nameField, emailField;
    private JComboBox<String> countryBox;
    private JRadioButton maleButton, femaleButton;
    private JCheckBox termsBox;
    
    public RegistrationForm() {
        // Frame setup
        super("Registration Form");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        
        // Create panels
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(6, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        // Form components
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);
        
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);
        
        JLabel countryLabel = new JLabel("Country:");
        String[] countries = {"Select Country", "USA", "UK", "Canada", "Australia", "India"};
        countryBox = new JComboBox<>(countries);
        
        JLabel genderLabel = new JLabel("Gender:");
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        
        termsBox = new JCheckBox("I accept the terms and conditions");
        
        // Buttons
        JButton submitButton = new JButton("Submit");
        JButton clearButton = new JButton("Clear");
        
        // Add components to form panel
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(countryLabel);
        formPanel.add(countryBox);
        formPanel.add(genderLabel);
        formPanel.add(genderPanel);
        formPanel.add(new JLabel("")); // Empty cell
        formPanel.add(termsBox);
        
        // Add buttons to button panel
        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);
        
        // Event handling for Submit button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validateForm()) {
                    displayResults();
                } else {
                    JOptionPane.showMessageDialog(RegistrationForm.this,
                        "Please fill all required fields and accept terms.",
                        "Validation Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        // Event handling for Clear button
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });
        
        // Add panels to frame
        add(new JLabel("Registration Form", JLabel.CENTER), BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        // Display the frame
        setLocationRelativeTo(null); // Center on screen
        setVisible(true);
    }
    
    // Validate form inputs
    private boolean validateForm() {
        return !nameField.getText().trim().isEmpty() &&
               !emailField.getText().trim().isEmpty() &&
               countryBox.getSelectedIndex() != 0 &&
               (maleButton.isSelected() || femaleButton.isSelected()) &&
               termsBox.isSelected();
    }
    
    // Display results
    private void displayResults() {
        String name = nameField.getText();
        String email = emailField.getText();
        String country = (String) countryBox.getSelectedItem();
        String gender = maleButton.isSelected() ? "Male" : "Female";
        
        String message = "Registration Successful!\n\n" +
                         "Name: " + name + "\n" +
                         "Email: " + email + "\n" +
                         "Country: " + country + "\n" +
                         "Gender: " + gender;
        
        JOptionPane.showMessageDialog(this, message, "Registration Results", JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Clear form
    private void clearForm() {
        nameField.setText("");
        emailField.setText("");
        countryBox.setSelectedIndex(0);
        genderGroup.clearSelection();
        termsBox.setSelected(false);
    }
    
    public static void main(String[] args) {
        // Run on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RegistrationForm();
            }
        });
    }
}
```

### 3. Simple Calculator
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame {
    private JTextField displayField;
    private double firstNumber = 0;
    private String operator = "";
    private boolean startNewInput = true;
    
    public SimpleCalculator() {
        // Frame setup
        super("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Display field
        displayField = new JTextField("0");
        displayField.setFont(new Font("Arial", Font.PLAIN, 24));
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setEditable(false);
        add(displayField, BorderLayout.NORTH);
        
        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));
        
        // Define buttons
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "CE", "", ""
        };
        
        // Create and add buttons
        for (String label : buttonLabels) {
            if (label.isEmpty()) {
                buttonPanel.add(new JLabel());
            } else {
                JButton button = new JButton(label);
                button.setFont(new Font("Arial", Font.PLAIN, 18));
                
                // Add action listener
                button.addActionListener(new ButtonClickListener());
                buttonPanel.add(button);
            }
        }
        
        // Add button panel
        add(buttonPanel, BorderLayout.CENTER);
        
        // Display the frame
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    // Button click handler
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String buttonText = source.getText();
            
            switch (buttonText) {
                case "0": case "1": case "2": case "3": case "4":
                case "5": case "6": case "7": case "8": case "9":
                    handleNumberButton(buttonText);
                    break;
                case ".":
                    handleDecimalButton();
                    break;
                case "+": case "-": case "*": case "/":
                    handleOperatorButton(buttonText);
                    break;
                case "=":
                    handleEqualsButton();
                    break;
                case "C":
                    handleClearButton();
                    break;
                case "CE":
                    handleClearEntryButton();
                    break;
            }
        }
    }
    
    private void handleNumberButton(String number) {
        if (startNewInput) {
            displayField.setText(number);
            startNewInput = false;
        } else {
            String currentText = displayField.getText();
            if (currentText.equals("0")) {
                displayField.setText(number);
            } else {
                displayField.setText(currentText + number);
            }
        }
    }
    
    private void handleDecimalButton() {
        if (startNewInput) {
            displayField.setText("0.");
            startNewInput = false;
        } else {
            String currentText = displayField.getText();
            if (!currentText.contains(".")) {
                displayField.setText(currentText + ".");
            }
        }
    }
    
    private void handleOperatorButton(String newOperator) {
        try {
            double displayValue = Double.parseDouble(displayField.getText());
            
            if (!operator.isEmpty()) {
                // Calculate result of previous operation
                double result = performCalculation(firstNumber, displayValue, operator);
                displayField.setText(String.valueOf(result));
                firstNumber = result;
            } else {
                firstNumber = displayValue;
            }
            
            operator = newOperator;
            startNewInput = true;
        } catch (NumberFormatException | ArithmeticException ex) {
            displayField.setText("Error");
            startNewInput = true;
        }
    }
    
    private void handleEqualsButton() {
        try {
            double secondNumber = Double.parseDouble(displayField.getText());
            double result = performCalculation(firstNumber, secondNumber, operator);
            
            displayField.setText(String.valueOf(result));
            firstNumber = 0;
            operator = "";
            startNewInput = true;
        } catch (NumberFormatException | ArithmeticException ex) {
            displayField.setText("Error");
            startNewInput = true;
        }
    }
    
    private void handleClearButton() {
        displayField.setText("0");
        firstNumber = 0;
        operator = "";
        startNewInput = true;
    }
    
    private void handleClearEntryButton() {
        displayField.setText("0");
        startNewInput = true;
    }
    
    private double performCalculation(double firstNumber, double secondNumber, String operator) {
        switch (operator) {
            case "+": return firstNumber + secondNumber;
            case "-": return firstNumber - secondNumber;
            case "*": return firstNumber * secondNumber;
            case "/":
                if (secondNumber == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return firstNumber / secondNumber;
            default: return secondNumber;
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SimpleCalculator();
            }
        });
    }
}
```

### Comparing AWT and Swing

| Feature | AWT | Swing |
|---------|-----|-------|
| **Component Type** | Heavyweight (platform-dependent) | Lightweight (platform-independent) |
| **Look and Feel** | Platform-dependent | Pluggable (same across platforms) |
| **Component Set** | Basic | Rich and extensive |
| **Performance** | Faster (native code) | Slower (pure Java) |
| **MVC Architecture** | No | Yes (Model-View-Controller) |
| **Double Buffering** | Not supported | Supported |
| **Component Names** | No prefix (e.g., Button) | 'J' prefix (e.g., JButton) |
| **Package** | java.awt | javax.swing |