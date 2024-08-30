//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
        int[] board = new int[n];  // board[i] will store the row position of the queen in the i-th column
        solve(0, board, solutions, n);
        return solutions;
    }
    
    private static void solve(int col, int[] board, ArrayList<ArrayList<Integer>> solutions, int n) {
        if (col == n) {
            // All queens are placed successfully
            ArrayList<Integer> solution = new ArrayList<>();
            for (int row : board) {
                solution.add(row + 1);  // Convert 0-based index to 1-based index for output
            }
            solutions.add(solution);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board)) {
                board[col] = row;  // Place queen at (row, col)
                solve(col + 1, board, solutions, n);  // Recursively place queens in the next column
            }
        }
    }

    private static boolean isSafe(int row, int col, int[] board) {
        for (int prevCol = 0; prevCol < col; prevCol++) {
            int prevRow = board[prevCol];
            // Check if two queens are in the same row or in the same diagonal
            if (prevRow == row || Math.abs(prevRow - row) == Math.abs(prevCol - col)) {
                return false;
            }
        }
        return true;
    }
}