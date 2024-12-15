//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);
        
        dist[src] = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++)
        graph.add(new ArrayList<>());
        
        for(int i = 0; i < m; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        // BFS
        Queue<Integer> q = new LinkedList<>();
        
        q.add(src);
        
        while(!q.isEmpty()){
            int node = q.poll();
            
            for(int neigh: graph.get(node)){
                if(dist[neigh] == (int)1e9){
                    dist[neigh] = dist[node] + 1;
                    q.add(neigh);
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            if(dist[i] == (int) 1e9){
                dist[i] = -1;
            }
        }
        return dist;
    }
}