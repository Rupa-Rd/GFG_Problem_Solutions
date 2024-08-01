//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int top = 0, left = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
        // System.out.println(bottom);
        while(top <= bottom && left <= right){
            // First row
            for(int i = left; i <= right; i ++){
                ans.add(matrix[top][i]);
            }
            top ++;
            
            // Last col
            for(int i = top; i <= bottom; i ++){
                ans.add(matrix[i][right]);
            }
            right --;
            
            // Last row
            if(top <= bottom){
                for(int i = right; i >= left; i --){
                    ans.add(matrix[bottom][i]);
                }
                bottom --;
            }
            
            // First col
            if(left <= right){
                for(int i = bottom; i >= top; i --){
                    ans.add(matrix[i][left]);
                }
                left ++;
            }
        }
        
        return ans;
    }
}
