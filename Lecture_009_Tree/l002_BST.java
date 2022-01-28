import java.util.ArrayList;
import java.util.Collections;

public class l002_BST {

  public static class Node {

    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }

    Node(int data) {
      this(data, null, null);
    }
  }

  public static int Size(Node node) {
    return (node == null) ? 0 : Size(node.left) + Size(node.right) + 1;
  }

  public static int height(Node node) {
    return (node == null)
      ? -1
      : Math.max(height(node.left), height(node.right)) + 1;
  }

  public static int maximum(Node node) {
    while (node.right != null) {
      node = node.right;
    }

    return node.data;
  }

  public static int minimum(Node node) {
    while (node.left != null) node = node.left;

    return node.data;
  }

  public static int sum(Node node) {
    return (node == null) ? 0 : sum(node.left) + sum(node.right) + node.data;
  }

  public static boolean find(Node node, int data) {
    while (node != null) {
      if (node.data == data) return true; else if (node.data < data) node =
        node.right; else node = node.left;
    }
    return false;
  }

  // T : O(logn) , S : O(1)  // space except arraylist bcz that is what we are passing.
  // thought after revisising nodetorootpath in binary tree 
  // but sir said not to use recursion in BST
  // so this method is not that useful 
  public static ArrayList<Node> nodeToRootPathBst(Node node, int data) {
    if (node == null) return null;

    if (node.data == data) {
      ArrayList<Node> list = new arrayList<>();
      list.add(node);
      return list;
    }

    if (node.data > data) {
      ArrayList<Node> left = nodeToRootPathBst(node.left, data);
      if (left != null) {
        left.add(node);
        return left;
      }
    }

    if (node.data < data) {
      ArrayList<Node> right = nodeToRootPathBst(node.right, data);
      if (right != null) {
        right.add(node);
        return right;
      }
    }

    return null;
  }

// sir method 

    public static ArrayList<Node> nodeToRootPathBst(Node node, int data){
       
        ArrayList<Node> list = new ArrayList<>();
        boolean flag = false;
        list.add(node);
       
        while(node != null){
            if(node.data == data){
                flag true;
                break;
            }
            else if(node.data < data) node = node.right;
            else node = node.left;
        }

        if(!flag)
            list.clear();
        
        Collections.reverse(list);
        return list;
    }

    // lca least common ancestor
    public static int lca(Node node, int d1, int d2) {
    int lca = -1;
    while(node != null){
        if(node.data < d1 && node.data < d2)
            node = node.right;
            
        else if(node.data > d1 && node.data > d2){
            node = node.left;
        }
        else{
            lca = node.data;
            break;
        }
    }
        return lca;
  }


//........................................................
  public static void printInRange(Node node, int d1, int d2) {
    
    if(node == null)
        return;
    
    printInRange(node.left,d1,d2);
    
    if(node.data >= d1 && node.data <= d2)
        System.out.println(node.data);
    
    printInRange(node.right, d1,d2);
  }

  //.................................................................

  // pep site pr duplicate add nhi krne uske liye else if consition lagayi hai
  public static Node add(Node node, int data) {
   if(node == null)
    return new Node(data, null , null);
    
    if(node.data < data){
        node.right = add(node.right,data);
    }
    else if(node.data > data){
        node.left = add(node.left,data);
    }
    
    return node;
  }

  // duplicate bhi add krne ho to
  public static Node addData(Node node, int data) {
   if(node == null)
    return new Node(data, null , null);
    
    if(node.data < data){
        node.right = addData(node.right,data);
    }
    else {
        node.left = addData(node.left,data);
    }
    
    return node;
  }

  //remove node in bst
  public static Node removeNode(Node node , int data){
      if(node.data == data)
      return null;

      if(node.data < data)
      node.right = removeNode(node.right,data);
      else 
      node.left = removeNode(node.left,data);

      return node;
  }
    
    public static Node remove(Node node, int data) {
        if (node == null)
            return null;

        if (node.data < data)
            node.right = remove(node.right, data);
        else if (node.data > data)
            node.left = remove(node.left, data);
        else {
            if (node.left == null || node.right == null)
                return node.left != null ? node.left : node.right;

            int minEle = minimum(node.right);
            node.data = minEle;

            node.right = remove(node.right, minEle);
        }

        return node;
    }
       // leetcode 450
    public static Node remove(Node node, int data) {
        if (node == null)
            return null;

        if (node.data < data)
            node.right = remove(node.right, data);
        else if (node.data > data)
            node.left = remove(node.left, data);
        else {
            if (node.left == null || node.right == null)
                return node.left != null ? node.left : node.right;

            int maxEle = maximum(node.left);
            node.data = maxEle;

            node.left = remove(node.left, maxEle);
        }

        return node;
    }


// add all greater values to that node in a bst -- gfg
    


}
