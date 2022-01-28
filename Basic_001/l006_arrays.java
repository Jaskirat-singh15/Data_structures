import java.util.*;
public class l006_arrays{
    public static Scanner scn = new Scanner(System.in);

    public static void test1(int n){
       // type[] arrayName = new type[size]  
        int[] arr = new int[n];
       
       // above we have decalred an array but not intialised so all the array 
       //location will have default value zero.
        for(int i=0 ; i< n ; i++){
            System.out.print(arr[i]+ " ");
        }
    }
    public static void display1(int[] arr){
        int n = arr.length;
        for(int i=0 ; i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void display2(int[] arr){
        int n = arr.length;
        // forEach loop 
        // 1. used for only get , if you try to set you get a beautifull error
        // 2.  ele increments by 1 automatically
        // 3. always in forward direction
        // 4. in range of loop :  [0,n-1]
        for(int ele : arr){
            System.out.print(ele + " ");
        }
    }

    public static void input1(int[] arr){
        int n = arr.length;   // pre-defined , gives size of array
        for(int i=0 ; i< n ; i++){
            arr[i] = scn.nextInt();
        }
    }
    public static int[] input2(int n){    
        // here we are returning array of int type i.e. our return type should be int[] instead of void
        int[] arr = new int[n];
        for(int i=0; i<n ; i++){
            arr[i] = scn.nextInt();
        }
        return arr;   // it should be catched in array type variable from where it was called(main function in this case)
    }
    
    
    // one way of doing is :
    // take the fisrt elemnt as max and then ompare with rest of the elments 
    // and set amx to that ele if it is greater then the curr value of max.
    // Note : handle test case if array size is 0
    // we will do this other way
    public static int maximum(int[] arr){
        int maxEle = -(int)1e9;   
        // Integer.MIN_VALUE => smallest value in java but not use this because we amke error 
        // while solving linklist question
        for(int ele : arr){
            maxEle = Math.max(maxEle,ele);
        }
        return maxEle;
        
    }

    public static int minimum(int[] arr){

        int minEle = (int)1e9;
        for(int ele : arr){
            minEle = Math.min(minEle,ele);
        }
        return minEle;
        
    }

    public static int findIndex(int[] arr,int data){  // better way
        int foundAtIndex = -1;
        for(int i=0 ; i<arr.length;i++){
            if(arr[i] == data){
                foundAtIndex = i;
                break;
            }
        }
        return foundAtIndex;

    }
    public static int find2(int[] arr , int data){  // not good but ok
        for(int i=0; i< arr.length; i++){
            if(arr[i] == data)
            return i;
        }
        return -1;
    }

    public static int span(int arr[]){
        int maxEle = maximum(arr);
        int minEle = minimum(arr);

        int span = maxEle-minEle;
       return span;

    }

    public static void swap(int[] arr , int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]= temp;
    }

    public static void reverse(int[] arr ){
        int n = arr.length;
        int i=0,j=n-1;
        while(i<j){
            swap(arr,i,j);
            i++;
            j--;
        }
        display1(arr);
    }

    public static void inverseOfArray(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];

        for(int i=0;i<n;i++){
            ans[arr[i]] = i;
        }
        display1(ans);
    }

    public static void main(String[] args){
        int n = scn.nextInt();
        // test1(n);

        // int[] arr = new int[n];
        // input1(arr);
        // display1(arr);

        // if we try to print arr , it will print its hashcode
        // System.out.print(arr);

       int[] arr =  input2(n);   // here we catch the array returned by the function
       // display2(arr);

        // System.out.println(findIndex(arr,23));
        inverseOfArray(arr);
    }
}