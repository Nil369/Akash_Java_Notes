package methods_practice;
/*
1.Write a Java method to print the multiplication table of a number n.
2. Write a program using functions to print the following pattern:
      *
     **
    ***
   ****

3. Write a recursive function to calculate the sum of first n natural numbers.
4. Write a function to print the following pattern:
    ****
    ***
    **
    *

5. Write a function to print the nth term of the Fibonacci series using recursion.
6. Write a function to find the average of a set of numbers passed as arguments.
7. Write a function to convert Celsius temperature into Fahrenheit.
*/

public class _7_methods {
    static void multiplicationTable(int n){
        System.out.printf("*********** Multiplication table of %d ***********\n",n);
        for(int i=1; i<=12; i++){
            System.out.printf("%d X %d = %d\n",n,i,n*i);
        }
        System.out.println("**********************");
    }

    static void pattern1(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static int sumOfNaturalNum(int n) {
        // Base condition
        if (n == 1) {
            return 1;
        }
        return n + sumOfNaturalNum(n - 1);
    }

    static int fib(int n) {
        /* if(n==1){
            return 0;
        }
        else if(n==2){
            return 1;
        } */
        if (n == 1 || n == 2) {
            return n - 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    static void printPattern2(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static int avgNum(int ...arr){
        int sum = 0,avg;
        for(int elem:arr){
            sum+=elem;
        }
        avg = sum/arr.length;
        return avg;
    }

    static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static void main(String[] args) {
        //solution1:
        multiplicationTable(7);

        //solution2:
        pattern1(5);

        //solution3:
        int sum = sumOfNaturalNum(10);
        System.out.println("Sum of n natural numbers is: "+sum);

        // Solution 4:
        printPattern2(3);

        // Solution 5:
        // fibonacci series - 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
        int result = fib(7);
        System.out.println("Fibonacci Series nth term :"+result);

        // Solution 6:
        System.out.println("Average number: "+avgNum(1,2,3,4,5));

        //solution 7:
        System.out.println("Celsius to Fahrenheit Conversion: "+celsiusToFahrenheit(32.6));
    }
}
