import java.util.*;

public class l001{
    public static Scanner scn = new Scanner(System.in);

    public static void sort01(int[] arr){

        int p = -1, itr = 0;

        while(itr < arr.length){
            if(arr[itr] == 0){
                swap(arr,++p,itr);
            }
            itr++;
        }

    }

    public static void sort012(int[] arr){
        int p1 = -1 , itr = 0 , p2 = arr.length - 1;

        while (itr <= p2){
            if(arr[itr] == 0){
                // swap(arr,++p,itr++);
                swap(arr,++p1,itr);
                itr++;
            }
            else if(arr[itr] == 1){
                itr++;
            }
            else if(arr[itr] == 2){
                swap(arr,itr,p2);
                p2--;
            }
        }
    }

    public static void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]= temp;
    }

    public static void print(int[] arr){
        for(int i =0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    
    // best method to solve
    //complexity o(n+m) 
    public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2){

        int n = arr1.length;
        int m = arr2.length;

        int[] ans = new int[n+m];

        int i = 0, j = 0, k = 0;

        while(i < n && j < m){
            if(arr1[i] < arr2[j]){
                ans[k++] = arr1[i++];
            }
            else{
                ans[k++] = arr2[j++];
            }
        }

        while(i<n){
            ans[k++] = arr1[i++];
        }

        while(j<m){
            ans[k++] = arr2[j++];
        }

        return ans;
    }

    // has same big O omplexity n+m 
    // but more complex bcz of more no of unit operations(conditions / checks) // explained in lecture vidoe
    public static int[] mergeTwoSortedArrays2(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;

        int[] ans = new int[n+m];

        int i = 0, j = 0, k = 0;
        long val1 = 0 , val2 = 0;

        while(i < n || j < m){
            val1 = (i < n)? arr1[i] : (long)1e18;
            val2 = (j < m)? arr2[j] : (long)1e18;

            if(val1 < val2){
                ans[k++] = (int)val1;
                i++;
            }
            else {
                ans[k++] = (int)val2;
                j++;
            }
        }

        return ans;

    }
     
     // can do this way but not optimal 
        /// best method is first one
    public static int[] mergeTwoSortedArrays3(int[] arr1, int[] arr2){
        int i = 0 ; j = 0; k = 0;

        int n = arr1.length, m = arr2.length;
        int[] ans = new int[n+m];

        while(i < n || j < m){

            if( i == n)
                ans[k++] = arr2[j++];
            else if( j == m)
                ans[k++] = arr1[i++];
            else if(arr[i] < arr[j])
                ans[k++] = arr[i++];
            else 
                ans [k++] = arr2[j++];
        }
        return ans;
    }

    // best , avg , worst - O(n2)
    public static void bubbleSort(int[] arr){
        int n = arr.length;

        for(int li = n-1; li > 0 ; li--){
            for(int i = 1; i <= li ; i++){
                if(arr[i-1]> arr[i]){
                    swap(arr,i,i-1);
                }
            }
        }
    }

    // best case - o(n) when array is already sorted 
    // else o(n2)
    public static void bubbleSort_opti(int[] arr){
        int n = arr.length;

        for(int li = n-1; li > 0 ; li--){
            boolean isSwapDone = false;
            for(int i =1 ; i <= li ; i++){
                if(arr[i-1] > arr[i]){
                    swap(arr,i,i-1);
                    isSwapDone = true;
                }
            }
            if(!isSwapDone) break;
        }
    }

    public static void selectionSort(int[] arr){
        int n = arr.length;

        for(int i = 0; i < n ; i++){
            for(int j = i+1; j < n ; j++){
                if(arr[i] > arr[j]){
                    swap(arr, i , j); 
                }
            }
        }
    }

    // thought myself
    public static void insertionSort(int[] arr){
        int n = arr.length;
        
        for(int i  = 1; i < n ; i++){
            for(int j = i -1 ; j > = 0  ; j--){
                if(arr[j+1] < arr[j]){
                    swap(arr,j+1,j);
                }
                else 
                    break;
            }
        }
    }

    // sir code 
    public static void insertionSort(int[] arr){
        int n = arr.length;
        
        for(int i  = 0; i < n ; i++){
            for(int j = i ; j > 0  ; j--){
                if(arr[j-1] > arr[j])
                    swap(arr,j-1,j);
                else 
                    break;
            }
        } 
    }


    public static void main(String[] args){

        int n = scn.nextInt();

        int[] arr = new int[n];

        // for(int i = 0; i <n; i++){
        //     arr[i]= scn.nextInt();
        // }

        // sort01(arr);
        // print(arr);

        int[] arr1 = {1,2,13,24,51,69};
        int[] arr2 = {3,5,9,41,56,61};
        mergeWithNoSpace(arr1,arr2);
    }
}