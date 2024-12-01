//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // Define ans variable
        int nProvinces = 0;
        // Define visited array 
        boolean[] visited = new boolean[V];
        // Compute BFS for each non visited vertex of the given graph
        for(int vertex = 0; vertex < V; vertex ++){
            // Count the number of times, the BFS call is made -> no of provinces
            if(!visited[vertex]){
                breadthFirstSearch(vertex, adj, visited);
                nProvinces ++;
            }
        }
        
        
        // Return the number of provinces
        return nProvinces;
    }
    
    // Define BFS
    static void breadthFirstSearch(int vertex, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        // Declare queue data structure to keep track of the vertices
        Queue<Integer> vertexOrder = new LinkedList<>();
        // Add the start vertex into the queue
        vertexOrder.add(vertex);
        // Mark the starting vertex as visited
        visited[vertex] = true;
        // Do the process till the queue is empty
        while(!vertexOrder.isEmpty()){
            // Traverse its neighbouring vertices
            int top = vertexOrder.poll();
            for(int neighbour=0; neighbour < adj.get(0).size(); neighbour ++){
                // If the nieghbouring vertex is not visited, add it to the queue
                if(adj.get(top).get(neighbour) == 1 && !visited[neighbour]){
                    // Mark it as visited
                    vertexOrder.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }
};