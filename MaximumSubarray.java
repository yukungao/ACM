/* http://www.lintcode.com/en/problem/maximum-subarray/ */

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code
        if(nums.length == 1) return nums[0];

        int curSum = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(curSum < 0) {
                curSum = 0;
            }

            curSum = curSum + nums[i];

            res = Math.max(res, curSum);

        }
        return res;
    }
}
