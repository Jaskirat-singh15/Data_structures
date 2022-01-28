import java.util.ArrayList;

public class l003_genericTree {

  public static class Node {

    int data = 0;
    ArrayList<Node> childs;

    Node(int data) {
      this.data = data;
      this.childs = new ArrayList<>();
    }
  }

  public static int height(Node root) {
    int h = -1;
    for (Node child : root.childs) {
      h = Math.max(height(child), h);
    }

    return h + 1;
  }

  // better to use for each loop
  public static int size(Node root) {
    int count = 0;
    for (Node child : root.childs) {
      count += size(child);
    }
    return count + 1;
  }

  // using for loop
  public static int size_2(Node root) {
    int count = 0;
    for (int i = 0; i < root.childs.size(); i++) {
      Node child = root.childs.get(i);
      count += size_2(child);
    }
    return count + 1;
  }

  public static int maximum(Node root) {
    int max = root.data;
    for (Node child : root.childs) {
      max = Math.max(maximum(child), max);
    }
    return max;
  }

  public static int minimum(Node root) {
    int min = root.data;
    for (Node child : root.childs) {
      min = Math.min(minimum(child), min);
    }
    return min;
  }

  // below three questions, cracked by myself submitted on portal
  public static int sum(Node root) {
    int sum = 0;
    for (Node child : root.childs) {
      sum += sum(child);
    }
    return sum + root.data;
  }

  // sir method
  public static int sum(Node root) {
    int sum = root.data;
    for (Node child : root.childs) {
      sum += sum(child);
    }
    return sum;
  }

  public static boolean find(Node root, int data) {
    if (root.data == data) return true;

    boolean ans;
    for (Node child : root.childs) {
      ans = find(child, data);
      if (ans) return true;
    }
    return false;
  }

  //sir method // better 
  public static boolean find(Node root, int data) {
    if (root.data == data) {
      return true;
    }

    boolean res = false;
    for (Node child : root.childs) {
      res = res || find(child, data);
    }
    return res;
  }

  public static boolean find_2(Node root, int data) {
    if (root.data == data) {
      return true;
    }
    boolean res = false;
    for (Node child : root.childs) {
      if (find_2(child, data)) {
        res = true;
        break;
      }
    }
    return res;
  }

  // count leaves in generic tree
  // thought by myself
  public static int countLeaves(Node root) {
    int count = 0;
    for (Node child : root.childs) {
      count += countLeaves(child);
    }

    return count != 0 ? count : count + 1;
  }

  // sir method  // so much simple than my approach
  public static int countLeaves(Node root) {
    if (root.childs.size() == 0) return 1;

    int count = 0;
    for (Node child : root.childs) {
      count += countLeaves(child);
    }
    return count;
  }

  // done by myself :
  // but havenot run anywhere , not sure if correct
  public static ArrayList<Node> nodeToRootPath(Node root, int data) {
    if (root.data == data) {
      ArrayList<Node> list = new ArrayList<>();
      list.add(root);
      return list;
    }

    for (Node child : root.childs) {
      ArrayList<Node> list = nodeToRootPath(child, data);
      if (list) {
        list.add(root);
        return list;
      }
    }
    return null;
  }

  // on portal we need ArrayList<Integer>
  public static ArrayList<Integer> nodeToRootPath(Node root, int data) {
    if (root.data == data) {
      ArrayList<Integer> list = new ArrayList<>();
      list.add(root.data);
      return list;
    }

    for (Node child : root.children) {
      ArrayList<Integer> list = nodeToRootPath(child, data);
      if (list != null) {
        list.add(root.data);
        return list;
      }
    }
    return null;
  }

  // when we need to pass arrayList as arguement.
  // done by myself
  public static boolean nodeToRootPath(
    Node root,
    int data,
    ArrayList<Node> ans
  ) {
    if (root.data == data) {
      ans.add(root);
      return true;
    }

    for (Node child : root.childs) {
      if (nodeToRootPath(child, data, ans)) {
        ans.add(root);
        return true;
      }
    }
    return false;
  }

  // on portal
  public static boolean nodeToRootPath(
    Node root,
    int data,
    ArrayList<Integer> ans
  ) {
    if (root.data == data) {
      ans.add(root.data);
      return true;
    }

    for (Node child : root.children) {
      if (nodeToRootPath(child, data, ans)) {
        ans.add(root.data);
        return true;
      }
    }
    return false;
  }

  // sir method for nodeToRootpath

  public static boolean nodeToRootPath(
    Node root,
    int data,
    ArrayList<Node> ans
  ) {
    if (root.data == data) {
      ans.add(root);
      return true;
    }

    boolean res = false;
    for (Node child : root.childs) res =
      res || nodeToRootPath(child, data, ans);

    if (res) ans.add(root);

    return true;
  }

  public static Arraylist<Node> nodeToRootPath(Node root, int data) {
    if (root.data == data) {
      ArrayList<Node> base = new ArrayList<>();
      base.add(root);
      return base;
    }

    ArrayList<Node> smallAns = new ArrayList<>();
    for (Node child : root.childs) {
      smallAns = nodeToRootPath(child, data);
      if (smallAns.size() != 0) break;
    }

    if (smallAns.size() != 0) {
      smallAns.add(root);
    }

    return smallAns;
  }

  // LCA
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    ArrayList<TreeNode> l1 = nodeToRootPath_02(root, p.val);
    ArrayList<TreeNode> l2 = nodeToRootPath_02(root, q.val);

    int i = l1.size() - 1;
    int j = l2.size() - 1;
    TreeNode lca = null;
    while (i >= 0 && j >= 0) {
      if (l1.get(i) != l2.get(j)) break;
      lca = l2.get(j);
      i--;
      j--;
    }

    return lca;
  }

  public static int distanceBetweenNodes(Node node, int d1, int d2) {
    ArrayList<Integer> l1 = nodeToRootPath(node, d1);
    ArrayList<Integer> l2 = nodeToRootPath(node, d2);
    int LCA = lca(node, d1, d2);
    ArrayList<Integer> l3 = nodeToRootPath(node, LCA);

    int x = l1.size();
    int y = l2.size();
    int z = l3.size();

    int d = x + y - 2 * z;
    return d;
  }

   public static boolean areSimilar(Node n1, Node n2) {
    if(n1.children.size() != n2.children.size())
        return false;
        
    boolean res = true;
    for(int i =0; i< n1.children.size(); i++){
        Node c1 = n1.children.get(i);
        Node c2 = n2.children.get(i);
        
        res = res && areSimilar(c1,c2);
    }
    return res;
  }

   public static boolean areMirror(Node n1, Node n2) {
        if(n1.children.size() != n2.children.size() ){
            return false;
        }
        boolean res = true;
        for(int i = 0 , j = n2.children.size()-1 ; i< n1.children.size() && j>=0; i++ , j--){
            Node c1 =n1.children.get(i) ;
            Node c2 =n2.children.get(j) ;
            res = res && areMirror(c1,c2);
        }
        return res;
  }

  // sir method
   public static boolean areMirror(Node n1 , Node n2){
      if(n1.children.size() != n2.children.size())
      return false;
      
      boolean res = true;
      int size = n1.children.size();
      for(int i =0 ; i< size ; i++){
          Node c1 = n1.children.get(i);
          Node c2 = n2.children.get(size-i-1);
          
          res = res && areMirror(c1,c2);
      }
      
      return res;
  }

  // is symmetric
  public static boolean IsSymmetric(Node node) {
    return areMirror(node,node);
  }

  static int ceil = (int)1e9;
  static int floor = -(int)1e9;
  public static void ceilAndFloor(Node node, int data) {
    if(node.data < data)
        floor = Math.max(floor,node.data);
    if(node.data > data)
    ceil = Math.min(ceil,node.data);
    
    for(Node child : node.children){
        ceilAndFloor(child,data);
    }
  }

 // kth largest element without using static or class or array
    
    

}
