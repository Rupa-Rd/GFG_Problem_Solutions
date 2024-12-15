//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][3];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
                edge[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res[] = obj.shortestPath(n, m, edge);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    class Pair{
        int edge, weight;
        
        Pair(int edge, int weight){
            this.edge = edge;
            this.weight = weight;
        }
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        boolean[] visited = new boolean[V];
        
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < E; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];
            
            graph.get(u).add(new Pair(v, weight));
        }
        
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                topoSort(i, visited, graph, st);
            }
        }
        
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);
        dist[0] = 0;
        
        while(!st.isEmpty()){
            int top = st.pop();
            
            for(Pair neigh: graph.get(top)){
                int v = neigh.edge;
                int weigh = neigh.weight;
                if(dist[top] + weigh < dist[v]){
                    dist[v] = dist[top] + weigh;
                }
            }
        }
        
        for(int i = 0; i < V; i++){
            if(dist[i] == (int)1e9){
                dist[i] = -1;
            }
        }
        
        return dist;
    }
    public void topoSort(int v, boolean[] visited, ArrayList<ArrayList<Pair>> graph, Stack<Integer> st){
        visited[v] = true;
        
        for(Pair neigh: graph.get(v)){
            if(!visited[neigh.edge]){
                topoSort(neigh.edge, visited, graph, st);
            }
        }
        
        st.push(v);
    }
}