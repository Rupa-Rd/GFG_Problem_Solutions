//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = scanner.nextInt(); // Number of rows
            int m = scanner.nextInt(); // Number of columns
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    public boolean isSafe(char[][] M, int r, int c) {
        int rows = M.length;
        int cols = M[0].length;
        return (r >= 0) && (r < rows) && (c >= 0) && 
               (c < cols) && (M[r][c] == '1');
    }

    // Breadth-First-Search to visit all cells in the 
    // current island
    public void BFS(char[][] M, int sr, int sc) {
        // These arrays are used to get row and
        // column numbers of 8 neighbours of
        // a given cell
        int[] rNbr = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] cNbr = { -1, 0, 1, -1, 1, -1, 0, 1 };

        // Simple BFS first step, we enqueue
        // source and mark it as visited
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { sr, sc });
        M[sr][sc] = '0';

        // Next step of BFS. We take out
        // items one by one from queue and
        // enqueue their unvisited adjacent
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            // Go through all 8 adjacent
            for (int k = 0; k < 8; k++) {
                int newR = r + rNbr[k];
                int newC = c + cNbr[k];
                if (isSafe(M, newR, newC)) {
                    M[newR][newC] = '0';
                    q.add(new int[] { newR, newC });
                }
            }
        }
    }
    public int numIslands(char[][] M) {
        int rows = M.length;
        int cols = M[0].length;
        int res = 0;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (M[r][c] == '1') {
                    BFS(M, r, c);
                    res++;
                }
            }
        }

        return res;
    }
}