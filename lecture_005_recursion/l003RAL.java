import java.util.*;
public class l003RAL{

    public static Scanner scn = new Scanner(System.in);

    public static ArrayList<String> subsequence(String str){
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = str.charAt(0);
        ArrayList<String> recAns = subsequence(str.substring(1));

        ArrayList<String> myAns = new ArrayList<>(recAns);
        for(String s : recAns){
            myAns.add(ch+s);
        }

        // can also write like
        // ArrayList<String> myAns = new ArrayList<>();
        // for(String s : recAns){
        //     myAns.add(s);
        //     myAns.add(ch+s);
        // }

        return myAns;
    }

    public static void main(String[] args){
        System.out.println(subsequence("abcd"));
    }
}