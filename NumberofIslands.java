/* http://www.lintcode.com/en/problem/number-of-islands/# */
/* Number of island */
/* DFS to find the connected component in undirected graph */


public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        // Write your code here

        // Think the 2D array as graph
        // It turns out to be the problem becomes find connected component
        // in Undirected Graph

        // Since we can change the original grid, it save us a visited array:)
        if(grid == null || grid.length == 0) return 0;
        int x_size = grid.length;
        int y_size = grid[0].length;

        int res = 0;
        for(int i = 0; i < x_size; i++) {
            for(int j = 0; j < y_size; j++) {
                if(grid[i][j] == false) continue;
                dfs(grid, i, j);
                res++;
            }
        }
        return res;
    }

    private void dfs(boolean[][] grid, int i, int j) {
        //Don't forget the return when found grid[i][j] = false, no need to search deeper
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == false) return;
        grid[i][j] = false;
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        return;
    }
}
