
import java.util.Scanner;

public class functions {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        // Problem 1: Make a function to check if a number is prime or not.
        if(isPrime(n)){
            System.out.println(n+" is Prime");
        }else{
            System.out.println(n+" is not a Prime number");
        }



        // Problem 2: Make a function to check if a given number n is even or not.
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if(isEven(num)){
            System.out.println(num+ " is an Even Number");
        }else{
            System.out.println(num+ " is a an Odd Number");
        }



        //Problem 3: Make a function to print the table of a given number n.
        System.out.print("Enter a number: ");
        num = sc.nextInt();

        printMultiplicationTable(num);


        // Problem 4: Write a function that calculates the Greatest Common Divisor of 2 numbers.
        System.out.print("Enter first number: ");
        int n1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int n2 = sc.nextInt();

        int gcd = findGCD(n1, n2);
        System.out.println("GCD is: " + gcd);


        // Problem 5: Write a program to print Fibonacci series of n terms where n is input by user
        System.out.print("Enter the number of terms: ");
        n = sc.nextInt();
        printFibonacci(n);

        sc.close();
    }



    public static boolean isPrime(int n){
        boolean val = true;
        if (n < 2) {
            System.out.println("This is neither prime nor composite");
        }

        for(int i = 2; i<= n/2; i++){
            if(n%i==0){
                val = false;
                break;
            }
        }
        return val;
    }


    public static boolean isEven(int n){
        return n%2==0;
    }


    public static void printMultiplicationTable(int num){
        for(int i=1;i<=12;i++){
            System.out.printf("%d x %d = %d\n",num,i,num*i);
        }
    }

    // Function to calculate GCD using Euclidean Algorithm
    public static int findGCD(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a; // or return b; both are the same at this point
    }

    // Function to print Fibonacci series up to n terms
    public static void printFibonacci(int n) {
        int a = 0, b = 1;
        System.out.print("Fibonacci Series: " + a);

        if (n > 1) {
            System.out.print(" " + b);
            for (int i = 2; i < n; i++) {
                int next = a + b;
                System.out.print(" " + next);
                a = b;
                b = next;
            }
        }
        System.out.println(); // Move to the next line
    }
}
