//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.print2largest(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int print2largest(int[] arr) {
        // Code Here
        // Bruteforce: O(NlogN)
        // if(arr.length < 2)
        // return -1;
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // pq.add(arr[0]);
        // for(int ele: arr){
        //     if(pq.size() != 0 && ele != pq.peek())
        //         pq.add(ele);
    
        //     if(pq.size() > 2){
        //         pq.remove(pq.size());
        //     }
        // }
        // pq.remove();
        
        // return pq.size() != 0 ? pq.remove() : -1;
        
        // Arrays.sort(arr);
        // return arr[arr.length - 2];
        
        if(arr.length < 2)
        return -1;
        
        int large = Integer.MIN_VALUE, secondLarge = Integer.MIN_VALUE;
        
        for(int i: arr){
            if(i > large){
                secondLarge = large;
                large = i;
            }else if(i > secondLarge && i != large){
                secondLarge = i;
            }
        }
        
        return secondLarge != Integer.MIN_VALUE ? secondLarge : -1;
    }
}