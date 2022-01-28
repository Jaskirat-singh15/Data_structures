import java.util.LinkedList;

public class queueUsingStackPush{
    LinkedList<Integer> st = new LinkedList<Integer>();
    LinkedList<Integer> temp = new LinkedList<Integer>();
    int peekEle = 0;
    queueUsingStackPush(){

    }
    public void push(int data){
        if(st.size()==0) peekEle = data;
        st.addFirst(data);
    }
    public void transfer(LinkedList<Integer> st1 , LinkedList<Integer> st2){
        while(st1.size() != 0){
            st2.addFirst(st1.removeFirst());
        }
    }
    public int pop(){
        transfer(st,temp);
        int rEle = temp.removeFirst();

        while(temp.size()!=0){
            this.push(temp.removeFirst());
        }
        return rEle;
    }
    public int peek(){
        return this.peekEle;
    }
    public boolean isEmpty(){
        return st.size() == 0;
    }
    public int size(){
        return st.size();
    }

}