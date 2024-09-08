public class Break_Continue {
    public static void main(String[] args) {
        // Break using loops!
       for (int i=0;i<50;i++){
           System.out.println(i);
           System.out.println("Java is great");
           if(i==2){
               System.out.println("Ending the loop");
               break;
           }
       }

        // Continue using loops!
           for(int i=0;i<50;i++){
           if(i==2){
               System.out.println("Ending the loop");
               continue;
           }
               System.out.println(i);
               System.out.println("Java is great");
       }
       
    }
}
