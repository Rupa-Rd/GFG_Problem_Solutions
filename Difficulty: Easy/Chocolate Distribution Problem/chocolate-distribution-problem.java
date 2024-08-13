//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0;i<n;i++)
                {
                    int x = sc.nextInt();
                    arr.add(x);
                }
            int m = sc.nextInt();
            
            Solution ob = new Solution();
            
    		System.out.println(ob.findMinDiff(arr,n,m));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        Collections.sort(a);
        // System.out.println(a);
        int min = a.get(0), max = a.get(m - 1), diff = max - min;
        for(int i = 1; i <= a.size() - m; i ++){
            min = a.get(i);
            max = a.get(i + m - 1);
            // System.out.println(min+" "+max);
            int temp = max - min;
            diff = Math.min(diff, temp);
        }
        
        return diff;
    }
}