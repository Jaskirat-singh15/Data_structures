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
    // O(N) --> full mathematical proof done in notes
    public heap(int[] data , boolean isMaxHeap ){
        this(isMaxHeap);

        for(int ele : data) 
            this.arr.add(ele);

        this.noOfEle = this.arr.size();

        for(int i = noOfEle -1 ; i >= 0 ; i--){
            downHeapify(i);
        }

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

    public int compareTo(int t , int o){
        if(isMaxHeap){
            return this.arr.get(t) - this.arr.get(o);
        }
        else{
            return this.arr.get(o) - this.arr.get(t);
        }
    }

    private void swap(int i , int j){
        int ei = this.arr.get(i);
        int e2 = this.arr.get(j);

        this.arr.set(i,e2);
        this.arr.set(j,e1);
    }

    private void downHeapify(int pi){
        int maxIdx = pi, lci = pi*2 + 1, rci = pi*2 + 2;

        if(lci < this.noOfEle && compareTo(lci,maxIdx) > 0){
            maxIdx = lci;
        }
        if(rci < this.noOfEle && compareTo(rci , maxIdx) > 0){
            maxIdx = rci;
        }

        if(maxIdx != pi){
            swap(pi , maxIdx);
            downHeapify(maxIdx);
        }
    }

    public int peek() throws Exception {
        underFlowException();
        this.arr.get(0);
    }

    //O(LogN)
    private void upHeapify(int ci){
        int pi = (ci-1)/2;
        if(pi >= 0 && compareTo(ci,pi) >  0){
            swap(ci,pi);
            upHeapify(pi);
        }
    }
    
    // O(LogN)
    public int remove() throws Exception{
        underFlowException();
        
        int rEle = this.arr.get(0);
        swap(0,this.noOfEle-1);
        this.arr.remove(this.noOfEle-1);

        this.noOfEle--;
        downHeapify(0);

        return rEle;
    }

    // O(LogN)
    public void add(int data){

        this.arr.add(data);
        this.noOfEle++;

        upHeapify(this.noOfEle-1);

    }


}