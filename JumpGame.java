/* http://www.lintcode.com/en/problem/jump-game/ */
// Greedy

public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        // Greedy, pick the largest remain step.

        if(A == null || A.length == 0) return true;
        int remain = A[0];

        for(int i =1; i < A.length; i++) {
            remain--;
            if(remain < 0) {
                return false;
            }
            if(remain < A[i]) {
                remain = A[i];
            }
        }
        return true;
    }
}
