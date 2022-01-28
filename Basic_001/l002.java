import java.util.*;

public class l002 {

  public static Scanner scn = new Scanner(System.in);

  public static boolean isEven(int num) {
    if (num % 2 == 0) return true; else return false;
  }

  public static void solve() {
    int n = scn.nextInt();
    boolean res = isPrime(n);
    if (res == true) 
         System.out.println("prime");
    else  System.out.println("not prime");
  }

  public static void allPrime(int low , int high){
      for(int i = low ; i<=high ; i++){
          boolean res = isPrime(i);
         if(res == true)
         System.out.println(i);
      }
  }

  public static boolean isPrime(int num) {  // optimized
    for (int i = 2; i*i <= num; i++) {
      if (num % i == 0) return false;
    }
    return true;
  }
//   public static boolean isPrime(int num) {  not optimized
//     for (int i = 2; i < num; i++) {
//       if (num % i == 0) return false;
//     }
//     return true;
//   }

  public static void main(String[] args) {
    int num = scn.nextInt();
    boolean res = isEven(num); // catching the result returned by the function
    System.out.println(res);
    //System.out.println(isEven(num));  this produces the same output
    // the functio is called and the answer is returned to syso statemnet which converts it into string and prints it

    // for prime number
    // in this question we have to input n number t number of times .
    // so we will solve such questions always by making a solve function and writing the logic there
    // and here we will execute that function t number of times
   
   
    // int t = scn.nextInt(); // number of inputs
    // for (int i= 0; i < t; i++) {
    //   solve();
    // }

     allPrime(2,100);

  }
}
