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



        // pattern 6: Half Pyramid with numbers:

        System.out.println("Half Pyramid with numbers: ");
        n=5;
        for(int i=1;i<=n;i++){
            for(int j = 1; j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }



        // pattern 7: Inverted Half Pyramid with numbers:

        System.out.println("Inverted Half Pyramid with numbers: ");
        n=5;
        for(int i=n;i>=1;i--){
            for(int j = 1; j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }



        // pattern 8: Flyoid's Traingle:

        System.out.println("Flyoid's Traingle: ");
        n=5;
        int num = 1; 
        for(int i=1;i<=n;i++){
            for(int j = 1; j<=i;j++){
                System.out.print(num+" ");
                num++;
            }
            System.out.println();
        }


        // pattern 9: 1-0 Traingle:

        System.out.println("Printing 1-0 Traingle: ");
        n=5;
        for(int i=1;i<=n;i++){
            for(int j = 1; j<=i;j++){
                int sum = i+j;
                if(sum%2==0){//even
                    System.out.print("1 ");
                }else{//odd
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }

        
    }
}
