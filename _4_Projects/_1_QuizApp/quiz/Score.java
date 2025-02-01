package _1_QuizApp.quiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("all")
public class Score extends JFrame implements ActionListener {

    Score(String name, int score) {
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon("D:\\03_Code Playground\\Akash_Java_Notes\\_4_Projects\\_1_QuizApp\\icons\\score.png");
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 200, 300, 250);
        add(image);

        JLabel heading = new JLabel("Thank You " + name + " for playing Quizify");
        heading.setBounds(45, 30, 700, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(heading);

        JLabel lblscore = new JLabel("Your score is " + score);
        lblscore.setBounds(350, 200, 300, 30);
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(lblscore);

        // Result message based on score
        JLabel message = new JLabel();
        message.setFont(new Font("Tahoma", Font.BOLD, 24));
        message.setForeground(Color.RED);
        message.setBounds(350, 250, 400, 30);

        if (score == 100) {
            message.setText("🎉 Perfect Score! Congratulations! 🎉");
            message.setForeground(new Color(0, 128, 0)); // Green
        } else if (score >= 80) {
            message.setText("Great Job! Keep it up! 🎉");
            message.setForeground(new Color(0, 128, 0)); // Green
        } else if (score < 50) {
            message.setText("Failed the quiz! Try again.");
            message.setForeground(Color.RED);
        } else {
            message.setText("Good effort! Keep practicing.");
            message.setForeground(new Color(255, 140, 0)); // Orange
        }

        add(message);

        JButton submit = new JButton("Play Again");
        submit.setBounds(380, 320, 120, 30);
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}
