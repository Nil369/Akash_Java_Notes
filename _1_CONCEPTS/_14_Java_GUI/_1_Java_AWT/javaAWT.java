package _1_Java_AWT;
import java.awt.*;
import java.awt.event.*;// Required for event handling

class RegisterAWT {
    Label headingLabel, nameLabel, emailLabel, passwordLabel;
    TextField nameField, emailField, passwordField;
    Button registerButton;
    Checkbox rememberMeCheckbox;
    @SuppressWarnings("all")
    public RegisterAWT() {
        Frame frame = new Frame("Register AWT");

        // Set Layout
        frame.setLayout(null);

        // Heading
        headingLabel = new Label("Register Form using AWT");
        headingLabel.setBounds(80, 30, 300, 30);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(headingLabel);

        // Name label and text field
        nameLabel = new Label("Name:");
        nameLabel.setBounds(50, 100, 100, 30);
        frame.add(nameLabel);

        nameField = new TextField();
        nameField.setBounds(150, 100, 200, 30);
        frame.add(nameField);

        // Email label and text field
        emailLabel = new Label("Email:");
        emailLabel.setBounds(50, 150, 100, 30);
        frame.add(emailLabel);

        emailField = new TextField();
        emailField.setBounds(150, 150, 200, 30);
        frame.add(emailField);

        // Password label and text field
        passwordLabel = new Label("Password:");
        passwordLabel.setBounds(50, 200, 100, 30);
        frame.add(passwordLabel);

        passwordField = new TextField();
        passwordField.setEchoChar('*'); // Mask password input
        passwordField.setBounds(150, 200, 200, 30);
        frame.add(passwordField);

        // Remember Me checkbox
        rememberMeCheckbox = new Checkbox("Remember Me");
        rememberMeCheckbox.setBounds(150, 250, 200, 30);
        frame.add(rememberMeCheckbox);

        // Register button
        registerButton = new Button("Register");
        registerButton.setBounds(150, 300, 100, 30);
        frame.add(registerButton);

        // Action listener for the Register button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String password = passwordField.getText();

                // Validation
                if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    showMessage(frame, "All fields are required!", "Error");
                } else if (!email.contains("@") || !email.contains(".")) {
                    showMessage(frame, "Please enter a valid email address!", "Error");
                } else {
                    showMessage(frame, "User: " + name + " Registered Successfully!", "Success");
                }
            }
        });

        // Window closing event
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Closing Register Form...");
                frame.dispose();
                System.out.println("Closed Register Form.");

            }
        });

        // Set frame properties
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    // Helper method to show messages
    public void showMessage(Frame parent, String message, String title) {
        Dialog dialog = new Dialog(parent, title, true);
        dialog.setLayout(new FlowLayout());
        Label msgLabel = new Label(message);
        Button okButton = new Button("OK");
        okButton.addActionListener(e -> dialog.setVisible(false));
        dialog.add(msgLabel);
        dialog.add(okButton);
        dialog.setSize(300, 150);
        dialog.setVisible(true);
    }
    public void printLogs(){
        System.out.println("Opened Form....");
    }
}


public class javaAWT {
    public static void main(String[] args) {
        RegisterAWT newRegisterForm = new RegisterAWT();
        newRegisterForm.printLogs();
    }
}
