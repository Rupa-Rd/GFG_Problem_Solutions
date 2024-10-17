//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.maximumPoints(arr, N);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][], int N) {
        // Memoization
        int[][] dp = new int[N][4];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
                
        return maxPoints(arr, dp, N - 1, 3);
        // Tabulation

    }
    public int maxPoints(int[][] A, int[][] dp, int day, int lastTask){
        if(dp[day][lastTask] != -1){
            return dp[day][lastTask];
        }
        
        int maxi = 0;
        if(day == 0){
            for(int i = 0; i <= 2; i++){
                if(i != lastTask){
                    maxi = Math.max(maxi, A[day][i]);
                }
            }
            
            return dp[day][lastTask] = maxi;
        }
        
        for(int i = 0; i <= 2; i++){
            if(i != lastTask){
                int tempPoints = A[day][i] + maxPoints(A, dp, day - 1, i);
                maxi = Math.max(maxi, tempPoints);
            }
            
        }
        
        return dp[day][lastTask] = maxi;
    }
}