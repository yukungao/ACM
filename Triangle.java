/* http://www.lintcode.com/en/problem/triangle/ */
/*
这个题需要注意的地方在于,边界需要处理一下子.
*/

public int minimumTotal(int[][] triangle) {
    // write your code here
    if(triangle == null || triangle.length == 0) return -1;
    if(triangle[0] == null || triangle.length == 0) return -1;

    // Initialize the
    int x_size = triangle.length;
    int y_size = triangle[x_size-1].length;
    int [][] dp = new int[x_size][y_size];

    // Choose the top-down version

    // Initialize
    // Need to take care of the edges
    dp[0][0] = triangle[0][0];

    for(int i = 1; i < x_size; i++) {
        dp[i][0] = dp[i-1][0] + triangle[i][0];
        dp[i][i] = dp[i-1][i-1] + triangle[i][i];
    }

    // Do the transition
    for(int i = 1; i < x_size; i++) {
        for(int j = 1; j < i; j++) {
            dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + triangle[i][j];
        }
    }

    // Find the answer
    int res = Integer.MAX_VALUE;
    for(int i = 0; i < y_size; i++) {
        res = Math.min(dp[x_size-1][i], res);
    }

    return res;

}
