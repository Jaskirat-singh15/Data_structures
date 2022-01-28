public class question{

    public static boolean balancedBrackets(String str){
        LinkedList<Character> st = new LinkedList<Character>();
        for(int i =0; i< str.length();i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.addFirst(ch);
            }
            else if(ch == ')' || ch == '}' || ch == ']'){
                if(st.size() == 0) return false;    // more closing brackets
                else if(ch == ')' && st.getFirst()!= '(')
                  return false;
                else if(ch == '}' && st.getFirst()!= '{')
                  return false;
                else if(ch == ']' && st.getFirst()!= '[')
                  return false;
                else
                  st.removeFirst();
            }
        }
        return st.size() == 0 ;
    }

    public static boolean duplicateBrackets(String str){
        LinkedList<Character> st = new LinkedList<>();
        for(int i =0; i< str.length() ; i++){
            char ch = str.charAt(i);
            
            boolean isLoopRun = false;
            while(st.size() != 0 && ch == ')' && st.getFirst() != '('){
                isLoopRun = true;
                st.removeFirst();
            }

            if(!isLoopRun && ch == ')')
               return true;
            else if(isLoopRun)
              st.removeFirst();
            else 
              st.addFirst(ch);   
        }
        return false;
    }
    
    //leetcode 277
    public static int findCelebrity(int[][] arr){
        int celeb = 0; // potential celebrity
        int n = arr.length;
        for(int i = 1; i < n; i++){
            if(arr[celeb][i] == 1)
             celeb = i;
        }

        for(int i=0; i<n ;i++){
            if(celeb == i) continue;
            else if(arr[celeb][i] == 1 || arr[i][celeb] == 0)
                return -1;
        }
        return celeb;
        
    }
        //written here to remember, we can write condition in syso statement
        // int ans = findCelebrity(arr);
        // System.out.println( ans == -1?"none":ans);  
    
    
    public static void nextGreater(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        LinkedList<Integer> st = new LinkedList<>();
        for(int i=0; i<n ; i++){

            while(st.size()!=0 && arr[st.getFirst()] < arr[i])
            ans[arr.removeFisrt()] = arr[i];

            st.addFirst(i);
        }

        for(int ele : ans)
        System.out.println(ele);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        Arrays.sort(arr,(a,b)->{
            return a[0]-b[0];
        });
        
        LinkedList<int[]> st = new LinkedList<>();
        for(int[] a : arr){
            int minStartTime = a[0];
            int maxEndTime = a[1];
            
            while(st.size()!=0 && a[0] <= st.getFirst()[1]){
                minStartTime = st.getFirst()[0];
                maxEndTime = Math.max(st.getFirst()[1],maxEndTime);
                st.removeFirst();
            }
            
            st.addFirst(new int[] {minStartTime,maxEndTime});
        }
        
        while(st.size()!=0){
            int[] a = st.removeLast();
            System.out.println(a[0] + " " + a[1]);
        }
    }

}