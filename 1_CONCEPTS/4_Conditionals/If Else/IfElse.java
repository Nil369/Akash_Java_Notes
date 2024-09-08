// the if-else statement is used to execute a block of code among 
// two or more alternatives based on a condition. The basic syntax is as follows:

/* 

if (condition) {
    // code to be executed if condition is true
} else {
    // code to be executed if condition is false
}

*/
import java.util.Scanner;

public class IfElse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number = ");
        int number = sc.nextInt();

        if (number > 0) {
            System.out.println("The number is positive.");
        } else if (number < 0) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }
    }
}
