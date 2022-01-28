public class dynamicQueue extends queue{

    public dynamicQueue(){
        super();
    }

    public dynamicQueue(int size){
        super(size);
    }

    @Override
    public void add(int data)throws Exception{
        if(super.size() == super.maxSize()){
            int[] temp = new int[super.size()];
            int idx = 0;
            while(super.size()!=0)
                temp[idx++] = super.remove();
            
            super.initialize(super.maxSize()*2);

            for(int ele : temp){
                super.add(ele);
            }
        }
        super.add(data);
    }
}