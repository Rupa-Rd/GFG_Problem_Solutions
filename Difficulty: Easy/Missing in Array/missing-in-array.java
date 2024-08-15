//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            System.out.println(sln.missingNumber(n, arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {

    // Note that the size of the array is n-1
    int missingNumber(int n, int arr[]) {
        
        // Your Code Here
        // Bruteforce : O(n^2)
        // int missing = -1;
        // for(int i = 1; i < n; i ++){
        //     int counter = 0;
        //     for(int j = 0; j < n-1; j ++){
        //         if(arr[j] != i){
        //             counter ++;
        //         }
        //     }
        //     if(counter == n-1)
        //     return i;
        // }
        
        // return n;
        
        // Optimized Solution:
        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));
        for(int j = 0; j < n - 1; j ++){
            if(arr[j] != j + 1)
            return j + 1;
        }
        
        return n;
    }
}