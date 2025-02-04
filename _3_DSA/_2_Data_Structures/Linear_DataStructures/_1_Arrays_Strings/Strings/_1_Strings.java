public class _1_Strings {
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


    }
}