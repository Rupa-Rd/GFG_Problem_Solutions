//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    public String direction = "DLRU";

    // Arrays to represent change in rows and columns
    public int[] dr = { 1, 0, 0, -1 };
    public int[] dc = { 0, -1, 1, 0 };
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        int n = mat.length;
        // List to store all the valid paths
        ArrayList<String> result = new ArrayList<>();
        // Store current path
        StringBuilder currentPath = new StringBuilder();

        if (mat[0][0] != 0 && mat[n - 1][n - 1] != 0) {
            // Function call to get all valid paths
            findPath(0, 0, mat, n, result, currentPath);
        }
        // if(result.size() == 0)
        // return -1;
        
        return result;
    }


    // Function to check if cell(row, col) is inside the
    // maze and unblocked
    public boolean isValid(int row, int col, int n,
                           int[][] maze)
    {
        return row >= 0 && col >= 0 && row < n && col < n
            && maze[row][col] == 1;
    }

    // Function to get all valid paths
    public void findPath(int row, int col, int[][] maze,
                         int n, ArrayList<String> ans,
                         StringBuilder currentPath)
    {
        // If we reach the bottom right cell of the matrix,
        // add the current path to ans and return
        if (row == n - 1 && col == n - 1) {
            ans.add(currentPath.toString());
            return;
        }
        // Mark the current cell as blocked
        maze[row][col] = 0;

        for (int i = 0; i < 4; i++) {
            // Find the next row based on the current row
            // (row) and the dr[] array
            int nextrow = row + dr[i];
            // Find the next column based on the current
            // column (col) and the dc[] array
            int nextcol = col + dc[i];

            // Check if the next cell is valid or not
            if (isValid(nextrow, nextcol, n, maze)) {
                currentPath.append(direction.charAt(i));
                // Recursively call the FindPath function
                // for the next cell
                findPath(nextrow, nextcol, maze, n, ans,
                         currentPath);
                // Remove the last direction when
                // backtracking
                currentPath.deleteCharAt(
                    currentPath.length() - 1);
            }
        }
        // Mark the current cell as unblocked
        maze[row][col] = 1;
    }
}