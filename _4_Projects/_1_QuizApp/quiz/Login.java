package _1_QuizApp.quiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("all")
public class Login extends JFrame implements ActionListener {
    JButton rules, back;
    JTextField tfname;
    Login(){
        getContentPane().setBackground(Color.WHITE); //setting background color to white
        setLayout(null);

        //adding image
        ImageIcon i1 = new ImageIcon("D:\\03_Code Playground\\Akash_Java_Notes\\_4_Projects\\_1_QuizApp\\icons\\login.jpeg");
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 750, 750);
        add(image);

        JLabel heading = new JLabel("Quizify");
        heading.setBounds(870, 60, 350, 60);
        heading.setFont(new Font("Arial Black", Font.BOLD, 50));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        JLabel name = new JLabel("Enter your name");
        name.setBounds(910, 150, 400, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        name.setForeground(new Color(30, 144, 254));
        add(name);

        tfname = new JTextField();
        tfname.setBounds(830, 200, 300, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);

        rules = new JButton("Rules");
        rules.setBounds(860, 270, 120, 25);
        rules.setBackground(new Color(30, 144, 254));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);

        back = new JButton("Back");
        back.setBounds(1000, 270, 120, 25);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(1300,750);
        setLocation(300,150);
        setVisible(true);
        System.out.println("Quiz App Running...");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rules) {
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);
        } else if (ae.getSource() == back) {
            setVisible(false);
            System.out.println("Closed Quiz App...");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
