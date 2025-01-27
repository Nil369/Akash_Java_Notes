public class _3_var_args {
    // varArgs is similar to Spread & Rest Operator in JavaScript && *args in Python
    // In this we can get all the values in the form of Array.
    // Which is a lot better than overloading same methods with 'n' no. of parameters!
    static int add(int... arr) {
        int result = 0;
        for (int a : arr) {
            result = result + a;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(add(1, 2));
        System.out.println(add(2, 3, 4));
        System.out.println(add(4, 5, 6));
    }
}
