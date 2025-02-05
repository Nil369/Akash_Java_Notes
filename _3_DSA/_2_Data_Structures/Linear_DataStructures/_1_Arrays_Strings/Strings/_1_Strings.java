import java.util.Scanner;

public class _1_Strings {
    @SuppressWarnings({"StringEquality", "RedundantStringConstructorCall", "ConvertToTryWithResources"})
    public static void main(String[] args) {

        String firstName = "Akash";
        String lastName = "Halder";

        String fullName = firstName + " " + lastName;
        System.out.println("\nFull Name: " + fullName);
        System.out.println("Full Name Length: " + fullName.length());

        for (int i = 0; i < fullName.length(); i++) {
            System.out.println(fullName.charAt(i));
        }



        // Comparing Strings:
        String name1 = "Tony";
        String name2 = "Tony";

        if (name1.equals(name2)) {
            System.out.println("They are the same string");
        } else {
            System.out.println("They are different strings");
        }


        // DO NOT USE == to check for string equality
        // Gives correct answer here
        if (name1 == name2) {
            System.out.println("They are the same string");
        } else {
            System.out.println("They are different strings");
        }

        // Gives incorrect answer here
        if (new String("Tony") == new String("Tony")) {
            System.out.println("They are the same string");
        } else {
            System.out.println("They are different strings");
        }



        // Substrings:
        String name = "AkashHalder";
        System.out.println(name.substring(0,5));


        
        // Parsing:
        // 1. ParseInt Method of Integer Class
        String str = "123";
        int num = Integer.parseInt(str);
        System.out.println(num);

        // 2. toString Method of String class
        int number = 1234;
        String str1 = Integer.toString(number);
        System.out.println(str1);




        // Practice Questions:
        // Q1: Take an array of Strings input from the user & find the cumulative(combined) length of all those strings.
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the Array: ");
        int size = sc.nextInt();
        String [] namesArr = new String[size];
        int res = inputArray(namesArr, size, sc);
        System.out.println("Combined length of those Strings are: "+res);


        // Q2. Input a string from the user. Create a new string called ‘result’ in which you will replace the
        // letter ‘e’ in the original string with letter ‘i’. Ex: original = “eabcdef’ ; result = “iabcdif”
        System.out.println("Enter a String: ");
        String org = sc.next();
        String result = "";

        for(int i=0;i<org.length();i++){
            if (org.charAt(i)=='e') {
                result += org.replace('e', 'i');
                break;                
            }
        }

        System.out.println("Result: "+result);


        /* Q3. Input an email from the user. You have to create a username from the email by deleting the part that comes after ‘@’. Display that username to the user. 
        Ex : email = “helloWorld123@gmail.com”; username = “helloWorld123” */ 
        System.out.print("Enter your Email: ");
        String email = sc.next();
        String userName = "";

        for(int i=0;i<email.length();i++){
            if(email.charAt(i) == '@'){
                break;
            }else{
                userName += email.charAt(i);
            }
        }
        System.out.println("User Name: "+userName);

        sc.close();

    }

    public static int inputArray(String[] arr, int size, Scanner sc) {
        int toLength = 0;
        System.out.println("Enter " + size + " strings:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.next(); 
            toLength+=arr[i].length();
        }
        return toLength;
    }
}