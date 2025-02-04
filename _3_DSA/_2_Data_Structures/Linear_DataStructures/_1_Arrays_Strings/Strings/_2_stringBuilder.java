public class _2_stringBuilder {
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

    }
}
