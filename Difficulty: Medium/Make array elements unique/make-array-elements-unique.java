//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            int A = obj.minIncrements(a);
            System.out.println(A);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int minIncrements(int[] arr) {
        // Code here
        int n = arr.length;
        int cnt = 0;

        // Find the maximum element in the array
        int mx = arr[0];
          for (int ele : arr) 
              mx = Math.max(mx, ele);

        // Create a frequency array
        int[] freq = new int[n + mx + 1];

        // Find the frequency of all elements from the array
        for (int ele : arr)
            freq[ele]++;

        for (int num = 0; num < freq.length; num++) {
            // If there is more than one occurrence of num
            if (freq[num] > 1) {
                // Increment all extra occurrences by 1 
                freq[num + 1] += freq[num] - 1;

                // Count these increment operations
                cnt += freq[num] - 1;
                freq[num] = 1;
            }
        }

        return cnt;
    }
}