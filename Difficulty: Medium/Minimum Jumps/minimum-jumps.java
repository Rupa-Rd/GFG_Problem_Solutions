//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
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

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr) {
        // your code here
        if (arr.length <= 1)
            return 0;
       
          //If value of first index guarantees 
          //only 1 jump is needed, return 1
        if (arr[0] >= arr.length-1)
            return 1;
 
        // Return -1 if not possible to jump
        if (arr[0] == 0)
            return -1;
 
        // initialization
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;
 
        // Start traversing array
        for (int i = 1; i < arr.length; i++) {
            // Check if we have reached 
// the end of the array
            if (i == arr.length - 1)
                return jump;
           
          //Check if value at current index guarantees jump to end
            if (arr[i] >= (arr.length-1) - i)
                return jump + 1;
 
            // updating maxReach
            maxReach = Math.max(maxReach, i + arr[i]);
 
            // we use a step to get to the current index
            step--;
 
            // If no further steps left
            if (step == 0) {
                // we must have used a jump
                jump++;
 
                // Check if the current 
// index/position or lesser index
                // is the maximum reach point 
// from the previous indexes
                if (i >= maxReach)
                    return -1;
 
                // re-initialize the steps to the amount
                // of steps to reach maxReach from position i.
                step = maxReach - i;
            }
        }
 
        return -1;
    }
}