//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String A[] = in.readLine().trim().split(" ");
            int N = Integer.parseInt(A[0]);
            A = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.isCircle(A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int isCircle(String s[]) {
        // code here
        int m = 26, n = s.length; 
    boolean mark[] = new boolean[m]; 
    int in[] = new int[26]; 
    int out[] = new int[26]; 
      
    ArrayList< 
    ArrayList<Integer>> adj = new ArrayList< 
                                  ArrayList<Integer>>(); 
    for(int i = 0; i < m; i++) 
        adj.add(new ArrayList<>()); 
          
    // Process all strings one by one 
    for(int i = 0; i < n; i++)  
    { 
          
        // Find first and last characters 
        int f = (int)(s[i].charAt(0) - 'a'); 
        int l = (int)(s[i].charAt( 
                 s[i].length() - 1) - 'a'); 
          
        // Mark the characters 
        mark[f] = mark[l] = true; 
          
        // Increase indegree and outdegree count 
        in[l]++; 
        out[f]++; 
          
        // Add an edge in graph 
        adj.get(f).add(l); 
    } 
      
    // If for any character indegree is not equal to 
    // outdegree then ordering is not possible 
    for(int i = 0; i < m; i++) 
    { 
        if (in[i] != out[i]) 
            return 0; 
    } 
    return isConnected(adj, mark,  
                       s[0].charAt(0) - 'a') == true ? 1 : 0; 
    }
    public static boolean isConnected( 
    ArrayList<ArrayList<Integer>> adj, 
    boolean mark[], int src) 
{ 
    boolean visited[] = new boolean[26]; 
      
    // Perform a dfs from src 
    dfs(adj, visited, src); 
    for(int i = 0; i < 26; i++) 
    { 
      
        /*  I character is marked (i.e. it was first or 
         last character of some string) then it should 
         be visited in last dfs (as for looping, graph 
         should be strongly connected) */
        if (mark[i] && !visited[i]) 
            return false; 
    } 
      
    // If we reach that means graph is connected 
    return true; 
} 
  
// Utility method for a depth first  
// search among vertices 
public static void dfs(ArrayList<ArrayList<Integer>> adj, 
                       boolean visited[], int src) 
{ 
    visited[src] = true; 
    for(int i = 0; i < adj.get(src).size(); i++) 
        if (!visited[adj.get(src).get(i)]) 
            dfs(adj, visited, adj.get(src).get(i)); 
} 
}