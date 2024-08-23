public class _2_stringMethods {
    public static void main(String[] args) {
        String name = "Akash";
        System.out.println(name);
        int value = name.length();
        System.out.println(value);

        String lstring = name.toLowerCase();
        System.out.println(lstring);

        String ustring = name.toUpperCase();
        System.out.println(ustring);

        String nonTrimmedString = "     Akash     ";
        System.out.println(nonTrimmedString);

        String trimmedString = nonTrimmedString.trim();
        System.out.println(trimmedString);

        System.out.println(name.substring(1));
        System.out.println(name.substring(1,5));

        System.out.println(name.replace('r', 'p'));
        System.out.println(name.replace("r", "ier"));

        System.out.println(name.startsWith("Har"));
        System.out.println(name.endsWith("dd"));

        System.out.println(name.charAt(4));

        String modifiedName = "Akashrryrry";
        System.out.println(modifiedName.indexOf("rry"));
        System.out.println(modifiedName.indexOf("rry", 4));
        System.out.println(modifiedName.lastIndexOf("rry", 7));

        //System.out.println(name.equals("Akash"));
        System.out.println(name.equalsIgnoreCase("AkaSH"));

        System.out.println("I am escape sequence\tdouble quote");
    }
}
