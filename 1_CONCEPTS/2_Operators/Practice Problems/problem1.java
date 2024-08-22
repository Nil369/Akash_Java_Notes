public class problem1 {

    @SuppressWarnings("unused") 
    public static void main(String[] args) {

        // Problem 1: Calculate the result of the expression
        float a = 7 / 4 * 9 / 2;
        System.out.println("The result of the expression 7 / 4 * 9 / 2 is: " + a);

        // Problem 2: Encrypt a grade by adding 8 and then decrypt it
        int grade = 85; // Example grade
        int encryptedGrade = grade + 8;
        int decryptedGrade = encryptedGrade - 8;
        System.out.println("Encrypted grade: " + encryptedGrade);
        System.out.println("Decrypted grade: " + decryptedGrade);

        // Problem 3: Compare numbers
        int userEnteredNumber = 50; // Example user-entered number
        int givenNumber = 45; // Example given number
        boolean isGreater = givenNumber > userEnteredNumber;
        System.out.println("Is " + givenNumber + " greater than " + userEnteredNumber + "? " + isGreater);

        // Problem 4: Expression (v^2 - u^2) / 2as
        // Assuming v, u, a, and s are given values
        int v = 10; // Example value
        int u = 5;  // Example value
        int aValue = 2; // Example value for 'a'
        int s = 3; // Example value for 's'
        int result = (v * v - u * u) / (2 * aValue * s);
        System.out.println("The result of (v^2 - u^2) / (2 * a * s) is: " + result);

        // Problem 5: Find the value of 'a'
        int x = 7;
        int y = 7 * 49 / 7 + 35 / 7;
        System.out.println("The value of 'a' is: " + y);
    }
}
