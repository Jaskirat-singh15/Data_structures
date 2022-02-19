import java.util.ArrayList;
import java.util.LinkedList;


public class l001{
   
   public static class Edge{
       int src;
       int nbr;
       int wt;

       Edge(int src, int nbr, int wt){
           this.src = src;
           this.nbr = nbr;
           this.wt = wt;
       }
   }

   public static void addEdge(ArrayList<Edge>[] graph , int u , int v , int w){
       graph[u].add(new Edge(u,v,w));
       graph[v].add(new Edge(v,u,w)); // bidirectional
   }

   public static void display(ArrayList<Edge>[] graph, int N){

       for(int i = 0; i < N; i++){
           System.out.print(i + "->");
           for(Edge e : graph[i]){
               System.out.print("(" + e.nbr + "," + e.wt + ") ");
           }
           System.out.println();

       }
       System.out.println();

   }
   
   public static int findEdge(ArrayList<Edge>[] graph, int u , int v){
       ArrayList<Edge> list = graph[u];
       for(int i = 0; i< list.size(); i++){
           Edge e = list.get(i);
           if(e.nbr == v)
            return i;
       }
       return -1;
   }

   public static void removeEdge(ArrayList<Edge>[] graph , int u , int v){
      
      int i1 = findEdge(graph, u, v);
      int i2 = findEdge(graph, v, u);

      graph[u].remove(i1);
      graph[v].remove(i2);

   }
    
    // there is a reason for running the loop from backwrd.
    // because if we remove from the starting , after deletion of a edge , shifting happens in arrayList
    // due to which some edges will not get deleted.
    // but running the loop from backward index or last index overcomes this problem.
   public static void removeVertex(ArrayList<Edge>[] graph , int u){
       ArrayList<Edge> list = graph[u];

       for(int i = list.size()-1; i>=0; i--){
           Edge e = list.get(i);

           removeEdge(graph, e.src, e.nbr);
       }
   }

   public static boolean hasPath(ArrayList<Edge>[] graph, int src , int des, boolean[] vis){
       if(src == des)
        return true;
    
       vis[src] = true;
       boolean res = false;
       for(Edge e : graph[src]){
           if(!vis[e.nbr])
            res = res || hasPath(graph,e.nbr,des,vis);
       }

       return res;

   }

   // print all paths
   // psf --> path so far
   public static int printAllPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis, String psf){
       if(src == dest){
          System.out.println(psf + dest);
       }
       vis[src] = true;
      int count = 0;
        for(Edge e : graph[src]){
            if(!vis[e.nbr]){
                count +=  printAllPaths(graph,e.nbr,dest,vis,psf + src);
            }
        }

        vis[src] = false;
        return count;

   }

   // thought myself , correct , but sir later said no need of dest in this question, see sir code below
   public static void preOrder(ArrayList<Edge>[] graph , int src , int dest, boolean[] vis, int wsf, String psf){
       
       if(src == dest){
           System.out.println(src + "->" + psf+dest + "@" + wsf);
       }
        else{
            System.out.println(src + "->" + psf+src + "@" + wsf);
        }

        vis[src] = true;
        // boolean res = false;
        for(Edge e : graph[src]){
            if(!vis[e.nbr]){
    
                 preOrder(graph,e.nbr,dest,vis,wsf+e.wt,psf+src);
            }
        }

       vis[src] = false;
    //    return res;
   }

    // here no need of base case. 
   public static void preOrder_(ArrayList<Edge>[] graph , int src , boolean[] vis, int wsf, String psf){
       System.out.println(src + " -> " + (psf+src) + " @ " + wsf);
       vis[src] = true;
       for(Edge e : graph[src]){
           if(!vis[e.nbr]){
               preOrder_(graph,e.nbr,vis,wsf+e.wt,psf+src);
           }
       }
       vis[src] = false;

   }

   // just print while backtacking for postOrder
    public static void postOrder_(ArrayList<Edge>[] graph , int src , boolean[] vis, int wsf, String psf){
       vis[src] = true;
       for(Edge e : graph[src]){
           if(!vis[e.nbr]){
               postOrder_(graph,e.nbr,vis,wsf+e.wt,psf+src);
           }
       }

       System.out.println(src + " -> " + (psf+src) + " @ " + wsf);
       vis[src] = false;

   }

    public static class pathPair{
        String psf = "";
        int wsf = -1;
    }

//     public static pathPair lightestPath(ArrayList<Edge>[] graph, int src , int dest, boolean[] vis){

//         for(Edge e : graph[src]){
//             if(!vis[e.nbr]){
//                 pathPair recAns = heaviest
//             }
//         }
        
//    }

   public static pathPair heaviestPath(ArrayList<Edge>[] graph, int src , int dest, boolean[] vis){
        if(src == dest){
            pathPair base = new pathPair();
            base.psf += src;
            base.wsf =0;

            return base;
        }

        vis[src] = true;
        pathPair myAns = new pathPair();
        for(Edge e : graph[src]){
            if(!vis[e.nbr]){
                pathPair recAns = heaviestPath(graph,e.nbr,dest,vis);
                if(recAns.wsf != -1 && recAns.wsf + e.wt > myAns.wsf){
                    myAns.psf = src + recAns.psf;
                    myAns.wsf = recAns.wsf + e.wt;
                }
            }
        }

        vis[src] = false;
        return myAns;
   }
    public static void heaviestPath(ArrayList<Edge>[] graph, int src, int dest) {
        boolean[] vis = new boolean[graph.length];
        pathPair ans = heaviestPath(graph, src, dest, vis);

        System.out.println("Heaviest Path: " + ans.psf + " of weight: " + ans.wsf);
    }

    public static class ceilFloorPair{
        int ceil = (int)1e9;
        int floor = -(int)1e9;
    }

    public static void ceilAndFloor_(ArrayList<Edge>[] graph, int src, int data, boolean[] vis,int wsf, ceilFloorPair pair){

        if(wsf > data){
            pair.ceil = Math.min(pair.ceil,wsf);
        }
        if(wsf < data){
            pair.floor = Math.max(pair.floor,wsf);
        } 

        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.nbr]){
                ceilAndFloor_(graph,e.nbr,data,vis,wsf+e.wt,pair);
            }
        }
        vis[src] = false;

    }
    public static void ceilAndFloor(ArrayList<Edge>[] graph,int src, int data){
        ceilFloorPair pair = new ceilFloorPair();
        boolean[] vis = new boolean[graph.length];
        ceilAndFloor_(graph,src,data,vis,0,pair);
        System.out.println(pair.ceil + " " + pair.floor);
    }

    public static void dfs_GCC(ArrayList<Edge>[] graph, int src , boolean[] vis){
        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.nbr]){
                dfs_GCC(graph,e.nbr,vis);
            }
        }
    }

    public static void GCC(ArrayList<Edge>[] graph , int src , boolean[] vis){
        int N = graph.length, componentCount =0;
        // boolean[] vis = new boolean[N];
        for(int i =0; i< N ;i++){
           if(!vis[i]){
            dfs_GCC(graph,i,vis);
            componentCount++;
           }
        }
        System.out.println(componentCount);
    }

    // on portal -- question is graph connected  // little bit change on above code.
     public static boolean GCC_(ArrayList<Edge>[] graph , int src , boolean[] vis){
        int componentCount =0;
        int N = graph.length;
        for(int i =0; i< N ;i++){
           if(!vis[i]){
                dfs_GCC(graph,i,vis);
            componentCount++;
           }
        }
        if(componentCount <= 1)
        return true;
        else return false;
    }   

    // number of island leetcode 200
    public void dfs(char[][] grid, int[][] dir, int sr, int sc){
        
        grid[sr][sc] = '0';
        for(int d =0; d<4; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c]== '1' )
                 dfs(grid, dir, r , c); 
            
            
        }
    }
    
    public int numIslands(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int componentCount = 0;
        
        int[][] dir = {{1,0}, {-1,0}, {0,-1}, {0,1}};
        
        for(int i =0 ; i< n ; i++){
            for(int j =0 ; j<m ; j++){
                if(grid[i][j] == '1'){
                     dfs(grid, dir, i,j);
                    componentCount++;
                }
                   
            }
        }
        return componentCount;
    }

    // area of island leetcode 695

     public int dfs(int[][] grid, int[][] dir, int sr , int sc){
        grid[sr][sc] = 0;
        int size = 0;
        for(int d =0; d<4 ; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if(r >=0 && c >=0 && r < grid.length && c < grid[0].length  && grid[r][c] == 1)
              size +=   dfs(grid,dir,r,c);
                
            
        }
         return size + 1;
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int maxSize = 0;
        
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
        
        for(int i =0 ; i< n ; i++){
            for(int j =0; j<m ; j++){
                
                if(grid[i][j] == 1){
                   int s = dfs(grid,dir,i,j);
                    maxSize = Math.max(maxSize,s);
                }
            }
        }
        return maxSize;
    }

    public static void hamiltonianPathCycle(ArrayList<Edge>[] graph, int osrc, int src, int edgeCount , boolean[] vis, String ans){

        if(edgeCount == graph.length-1){
            int idx = findEdge(graph,src,osrc);

            if(idx != -1){
                System.out.println(ans + src + "*");
            }
            else{
                System.out.println(ans + src + ".");
            }

            return;
        }

        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.nbr])
                hamiltonianPathCycle(graph,osrc,e.nbr,edgeCount+1,vis,ans+src);
        }

        vis[src] = false;

    }

    public static void hamiltonianPathCycle_(ArrayList<Edge>[] graph, int src){
        int N = graph.length;
        boolean[] vis = new boolean[N];
        hamiltonianPathCycle(graph,src,src,0,vis,"");
    }

    public static void BFS(ArrayList<Edge>[] graph , int src , int dest){

        LinkedList<Integer> que = new LinkedList<>();
        int N = graph.length;
        boolean[] vis = new boolean[N];

        que.addLast(src);
        int level = 0;

        boolean isCyclePresent = false;
        int shortestPath = -1;

        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                int rvtx = que.removeFirst();

                if(vis[rvtx]){
                    isCyclePresent = true;
                    continue;
                }

                if(rvtx == dest){
                    shortestPath = level;
                }

                vis[rvtx] = true;
                for(Edge e : graph[rvtx]){
                    if(!vis[e.nbr]){
                        que.addLast(e.nbr);
                    }
                }
            }
        }
    }



   public static void construction(){
       int N = 7;
       ArrayList<Edge>[] graph = new ArrayList[N];
       for(int i =0; i<N ; i++){
           graph[i] = new ArrayList<>();
       }

        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 3, 10);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 40);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 2);
        addEdge(graph, 4, 6, 8);
        addEdge(graph, 5, 6, 3);

        // display(graph,N);
        // removeVertex(graph, 4);
        // // removeEdge(graph,0,3);
        // display(graph,N);
        boolean[] vis = new boolean[N];
        String psf = "";
        // printAllPaths(graph,0,6,vis,psf);
        int wsf = 0;
        // preOrder_(graph,0,vis,wsf,psf);
        // System.out.println();
        // postOrder_(graph,0,vis,wsf,psf);

        // heaviestPath(graph,0,6);

        // ceilAndFloor(graph,0,42);

        // hamiltonianPathCycle_(graph,0);

        BFS(graph,0,6);
   }


   
   
    public static void main(String[] args){
        construction();
        
    }
}