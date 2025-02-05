
import java.util.Scanner;

public class bitManipulation {

    public static void main(String[] args) {

        // Get Bit:
        int n = 5; //0101
        int pos = 3;
        int bitMask = 1 << pos;

        if ((bitMask & n) == 0) {
            System.out.println("bit was zero");
        } else {
            System.out.println("bit was one");
        }


        // Set Bit:
        n = 5;
        pos = 1;
        bitMask = 1 << pos;
        int newNum = bitMask | n;
        System.out.println(newNum);


        // Clear Bit:
        n = 5; //0101
        pos = 2;
        bitMask = 1 << pos;
        int newBitMask = ~(bitMask);
        int newNumber = newBitMask & n;
        System.out.println(newNumber);


        // Update Bit:
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int oper = sc.nextInt();
        // oper=1 -> set; oper=0 -> clear
        n = 5;
        pos = 1;
        bitMask = 1 << pos;

        if (oper == 1) {
            //set
            int num = bitMask | n;
            System.out.println(num);
        } else {
            //clear
            newBitMask = ~(bitMask);
            int NewNum = newBitMask & n;
            System.out.println(NewNum);
        }
        


        // PRACTICE QUESTIONS:
        // Q1: Check if a number is a power of 2
        System.out.print("Enter a number to check if it's a power of 2: ");
        int num = sc.nextInt();
        System.out.println(num + " is a power of 2: " + isPowerOfTwo(num));

        // Q2: Toggle a bit at a given position
        System.out.print("Enter a number: ");
        n = sc.nextInt();
        System.out.print("Enter position to toggle (0-based index): ");
        pos = sc.nextInt();
        System.out.println("Number after toggling bit at position " + pos + ": " + toggleBit(n, pos));

        // Q3: Count the number of 1s in binary representation
        System.out.print("Enter a number to count set bits: ");
        int bitNum = sc.nextInt();
        System.out.println("Number of 1's in binary: " + countSetBits(bitNum));

        // Q4: Decimal to Binary conversion
        System.out.print("Enter a decimal number to convert to binary: ");
        int dec = sc.nextInt();
        System.out.println("Binary representation: " + decimalToBinary(dec));

        // Q5: Binary to Decimal conversion
        System.out.print("Enter a binary number to convert to decimal: ");
        String bin = sc.next();
        System.out.println("Decimal representation: " + binaryToDecimal(bin));

        sc.close();

    }

    // Function to check if a number is a power of 2
    public static boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }

    // Function to toggle a bit at a given position
    public static int toggleBit(int n, int pos) {
        return n ^ (1 << pos);
    }

    // Function to count number of 1's in binary representation
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    // Function to convert decimal to binary
    public static String decimalToBinary(int n) {
        StringBuilder binary = new StringBuilder();
        while (n > 0) {
            binary.append(n % 2);
            n /= 2;
        }
        return binary.reverse().toString();
    }

    // Function to convert binary to decimal
    public static int binaryToDecimal(String binary) {
        int decimal = 0;
        int length = binary.length();
        for (int i = 0; i < length; i++) {
            if (binary.charAt(length - 1 - i) == '1') {
                decimal += Math.pow(2, i);
            }
        }
        return decimal;
    }
}
