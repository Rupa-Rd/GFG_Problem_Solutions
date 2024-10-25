//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            v = new Solution().alternateSort(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static ArrayList<Integer> alternateSort(int[] arr) {

        // Your code goes here
        Arrays.sort(arr);  // Step 1: Sort the array
        int n = arr.length;
        
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0;  // Pointer to smallest elements
        int right = n - 1;  // Pointer to largest elements
        
        // Step 2: Alternate between largest and smallest elements
        while (left <= right) {
            // Add largest element
            if (right >= left) {
                result.add(arr[right--]);
            }
            // Add smallest element
            if (left <= right) {
                result.add(arr[left++]);
            }
        }
        
        return result;
    }
}
