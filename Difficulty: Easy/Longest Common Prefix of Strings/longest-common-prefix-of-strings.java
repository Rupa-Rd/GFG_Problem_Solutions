//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
        int n = arr.length;
       // take temp_prefix string and assign first element of arr : a.
       String result = arr[0];
      
       // Iterate for rest of element in string.
       for(int i = 1; i < n; i++){
            // .indexOf() return index of that substring from string.
            while(arr[i].indexOf(result) != 0){
              
                // update matched substring prefx
                result = result.substring(0, result.length()-1);
              
                // check for empty case. direct return if true..
                if(result.isEmpty()){
                    return "-1";
                }
            }
        }
        return result;
    }
}