// leetcode 225
class stackUsingQueuePush {
    
    LinkedList<Integer> que = new LinkedList<Integer>();
    LinkedList<Integer> temp = new LinkedList<Integer>();
    
    int topEle = 0;

    public stackUsingQueuePush() {
        
    }
    


    // o(1)
    public void push(int x) {
        topEle = x;
        que.addLast(x);
    }
    
    //O(n)
    public int pop() {
        while(que.size() > 1){
            temp.addLast(que.removeFirst());
        }
        int rEle = que.removeFirst();
        while(temp.size()!=0){
            push(temp.removeFirst());
        }
        return rEle;
    }
    
    public int top() {
        return topEle;
    }
    
    public boolean empty() {
        return que.size() ==0;
    }
}