//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])
    {
        //taking input using class Scanner
        Scanner sc = new Scanner(System.in);
        
        //taking total count of testcases
        int t = sc.nextInt();
        
        
        
        while(t-- > 0)
        {
            //taking total number of elements
            int n = sc.nextInt();
            
            //taking size of subArrays 
            int k = sc.nextInt();
            
            //Declaring and Intializing an array of size n
            int arr[] = new int[n];
            
            //adding all the elements to the array 
            for(int i = 0; i <n; i++)
            {
                arr[i] =sc.nextInt();
            }
            
            //Calling the method max_of_subarrays of class solve
            //and storing the result in an ArrayList
            ArrayList <Integer> res = new Solution().max_of_subarrays(arr, n, k);
            
            //printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        int tempMax = 0;
        for(int i = 0; i < k; i ++){
            tempMax = Math.max(tempMax, arr[i] );
        }
        
        ans.add(tempMax);
        
        for(int i = 1; i <= n - k; i ++){
            if(arr[i-1] == tempMax){
                int temp = arr[i];
                for(int j = i+1; j < i + k; j ++){
                    temp= Math.max(temp, arr[j]);
                } 
                tempMax = temp;
            }else{
                tempMax = Math.max(tempMax, arr[i + k - 1]);
            }
            ans.add(tempMax);
        }
        // for(int i = 0; i <= n - k ; i ++){
        //     int tempMax = arr[i];
        //     for(int j = i+1; j < i + k; j ++){
        //         tempMax= Math.max(tempMax, arr[j])
        //     }
        //     ans.add(tempMax);
        // }
        
        
        return ans;
    }
}