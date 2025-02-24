//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        // Bruteforce
        int lB = Integer.MIN_VALUE, uB = Integer.MAX_VALUE;
        
        for(int i = 0; i < arr.length; i++){
            
            if(arr[i] <= x && arr[i] > lB){
                lB = arr[i];
            }
            
            if(arr[i] >= x && arr[i] < uB){
                uB = arr[i];
            }
        }
        
        
        if(lB == Integer.MIN_VALUE)
            lB = -1;
        if(uB == Integer.MAX_VALUE)
            uB = -1;
            
            
        return new int[]{lB, uB};
        
    }
}
