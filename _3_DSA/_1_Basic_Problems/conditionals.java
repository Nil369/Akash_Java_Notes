import java.util.Scanner;

public class conditionals {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        // Problem 1: Write a Menu driven Program in Java to Perform Addition, Subtraction, Multiplication, Division & Modulo Operation
        System.out.println("****** Calculator App: ******");
        System.out.println("1. Add\n2. Substract\n3. Multiply\n4. Divide\n5. Modulo");
        Scanner sc = new Scanner(System.in);

        int num1, num2, op;
        System.out.print("Enter 1st number: ");
        num1 = sc.nextInt();
        System.out.print("Enter 2nd number: ");
        num2 = sc.nextInt();
        System.out.print("Enter The operation you want to perform:  ");
        op = sc.nextInt();

        switch (op) {
            case 1-> System.out.println("Result: "+(num1+num2));
            case 2-> System.out.println("Result: "+(num1-num2));
            case 3-> System.out.println("Result: "+(num1*num2));
            case 4-> {
                if(num2 == 0) {
                    System.out.println("Invalid Division");
                } else {
                    System.out.println("Result: "+(num1/num2));
                }
            }
            case 5-> {
                if(num2 == 0) {
                    System.out.println("Invalid Division");
                } else {
                    System.out.println("Result: "+(num1%num2));
                }
            }
            default-> System.err.println("Invalid Choice!! Enter from the above menu");
        }


        sc.close();

    }
}