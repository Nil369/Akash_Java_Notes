import java.util.Scanner;

public class switchCaseEnhanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter an operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        // Enhanced switch-case
        switch (operator) {
            case '+' -> System.out.println("The sum is: " + (num1 + num2));
            case '-' -> System.out.println("The difference is: " + (num1 - num2));
            case '*' -> System.out.println("The product is: " + (num1 * num2));
            case '/' -> {
                if (num2 != 0) {
                    System.out.println("The division result is: " + (num1 / num2));
                } else {
                    System.out.println("Error! Division by zero is not allowed.");
                }
            }
            default -> System.out.println("Invalid operator!");
        }
    }
}
