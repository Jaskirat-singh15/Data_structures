import java.util.ArrayList;
public class binaryTree{

    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data, Node left , Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }

        Node(int data){
            this(data,null,null);  // constructor chaining
        }
    }
    
    // root node , then left subtree , then right subtree
    public static void preorderTraversal(Node root , ArrayList<Integer> ans){
        if(root == null){
            return;
        }

        ans.add(root.data);
        preorderTraversal(root.left,ans);
        preorderTraversal(root.right,ans);
    }

    // left subtree, root node , right subtree
    public static void inorderTraversal(Node root , ArrayList<Integer> ans){
        if(root == null)
         return;

        inorderTraversal(root.left,ans);
        ans.add(root.data);
        inorderTraversal(root.right,ans);
        
    }

    // leetcode 94
    // not best way , but if we cant pass arraylist as parameter , will have to do this method
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> myAns = new ArrayList<Integer>();
        List<Integer> left = inorderTraversal(root.left);
        
        myAns.addAll(left);
        
        myAns.add(root.val);
        
        List<Integer> right = inorderTraversal(root.right);
        
        for(int ele : right) myAns.add(ele);
        
        return myAns;
        
    }

    // left subtree, right subtree , root node
    public static void postorderTraversal(Node root , ArrayList<Integer> ans){
        if(root == null)
         return;

        postorderTraversal(root.left,ans);
        postorderTraversal(root.right,ans);
        ans.add(root.data);
        
    }
    
    // no. of nodes in tree
    // faith -> left subtree apna size le ayega 
    // right subtree apna size le ayega 
    // ans = leftsize + rightSize + 1
    // base case -> root is null , return
    public static int size(Node node){
        if(node == null)
            return 0;
        
        int leftSize = size(node.left);
        int rightSize = size(node.right);
        return leftSize + rightSize + 1;

        //  in one line
        // return (node == null)? 0 : size(node.left) + size(node.right) + 1;
    }

    public static int sum(Node node){
        if(node == null){
            return 0;
        }

        int leftSum = sum(node.left);
        int rightSum = sum(node.right);

        return leftSum + rightSum + node.data;

        // return (node == null)? 0 : sum(node.left) + sum(node.right) + node.data;
    }

    public static int max(Node node){
        if(node == null){
            return -(int)1e9;
        }

        int leftMax = max(node.left);
        int rightMax = max(node.right);

        return Math.max(Math.max(leftMax,rightMax),node.data);

        // return (node == null)? -(int)1e9 : Math.max(Math.max(max(node.left),max(node.right)),node.data);
    }

    public static int min(Node node){
        if(node == null){
            return (int)1e9;
        }

        int leftMin = min(node.left);
        int rightMin = min(node.right);

        return Math.min(Math.min(leftMin,rightMin),Node.data);

        // return (node == null)? (int)1e9 : Math.min(Math.min(min(node.left),min(node.right)),node.data);
    }

    // for height in terms of edge return -1 at null , for height in terms of nodes return 0 at null
    // in terms of edge
    public static int height(Node node){
        if(node == null){
            return -1;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight,rightHeight) + 1;

        // return (node == null)? -1 : Math.max(height(node.left),height(node.right)) + 1;
    }
     
     // count leaf nodes in binary tree -> gfg
    public static int countLeaves(Node node) {   
         if(node == null) return 0;
         else if(node.left == null && node.right == null) return 1;
         
         int leftCount = countLeaves(node.left);
         int rightCount = countLeaves(node.right);
         return leftCount+rightCount;
    }
     

     
    public static int countExactlyOneChild(Node node){
        if(node == null) return 0 ;
        else if(node.left == null && node.right == null) return 0;
        
        int leftCount =countExactlyOneChild(node.left);
        int rightCount =countExactlyOneChild(node.right); 
        int sum = leftCount + rightCount;
        if(node.left==null || node.right == null){
            sum+=1;
        }
        return sum;

    }

    // print the nodes having exactly one child 
    public static void exactlyOneChild(Node node , ArrayList<Integer> ans){

        if(node == null || (node.left==null && node.right == null))
        return;

        if(node.left==null || node.right == null)
        ans.add(node.data);

        exactlyOneChild(node.left,ans);
        exactlyOneChild(node.right,ans);
    }


    // class 2 ----------------------------------

    public static boolean findData(Node node , int data){
        if(node == null) 
            return false;
        
        if(node.data = data)
            return true;
        
        return findData(node.left,data) || findData(node.right,data);
    }
    

    // here we are following the approach of findData 
    // also arrayList is created on heap , so change in arrayList are reflected everyWhere 
    public static boolean nodeToRootPath(Node node , int data , ArrayList<Node> ans){
        if(node == null) return false;

        if(node.data == data){
            ans.add(node);
            return true;
        }

        boolean res = nodeToRootPath(node.left,data,ans) || nodeToRootPath(node.right,data,ans);
        if(res){
            ans.add(node);
        }
        return res;
    }
    public static ArrayList<Node> nodeToRootPath(Node node , int data){
        ArrayList<Integer> ans = new ArrayList<>(); // arrayList created on heap , so changes are reflected evrywhere
        nodeToRootPath(node,data,ans);
        return ans;
    }

    public static ArrayList<Node> nodeToRootPath_02(Node node , int data){
        if(node == null) return null;

        if(node.data == data){
            ArrayList<Node> List = new ArrayList<>();
            List.add(node);
            return List;
        }

        ArrayList<Node> left = nodeToRootPath_02(node.left,data);
        if(left != null){
            left.add(node);
            return left;
        }

        ArrayList<Integer> right = nodeToRootPath_02(node.right , data);
        if(right!=null){
            right.add(node);
            return right;
        }
        return null;
    }

    public static ArrayList<Node> nodeToRootPath02(Node node , int data){
        ArrayList<Node> ans = nodeToRootPath_02(node , data);
        return ans!=null? ans: new ArrayList<>();
    }

    //-------------------------------

    public static void printKlevelsDown(Node node, int k, ArrayList<Integer> ans){
        if(node == null || k < 0) 
            return;
       
        if(k == 0){
            ans.add(node.data);
            return;
        }

        printKlevelsDown(node.left,k-1,ans);
        printKlevelsDown(node.right,k-2,ans);


    }
    //.........................

     public static void printKlevelsDown(Node node, int k,Node block, ArrayList<Integer> ans){
        if(node == null || k < 0 || node == block) 
            return;
       
        if(k == 0){
            ans.add(node.data);
            return;
        }

        printKlevelsDown(node.left,k-1,block,ans);
        printKlevelsDown(node.right,k-2,block,ans);
    }

    public static ArrayList<Integer> kAway(Node node , int data , int k){

       ArrayList<Node> list = new ArrayList<>();
       nodeToRootPath(node,data,list);

       ArrayList<Integer> ans = new ArrayList<>();
       Node block = null;
       for(int i=0; i<list.size();i++){
           printKlevelsDown(list.get(i),k-i,block,ans);
           block = list.get(i);
       }
       return ans;
    }

    //........................
    public static boolean removeLeaves_(Node node){
        if(node == null) return false;
        if(node.left==null && node.right == null){
            return true;
        }
        boolean left = removeLeaves_(node.left);
        if(left){
            node.left = null;
        }

        boolean right = removeLeaves_(node.right);
        if(right){
            node.right = null;
        }
        return false;
    }
    public static Node removeLeaves(Node node){
        boolean res = removeLeaves_(node);
        if(res){
            return null;   // for single node(only root is present)
        }
        else{
            return node;
        }
    }

    ...........................................
    // BST binary search tree
    
    // using static variable, not prefered , thats why see the method below
    static Node prev = null;
    public static boolean isBst(Node node){
       
        if(node == null) return true;
       
        if(!isBst(node.left)){
           return false;
       }
       
       if(prev != null && prev.data > node.data)
       return false;
       prev = node;
       
       if(!isBst(node.right)){
           return false;
       }
       return true;
   }

   // without static variable

   public static class isBstPair{
       boolean isBst = true;
       int maxEle = -(int)1e9; 
       int minEle = (int)1e9; 
   }

   public static isBstPair isBst_02(Node node){
       if(node == null)
        return new isBstPair();

       isBstPair left = isBst_02(node.left);
       if(!left.isBst)
        return left;

       isBstPair right = isBst_02(node.right);
       if(!right.isBst)
        return right;

       isBstPair self = new isBstPair();
       self.isBst = false;

       if(left.maxEle < node.data && right.minEle > node.data){
           self.maxEle = Math.max(right.maxEle,node.data);
           self.minEle = Math.min(left.minEle,node.data);
           self.isBst = true;
       }  

       return self;

   }


// balanced tree --> for every node , -1 <= (leftHeight-rightHeight) <= 1
// this solution is the brute force solution
// brute force solution is the most basic approach to solve the question
// after that you can optimize that code , either by adjusting the if consition,by using extra space,
// or if order does not matter using sorting you can optimize your code
// the code below this is same ditto , but there we are checking if left is not balanced or right is not balanced 
// return false, because then the tree is not balanced
// so that code becomes little more optimized
   public static boolean isBal(Node node){
       if(node == null) return true;

       boolean leftBal = isBal(node.left);
       boolean rightBal = isBal(node.right);

       int lh = height(node.left);
       int rh = height(node.right);

       int diff = Math.abs(lh-rh);
       

       if(!leftBal || !rightBal || diff > 1 ){
           return false;
       }
       return true;
   }

// little more optimized but here also our complexity is O(n^2)
   public static boolean isBal(Node node){
       if(node == null) return true;

       if(!isBal(node.left))
        return false;

       if(!isBal(node.right))
        return false;

       int lh = height(node.left);
       int rh = height(node.right);

       int diff = Math.abs(lh-rh);
       if(diff > 1)
        return false;

       return true;   
   }

   public static class balPair{
       int height = -1;
       boolean isBal = true;
   } 
   public static balPair isBal2(Node node){
       if(node == null){
           return new balPair();
       }

       balPair lPair = isBal2(node.left);
       if(!lPair.isBal)
        return lPair;

       balPair rPair = isBal2(node.right);
       if(!rPair.isBal)
        return rPair;

       balPair myAns = new balPair();
       if(Math.abs(lPair.height - rPair.height) > 1){
           myAns.isBal = false;
           return myAns;
       }  

       myAns.height = Math.max(lPair.height,rPair.height) + 1;
       return myAns;
   }

    public int isBal3(TreeNode node){
        if(node == null) return -1;
        
        int lh = isBal3(node.left);
        if(lh == -2)
            return lh;
        
        
        int rh = isBal3(node.right);
          if(rh == -2)
            return rh;
        
       
        if(Math.abs(lh-rh) > 1){
           
            return-2;
        }
        
        return Math.max(lh,rh)+1;
        
    }
//....................
    // tilt of a node --> left subtree sum - right subtree sum ka mod
    // sum of tilt of all nodes is the tilt of tree
    
    public static class tiltPair{
        int tiltSF =0;
        int sum =0;
    }

    public static tiltPair findTilt(Node node){
        if(node == null)
        return new tiltPair();

        tiltPair left = findTilt(node.left);
        tiltPair right = findTilt(node.right);

        tiltPair myAns = new tiltPair();
        myAns.tiltSF = left.tiltSF + right.tiltSF + Math.abs(left.sum - right.sum);
        myAns.sum = left.sum + right.sum + node.val;

        return myAns;
    }

// other method --> when type of variables are same in class that we return 
// we can make an array and return that as well
// it will take lesser time in writing the code.
// {tiltSF , sum}
    public static int[] findTilt_02(Node node){
        if(node == null)
        return new int[2];

        int[] left = findTilt_02(node.left);
        int[] right = findTilt_02(node.right);

        int[] myAns = new int[2];
        myAns[0] = left[0] + right[0] + Math.abs(left[1] - right[1]);
        myAns[1] = left[1] + right[1] + node.val;

        return myAns;
    }

    // diameter of binary tree  o(n^2)
    public int diameterOfBinaryTree_(TreeNode node){
        if(node == null)
            return 0;
        
        int ld = diameterOfBinaryTree_(node.left);
        int rd = diameterOfBinaryTree_(node.right);
        
        int lh = height(node.left);
        int rh = height(node.right);
        
        return Math.max(Math.max(ld,rd), lh+rh+2);


    }

    //{diameter,height} -- most prefered method // complexity o(n)
    public int[] diameterOfBinaryTree_02(TreeNode node){
        if(node == null)
            return new int[]{0,-1};
        
        int[] ld = diameterOfBinaryTree_02(node.left);
        int[] rd = diameterOfBinaryTree_02(node.right);

        int[] myAns = new int[2];
        myAns[0] = Math.max(Math.max(ld[0],rd[0]), ld[1] + rd[1] + 2);
        myAns[1] = Math.max(ld[1],rd[1]) +1;
        
        return myAns;

    }

// method 3 -- using static
    int diameter = 0;
    public int diameterOfBinaryTree_03(TreeNode node){
        if(node == null)
        return -1;

        int ld = diameterOfBinaryTree_03(node.left);
        int rd = diameterOfBinaryTree_03(node.right);

        diameter = Math.max(diameter, ld + rd +2 );
        return Math.max(ld,rd) + 1;
    }



// largest Bst
   public static class lBstPair{
       boolean isBst = true;
       int max = -(int)1e9;
       int min = (int)1e9;

       int MaxSize =0;
       Node MaxBstNode = null;
   }

   public static lBstPair largestBst(Node node){
       if(node == null)
       return new lBstPair();

       lBstPair left = largestBst(node.left);
       lBstPair right = largestBst(node.right);

       lBstPair myAns = new lBstPair();

       if(left.isBst && right.isBst && left.max < node.data && node.data < right.min){
           myAns.isBst = true;
           myAns.min = Math.min(left.min,node.data);
           myAns.max = Math.max(right.max,node.data);

           myAns.MaxSize = left.MaxSize + right.MaxSize + 1;
           myAns.MaxBstNode = node;
       }
       else{
           myAns.isBst = false;
           myAns.MaxSize = Math.max(left.MaxSize, right.MaxSize);
           myAns.MaxBstNode = left.MaxSize > right.MaxSize ? left.MaxBstNode : right.MaxBstNode;
       }
       return myAns;
   }


   // lca
   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        ArrayList<TreeNode> l1 = nodeToRootPath_02(root,p.val);
        ArrayList<TreeNode> l2 = nodeToRootPath_02(root,q.val);
        
        int i = l1.size() -1;
        int j = l2.size() -1;
        TreeNode lca = null;
        while(i>=0 && j>=0){
            if(l1.get(i) != l2.get(j))
                break;
            lca = l2.get(j);
            i--;
            j--;
        }
        
        return lca;
        
    }

}