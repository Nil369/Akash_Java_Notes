public class _2_methodOverloading {

    static void tellJoke(){
        System.out.println("I invented a new word!\nPlagiarism!\n");
    }

    static void change(int a){
        a = 98;
    }

    static void changeArr(int [] arr){
        arr[0] = 98;
    }

    // Method Overloading: Methods having same name BUT, DIFFERENT PARAMETERS!
    static int multiply(int a,int b){
        return a*b;
    }
    static int multiply(int a,int b,int c){
        return  a*b*c;
    }


    public static void main(String[] args) {
        tellJoke();

        // Case 1: Changing the Integer
        int x = 45;
        change(x);
        System.out.println("The value of x after running change method is: " + x);

        // Case 2: Changing the Array
        int [] marks = {52, 73, 77, 89, 98, 94};
        changeArr(marks);
        System.out.println("The value of MARKS after running changeArr method is: " + marks[0]);


        // Method Overloading
        int c = multiply(5,4);
        int d = multiply(5,4,3);
        System.out.println(c);
        System.out.println(d);

        // Arguments are actual!
    }
}
