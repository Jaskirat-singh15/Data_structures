public class linkedlist {

  public class Node {

    int data = 0;
    Node next = null;

    Node(int data) {
      this.data = data;
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public int size() {
      return this.size;
    }

    public boolean isEmpty() {
      return this.size == 0;
    }

    public void display() {
      for (Node temp = head; temp != null; temp = temp.next) {
        System.out.print(temp.data + " ");
      }
      System.out.println();
    }

    // to display linked list // best method is to override toString
    @override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node curr = this.head;
        while(curr != null){
            sb.apppend(curr.data);
            if(curr.next != null)
            sb.append(", ");
            curr = curr.next;
        }
        sb.append("]");

        return sb.toString();
    }

    // ===========================================================

    private void addFirstNode(Node node) {
      if (this.size == 0) this.head = this.tail = node; else {
        node.next = this.head;
        this.head = node;
      }
      this.size++;
    }

    public void addFirst(int data) {
      Node node = new Node(data);
      addFirstNode(node);
    }

    public void addLastNode(Node node) {
      if (this.size == 0) this.head = this.tail = node; else {
        this.tail.next = node;
        this.tail = node;
      }
      this.size++;
    }

    public void addLast(int data) {
      Node node = new node(data);
      addLastNode(node);
    }

    // private void addNodeAt(int idx , Node node){   // my way , thught and wrote , dont know if correct
    //     Node curr = this.head;
    //     if(this.size == 0) this.head = this.tail = node;
    //     if(idx == 0){
    //       node.next = curr;
    //       this.head = node;
    //     }
    //     else{
           
    //         while(idx-- > 1 )
    //             curr = curr.next;
           
    //        node.next = curr.next; 
    //        curr.next = node;
    //     }
    //     this.size++;
    // }

    private void addNodeAt(Node node , int idx){
        if(idx ==1 ) addFirstNode(node);
        else if(idx == this.size) addLastNode(node);
        else{
            Node prevNode = getNodeAt(idx-1);
            Node forwNode = prevNode.next;

            prevNode.next = node;
            node.next = forwNode;
            this.size++;    // written inside else because the above function used in if and ElseIf handle size by themselves
        } 
    }
    public void addAt(int idx , int data){
        if(idx<0 || idx > this.size)  return -1 ;
        
        Node node = new Node(data);
        addNodeAt(node , idx);
    }

    // =================================================

    private Node removeFirstNode() {
      Node node = this.head;
      if (this.size == 1) this.head = this.tail = null; else {
        this.head = this.head.next;
        node.next = null;
      }
      this.size--;
      return node;
    }

    public int removeFirst() {
      if (this.size == 0) return -1;
    //    else lgane kizrurat nhi hi kyuki tha return -1 pr function khatam ho jayega 
    // agar ham return nhi krte to else lgaana zruri hai vrna null pointer exception aa jayega
      return removeFirstNode().data;
    }
    
    // private Node removeLastNode(){    // my way , i thought and wroote, dont know if correct
    //    Node curr = this.head;
    //     if(this.size == 1 ){
    //         this.head = this.tail = null;   
    //     }
    //     else{
    //         while(curr.next.next = null){
    //             curr = curr.next;
    //         }
    //         curr.next = null;
    //         this.tail = curr;
    //     }
    //      this.size--;
    //       return curr;
    // }

    private Node removeLastNode(){
       Node node =  this.tail;
        if(this.size ==1 ) 
        this.head = this.tail = null;
        else{
            Node secondLast = getNodeAt(this.size -2 );
            secondLast.next = null;
            this.tail = secondLast;
        }
        this.size--;
        return node;
    }
    public int removeLast(){
        if(this.size == 0) return -1;

        return removeLastNode().data;
    }
    private Node removeNodeAt(int idx){
       Node ptr = this.head;
       if(this.size == 1) this.head = this.tail = null;
       else{
           while(idx-- > 0)
       }
    }
    // private Node removeNodeAt(int idx){
    //     if(idx == 0) removeFirstNode();
    //     else if(idx == this.size-1) removeLastNode();
    //     else{
    //         Node prevNode =  getNodeAt(idx-1);
    //         Node node = prevNode.next;
           
    //         prevNode = prevNode.next.next;
    //         node.next = null;
    //         this.size--;
    //           
    //         return node;
    //     }
    // }


     private Node removeNodeAt(int idx){
        if(idx == 0) removeFirstNode();
        else{
            Node prevNode =  getNodeAt(idx-1);
            Node node = prevNode.next;
            Node forwNode = node.next;
           
            node.next = null;
            prevNode.next = forwNode;
            this.size--;

            return node;
        }
    }
    public int removeAt(int idx){
        if(idx <0 || idx>=this.size) return -1;

        return removeNodeAt(idx).data;
    }

    // ===================================================

    private Node getFirstNode() {
      return this.head;
    }

    public int getFirst() {
      if (this.size == 0) return -1;

      return getFirstNode().data;
    }

    private Node getLastNode(){
        return this.tail;
    }
    public int getLast(){
       if(this.size == 0) return -1;
       return getLastNode().data;
    }

    private Node getNodeAt(int idx){
        Node curr = this.head;
        while(idx-- > 0){
            curr = curr.next;
        }
        return curr;
    }
    public int getAt(int idx){
        if(idx<0 || idx>=this.size) return -1;

        return getNodeAt(idx).data;
    }
  }

  // questions
  public void oddEven(Node head){  // first odd then even values
      if(this.size ==0 || this.size ==1) return;
      Node odd = new Node(-1);  // dummy Node
      Node op = odd;

      Node even = new Node(-1);  // Dummy Node
      Node ep = even;

      Node curr = this.head;

      while(curr != null){
         if(curr.data %2 == 0){
             ep.next = curr;
             ep = ep.next;
         }
         else{
             op.next = curr;
             op = op.next;
         }
        curr = curr.next;
      }
         op.next = even.next;
         ep.next = null;

         this.head = odd.next;
        
        if(even.next != null) this.tail = ep;
        else this.tail = op;
  }

  // remove duplicates in a sorted linked list
  // thought by myself , successfully submitted on pepcoding
  // but sir method is more good , see code below
//   public void removeDuplicatesInSortedLinkedList(Node head){
//       if(this.size ==0 || this.size ==1) return ;
//       Node prev = new Node(-1);
//       Node p = prev;

//       Node curr = this.head;
//       while(curr!=null){
//           if(curr.data != p.data){
//               p.next = curr;
//               p = p.next;
//           } 
//           curr = curr.next;
//       }
//       p.next = null;

//       this.tail = p;

//   }

// remove duplicates from sorted linked list     leetcode 83
public void removeDuplicates(Node head){
    if(head== null || head.next == null) return ;

    Node dummy = new Node(-101);  // check constraints , otherwise link dummy to head , dp to head , curr to head.next
    Node dp = dummy;

    Node curr = this.head;
    int size =0;
    while(curr!=null){
        while(curr!=null && (curr.data == dp.data)){
            Node forw = curr.next;
            curr.next = null;
            curr = forw;
        }

        dp.next = curr;
        if(curr!=null){
            curr = curr.next;
            dp = dp.next;
            size++;
        }
    }
    this.size = size;
    this.head = dummy.next;
    this.tail = dp;
}

// reverse linked list pointer iteratuve leetcode 206
    public  static ListNode reverseLinkedList(){
        if(head == null || head.next == null) return head;

        Node prev = null;
        Node curr = this.head;
        while(curr!=null){
        Node forw = curr.next;  // backup
            
            curr.next = prev;  // link
            
            prev = curr;    // move
            curr = forw;
        }
        this.tail = this.head;
        this.head = prev;
        return head;
    }

    public static ListNode addTwoNumbers(ListNode l1 , ListNode l2){
       
        l1 = reverseLinkedList(l1);
        l2 = reverseLinkedList(l2);

        ListNode dummy = new ListNode(-1);

        ListNode c1 = l1 , c2 = l2 , prev = dummy;
        int carry =0;
        while(c1!= null || c2!=null || carry!=0){
            int sum = carry + (c1 != null ? c1.val : 0) + (c2 !=null ? c2.val : 0);

            carry = sum/10;
            sum%=10;
            prev.next = new ListNode(sum);

            prev = prev.next;
            if(c1!=null) c1 = c1.next;
            if(c2!=null ) c2 = c2.next;
        }
        ListNode head = dummy.next;
        head = reverseLinkedList(head);
        
        l1 = reverseLinkedList(l1);
        l2 = reverseLinkedList(l2);

        return head;
    }

    // add two numbers using recursion



    // reverse linked list using recursion
     private Node reversePRHelper(Node node){
      if(node.next == null) return node;
      
      Node reverseNode = reversePRHelper(node.next);
      reverseNode.next = node;
      
      return node;
    }

    public void reversePR(){
     Node reverseNode = reversePRHelper( head);
     reverseNode.next = null;
     
     head = tail;
     tail = reverseNode;
    }

    // display reverse 
     private void displayReverseHelper(Node node){
      if(node == null) return;
      
      displayReverseHelper(node.next);
      System.out.print(node.data + " ");
    }

    public void displayReverse(){
      displayReverseHelper(head);
      System.out.println();
    }

    // fold linked list
    public void fold() {
      Node midNode = midNode(head);
      Node nhead = midNode.next;
      midNode.next = null;
      
      nhead = reverse(nhead);
      
      Node c1 = head , c2 = nhead;
      while(c2!=null){
          Node f1 = c1.next ;
          Node f2 = c2.next;
          
          
          c1.next = c2;
           c2.next = f1;
           c1=f1;
           c2=f2;
      }
      if(size()%2 != 0) tail = midNode;
      else
      tail = midNode.next;
    }

}
