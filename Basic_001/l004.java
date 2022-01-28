import java.util.*;

public class l004{
    public static Scanner scn = new Scanner(System.in);

    public static void squarePrint(int n){
        int nst =n;  // no. of stars to be printed in first row
        //  for loop for pattern to be printed in how many rows
        for(int row =1 ; row <=n ; row++){
            for(int cst =1; cst<=nst;cst++){
                System.out.print("* ");   // inner for loop logic so that first row is printed correctly
            }
            // updation for printing the next row pattern
            nst = n;
            System.out.println();
        }
    }

    public static void trianglePrint(int n){
        int nst =1;
        for(int row =1 ; row <= n;row++){
            for(int cst =1 ; cst<=nst;cst++){
                System.out.print("*\t");
            }
            nst++;
            System.out.println();
        }
    }
    public static void reverseTriangle(int n){
        int nst = n;

        for(int row =1 ; row<=n; row++){
            for(int cst =1; cst<=nst;cst++){
                System.out.print("*\t");
            }
            nst--;
            System.out.println();
        }
    }

    public static void mirrorTriangle(int n){
        int nst = 1;
        int nsp = n-1;

        for(int row =1 ; row <=n; row++){

        for(int csp =1 ; csp<=nsp;csp++) System.out.print("\t");
        for(int cst=1 ; cst<=nst;cst++)  System.out.print("*\t");
       
        nst++;
        nsp--;
        System.out.println();
        
        }
    }

    public static void halfDiamond(int n){

        int nst = 1;
        int nsp = n-1;

        for(int row =1 ; row <= n ; row ++){
            for(int csp =1 ; csp <= nsp ; csp ++) System.out.print("\t");
            for(int cst =1 ; cst<= nst ; cst++) System.out.print("*\t");

            nst += 2;
            nsp--;
            System.out.println();
        }

    }

    public static void diamond(int n){

        int nst =1 ;
        int nsp = n/2;

        for(int row = 1; row <=n ;row++){
            for(int csp =1 ; csp <= nsp ; csp++) System.out.print("\t");
            for(int cst =1 ; cst<=nst ; cst++) System.out.print("*\t");

            if(row <= (n/2)){
                nst +=2;
                nsp--;
            }
            else{
                nst -= 2;
                nsp++;
            }
            System.out.println();
        }
    }

    public static void hollowDiamond(int n){
        int nst = n/2;
        int nsp = 1;

        for(int row =1 ; row <= n ; row ++){
            for(int cst = 1 ; cst <= nst ; cst++) System.out.print("*\t");
            for(int csp =1 ; csp <= nsp ; csp++) System.out.print("\t");
            for(int cst = 1 ; cst <= nst ; cst++) System.out.print("*\t");

            if(row<= (n/2)){
                nst--;
                nsp += 2;
            }
            else{
                nst++;
                nsp -= 2;
            }
            System.out.println();
            
        }
    }

    public static void numberDiamond1(int n){
        int nst = 1 ;
        int nsp = n/2 ;

        

        for(int row = 1; row <= n ; row ++){
            int val = row;
            for(int csp =1 ; csp <= nsp ; csp++) System.out.print("\t");
            for(int cst =1 ; cst<=nst;cst++ ) System.out.print(row + "\t");

            if(row<=n/2){
                nst +=2;
                nsp--;
            }
            else{
                nsp++;
                nst-=2;
            }
            System.out.println();
        }

    }
    
    public static void main(String[] args){
        int  n = scn.nextInt();
        // squarePrint(n);

        // trianglePrint(n);

        // reverseTriangle(n);

        // mirrorTriangle(n);

        // diamond(n);
        // halfDiamond(n);

        // diamond(n);

        // hollowDiamond(n);

        numberDiamond1(n);


    }
}