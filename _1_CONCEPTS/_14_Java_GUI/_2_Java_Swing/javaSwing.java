package _2_Java_Swing;

import javax.swing.*;

class LoginForm {
    public LoginForm() {
        JFrame frame = new JFrame("Login Form");

        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");
        JTextField userField = new JTextField();
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        // Setting bounds for components
        userLabel.setBounds(50, 50, 100, 30);
        userField.setBounds(150, 50, 150, 30);
        passLabel.setBounds(50, 100, 100, 30);
        passField.setBounds(150, 100, 150, 30);
        loginButton.setBounds(150, 150, 100, 30);

        // Adding ActionListener to the login button
        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            // Validating fields
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Username: " + username + "\nPassword: " + password);
            }
        });

        // Adding components to the frame
        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(loginButton);

        // Frame properties
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    void printDetails() {
        System.out.println("Opening Form...");
    }
}

public class javaSwing {
    public static void main(String[] args) {
        LoginForm form = new LoginForm();
        form.printDetails();
    }
}
