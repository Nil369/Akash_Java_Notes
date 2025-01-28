package _2_Java_Swing;

import javax.swing.*;


public class RegisterForm_Swing extends JFrame {

    JButton registerButton;
    JCheckBox rememberMeCheckBox;
    JTextField userName;
    JTextField email;
    JTextField password;
    JLabel Heading;
    private JPanel panelMain;

    public RegisterForm_Swing() {
        registerButton.addActionListener(e -> {
            String user = userName.getText();
            String emailText = email.getText();
            String pass = password.getText();

            // Validation logic
            if (user.isEmpty() || emailText.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(registerButton, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!emailText.contains("@") || !emailText.contains(".")) {
                JOptionPane.showMessageDialog(registerButton, "Please enter a valid email address!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(registerButton, "User: " + user + " Registered Successfully!!");
            }
        });
    }

    public static void main(String[] args) {
        RegisterForm_Swing register = new RegisterForm_Swing();

        register.setContentPane(register.panelMain);
        register.setTitle("Register Form");
        register.setSize(400, 300);
        register.setVisible(true);
        register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
