import java.util.Scanner;
import java.util.PriorityQueue;

public class questions{
    public static Scanner scn = new Scanner(System.in);

    // Brute force method
    // max type priority queue
    // N.log(N) + K.log(N)
    public static int kthLargest_(int[] arr, int k){

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return b-a;
        });

        for(int ele : arr){
            pq.add(ele);
        }
       int rv = 0;
        for(int i = 0; i < k-1; i++){
           rv = pq.remove();
        }
        return rv;

    }

    // sir method 
    // time complexity --> N.log(k)
    public static int kthLargest(int[] arr , int k){

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // by default min type
        for(int ele : arr){
            pq.add(ele);
            if(pq.size() > k)
                pq.remove();
        }

        return pq.peek();
    }

    public static int kthSmallest(int[] arr , int k){

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return b-a;
        });
        for(int ele : arr){
            pq.add(ele);
            if(pq.size() > k ){
                pq.remove();
            }
        }
        return pq.peek();
    }

    public static void sortKSortedArray(int[][] arr){
        int n = arr.length , m = arr[0].length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            int r1 = a / m , c1 = a % m , r2 = b / m , c2 = b % m;
            return arr[r1][c1] - arr[r2][c2];
        });

        for(int i = 0; i < n ; i++){
            pq.add(i*m + 0); //  c(current column) value which is 0 becuase we are adding 0th column elements
        }

        int ans = new int[n*m];
        int idx = 0;
        while(pq.size() != 0){
            Integer eidx = pq.remove();
            int r = eidx / m , c = eidx % m;
            ans[idx++] = arr[r][c];

            c++;
            if(c < m)
                pq.add(r * m + c);
        }

        for(int i = 0; i < n*m ; i++){
            System.out.print(ans[i] + " ");
        }
    }

    public static void main(String[] args){
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();

        // System.out.println(kthLargest(arr,k));
        System.out.println(kthSmallest(arr,k));

    }
}