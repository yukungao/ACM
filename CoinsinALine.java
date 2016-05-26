/* http://www.lintcode.com/en/problem/coins-in-a-line/ */
/* Coins in a line */

public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        if(n==0) return false;
        if(n<3) return true;

        boolean dp[] = new boolean[n+1];
        dp[1] = true;
        dp[2] = true;

        for(int i = 3; i <= n; i++) {
            // Why the xor logic
            dp[i] = (!dp[i-1])&&dp[i-2] || dp[i-1]&&(!dp[i-2]);
        }
        return dp[n];
    }
}
