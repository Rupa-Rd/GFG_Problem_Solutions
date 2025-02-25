//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      Solution obj = new Solution();
      List<String> ans = obj.generateBinaryStrings(n);
      for(String s : ans) System.out.print(s+" ");
      System.out.println();
    
System.out.println("~");
}
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static List<String> generateBinaryStrings(int n) {
    // code here
    
        List<String> ans = new ArrayList<>();
        if(n == 0){
            return ans;
        }    
        char[] ch = new char[n];
        ch[0] = '0';
        recursiveSol(1, n, ans, ch);
        ch[0] = '1';
        recursiveSol(1, n, ans, ch);
        
        return ans;
  }
  public static void recursiveSol(int indx, int n, List<String> ans, char[] ch){
      if(indx == n){
          ans.add(String.valueOf(ch));
          return;
      }
      
      if(ch[indx - 1] == '0'){
          ch[indx] = '0';
          recursiveSol(indx + 1, n, ans, ch);
          ch[indx] = '1';
          recursiveSol(indx + 1, n, ans, ch);
      }
      
      if(ch[indx - 1] == '1'){
          ch[indx] = '0';
          recursiveSol(indx + 1, n, ans, ch);
      }
  }
}
     
     