public class questions{

    public class listNode{
        int val ;
        listNode next;
        
        listNode(){

        }
        listNode(int val){
            this.val = val
        }
        listNode(int val , listNode next){
            this.val = val;
            this.next = next;
        }
    }
    
    // leetcode 876
    public listNode middleNode(listNode head){
        if(this.head == null || this.head.next == null) return head;

        listNode slow = this.head;
        listNode fast = this.head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast  = fast.next.next;
        }
        return slow;
    }

    public listNode removeNthFromEnd(listNode head , int n){
if (head == null || head.next == null)
            return null;

        ListNode slow = head, fast = head;
        while (n-- > 0)
            fast = fast.next;

        if (fast == null)
            return head = head.next;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}