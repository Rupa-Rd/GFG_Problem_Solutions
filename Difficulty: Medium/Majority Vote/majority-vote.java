//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String part : parts) {
                nums.add(Integer.parseInt(part));
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(List<Integer> nums) {
        // Your code goes here.
        int n = nums.size();
        int freq = n / 3;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (Integer i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1); // Corrected method name
        }
        
        List<Integer> ans = new ArrayList<>();
        
        for (Map.Entry<Integer, Integer> m : map.entrySet()) { // Corrected method name
            if (m.getValue() > freq) { // Changed >= to >
                ans.add(m.getKey());
            }
        }
        
        if (ans.size() == 0) {
            ans.add(-1);
        }
        return ans;

    }
}
