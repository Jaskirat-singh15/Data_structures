import java.util.*;

public class l003 {

  public static Scanner scn = new Scanner(System.in);

  public static int countDigits(int n) {
    int count = 0;
    while (n != 0) {
      n /= 10;
      count++;
    }
    return count;
  }

  public static void printDigitsInReverse(int n) {
    int rem;
    while (n != 0) {
      // % modulus operator gives us the rem
      rem = n % 10;
      n /= 10;
      System.out.println(rem);
    }
  }

  public static int power(int n) {
    // here we divide the number by 10 once so that pow doesnot reach 10^9 because that
    // will not be able to store in integer and we need to get the power 10^8 i.e. one less
    // than the number of digits
    n /= 10;
    int pow = 1;
    while (n != 0) {
      pow *= 10;
      n /= 10;
    }
    return pow;
  }

  public static void printDigitsOfANumber(int n) {
    int pow = power(n);

    while (pow != 0) {
      System.out.println(n / pow);
      n %= pow;
      pow /= 10;
    }
  }

  public static int rotateANumber(int n, int r) {
    int length = countDigits(n);

    if (r > 0)  r %= length; 
    
    else if (r < 0) 
     r = (r % length) + length;
    
    int div = 1;
    int mul = 1;
    
    for (int i = 1; i <= length; i++) {
      if (i <= r) {
        div *= 10;
      } else {
        mul *= 10;
      }
    }

    int a = n % div;
    int b = n / div;

    int ans = (a * mul) + b;
    return ans;
  }

  public static boolean pythagoreanTriplet_01(int a, int b , int c){
      int max = Math.max(Math.max(a,b),c);
      if(max == a && (b*b + c*c == a*a)) return true;
      else if(max ==b && (a*a + c*c == b*b)) return true;
      else if(max ==c && (a*a + b*b == c*c)) return true;
      else return false;
  }
  public static boolean pythagoreantriplet_02(int a, int b , int c){
      return ((a*a + b*b == c*c)||(b*b + c*c == a*a)||(a*a + c*c == b*b));
  }

  public static void main(String[] args) {
    int n = scn.nextInt();
    // System.out.println(countDigits(n));

    //printDigitsInReverse(n);

    // printDigitsOfANumber(n);

    System.out.println(rotateANumber(n, -2));
    System.out.println(rotateANumber(n, -12));
    System.out.println(rotateANumber(n, -99));
  }
}
