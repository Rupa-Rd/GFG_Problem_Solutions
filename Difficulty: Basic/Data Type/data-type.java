//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            int ans = obj.dataTypeSize(s);
            String Character = "Character";
            if (Character.equals(s) && ans == 2) {
                ans = 1;
            }
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int dataTypeSize(String str) {
        // code here
        HashMap<String, Integer> size = new HashMap<>();
        size.put("Integer", 4);
        size.put("Character", 1);
        size.put("Float", 4);
        size.put("Double", 8);
        size.put("Long", 8);
        // size.put("Byte", 1);
        return size.containsKey(str) ? size.get(str) : -1;
    }
}