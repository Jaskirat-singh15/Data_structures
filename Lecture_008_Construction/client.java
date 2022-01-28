public class client{

    public static void stackTest() throws Exception{
        stack st = new stack(10);

        for(int i =1 ; i<=10 ; i++){
            st.push(i*10);
        }
        while(st.size() != 0){
            
            System.out.println(st.pop());
        }
    }
    
    public static void queueTest_01() throws Exception{
        queue que = new queue();

        que.add(10);
        que.add(20);
        que.remove();
        que.add(30);
        que.add(40);
        que.remove();
        que.add(50);
        que.add(60);
        System.out.println(que);

    }
    public static void queueTest_02() throws Exception{
        queue que = new queue(10);

        for(int i =1 ; i<= 10 ; i++){
            que.add(i*10);
        }

        while(que.size() != 0){
            System.out.println(que.remove());
        }
    }

    public static void dynamicStackTest() throws Exception{
        dynamicStack st = new dynamicStack(4);

        for(int i =1 ; i<=10 ; i++){
            st.push(i*10);
        }
        System.out.println(st);
        while(st.size() != 5){
            
            System.out.println(st.pop());
        }
    }

     public static void dynamicQueueTest() throws Exception{
        dynamicQueue st = new dynamicQueue(4);

        for(int i =1 ; i<=10; i++){
            st.add(i*10);
        }
        System.out.println(st);
        while(st.size() != 5){
            
            System.out.println(st.remove());
        }
    }

    public static void main(String[] args) throws Exception{
        // stack st = new stack();
        // st.push(34);
        // st.push(100);
        // System.out.println(st);
        // st.push(300);
        // System.out.println(st);
        // // st.pop();
        // // System.out.println(st);

        // System.out.println(st.pop());
        

        // queue q = new queue();
        // q.add(15);
        // q.add(30);
        // q.add(50);
        // q.add(50);
        // q.add(50);
        // System.out.println(q.size());
        // q.remove();
        // System.out.println(q);
        // System.out.println(q.size());
        // System.out.println(q.peek());
        // System.out.println(q.isEmpty());
        // q.add(100);
        // System.out.println(q);

    //    queueTest_02();
    //    queueTest_01();

    // dynamicStackTest();
    dynamicQueueTest();
    }
}