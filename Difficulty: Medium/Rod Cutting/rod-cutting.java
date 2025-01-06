//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int[] arr = new int[s.length];
            for (int i = 0; i < s.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr));

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public int cutRod(int[] price) {
        // code here
        // l=8, p=0, i=7
        //      /       \
        //l=0, p=20, i=7
         int n = price.length;
         int length = n;
    int[][] dp = new int[n][length + 1];
    
    // Initialize base case for length 0, where no rod can be cut.
    for (int i = 0; i <= length; i++) {
        dp[0][i] = (i / 1) * price[0];  // First rod can be cut into parts of length 1
    }
    
    // Start filling the dp table for all other lengths
    for (int indx = 1; indx < n; indx++) {
        for (int len = 0; len <= length; len++) {
            // Not taking the current rod
            int notTaken = dp[indx - 1][len];
            
            // Taking the current rod if possible
            int taken = Integer.MIN_VALUE;
            if ((indx + 1) <= len) {
                taken = price[indx] + dp[indx][len - (indx + 1)];
            }

            // Store the maximum value in dp[indx][len]
            dp[indx][len] = Math.max(taken, notTaken);
        }
    }

    // The result is stored in the bottom-right cell of the dp table
    return dp[n - 1][length];
        // return memo(n, price, n - 1, dp);
    }
    public int memo(int length, int[] price, int indx, int[][] dp){
        if(indx == 0){
            return (length / (indx + 1)) * price[0];
        }
        if(dp[indx][indx + 1] != -1){
            return dp[indx][indx + 1];
        }
        int taken = Integer.MIN_VALUE;
        int notTaken = recursiveSol(length, price, indx - 1);
        
        if(indx + 1 <= length){
            taken = price[indx] + recursiveSol(length - (indx + 1), price, indx);
        }
        
        return dp[indx][indx + 1] = Math.max(taken, notTaken);
    }
    public int recursiveSol(int length, int[] price, int indx){
        if(indx == 0){
            return (length / (indx + 1)) * price[0];
        }
        int taken = Integer.MIN_VALUE;
        int notTaken = recursiveSol(length, price, indx - 1);
        
        if(indx + 1 <= length){
            taken = price[indx] + recursiveSol(length - (indx + 1), price, indx);
        }
        
        return Math.max(taken, notTaken);
    }
}