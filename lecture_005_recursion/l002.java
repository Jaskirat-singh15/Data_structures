// Recursion with array 
// all codes are written by me , by thinking about the faith , so to solve think about the faith.
import java.util.Scanner;


public class l002{
    public static Scanner scn = new Scanner(System.in);

    //Faith: hamme idx+1 se end tak sare elements print ho jayenge
    // now hame arr[idx] ko print karna hai, so ise starting me syso kardo
    // base case: ki agar idx bada ya eqaul(>=) ho jata hai array ki length k ,then return
    // when sir wrote the code , used base case as (idx == arr.length) return; 
    public static void printArray(int[] arr , int idx){
        if(idx >= arr.length) return;
        System.out.println(arr[idx]);
        printArray(arr,idx+1);
    }

    // Faith: faith hoga ki hamme idx+1 se end tak element reverse print ho jayenge
    // now: we want to print fisrt ele i.e. arr[idx] , where? at last, so write after recursive call 
    // base case : same as above if(idx >= arr.length) or if(idx == arr.length) , both works fine
    public static void printArrayReverse(int[] arr , int idx){
        if(idx >= arr.length) return;
        printArrayReverse(arr, idx+1);
        System.out.println(arr[idx]);
    }

    // Faith : socha ki hamme idx+1 se end tak k elements ka max mil jayega
    // now , compare arr[idx] with max , and store in max and then return max
    // base case: ki agar idx arr ki length se bada ho jaata hai , to return krdi sabse choti value 
    // ye saare code khud soch kar pass kare hai, so try to think the same way explained above  
    // ye code post order me work kar rha hai, right.  
    public static int maximum(int[] arr , int idx){
        if(idx >= arr.length) return -(int)1e9;  // least integer value
        int max = maximum(arr,idx+1);
        max = Math.max(arr[idx],max);
        return max;
    }


    public static int minimum(int[] arr , int idx){

        if(idx >= arr.length) return (int)1e9;
        int min = minimum(arr,idx+1);
        min = Math.min(arr[idx],min);
        return min;

    }


    // important code , used to solve many tree questions
    // Faith: fiath socha ki agar data arr[idx] ke equal hai , to true return krdo
    // nhi equal to idx +1 se end tak check kro
    // base case : idx == arr.length , return false
    public static boolean findData(int[] arr , int idx , int data){
        if(idx == arr.length) return false;
        if(arr[idx] == data) return true;
        return findData(arr,idx+1,data);
    }


    // find data 2 , in this working in postorder ,
    // not good than the above , but should know this as well
    // faith: idx+1 se end tak data hai , to true return krdo
    // nhi mila to , idx pe check krenge 
    // also thought own , same as sir
    public static boolean findData2(int[] arr , int idx){
        if(idx == arr.length) return false;
        boolean recAns = findData2(arr,idx+1,data);
        if(recAns) return recAns;
        return arr[idx] == data ;
       
    }

    public static int firstIndex(int[] arr, int idx , int data){
        if(idx == arr.length) return -1;
        if(arr[idx] == data) return idx;
        return firstIndex(arr,idx+1,data);
    }

    // trverse from start--> question constraint hai
    // so think to work in postorder
     public static int lastIndex(int[] arr, int idx, int data) {
        if (idx == arr.length)
            return -1;
        int recAns = lastIndex(arr, idx + 1, data);
        if (recAns != -1)
            return recAns;

        return arr[idx] == data ? idx : -1;
    }

    // after writing first and last index , we knew that we get the data while pre as well post 
    // so wile pre , just count the no. of occurences of data , when base case hits return new array of count size 
    // and in post order fill the arr with the indexes 
    // dry run the code to understand it better
    public static int[] allIndex(int[] arr, int idx, int data, int count){

        if(idx == arr.length) return new int[count];

        if(arr[idx] == data) count++;

        int[] recAns = allIndex(arr,idx+1,data,count);

        if(arr[idx] == data){
            recAns[count-1] = idx;
        }

        return recAns;
    }

    public static boolean firstAndLastIndex(int[] arr, int idx, int data , int[] ans){
        if(idx == arr.length)
            return false;
        
        if(arr[idx] == data){
            ans[0] = idx;
        }
        boolean res = firstAndLastIndex(arr,idx+1,data,ans);
        if(res) return res;

        if(arr[idx] == data){
            ans[1] = idx;
            return true;
        }

        return false;
    }
    

    public static void main(String[] args){
        // int[] arr = {2,3,4,45,56,78,98,-11,-3,-29,456,4,665};
       
        int[] arr = {12, 3, 2, 4, 34, 3, 4, 2, 2, 76};

        // printArray(arr,0);
        // printArrayReverse(arr,0);

        System.out.println(maximum(arr,0));
        System.out.println(minimum(arr,0));
        System.out.println(findData(arr,0,2));
        System.out.println(firstIndex(arr,0,2));
        System.out.println(lastIndex(arr,0,2));
    }
       
    
}