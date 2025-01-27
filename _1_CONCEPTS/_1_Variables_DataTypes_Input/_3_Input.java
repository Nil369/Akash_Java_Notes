import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _3_Input {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {

        // Method 1: using read:-

        // System.out.println("Enter a number");
        // int num = System.in.read(); // this methods throws a IO Exception so we used thorws IO Exception & imported it
        // System.out.println(num); // This returns the ASCII value of the numbers & characters 
        // System.out.println(num - 48); here we are subtracting the ASCII value of 0 to get the actual value
        // read method only reads a single character...Thus JAVA gives other 2 class for taking input 


        // Method 2: using BufferedReader:-        
        System.out.println("Enter a number");

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bf =  new BufferedReader(in); 
        // BufferedReader can input other things also like Files, Network Request
        // Note this BufferedReader takes input as String so we need to convert it to Integer
        int input = Integer.parseInt(bf.readLine());
        System.out.println("Your num is: "+input);
        bf.close();


        // Method 3: using Scanner class (RECOMMENDED):-
        System.out.print("\nEnter your name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Hello, " + name);

        System.out.println("\nAdding 2 numbers, Taking Input from the user");
        System.out.print("Enter the first number: ");
        int a = sc.nextInt();
        System.out.print("Enter the second number: ");
        int b = sc.nextInt();
        System.out.println("The sum is = " + (a + b));

        // closing the scanner object:
        sc.close();

        //NOTE: If you close Scanner and then try to use System.in again,
        // it will throw an error because closing Scanner also closes the
        // underlying System.in stream.
    }

}
