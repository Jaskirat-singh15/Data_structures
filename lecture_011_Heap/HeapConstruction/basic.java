public class basic{
    public static Scanner scn = new Scanner(System.in);

    public static int HeightOfTree(int[] arr , int idx){
        if(idx > arr.length() - 1 ) return -1;
        int lh = heightOfTree( arr, idx*2 + 1);
        int rh = heightOfTree( arr, idx*2 + 2);

        return Math.max(lh,rh) + 1;

    }

    public static void main(String[] args){

    }
}