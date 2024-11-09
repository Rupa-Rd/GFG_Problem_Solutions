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
            String A = obj.minSum(a);
            System.out.println(A);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String addString(String s1, String s2) {
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();

        // Calculate and store the resultant sum 
          // in reverse order in res
        while (i >= 0 && j >= 0) {
            int sum = (s1.charAt(i) - '0') + 
                      (s2.charAt(j) - '0') + carry;
            res.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }

        // If string s2 is over and string s1 is left
        // Note that the difference in length between
        // the strings could be at max 1.
        if (i == 0) {
            int sum = (s1.charAt(i) - '0') + carry;
            res.append(sum % 10);
            carry = sum / 10;
        }

        // If carry is left
        if (carry > 0) {
            res.append(carry);
        }

        // Remove leading zeroes which are currently
        // at the back due to reversed string res
        while (res.length() > 0 && res.charAt(res.length() - 1) == '0')
            res.deleteCharAt(res.length() - 1);

        // Reverse our final string
        return res.reverse().toString();
    }
    String minSum(int[] arr) {
        // code here
        
        Arrays.sort(arr);
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for (int i = 0; i < arr.length; i += 2) {
            s1.append(arr[i]);
        }
        for (int i = 1; i < arr.length; i += 2) {
            s2.append(arr[i]);
        }

        return addString(s1.toString(), s2.toString());
    }
}
