//{ Driver Code Starts

// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(sc.nextInt());
            }
            Solution ob = new Solution();

            ArrayList<Integer> ans = ob.subsetSums(arr, N);
            Collections.sort(ans);
            for (int sum : ans) {
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java//User function Template for Java
class Solution {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        // Bruteforce: O(n^2)
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        generateSubset(0, 0, n, arr, ans);
        
        return ans;
    }
    
    void generateSubset(int indx, int sum, int n, ArrayList<Integer> A, ArrayList<Integer> ans){
        if( indx == n){
            ans.add(sum);
            return;
        }
        
        // Pick the number
        generateSubset(indx + 1, sum + A.get(indx), n, A, ans);
        
        generateSubset(indx + 1, sum, n, A, ans);
    }
}