//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size)
    {
        // your code here
        // Bruteforce
        // int ans = -1, expected = size/2;
        // for(int i = 0; i < size; i ++){
        //     int count = 1;
        //     for(int j = i +1; j < size; j ++){
        //         if(a[j] == a[i]){
        //             count ++;
        //         }
        //     }
        //     if(count > expected){
        //         ans = a[i];
        //         break;
        //     }
            
        // }
        
        // return ans;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < size; i ++){
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        int ans = -1, expect = size/2;
        
        for(Map.Entry<Integer, Integer> g: map.entrySet()){
            int temp = g.getValue();
            if(temp > expect){
                ans = g.getKey();
                break;
            }
        }
        
        return ans;
        
    }
}