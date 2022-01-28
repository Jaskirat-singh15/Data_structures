// leetcode 225
class stackUsingQueuePop {
    
    LinkedList<Integer> que = new LinkedList<Integer>();
    LinkedList<Integer> temp = new LinkedList<Integer>();
    
    

    public stackUsingQueuePop() {
        
    }
    private void transfer(LinkedList<Integer> que1 , LinkedList<Integer> que2){
        while(que1.size() !=0){
            que2.addLast(que1.removeFirst());
        }
    }
    // O(n)
    public void push(int x) {
       temp.addLast(x);
       transfer(que,temp);

       LinkedList<Integer> temp1 = que;
       que = temp;
       temp = temp1;
    }
    
    // o(1)
    public int pop() {
        return que.removeFirst();
    }
    
    public int top() {
        return que.getFirst();
    }
    
    public boolean empty() {
        return que.size() ==0;
    }
}
