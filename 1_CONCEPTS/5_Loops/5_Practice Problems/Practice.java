/*
Question 1: Write a program to print the following pattern :

****

***

**

*
 
Question 2: Write a program to sum first n even numbers using a while loop.

Question 3: Write a program to print the multiplication table of a given number n.

Question 4: Write a program to print a multiplication table of 10 in reverse order.

Question 5: Write a program to find the factorial of a given number using for loops.

Question 6: Repeat problem 5 using a while loop.

Question 7: Repeat problem 1 using for/while loop.

Question 8: Write a program to calculate the sum of the numbers occurring in the multiplication table of 8.

Question 9: Repeat problem 2 using for loop.

*/




import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Question 1: Print pattern
        System.out.println("Question 1: Pattern:");
        for (int i = 4; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Question 2: Sum of first n even numbers using while loop
        System.out.println("\nQuestion 2: Sum of first n even numbers");
        System.out.print("Enter a value for n: ");
        int n = scanner.nextInt();
        int sum = 0, count = 0, num = 0;
        while (count < n) {
            if (num % 2 == 0) {
                sum += num;
                count++;
            }
            num++;
        }
        System.out.println("Sum of first " + n + " even numbers: " + sum);

        // Question 3: Print multiplication table of given number
        System.out.println("\nQuestion 3: Multiplication table of a given number");
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }

        // Question 4: Multiplication table of 10 in reverse order
        System.out.println("\nQuestion 4: Multiplication table of 10 in reverse order");
        for (int i = 10; i >= 1; i--) {
            System.out.println("10 x " + i + " = " + (10 * i));
        }

        // Question 5: Factorial using for loop
        System.out.println("\nQuestion 5: Factorial using for loop");
        System.out.print("Enter a number to find its factorial: ");
        int factNumber = scanner.nextInt();
        long factorial = 1;
        for (int i = 1; i <= factNumber; i++) {
            factorial *= i;
        }
        System.out.println("Factorial of " + factNumber + " is: " + factorial);

        // Question 6: Factorial using while loop
        System.out.println("\nQuestion 6: Factorial using while loop");
        factorial = 1;
        int temp = factNumber;
        while (temp > 0) {
            factorial *= temp;
            temp--;
        }
        System.out.println("Factorial of " + factNumber + " is: " + factorial);

        // Question 7: Repeat problem 1 using while loop
        System.out.println("\nQuestion 7: Pattern using while loop");
        int i = 4;
        while (i > 0) {
            int j = 0;
            while (j < i) {
                System.out.print("*");
                j++;
            }
            System.out.println();
            i--;
        }

        // Question 8: Sum of numbers in multiplication table of 8
        System.out.println("\nQuestion 8: Sum of numbers in multiplication table of 8");
        sum = 0;
        for (i = 1; i <= 10; i++) {
            sum += 8 * i;
        }
        System.out.println("Sum of numbers in the multiplication table of 8: " + sum);


        // Question 9: Repeat problem 2 using for loop
        System.out.println("\nQuestion 9: Sum of first n even numbers using for loop");
        sum = 0;
        count = 0;
        for (num = 0; count < n; num++) {
            if (num % 2 == 0) {
                sum += num;
                count++;
            }
        }
        System.out.println("Sum of first " + n + " even numbers: " + sum);
    }
}
