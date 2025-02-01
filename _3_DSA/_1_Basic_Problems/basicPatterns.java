public class basicPatterns {
    public static void main(String[] args) {

        // pattern 1: Solid Rectangle    
        int n = 4;
        int m = 5;

        System.out.println("Solid Rectangle: ");
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                System.out.print("*");
            }
            System.out.println();
        }



        // pattern 2: Hollow Rectangle:
        System.out.println("Hollow Rectangle: ");
        for(int i=1;i<=n;i++){
            for(int j= 1;j<=m;j++){
                if (i==1||i==n|| j==1 || j==m) {
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }



        // pattern 3: Half Pyramid:

        System.out.println("Half Pyramid: ");
        for(int i=1;i<=n;i++){
            for(int j = 1; j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }


        
        // pattern 4: Inverted Half Pyramid:

        System.out.println("Inverted Half Pyramid: ");
        for(int i=n;i>=1;i--){
            for(int j = 1; j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }



        // pattern 5: Half Pyramid(rotated by 180 deg):

        System.out.println("Half Pyramid(rotated by 180 deg): ");
        for(int i=1;i<=n;i++){
            // Inner Loop -> space        
            for(int j=1; j<=n-i; j++) {
                System.out.print(" ");
            }

            // Inner Loop -> star
            for(int j = 1; j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
