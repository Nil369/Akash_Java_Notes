
import java.util.Scanner;

public class _4_Recursion {
    // factorial(0) = 1
    // factorial(n) = n * (n-1) *....1
    // Ex: factorial(5) = 5 * 4 * 3 * 2 * 1 = 120
    // factorial(n) = n * factorial(n-1)

    // Recursion is the process in which a function/method call itself recursively until a base condition is met!
    static int factorial(int n){
        if(n==0 || n==1){
            return 1;
        }
        else{
            return n * factorial(n-1);
        }
    }
    
    static int factorial_iterative(int n){
        if(n==0 || n==1){
            return 1;
        }
        else{
            int product = 1;
            for (int i=1;i<=n;i++){ // 1 to n
                product *= i;
            }
            return product;
        }
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        System.out.println("The value of factorial x is: " + factorial(userInput));
        System.out.println("The value of factorial x is: " + factorial_iterative(userInput));

        sc.close();

    }
}
