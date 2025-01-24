public class _1_Arrays{
    @SuppressWarnings("unused")
    public static void main(String[] args){

        // Arrays can be created using 3 main ways:

        // 1. Array declaration & memory allocation:
        int [] marks = new int[5];
        marks[0] = 30;
        marks[1] = 60;
        marks[2] = 70;
        marks[3] = 90;
        marks[4] = 98;
        // marks[5] = 100; -> throws OutofBound Error
        System.out.print("From marks Array: "+marks[4]);

        // 2. Array declaration & then memory allocation:
        int [] studMarks;
        studMarks = new int[5];

        // 3. Array declaration, memory allocation and initialization all together
        int [] studentMarks = {60,80,90,100,95};
        System.out.println("\n\nFrom studentMarks Array: "+studentMarks[0]);
        System.out.printf("From studentMarks Array: %d",studentMarks[4]);
        

        
    }
}