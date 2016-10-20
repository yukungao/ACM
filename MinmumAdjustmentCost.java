/* http://www.lintcode.com/en/problem/minimum-adjustment-cost/ */

/*
keypoint:
1. Initialize dp[i][j] to MAX_VALUE

2. dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + Math.abs(j - A.get(i)));
  where Math.abs(j-k) < target && j,k <=100
*/

public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        if(A == null || A.size() == 0) return 0;

        int size = A.size();

        // dp[i][v] is we change the A[i] to v requie the minmum cost
        // The answer is stored here: dp[n-1][..]

        // Initialization: dp[0]
        // Transform function: dp[i][v] = Min(dp[i-1][v'] + k - a[i]) where  v'-target <= k <= v'+target
        int [][] dp = new int[size][101];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j <= 100; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                // If this is the first
                if(i == 0) {
                    dp[i][j] = Math.abs(j - A.get(i));
                } else {
                    for(int k = 0; k <= 100; k++) {
                        if(Math.abs(j - k) > target) {
                            continue;
                        } else {
                            dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + Math.abs(j - A.get(i)));
                        }
                    }
                }
            }
        }

        int res = Integer.MAX_VALUE;

        for(int j = 0; j <= 100; j++) {
            res = Math.min(dp[size-1][j], res);
        }

        return res;

    }
}
