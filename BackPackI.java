/* http://www.lintcode.com/en/problem/backpack/# */

public int backPack(int m, int[] A) {
    // write your code here
    if(A == null || A.length == 0 || m == 0) return 0;

    boolean[][] dp = new boolean [A.length+1][m+1];

    /*

    dp[i][j] represent from 0->j if we can fullfill m;
    Initial value dp[0][0] = true;
    dp[*][0] is true;
    dp[i][j] = dp[i-1][j] | dp[i-1][j-A[i-1]]
    */

    for(int i = 0; i <= A.length; i++) {
        dp[i][0] = true;
    }

    int res = 0;

    for(int i = 1; i <= A.length; i++) {
        // Should start from A[i-1] otherwise, you are picking duplicate
        for(int j = 1; j <= m; j++) {
            // First need to restore the previous status!
            dp[i][j] = dp[i-1][j];

            if( j >= A[i-1]) {
                dp[i][j] = dp[i][j] || dp[i-1][j-A[i-1]];
            }

            if(dp[i][j]) {
                res = Math.max(res, j);
            }
        }
    }

    return res;
}
