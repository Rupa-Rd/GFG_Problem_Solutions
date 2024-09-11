//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            long[] a = new long[input.length];

            for (int i = 0; i < input.length; i++) {
                a[i] = Long.parseLong(input[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.minCost(a));
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    // Function to return the minimum cost of connecting the ropes.
    public long minCost(long[] arr) {
        // code here
        // ArrayList<Long> temp = new ArrayList<>();
        // long ans = 0;
        // for(long i: arr)
        //     temp.add(i);
            
        // while(temp.size() > 1){
        //     Collections.sort(temp);
        //     long first = temp.get(0);
        //     long second = temp.get(1);
            
        //     long cost = (first + second);
        //     ans += cost;
            
        //     temp.remove(0);
        //     temp.remove(0);
        //     temp.add(cost);
        // }
        
        // return ans;
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long ans = 0;
        
        for(long i: arr)
            pq.add(i);
        
        while(pq.size() > 1){
            long first = pq.remove();
            long second = pq.remove();
            long cost = first + second;
            
            ans += cost;
            
            pq.add(cost);
        }
        return ans;
    }
}