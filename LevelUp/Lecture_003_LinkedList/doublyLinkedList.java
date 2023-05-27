public class doublyLinkedList{
    
    public static class Node{
        int data = 0;
        Node prev = null;
        Node next = null;

        Node(int data , Node prev, Node next){
            this.data = data;
            this.prev = prev;
             this.next = next;
        }

        Node(data){
            this.super(data,null,null);
        }
    }

     // Exceptions========================================

    private boolean ListIsEmptyException() {
      if (this.size == 0) {
        System.out.print("ListIsEmpty: ");
        return true;
      }
      return false;
    }

    private boolean indexIsInvalidException(int index, int leftRange, int rightRange) {
      if (index < leftRange || index > rightRange) {
        System.out.print("IndexIsInValid: ");
        return true;
      }
      return false;
    }

    // BasicFunctions======================================

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    // AddFunctions======================================

    private void addFirstNode(Node node){
        if(this.size == 0){
            this.head = this.tail = node;
        }
        else{
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
        
        this.size++;
        
    }
    
    public void addFirst(int val) {
        Node node = new Node(val);
        addFirstNode(node);
    }

    private void addLastNode(Node node){
        if(this.size == 0){
            this.head = this.tail = node;
        }
        else{
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
        this.size++;
    }
    
    public void addLast(int val) {
      Node node = new Node(val);
      addLastNode(node);
    }

     private Node removeFirstNode(){
        Node node = this.head;
        if(this.size == 1){
            this.head = this.tail = null;
        }
        else{
            Node forw = node.next;
            node.next = null;
            forw.prev = null;
            
            this.head = forw;
        }
        
        this.size--;
        return node;
    }
    
    public int removeFirst() {
        if(ListIsEmptyException()){
            return -1;
        }
        
        retur removeFirstNode().data;
    }

     private Node removeLastNode(){
        Node node = this.tail;
        if(this.size == 1){
            this.head = this.tail = null;
        }
        else{
            Node p = node.prev;
            node.prev = null; 
            p.next = null;
            
            this.tail = p;
        }
        
        this.size--;
        return node;
    }
    public int removeLast() {
        if(ListIsEmptyException()){
            return -1;
        }
        
        return removeLastNode().data;
    }

    public int getFirst() {
        if(listIsEmptyException()){
            return -1;
        }
        
        return this.head.data;    
    }

    public int getLast() {
        
        if(listIsEmptyException()){
            return -1;
        }
        
        return this.tail.data;
    }

    private Node getNodeAt(int index){
        Node curr = this.head;
        
        while(index-- > 0){
            curr = curr.next;
        }
        return curr;
    }
        
    public int getAt(int index) {
        if(indexIsInvalidException(index,0,this.size-1)){
            return -1;
        }
        
        else if(ListIsEmptyException()){
            return -1;
        }
        
        return getNodeAt(index).data;
    }




}