//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for(int i: arr){
            if(i < 0)
                neg.add(i);
            else
                pos.add(i);
        }
        
        int l = 0, r = 0, k = 0, check = 0;
        
        while(l < pos.size() && r < neg.size()){
            if(check == 0){
                arr.set(k, pos.get(l));
                l++;
                check = 1;
            }else{
                arr.set(k, neg.get(r));
                r++;
                check = 0;
            }
            k++;
        }
        
        while(l < pos.size()){
            arr.set(k, pos.get(l));
            l ++;
            k++;
        }
        while(r < neg.size()){
            arr.set(k, neg.get(r));
            r++;
            k++;
        }
    }
}