
import java.util.Scanner;

public class _2_stringBuilder {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {

        // String Builder is a mutable datatype in Java that points to the same
        // Heap Memory & makes changes in the same string making it mutable

        StringBuilder sb = new StringBuilder("Tony Stark");
        System.out.println("\n"+sb);

        // getting a char from Index:
        System.out.println(sb.charAt(0));

        // Set a Character at Index
        sb.setCharAt(0, 'P');
        System.out.println(sb);


        // Insert a Character at Some Index
        sb = new StringBuilder("tony");
        sb.insert(0, 'S');
        System.out.println(sb);


        //delete char at some Index
        sb.delete(0, 1);
        System.out.println(sb);


        // appending:
        sb.append(" Stark");
        System.out.println(sb);

        // print length of String
        System.out.println(sb.length());



        // Q1. Reverse a String using String Builder
        StringBuilder str = new StringBuilder("hello");
        System.out.println("Reversing a string: "+str);
        for(int i=0;i<str.length()/2;i++){
            int front = i;
            int back = str.length() - i - 1;

            char frontChar = str.charAt(front);
            char backChar = str.charAt(back);

            str.setCharAt(front, backChar);
            str.setCharAt(back, frontChar);
        }
        System.out.println(str);




        // PRACTICE QUESTIONS:
        // Q1: Find cumulative length of all strings in an array
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the Array: ");
        int size = sc.nextInt();
        sc.nextLine(); // Consume newline
        String[] namesArr = new String[size];

        int res = inputArray(namesArr, size, sc);
        System.out.println("Combined length of those Strings: " + res);

        // Q2: Replace 'e' with 'i' in a given string using StringBuilder
        System.out.print("Enter a String: ");
        String org = sc.nextLine();
        String result = replaceCharacter(org, 'e', 'i');
        System.out.println("Result: " + result);

        // Q3: Extract username from email (before '@') using StringBuilder
        System.out.print("Enter your Email: ");
        String email = sc.next();
        String userName = extractUsername(email);
        System.out.println("User Name: " + userName);

        sc.close(); // Close scanner

    }

    public static int inputArray(String[] arr, int size, Scanner sc) {
        int totalLength = 0;
        System.out.println("Enter " + size + " strings:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextLine();
            totalLength += arr[i].length();
        }
        return totalLength;
    }

    public static String replaceCharacter(String str, char oldChar, char newChar) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == oldChar) {
                sb.setCharAt(i, newChar);
            }
        }
        return sb.toString();
    }

    public static String extractUsername(String email) {
        StringBuilder username = new StringBuilder();
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                break;
            }
            username.append(email.charAt(i)); // Append characters before '@'
        }
        return username.toString();
    }
}
