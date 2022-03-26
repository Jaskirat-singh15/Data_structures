import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class l002_hashmapBasic{

    public static Scanner scn = new Scanner(System.in);

    public static void HashMapBasic(){
        // HashMap<key,value>

        HashMap<String,Integer> map = new HashMap<>();

        map.put("India",98);
        map.put("Uk",97);
        map.put("America",99);
        map.put("Australia",100);
        // does not contain duplicate, so it will update "Austrlia" key with VALUE 80
        map.put("Australia",80); 

        map.remove("Uk");// will remove uk from the hashmap

        System.out.println(map.get("India")); // will print value of this key only
        System.out.println(map.get("india")); // will print null if key doesnot exist

        // keep a check if key exist or not , only print if it exists
        if(map.containsKey("India")) // returns true or false
            System.out.println(map.get("India"));
        

        System.out.println(map); // will print all the key value pairs

        //other way to print
        ArrayList<String> keys = new ArrayList<>(map.keySet()); // will give a set of all keys to arrayist
        System.out.println(keys);

        // another way to print 3
        for(String key : map.keySet()){
            System.out.println(key + "->" + map.get(key));
        }


    }

     // thought on my own
     public static void frequency_(String str){
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < str.length(); i++){
            if(map.containsKey(str.charAt(i)) )
                map.put(str.charAt(i),map.get(str.charAt(i)) + 1);
            else
            map.put(str.charAt(i),1);
        }
        
        System.out.println(map);
    }
    
    //sir method 
    // same as i thought above 
    // sir just made it simplified by storing it in character ch
    public static void frequency(String str){
        HashMap<Character,Integer> map = new HashMap<>();

        // for(int i = 0; i < str.length(); i++){
        //     char ch = str.charAt(i);

        //     if(map.containsKey(ch))
        //         map.put(ch,map.get(ch) + 1);
        //     else 
        //     map.put(ch, 0+1 ); 
        // }

        // best method - used function getOrDefault
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }

        // not that good method becuse using put twice but possible
        // for(int i = 0; i < str.length(); i++){
        //     char ch = str.charAt(i);

        //     map.putIfAbsent(ch,0);
        //     map.put(ch,map.get(ch) + 1);
        // }

        // System.out.println(map);

        // if want to print without syso
        for(char ch : map.keySet() ){
            System.out.println(ch + " -> " + map.get(ch));
        }

        // on portal required to ptint the highest frequency character
        char mfc = str.charAt(0);
        for(char ch : map.keySet()){
            
            if(map.get(ch) > map.get(mfc) )
                mfc = ch;
            
        }
        System.out.println(mfc);
    }

    public static void IndexOfChar(String str){
        HashMap<Character,ArrayList<Integer>> map = new HashMap<>();

        // for(int i = 0; i<str.length(); i++){
        //     char ch = str.charAt(i);

        //     if(!map.containsKey(ch))
        //         map.put(ch,new ArrayList<>());

        //     map.get(ch).add(i);

        // }

        for(int i =0 ; i< str.length(); i++){
            char ch = str.charAt(i);
            map.putIfAbsent(ch,new ArrayList<>());
            map.get(ch).add(i);
        }

        // System.out.println(map);
         for(char ch : map.keySet() ){
            System.out.println(ch + " -> " + map.get(ch));
        }
        
    }

    public static void intersectionWithoutDuplicate(int[] arr1 , int[] arr2){
        HashMap<Integer, Integer > map = new HashMap<>();

       for(int ele : arr1){
           map.put(ele,map.getOrDefault(ele,0) + 1);
       }

       for(int ele : arr2){
           if(map.containsKey(ele)){
               System.out.println(ele);
               map.remove(ele);
           }
       }
    }

    public static void intersectionWithDuplicate(int[] arr1, int[] arr2){

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int ele : arr1){
            map.put(ele,map.getOrDefault(ele,0) + 1);
        }

        for(int ele : arr2){
            if(map.containsKey(ele)){
                System.out.println(ele);
                map.put(ele,map.get(ele) - 1);
                if(map.get(ele) == 0)
                    map.remove(ele);
            }
        }

    }

    public static void highestFreqCharacter(String str){
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }

        int maxfreq = 0;
        char ans = '\u0000'; // this code store null in character (always in single qoutes)
        for(char ch : map.keySet()){
            if(map.get(ch) > maxfreq){
                maxfreq = map.get(ch);
                ans = ch;
            }
        }

        System.out.println(ans);

    }
    
    public static void main(String[] args){

        // HashMapBasic();
        // String str = scn.next();

        // frequency(str);

        // IndexOfChar(str);

        int n1 = scn.nextInt();
    int[] arr1 = new int[n1];
    for(int i =0; i < n1 ; i++){
        arr1[i] = scn.nextInt();
    }
    int n2 = scn.nextInt();
    int[] arr2 = new int[n2];
    for(int i =0; i < n2 ; i++){
        arr2[i] = scn.nextInt();
    }
    
    intersectionWithoutDuplicate( arr1 ,  arr2);

    }
}