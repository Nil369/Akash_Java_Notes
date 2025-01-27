public class _2_arrayTraversal {
    public static void main(String[] args){

        float [] studMarks = {98.5f, 45.5f, 79.5f, 99.5f, 80.5f};
        String [] students ={"Akash", "Shruti", "Golu", "Luv"};
        System.out.println(students.length);
        System.out.println(studMarks[0]);


        int [] marks = {90,70,95,85,80};

        // 1. Printing the elements using (Naive Way):
        System.out.println("\nPrinting elements using Naive Way: ");
        System.out.println(marks[0]);
        System.out.println(marks[1]);
        System.out.println(marks[2]);
        System.out.println(marks[3]);
        System.out.println(marks[4]); // If we were going to print one-by-one then why did you used Array??


        // 2. Printing elements using For Loop (Recommedend/Standard):
        System.out.println("\nPrinting elements using For Loop: ");

        for(int i=0;i<marks.length;i++){
            System.out.println(marks[i]);
        }

        // 3. Printing elements in Reverse Order:
        System.out.println("\nPrinting elements in Reverse Order: ");
        
        for(int i = marks.length-1; i >= 0; i--){
            System.out.println(marks[i]);
        }

        // 4. Printing Array Elements using For-Each Loop: 
        System.out.println("\nPrinting elements using for-each: ");

        for(int elem : marks){
            System.out.println(elem);
        }
        // This loop is used when we don't care about the index.
        // We just need the content inside the array 

    }
}
