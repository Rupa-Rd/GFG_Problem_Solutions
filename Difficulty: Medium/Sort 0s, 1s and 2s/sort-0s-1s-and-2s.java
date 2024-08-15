//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for Java

class Solution
{
    public static void sort012(int a[], int n)
    {
        // code here 
        // Time Complexity: O(n + n) = O(n)
        // int count0 = 0, count1 = 0, count2 = 0;
        
        // for(int i = 0; i < n; i ++){
        //     if(a[i] == 0)
        //     count0 ++;
        //     else if(a[i] == 1)
        //     count1 ++;
        //     else
        //     count2 ++;
        // }
        
        // Replace the elements of the array
        
        // Replace 0's
        // int j = 0;
        // while(j < count0){
        //     a[j ++] = 0;
        // }
        
        // Replace 1's
        
        // while(j < count0 + count1){
        //     a[j ++] = 1;
        // }
        
        // Replace 2's
        
        // while(j < n){
        //     a[j ++] = 2;
        // }
        
        // count0=2, count1=1, count2=2
        // [0 0 1 2 0] -> after replacing 0's j = 2
        // [0 0 1 2 0] -> after replacing 1's j = 3
        // [0 0 1 2 2] -> after replacing 2's j = 5
        
        Arrays.sort(a);
    }
    
}

//{ Driver Code Starts.

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}


// } Driver Code Ends