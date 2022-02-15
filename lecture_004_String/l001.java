import java.util.*;
public class l001 {

  public static Scanner scn = new Scanner(System.in);

  public static boolean isPalindrome(String str, int si, int ei) {
    while (si < ei) {
      if (str.charAt(si) != str.charAt(ei)) return false;

      si++;
      ei--;
    }

    return true;
  }

  public static void printAllPalindromicSubString(String str) {
      for(int i = 0 ; i<str.length(); i++){
          for(int j = i; j<str.length(); j++){
              if(isPalindrome(str,i,j)){
                  System.out.println(str.substring(i,j+1));  // j+1 because ending index not incuded in substring function
              }
          }
      }
  }

  // sir method  (same only)
   public static void printAllPalindromicSubString_(String str) {
        int n = str.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(str, i, j)) {
                    String s = str.substring(i, j + 1);
                    System.out.println(s);
                }
            }
        }
    }

    // string compression 1 on pepcoding site // here we are counting the changes as well(not required on portal) 
    public static void removeDuplicates(String str){
        if(str.length() == 0)
            return;
        
        int n = str.length();
        String ans = str.charAt(0) + "";  // we are adding empty string at the end to convert character to string.

        int i = 1;
        int changes = 0;
        while(i < n){
            while( (i < n) && ans.charAt(ans.length() - 1) == str.charAt(i)){
                i++;
            }

            changes++;
            if(i<n)
                ans += str.charAt(i);
            i++;
        } 
        System.out.println(ans);
    }

    // string compression 2 on portal
     public static void removeDuplicates_2(String str){
        if(str.length() == 0)
            return;
        
        int n = str.length();
        String ans = str.charAt(0) + "";  

        int i = 1;
        int changes = 0, count = 0;
        while(i < n){
            count = 1; // beacuse we have added one cahracter already
            while( (i < n) && ans.charAt(ans.length() - 1) == str.charAt(i)){
                count++;
                i++;
            }

            changes++;
            if(count > 1){
                ans += count;
            }
            if(i<n){
                ans += str.charAt(i);
            }
            i++;
        } 
        System.out.println(ans);
    }

    public static int countOfHi(String str){

        int n = str.length();
        int i = 0, count = 0;
        while(i < n){
            if( i< n-1 && str.charAt(i) == 'h' && str.charAt(i+1) == 'i'){
                count++;
                i+= 2;
            }
            else
                i++;
            
        } 
        return count;
    }

    // just count hi, dont count hi whih is substring of hit
    public static int countHiWithoutHit(String str) {
        int n = str.length();
        int i = 0, count = 0;
        while (i < n - 1) {
            if (str.charAt(i) == 'h' && str.charAt(i + 1) == 'i') {
                if (i + 2 < n && str.charAt(i + 2) == 't') {
                    i += 3;
                } else {
                    count++;
                    i += 2;
                }
            } else
                i++;
        }

        return count;
    }

  public static void main(String[] args) {
    //   String str = "aaabbcccceeeeeghheeiii";
    //   System.out.println(isPalidrome(str,0,str.length()-1));

    // printAllPalindromicSubString(str);

    // removeDuplicates(str);
    // removeDuplicates_2(str);

    String s = "hi hit hihithithi";
    System.out.println(countOfHi(s));

    System.out.println(countHiWithoutHit(s));


  }
}
