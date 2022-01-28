public class stack{
    private int[] arr;
    private int tos;
    private int size;
    private int maxSize;

    protected void initialize(int len){
        this.arr = new int[len];
        this.tos =-1;
        this.size =0;
        this.maxSize = len;       
    }

    // constructor
    public stack(){
        initialize(5);
    }

    public stack(int size){
        initialize(size);
    }
     
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = tos ; i >= 0; i--){
            sb.append(this.arr[i]);
            if(i!=0){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void stackIsEmptyException() throws Exception{
        if(this.size == 0) 
        throw new Exception("stack is empty:-1");

    }

    private void stackIsOverflowException() throws Exception{
        if(this.size == this.maxSize)
        throw new Exception("stackIsOverflowException : -1");
    }

    public int size(){
        return this.size;
    }
    public int maxSize(){
        return this.maxSize;
    }
    public boolean isEmpty(){
        return this.size == 0;
    }

    private void push_(int data){
        this.arr[++this.tos] = data;
        this.size++;
    }
    public void push(int data) throws Exception{
        stackIsOverflowException();
        push_(data);
    }

    public int top() throws Exception{
        stackIsEmptyException();
        return this.arr[this.tos];
    }
    
    private int pop_(){
        int rv = this.arr[this.tos];
        this.arr[this.tos--] = 0;
        this.size--;
        return rv;
    }
    public int pop() throws Exception{
        stackIsEmptyException();
        return pop_();
    }
}