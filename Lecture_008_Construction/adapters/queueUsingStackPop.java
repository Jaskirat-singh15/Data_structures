import java.util.LinkedList;

public class queueUsingStackPop{
    LinkedList<Integer> st = new LinkedList<Integer>();
    LinkedList<Integer> temp = new LinkedList<Integer>();
    queueUsingStackPush(){

    }

    public void push(int data){
        transfer(st,temp);
        st.addFirst(data);
        transfer(temp,st);
    }

    public void transfer(LinkedList<Integer> st1 , LinkedList<Integer> st2){
        while(st1.size() != 0){
            st2.addFirst(st1.removeFirst());
        }
    }

    public int pop(){
        return st.removeFirst();
    }

    public int peek(){
        return st.getFirst();
    }
    public boolean empty(){
        return st.size() == 0;
    }
    public int size(){
        return st.size();
    }

}