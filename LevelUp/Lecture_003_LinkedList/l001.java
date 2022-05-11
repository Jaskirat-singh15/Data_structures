public class l001{
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode{
        int data = 0 ;
        ListNode next = null;

        ListNode(int data){
            this.data = data;
        }
    }

    // will give first mid in case of even size linked list
    // O(n) , no extra space
    public static ListNode midNode(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast =  fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // o(n) , no extra space , 
    // also didinot had head and tail like we did in basic linkedlist 
    // if we had ll class , then also set head and tail pointers
     public static ListNode reverse(ListNode head) {
      if(head == null || head.next == null){
          return head;
      }
      
      ListNode prev = null , curr = head;
      while(curr != null){
          ListNode forw = curr.next;  // backup
          
          curr.next = prev;  // link
          prev = curr;       // move
          curr = forw;
      }
      
        return prev;
    }

    // thought own
    // not good bcz , we misplaced the head pointer as well as 
    // we changed the links of the original linked list
    // see sir method below --> same approach but linked list is se again
     public static boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null){
            return true;
        }
        
        ListNode mid = midNode(head);
        ListNode nhead = reverse(mid.next);
        
        while(head != mid.next)
        {
            if(head.val != nhead.val){
                return false;
            }
            head = head.next;
            nhead = nhead.next;
        }
        return true;
    }

    public static boolean isPalindrome(ListNode head){
        if(head == null || head.next == null){
            return true;
        }

        ListNode mid = midNode(head);
        ListNode nhead = mid.next;
        mid.next = null;

        nhead = reverse(nhead);
        boolean flag = true;
        while(head != null && nhead != null){
            if(head.val != nhead.val){
                // return false;  cnnot directly retturn bcz we have to make the linked list same as it was before
                flag = false;
                break;
            }
            head = head.next;
            nhead = nhead.next;
        }

        nhead = reverse(nhead);   //make the linked list same as it was before
        mid.next = nhead;

        return flag;
    }

    public static void fold(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        
        ListNode mid = midNode(head);
        ListNode nhead = mid.next;
        mid.next = null;
        
        nhead = reverse(nhead);
        
        ListNode c1 = head , c2 = nhead;
        while(c1 != null && c2 != null){     // can just write while(c2 != null ) , bcz hamesha c2 hi pahle null hoga

            // backup
            ListNode f1 = c1.next;
            ListNode f2 = c2.next;
            
            // links
            c1.next = c2;
            c2.next = f1;
            
            // move
            c1 = f1;
            c2 = f2;
        }
    }

    public static void unfold(ListNode head){
        if(head == null || head.next == null)
        return;

        ListNode d1 = new ListNode(-1), d2 = new ListNode(-1) , c1 = d1 , c2 = d2 , c = head;

        while(c != null){
            c1.next = c;
            c2.next = c.next;

            c1 = c1.next;
            c2 = c2.next;

            c = c.next;
            if(c!= null){
                c = c.next;
            }
        }

        c1.next = null;
        ListNode rhead = reverse(d2.next);
        c1.next = rhead;
    }

    public static ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return (l1 == null)? l2 : l1;
        }
        
        ListNode dummy = new ListNode(-1), c1 = l1 , c2 = l2, prev = dummy;
        
        while(c1 != null && c2 != null){
            if(c1.val <= c2.val){
                prev.next = c1 ;
                c1 = c1.next;
            }
            else{
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }
         prev.next = (c1 == null)? c2 : c1;

         // cannot write like 
        // (c1 == null)? prev.next = c2 :  prev.next = c1;
        return dummy.next;
    }

    public static ListNode removeNthNodeFromEnd(ListNode head, int n){
        if(head == null){
            return head;
        }

        ListNode slow = head, fast = head;

        while(n-- > 0){
            fast = fast.next;
        }
        if(fast == null){
            ListNode rNode = slow;
            head = head.next;
            rNode.next = null;
            return head;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        ListNode rNode = slow.next;
        slow.next = rNode.next;
        rNode.next = null;
        return head;
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode odd = new ListNode(-1), even = new ListNode(-1), ep = even , op = odd , c = head;
        
        while( c != null){
            if(c.val % 2 == 0){
                ep.next = c;
                ep = ep.next;
            }
            else{
                op.next = c;
                op = op.next;
            }
            c= c.next;
        }
        
        op.next = null;
        ep.next = odd.next;
        return even.next;
    }

    // solved own by dry run
    public static ListNode segregate01(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode d1 = new ListNode(-1), d2 = new ListNode(-1), p1 = d1 , p2 = d2, c = head;
        
        while(c != null){
            if(c.val == 0){
                p1.next = c;
                p1 = p1.next;
            }
            else{
                p2.next = c;
                p2 = p2.next;
            }
            c = c.next;
        }
        
        p1.next = d2.next;
        return d1.next;
    }

    // done by myself --> dry run
    public static ListNode segregate012(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode d1 = new ListNode(-1),d2 = new ListNode(-1),d3 = new ListNode(-1), p1 = d1 , p2 = d2 , p3 = d3, c = head;
        
        while(c != null){
            if(c.val == 0){
                p1.next = c;
                p1 = p1.next;
            }
            else if(c.val == 1){
                p2.next = c;
                p2 = p2.next;
            }
            else if(c.val == 2){
                p3.next = c;
                p3 = p3.next;
            }
            
            c = c.next;
        }
        
        p1.next = p2.next = p3.next = null;
        
        p2.next = d3.next;
        p1.next = d2.next;
        return d1.next;
    }

    // merge k sorted lists
    // // brute force method :
    // merge th efirst lisst with empty list and store the result ,
    // the merge this result with second list , and store in result variable 
    // keep on going till the end of array

    // complexity : N.K , derived in notes
    // code :
     public static ListNode mergeKLists(ListNode[] lists) {
        
       int k = lists.length;
       ListNode ans = null;  // never leave unintialized
       
    //   for(int i = 0 ; i < k ; i++){
    //       ans = mergeTwoSortedList(ans,lists[i]);
    //   }
    
    for(ListNode head : lists){
        ans = mergeTwoSortedList(ans,head);
    }
       
       return ans;
    }

    // optimize the above code:

    public static ListNode mergeKLists(ListNode[] lists, int si , int ei){
        if(si == ei){
            return lists[si];
        }
        
        int mid = (si+ei)/2;
        
        ListNode leftList = mergeKLists(lists, si , mid);
        ListNode rightList = mergeKLists(lists, mid+1 , ei);
        
        return mergeTwoSortedList(leftList , rightList);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length == 0){
            return null;
        }

        // int si = 0 , ei = lists.length-1;
        
        // ListNode ans = mergeKLists(lists, si , ei);
        
        // return ans;

        // simply write in one line like
        return mergeKLists(lists, 0 , lists.length - 1);
    
    }



}