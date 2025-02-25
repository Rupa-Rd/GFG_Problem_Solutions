//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String S = br.readLine();
            Solution ob = new Solution();

            String s = ob.removeUtil(S);
            if (s.isEmpty()) {
                System.out.println("\"\"");
            } else {
                System.out.println(s);
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeUtil(String s) {
        if(!AdjacentDuplicates(s)){
            return s;
        }
        StringBuilder newString = new StringBuilder();
        int i = 0;
        while(i < s.length()){
            if(i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)){
                int end = lastOccurence(s, i);
                i = end;
            }else{
                newString.append(s.charAt(i));
                i++;
            }
            
        }
        
        return removeUtil(newString.toString());
    }
    public int lastOccurence(String s, int start){
        int i = start;
        while(i < s.length() && s.charAt(start) == s.charAt(i)){
            i++;
        }
        return i;
    }
    public boolean AdjacentDuplicates(String s){
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i - 1) == s.charAt(i)){
                return true;
            }
        }
        
        return false;
    }
}