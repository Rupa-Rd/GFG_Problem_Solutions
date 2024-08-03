//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
   
    public int celebrity(int mat[][]) {
        // code here
        // Map<Integer, Integer> map = new HashMap<>();
        int n = mat.length;
        int[] indegree = new int[n];
        int[] outdegree = new int[n];

        // query for all edges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Convert boolean result to int (1 for
                // true, 0 for false)
                int x = knows(i, j, mat) ? 1 : 0;

                // set the degrees
                outdegree[i] += x;
                indegree[j] += x;
            }
        }

        // find a person with indegree n-1 and out degree 0
        for (int i = 0; i < n; i++) {
            if (indegree[i] == n - 1 && outdegree[i] == 0) {
                return i;
            }
        }

        return -1;
    }
    public boolean knows(int a, int b, int[][] matrix)
    {
        return matrix[a][b] == 1;
    }
}