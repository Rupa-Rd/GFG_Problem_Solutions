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
        for(int i = 0; i < arr.length; i++){
            while(arr[i] != i+1 && arr[i] < n){
                int correctPos = arr[i] - 1;
                int temp = arr[i];
                arr[i] = arr[correctPos];
                arr[correctPos] =  temp;
            }
        }
        // System.out.println(Arrays.toString(arr));
        for(int i = 0; i < n - 1; i++){
            if(arr[i] != i+1){
                return i +1 ;
            }
        }
        return n;
    }
}