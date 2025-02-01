package _1_QuizApp.quiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("all")
public class Rules extends JFrame implements ActionListener{

    String name;
    JButton start, back;

    Rules(String name) {
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Hello "+ name +", Welcome " + " to Quizify");
        heading.setBounds(220, 20, 700, 30);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
                "<html>" +
                        "1. Answer each question concisely and accurately." + "<br><br>" +
                        "2. Maintain focus—avoid distractions and unnecessary interactions." + "<br><br>" +
                        "3. All questions are mandatory for getting marks; skipping means you get 0 marks" + "<br><br>" +
                        "4. Stay calm and composed throughout the quiz." + "<br><br>" +
                        "5. Think critically before selecting an answer." + "<br><br>" +
                        "6. Performance may vary—focus on your own progress." + "<br><br>" +
                        "7. This quiz is designed to challenge your knowledge—be prepared!" + "<br><br>" +
                        "8. Best of luck! Stay confident and do your best." + "<br><br>" +
                        "</html>"
        );
        add(rules);


        back = new JButton("Back");
        back.setBounds(250, 500, 100, 30);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setBounds(400, 500, 100, 30);
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);

        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name);
        } else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Rules("User");
    }
}
