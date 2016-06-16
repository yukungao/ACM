/* http://www.lintcode.com/en/problem/house-robber/ */


public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        int size = A.length;
        if(A == null || size == 0) return 0;
        if(size == 1) return A[0];

        long [] dp = new long [A.length];
        dp[0] = A[0];
        dp[1] = Math.max(A[1],A[0]);

        for(int i = 2; i < A.length; i++) {
            dp[i] = Math.max(dp[i-2]+A[i], dp[i-1]);
        }

        return dp[A.length-1];
    }
}



/* Rolling array to reduce space complexity to o(1) */

public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        int size = A.length;
        if(A == null || size == 0) return 0;
        if(size == 1) return A[0];

        long [] dp = new long [2];
        dp[0] = A[0];
        dp[1] = Math.max(A[1],A[0]);

        for(int i = 2; i < A.length; i++) {
            dp[i%2] = Math.max(dp[(i-2)%2]+A[i], dp[(i-1)%2]);
        }

        return dp[(A.length-1)%2];
    }
}
