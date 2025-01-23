import java.util.Scanner;

public class Input {

    public static void main(String[] args) {

        System.out.print("Enter your name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Hello, " + name);


        System.out.println("\nAdding 2 numbers, Taking Input from the user");
        System.out.print("Enter the first number: ");
        int a = sc.nextInt();
        System.out.print("Enter the second number: ");
        int b = sc.nextInt();
        System.out.println("The sum is = "+(a+b));

        // closing the scanner object:
        sc.close();

        //NOTE: If you close Scanner and then try to use System.in again,
        // it will throw an error because closing Scanner also closes the
        // underlying System.in stream.

    }

}
