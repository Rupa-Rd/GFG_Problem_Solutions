//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    
    public static int countgroup(int arr[]) {
        // Complete the function
        int MOD = 1000000007;
        int n = arr.length;

        // Step 1: Calculate XOR of the entire array
        int totalXor = 0;
        for (int num : arr) {
            totalXor ^= num;
        }

        // If total XOR is not zero, no such split is possible
        if (totalXor != 0) {
            return 0;
        }

        
        return power(2, n - 1, MOD) - 1;
    }
    public static int power(int b, int p, int mod){
        long res = 1;
        while(p > 0){
            if(p % 2 == 1){
                res = (res * b) % mod;
            }
            p = p / 2;
            b = (b * b) % mod;
        }
        
        return (int) res;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int ans = obj.countgroup(arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends