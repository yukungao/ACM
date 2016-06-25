/* https://leetcode.com/problems/dungeon-game/ */
/* Dungeon game */
/* Think backwards */
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon[0] == null) return 0;
        int m = dungeon.length;
        int n = dungeon[0].length;
        int [][] dp = new int[m][n];
        /*
         dp[i][j] represent the life value remain when getting into i,j
         We need to search backwards from the destination(right bottom)
         to the source(top left) The result is stored in dp[0][0]
         dp[i][j] =  max(min(dp[i+1][j] , dp[i][j+1]) - dungeon[i][j] , 1)
        */

        dp[m-1][n-1] = Math.max(1 - dungeon[m-1][n-1] , 1);

        // Initialize the dp[0..m-1][n-2]
        for(int i = m-2; i >= 0; i--) {
            dp[i][n-1] = Math.max(dp[i+1][n-1] - dungeon[i][n-1], 1);
        }

        // Initialize the dp[m-1][0..n-2]
        for(int i = n-2; i >= 0; i--) {
            dp[m-1][i] = Math.max(dp[m-1][i+1] - dungeon[m-1][i], 1);
        }

        // Fill the Matrix from bottom right till top left
        for( int i = m-2; i>=0; i--) {
            for( int j = n-2; j>=0; j--) {
                dp[i][j] = Math.max(Math.min(dp[i+1][j] , dp[i][j+1]) - dungeon[i][j] , 1);
            }
        }
        return dp[0][0];
    }
}
