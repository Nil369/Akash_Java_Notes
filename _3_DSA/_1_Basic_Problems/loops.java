
import java.util.Scanner;

public class loops {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {

        // Problem 1: Print all even numbers till n.
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        System.out.println("Even No. till n is: ");
        for(int i = 1; i <= n; i++){
            if(i%2==0){
                System.out.print(i +" ");
            }
        }


        /* Problem 2: Run these loop on your system and analyze what happens.
            for(; ;) {
                System.out.println("Hello Akash");
            }
        Try to think of the reason for the output produced.*/
        
        // This will turn into an infite loop as no terminating condition is given
        
        
        // Problem 3: 
        /*
        Make a menu driven program. The user can enter 2 numbers, either 1 or 0. 
        If the user enters 1 then keep taking input from the user for a student’s marks(out of 100). 
            If they enter 0 then stop.
            If he/ she scores :
            Marks >=90 -> print “This is Good”
            89 >= Marks >= 60 -> print “This is also Good”
            59 >= Marks >= 0 -> print “This is Good as well”
        Because marks don’t matter but our effort does.
        */

        int input;

        do { 
            System.out.println("\nEnter your Marks: ");
            int marks = sc.nextInt();

            if(marks >= 90 && marks <= 100) {
                System.out.println("This is Good");
            } else if(marks >= 60 && marks <= 89) {
                System.out.println("This is also Good");
            } else if(marks >= 0 && marks <= 59) {
                System.out.println("This is Good as well");
            } else {
                System.out.println("Invalid");
            }

            
            System.out.println("Want to continue ? (yes(1) or no(0))");
            input = sc.nextInt();

        } while (input == 1);



        // Problem 4: Print if a number n is prime or not (Input n from the user). 
        
        System.out.println("Enter a number: ");
        int userInput = sc.nextInt();
        boolean isPrime = true;

        if (userInput < 2) {
            System.out.println("This is neither prime nor composite");
            // Exit early for 1 and negative numbers
        }

        for(int i = 2; i<= userInput/2; i++){
            if(userInput%i==0){
                isPrime = false;
                break;
            }
        }

        /* Optimised Approach -> Instead of checking up to userInput / 2, we can check only up to √(userInput).
        Why? Because any composite number must have at least one factor ≤ its square root.

            Factors of 36:
            1 × 36
            2 × 18
            3 × 12
            4 × 9
            6 × 6  ← √36
        The largest factor before repeating is 6, which is √36.
        This means we only need to check up to 6, instead of 18.

        Loop from 2 to sqrt(userInput) -> i*i <= userInput

        for(int i = 2; i * i <= userInput; i++) {
            if(userInput % i == 0) {
                isPrime = false;
                break;
            }
        }

        */

        if (isPrime) {
            System.out.println("This is a prime number");
            
        }else{
            System.out.println("This is not a prime number");
        }

        sc.close();

    }

}
