import java.util.ArrayList;

// when we studied STL(java ka predefined heap, it was by deafault min type priority queue)
// now we are making our own heap class
// we studied that an array can behve like a tree in basic.java
// similarly an array(dynamic) or ArrayList can be used to make heap theory
// here we are by default giving max pq to our heap

public class heap{
    // data members.================================================

    private ArrayList<Integer> arr;   
    private int noOfEle = 0;  // stores the size
    private boolean isMaxHeap = true;  // by default gives max heap 

    // Constructors.================================================

    private void initialize(boolean isMaxHeap){
        this.arr = new ArrayList<>();
        this.noOfEle = 0;
        this.isMaxHeap = isMaxHeap;
    }

    public heap(boolean isMaxHeap){
        initialize(isMaxHeap);
    }

    // default constructor
    // here we havve done constructor chaining. --> oops concept
    // will find a constructor which acccepts boolean as paarameter.
    public heap(){
        this(true);
    }

    // also the first line of a constructor must be a constructor call
    // after that you can write whatever code you want to.
    public heap(int[] data , boolean isMaxHeap ){
        this(isMaxHeap);

        for(int ele : data) this.arr.add(ele);
        this.noOfEle = this.arr.size();

    }

    // Exceptions.====================================================

    private void underFlowException() throws Exception{   // done exception handling
        if(this.noOfEle == 0)
            throw new Exception("HeapUnderFlowException");
    }

     // Basic functions.===============================================

    public int size(){  
        return this.noOfEle;
    }

    public boolean isEmpty(){
        return this.noOfEle == 0;
    }

     // DS functions.====================================================

    public int peek() throws Exception {
        underFlowException();
        this.arr.get(0);
    }

    public int remove() throws Exception{
        underFlowException();

    }

    public void add(int data){

    }


}