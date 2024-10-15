//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to count the number of subarrays which adds to the given sum.
    static int subArraySum(int arr[], int tar) {
        // add your code here
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        
        // Initialize sum of elements and the result count
        int cumulativeSum = 0;
        int subarrayCount = 0;
        
        // Insert 0 in the map to handle the case where a subarray starts from index 0
        prefixSumCount.put(0, 1);
        
        // Traverse through the array
        for (int num : arr) {
            // Add the current element to the cumulative sum
            cumulativeSum += num;
            
            // Check if (cumulativeSum - target) exists in the map
            if (prefixSumCount.containsKey(cumulativeSum - tar)) {
                subarrayCount += prefixSumCount.get(cumulativeSum - tar);
            }
            
            // Update the map with the current cumulative sum
            prefixSumCount.put(cumulativeSum, prefixSumCount.getOrDefault(cumulativeSum, 0) + 1);
        }
        
        // Return the total number of subarrays with the sum equal to the target
        return subarrayCount;
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

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

            int tar = Integer.parseInt(br.readLine());
            Solution obj = new Solution();
            int res = obj.subArraySum(arr, tar);

            System.out.println(res);
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends