//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int W = Integer.parseInt(in.readLine().trim());
            String line2[] = in.readLine().trim().split(" ");
            int N = line2.length;
            int val[] = new int[N];
            for (int i = 0; i < N; i++) val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split(" ");
            int wt[] = new int[N];
            for (int i = 0; i < N; i++) wt[i] = Integer.parseInt(line3[i]);

            Solution ob = new Solution();
            System.out.println(ob.knapSack(val, wt, W));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = wt.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for(int[] row: dp)
        Arrays.fill(row, -1);
        
        
        
        return memo(n - 1, capacity, wt, val, dp);
    }
    static int memo(int indx, int capacity, int[] wt, int[] val, int[][] dp){
        if(indx == 0){
            return (capacity / wt[0]) * val[0];
        }
        if(dp[indx][capacity] != -1){
            return dp[indx][capacity];
        }
        
        int notTaken = memo(indx - 1, capacity, wt, val, dp);
        int taken = Integer.MIN_VALUE;
        
        if(wt[indx] <= capacity){
            taken = val[indx] + memo(indx, capacity - wt[indx], wt, val, dp);
        }
        
        return dp[indx][capacity] = Math.max(taken, notTaken);
    }
    
    static int recursiveSol(int indx, int capacity, int[] wt, int[] val){
        if(indx == 0){
            return (capacity / wt[0]) * val[0];
        }
        
        int notTaken = recursiveSol(indx - 1, capacity, wt, val);
        int taken = Integer.MIN_VALUE;
        
        if(wt[indx] <= capacity){
            taken = val[indx] + recursiveSol(indx, capacity - wt[indx], wt, val);
        }
        
        return Math.max(taken, notTaken);
    }
    //  f(indx, capacity)
    //                  f(1, 3) = 0
    //              /            \
    //    f(1, 2) = 1           f(0, 3) = 0
    //    /         \            /            \
    //  f(1, 1) = 2  f(1, 2) = 1 f(0, 0) = 1  f(0, 3) = 0
    //   /\
    //  f(1, 0) = 3 f(1, 1) = 2
    //   /\
}