/*
Q1. Write a program to sum three numbers in Java.
Q2.Write a program to calculate CGPA using marks of three subjects (out of 100)
Q3.Write a Java program that asks the user to enter his/her name and greets them with “Hello <name>, have a good day” text.
Q4.Write a Java program to convert Kilometers to miles.
Q5.Write a Java program to detect whether a number entered by the user is an integer or not.
*/
import java.util.Scanner;
public class problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Q1: Sum three numbers
        System.out.println("Q1: Sum of Three Numbers");
        System.out.print("Enter the first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = sc.nextInt();
        System.out.print("Enter the third number: ");
        int num3 = sc.nextInt();
        int sum = num1 + num2 + num3;
        System.out.println("The sum of the three numbers is: " + sum);

        // Q2: Calculate CGPA using marks of three subjects
        System.out.println("\nQ2: Calculate CGPA");
        System.out.print("Enter marks for subject 1 (out of 100): ");
        float marks1 = sc.nextFloat();
        System.out.print("Enter marks for subject 2 (out of 100): ");
        float marks2 = sc.nextFloat();
        System.out.print("Enter marks for subject 3 (out of 100): ");
        float marks3 = sc.nextFloat();
        float totalMarks = marks1 + marks2 + marks3;
        float cgpa = totalMarks / 30; // Assumes a max CGPA of 10
        System.out.println("Your CGPA is: " + cgpa);

        // Q3: Greet the user
        System.out.println("\nQ3: Greet the User");
        sc.nextLine(); // Consume newline left-over from previous input
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Hello " + name + ", have a good day!");

        // Q4: Convert Kilometers to miles
        System.out.println("\nQ4: Convert Kilometers to Miles");
        System.out.print("Enter distance in kilometers: ");
        double kilometers = sc.nextDouble();
        double miles = kilometers * 0.621371; // 1 kilometer = 0.621371 miles
        System.out.println("The distance in miles is: " + miles);

        // Q5: Detect whether input is an integer
        System.out.println("\nQ5: Detect whether input is an integer");
        System.out.println("Enter your number");
        System.out.println(sc.hasNextInt());

    }
}
