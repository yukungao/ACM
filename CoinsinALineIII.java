/* http://www.lintcode.com/en/problem/coins-in-a-line-iii/ */
/* coins-in-a-line 3*/

/* There are n coins in a line. Two players take turns to take a coin from one of
the ends of the line until there are no more coins left. The player with the
larger amount of money wins.

Could you please decide the first player will win or lose? */


public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if(values == null || values.length == 0) return false;
        if(values.length <= 2)   return true;
        int size = values.length;
        // dp[i][j] reperenst, from ist-->jst, what's the maxim you can get
        int[][] dp = new int[size+10][size+10];

        // Initialize dp[i][j] with

        for(int i=0; i<=size; i++) {
            for(int j=0; j<=size; j++) {
                dp[i][j] = Integer.MAX_VALUE/2;
            }
        }

        for(int i=1; i<=size; i++) {
            dp[i][i] = values[i-1];
        }

        int sum = 0;

        for(int i=size; i>=1; i--) {
            sum += values[i-1];
            for(int j=i+1; j<=size; j++) {
                dp[i][j] = Math.max(values[i-1] + Math.min(dp[i+2][j], dp[i+1][j-1]),
                    values[j-1] + Math.min(dp[i+1][j-1], dp[i][j-2]));
            }
        }

        return dp[1][size] > sum - dp[1][size];
    }
}
