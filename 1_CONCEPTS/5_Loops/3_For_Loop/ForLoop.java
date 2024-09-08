public class ForLoop {
    public static void main(String[] args) {

                System.out.println("1st for loop running...");
               for (int i=1; i<=10; i++){
                   System.out.println(i);
               }

                // 2i = Even Numbers = 0, 2, 4, 6, 8
                // 2i+1 = Odd Numbers = 1, 3, 5, 7, 9

                int n = 3;
                System.out.println("2nd for loop running...");
                for (int i =0; i<n; i++){
                   System.out.println(2*i+1);
                }
                System.out.println("3rd for loop running...");
                for(int i=5; i!=0; i--){
                    System.out.println(i);
                }
            }
}
