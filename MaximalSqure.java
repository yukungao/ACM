/* http://www.lintcode.com/en/problem/maximal-square/# */

public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // write your code here
        // Dynamic programing
        // Build a S[i][j] which means the maxim size squre with i and j as the
        // right-most, bot-most point.
        // Update the max value along the searching.

        if(matrix == null || matrix.length == 0) return 0;

        int rlen = matrix.length;
        int clen = matrix[0].length;
        int [][] dp = new int [rlen+1][clen+1];
        int max = 0;

        for(int i = 1; i <= rlen; i++) {
            for(int j = 1; j <= clen; j++) {
                // Init the boundary
                if(matrix[i-1][j-1] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max*max;
    }
}
