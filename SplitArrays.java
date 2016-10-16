/* https://leetcode.com/problems/split-array-largest-sum/ */

/* DP solution, O(n^3), TLE */
public int splitArray(int[] nums, int m) {
    /*
        Tradition DP problem
        dp[s][j] represnet from nums[0,j-1], we split s subarray,
        that could achieve the optimal result:
        Thus, we h

    */

    if(nums == null || nums.length == 0) return 0;

    int len = nums.length;
    int [][] dp = new int[m+1][len+1];
    int[] sum = new int[len+1];

    for(int i = 0; i <= m; i++) {
        for(int j = 0; j <= len; j++) {
            dp[i][j] = Integer.MAX_VALUE;
        }
    }
    dp[0][0] = 0;

    // Calculate the sum

    for(int i = 1; i <= len; i++) {
        sum[i] = sum[i-1] + nums[i-1];
    }


    for(int i = 1; i <= m; i++) {
        for(int j = i; j <= len; j++) {
            for(int k = i - 1; k < j; k++) {
                dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][k], sum[j] - sum[k]));
            }
        }
    }

    return dp[m][len];
}

/* Greedy + Binary Search */
/*o(nlgn) */
