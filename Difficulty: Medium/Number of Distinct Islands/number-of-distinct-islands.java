//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        Set<String> isLands = new HashSet<>();
        
        int n = grid.length, m = grid[0].length;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    Set<String> isShaped = new HashSet<>();
                    dfs(i, j, isShaped, grid, i, j);
                    isLands.add(String.join(",",isShaped));
                }
            }
        }
        
        return isLands.size();
    }
    void dfs(int row, int col, Set<String> isShaped, int[][] grid, int baseX, int baseY){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0){
            return;
        }
        
        grid[row][col] = 0;
        String direction = (row - baseX) + "," + (col - baseY);
        isShaped.add(direction);
        
        dfs(row + 1, col, isShaped, grid, baseX, baseY);
        dfs(row - 1, col, isShaped, grid, baseX, baseY);
        dfs(row, col + 1, isShaped, grid, baseX, baseY);
        dfs(row, col - 1, isShaped, grid, baseX, baseY);
    }
}
