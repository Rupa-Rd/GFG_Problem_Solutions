//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static long[] productExceptSelf(int nums[]) {
        // code here
        int n = nums.length;
        long[] prod = new long[n]; 
        if (n == 1) { 
            // System.out.print("0");
            prod[0] = 1;
            return prod; 
        } 
  
        int i;
        long temp = 1; 
  
        /* Allocate memory for the product array */
        
  
        /* Initialize the product array as 1 */
        for (int j = 0; j < n; j++) 
            prod[j] = 1; 
  
        /* In this loop, temp variable contains product of 
           elements on left side excluding arr[i] */
        for (i = 0; i < n; i++) { 
            prod[i] = temp; 
            temp *= nums[i]; 
        } 
  
        /* Initialize temp to 1 for product on right side */
        temp = 1; 
  
        /* In this loop, temp variable contains product of 
           elements on right side excluding arr[i] */
        for (i = n - 1; i >= 0; i--) { 
            prod[i] *= temp; 
            temp *= nums[i]; 
        } 
  
        
  
        return prod; 
    }
}
