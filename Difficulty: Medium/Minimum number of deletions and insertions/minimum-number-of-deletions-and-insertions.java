//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    int n = str1.length(), m = str2.length();
	    int LCS = longestCommonSubsequence(str1, str2, n, m);
	    int minDel = n - LCS, minIns = m - LCS;
	    
	    return minDel + minIns;
	    
	} 
	public int longestCommonSubsequence(String str1, String str2, int n, int m){
	    
	    int[][] LCS = new int[n + 1][m + 1];
	    
	    for(int i = 0; i <= n; i ++){
	        for(int j = 0; j <= m; j ++){
	            if(i == 0 || j == 0){
	                LCS[i][j] = 0;
	            }
	            else if(str1.charAt(i - 1) == str2.charAt(j - 1)){
	                LCS[i][j] = LCS[i - 1][j - 1] + 1;
	            }else{
	                LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
	            }
	            
	        }
	    }
	    
	    return LCS[n][m];
	}
	
	    
}