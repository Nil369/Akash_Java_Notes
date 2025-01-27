/*
Q1. Write a Java program to convert a string to lowercase.

Q2. Write a Java program to replace spaces with underscores.

Q3. Write a Java program to fill in a letter template which looks like below:
// letter = “Dear <|name|>, Thanks a lot”
// Replace <|name|> with a string (some name)

Q4. Write a Java program to detect double and triple spaces in a string.
*/

import java.util.Scanner;
public class practiceProblems {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        // Sol 1:
        System.out.println("\nSolution 1:");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name = ");
        String name = sc.nextLine();
        System.out.println("Your name in LowerCase : " + name.toLowerCase());

        // Sol 2:
        System.out.println("\nSolution 2:");
        System.out.print("Enter a sentence: ");
        String sen = sc.nextLine();
        System.out.println("String with spaces replaced by underscores: " + sen.replace(" ", "_"));

        // Sol 3: 
        System.out.println("\nSolution 3:");
        String letter = "Dear <|name|>, Thanks a lot!";
        letter = letter.replace("<|name|>", "Akash");
        System.out.println(letter);

        // Sol 4:
        System.out.println("\nSolution 4:");
        String myString = "This string contains double and  triple spaces";
        System.out.println(myString.indexOf("  "));
        System.out.println(myString.indexOf("   "));
    }
}
