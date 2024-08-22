/*
 * Write a Program to calculate the percentage of a given student
 * In Board Exam. Take marks of 5 subjects as input and calculate the percentage
 */

import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        System.out.println("Percentage Calculator");
        Scanner sc = new Scanner(System.in);
        
        // Declare variables for marks
        int a, b, c, d, e;
        
        // Take input from user for each subject
        System.out.print("Enter your marks in subject 1 = ");
        a = sc.nextInt();
        System.out.print("Enter your marks in subject 2 = ");
        b = sc.nextInt();
        System.out.print("Enter your marks in subject 3 = ");
        c = sc.nextInt();
        System.out.print("Enter your marks in subject 4 = ");
        d = sc.nextInt();
        System.out.print("Enter your marks in subject 5 = ");
        e = sc.nextInt();
        
       
        int totalMarks = a + b + c + d + e;
        float percentage = (totalMarks / 500.0f) * 100;
        System.out.println("Your percentage is = " + percentage);
        
        // Close the scanner
        sc.close();
    }
}

