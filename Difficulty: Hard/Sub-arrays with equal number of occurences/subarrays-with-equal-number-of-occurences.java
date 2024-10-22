//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends
// User function Template for Java

class Solution {

    static int sameOccurrence(int arr[], int x, int y) {
        // write code here
        // int n = arr.length;
               HashMap<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1); // To handle subarrays starting from index 0
        
        int count = 0;
        int balance = 0;
        
        // Step 2: Traverse the array
        for (int num : arr) {
            // Step 3: Update balance
            if (num == x) {
                balance += 1;
            } else if (num == y) {
                balance -= 1;
            }

            // Step 4: Check if the balance has been seen before
            count += prefixMap.getOrDefault(balance, 0);
            
            // Step 5: Add the current balance to the map
            prefixMap.put(balance, prefixMap.getOrDefault(balance, 0) + 1);
        }
        
        return count;
    }
}

//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
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

            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.sameOccurrence(arr, x, y);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends