/* http://www.lintcode.com/en/problem/unique-binary-search-trees/ */

public class Solution {
    /**
     * @paramn n: An integer
     * @return: An integer
     */
    public int numTrees(int n) {
        // write your code here
        // Since its BST, the order matters
        // Could get the transition function.
        // dp[k] = dp[0] * dp[k-1] + dp[1] * dp[k-2] +..

        if(n < 0)return 0;
        if(n == 0 || n == 1) return 1;

        int[] dp = new int[n+1];
        //Null tree
        dp[0] = 1;
        // Only one node
        dp[1] = 1;

        for(int i = 2; i <=n; i++) {
            for(int j = 0; j < i; j++) {
                dp[i] += dp[j]*dp[i-j-1];
            }
        }

        return dp[n];
    }
}
