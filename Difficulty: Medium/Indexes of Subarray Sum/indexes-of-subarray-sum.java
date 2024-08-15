//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        StringBuilder sb = new StringBuilder();
        for (int e : a) sb.append(e + " ");
        System.out.println(sb);
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str[] = br.readLine().trim().split(" ");

            int n = Integer.parseInt(str[0]);
            int s = Integer.parseInt(str[1]);

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(arr, n, s);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        // code here
        // Bruteforce: O(n^2)
        
        ArrayList<Integer> ans = new ArrayList<>();
        // for(int i = 0; i < n; i++){
        //     int sum = 0;
        //     for(int j = i; j < n; j++){
        //         sum += arr[j];
        //         if(sum == s){
        //             ans.add(i+1);
        //             ans.add(j+1);
        //             break;
        //         }
        //     }
        //     if(ans.size() != 0)
        //     break;
        // }
        // if(ans.size() == 0){
        //     ans.add(-1);
        //     // ans.add(-1);
        // }
        
        // return ans;
        
        int i = 0, j = 0, sum =0;
        while(i < n && j < n){
            sum += arr[j];
            while(sum > s ){
                sum -= arr[i];
                i ++;
            }
            if(sum == s && i <= j){
                ans.add(i + 1);
                ans.add(j + 1);
                break;
            }
           j ++; 
        }
        if(ans.size() == 0)
        ans.add(-1);
        
        return ans;
        
    }
}
