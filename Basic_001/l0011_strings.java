import java.util.*;
public class l0011_strings{
    public static Scanner scn = new Scanner(System.in);

    public static boolean ispalindrome(String str){
        int si = 0;
        int ei = str.length()-1;
        while(si<ei){
          if(str.charAt(si)!=str.charAt(ei))
          return false;

          si++;
          ei--;
        }
        return true;
    }

    public static void allPalindrome(String str){
        int si= 0 , ei = str.length()-1;
        
    }

    public static void main(String[] args){

        // String str = "jaskirat singh";
        // String str1= "aaa";
        // String str2 = str1+str;
        // System.out.println(str2);
        // str+="abc";
        // System.out.println(str);
        String str = scn.next();  // do read carefully. it is scn.next() not nextInt()

        boolean palindrome = ispalindrome(str);
        System.out.println(palindrome);

    }
}