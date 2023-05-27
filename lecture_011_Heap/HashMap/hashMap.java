import java.util.LinkedList;

public class hashMap{

    //class
    private class Node{
        Integer key = null;
        Integer value = null;

        Node(Integer key, Integer value){
            this.key = key;
            this.value = value;
        }
    }

    // data members=====================================
    private LinkedList<Node>[] buckets;
    private int bucketLen = 0;
    private int totalNoOfNodes = 0;


    // constructors=====================================
    private void initialize(int size){
        this.bucketLen = size;
        
        this.buckets = new LinkedList[size];
        for(int i = 0; i < size; i++){
            buckets[i] = new LinkedList<>();
        }

        this.totalNoOfNodes = 0;

    }

    public hashMap(){
        initialize(10);
    }
    // exception handling==================================



    //basic functions =====================================

    public int size(){
        return this.totalNoOfNodes;
    }

    public boolean isEmpty(){
        return this.totalNoOfNodes == 0;
    }

    // Ds functions=========================================
    


    public Integer get(Integer key){

        LinkedList<Node> group = getGroup(key);

    }

    public Integer remove(Integer key){

    }

    public Integer getOrDefault(Integer key){
        
    }

    public boolean containsKey(Integer key){
        LinkedList<Node> group = getGroup(key);
        int gs = group.size();
        boolean res = false;
        while(gs-- > 0){
            if(group.getFirst().key == key){
                res = true;
                break;
            }

            group.addLast(group.removeFirst());
        }

        return res;
    }


    public LinkedList<Node> getGroup(Integer key){
        int hc = getHashCode(key);
        return buckets[hc];
    }

    public int getHashCode(Integer key){
        return Math.abs(key.hashCode()) % this.bucketLen;
    }

   


}