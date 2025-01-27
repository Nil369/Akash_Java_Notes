class InsufficientBalanceException extends Exception {
    @Override
    public String toString() {
        return "Insufficient balance in your account!";
    }

    @Override
    public String getMessage() {
        return "You do not have enough balance to complete this transaction.";
    }
}

public class _5_throwVsThrows {
    public static void withdraw(double balance, double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            // Using throw to explicitly create and throw an exception
            throw new InsufficientBalanceException();
        }
        System.out.println("Transaction successful! Remaining balance: " + (balance - amount));
    }

    public static double calculateInterest(double balance, int rate) throws ArithmeticException {
        // `throws` indicates that this method might throw ArithmeticException
        if (rate == 0) {
            throw new ArithmeticException("Interest rate cannot be zero!");
        }
        return (balance * rate) / 100;
    }

    public static void main(String[] args) {
        double accountBalance = 1000.0;

        try {
            withdraw(accountBalance, 1500.0);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage()); // Handle the custom exception
        }

        try {
            double interest = calculateInterest(accountBalance, 5);
            System.out.println("Interest earned: " + interest);

            double invalidInterest = calculateInterest(accountBalance, 0);
            System.out.println("Interest earned: " + invalidInterest);
            
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage()); 
        }
    }
}
