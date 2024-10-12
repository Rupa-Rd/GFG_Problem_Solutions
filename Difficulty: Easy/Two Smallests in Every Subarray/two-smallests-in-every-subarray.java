//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int[] a = new int[s.length];
            for (int i = 0; i < s.length; i++) a[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            int res = obj.pairWithMaxSum(a);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public int pairWithMaxSum(int[] arr) {
        // code here
        int N = arr.length;
        if (N < 2)
            return -1;

        // Find two consecutive elements with maximum
        // sum.
        int res = arr[0] + arr[1];
        for (int i = 1; i < N - 1; i++)
            res = Math.max(res, arr[i] + arr[i + 1]);

        return res;
    }
}
