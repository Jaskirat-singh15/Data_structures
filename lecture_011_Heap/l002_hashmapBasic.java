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

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(map.containsKey(ch))
                map.put(ch,map.get(ch) + 1);
            else 
            map.put(ch, 0+1 ); 
        }

        System.out.println(map);
    }
    
    public static void main(String[] args){

        // HashMapBasic();
        String str = scn.next();
        frequency(str);

    }
}