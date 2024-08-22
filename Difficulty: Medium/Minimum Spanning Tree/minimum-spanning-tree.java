//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair<K, V>{
    public K vertex;
    public V weight;
    
    public Pair(K vertex, V weight){
        this.vertex = vertex;
        this.weight = weight;
    }
}
class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        boolean[] visited = new boolean[V];
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((x,y) -> x.weight - y.weight);
        
        pq.add(new Pair(0,0));
        int mstWeight = 0;
        // System.out.println(Collection.toString(adj)));
        
        while(!pq.isEmpty()){
            int vertex = pq.peek().vertex;
            int weight = pq.peek().weight;
            pq.poll();
            
            if(visited[vertex]) continue;
            
            visited[vertex] = true;
            mstWeight += weight;
            // for(int[] a: adj){
            //     System.out.println(Arrays.deepToString(a));
            // }
            for(int[] neighbor: adj.get(vertex)){
                
                if(!visited[neighbor[0]]){
                    pq.add(new Pair(neighbor[0], neighbor[1]));
                }
            }
        }
        
        return mstWeight;
    }
}