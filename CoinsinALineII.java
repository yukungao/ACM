/* http://www.lintcode.com/en/problem/coins-in-a-line-ii/ */
/* Coins in a Line 2 */
/* Game theory, pick the best solution within the worst ones left by the op*/

public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        // dp[i] means, from i to the end, the maxim sum.
        // For each step, the first guy have two choice
        // 1. pick values[i] only
        // 2. pick values[i] and values[i+1]

        // For the 1st choice, the op could pick from dp[i+2] or dp[i+3] and he
        // will pick up the minimum one for you.
        // For the 2st choice, the op could pick from dp[i+3] or dp[i+4] and he
        // will pick the minimum one for you.
        // You are sure to pick the larger one out of 1 and 2
        // So we get the equation
        // dp[i] = max((values[i] + min(dp[i+2], dp[i+3])), values[i] + values[i+1]+ min(dp[i+3], dp[i+4]));

        // The result is to decide if dp[0] > sum - dp[0];
        if (values == null || values.length == 0) return false;
        if (values.length < 3) return true;

        int size = values.length;

        int dp [] = new int [size+1];

        dp[size] = 0;
        dp[size-1] = values[size-1];
        dp[size-2] = values[size-2] + values[size-1];
        dp[size-3] = values[size-3] + values[size-2];
        int op1 = -1;
        int op2 = -1;

        for(int i = size -4; i >=0; i--) {
             op1 = values[i] + Math.min(dp[i+2], dp[i+3]);
             op2 = values[i] + values[i+1]+ Math.min(dp[i+3], dp[i+4]);
            dp[i] = Math.max(op1, op2);
        }

        int sum = 0;
        for(int i = 0; i < size; i++) {
            sum = sum + values[i];
        }

        return (dp[0] > sum - dp[0]);
    }
}
