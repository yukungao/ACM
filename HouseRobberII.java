/* http://www.lintcode.com/en/problem/house-robber-ii/ */


public class Solution {
    /**
     * @param nums: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public int houseRobber2(int[] nums) {
        // write your code here
        // Since its a circle, there are two condition
        // 1. The last house  get robbed
        // 2. The last house didn't get robbed
        int size = nums.length;

        if(nums == null || size == 0) {
            return 0;
        } else if(size == 1) {
            return nums[0];
        } else if(size == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int [] dp1 = new int [size];
        int [] dp2 = new int [size];

        // Condition 1: The last house didn't be robbed
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);


        for(int i = 2; i < size -1; i++) {
            dp1[i] = Math.max(dp1[i-2] + nums[i], dp1[i-1]);
        }
        dp1[size-1] = dp1[size-2];

        // Condition 2: The last house be robbed
        dp2[0] = 0;
        dp2[1] = nums[1];

        for(int i = 2; i < size -2; i++) {
            dp2[i] = Math.max(dp2[i-2] + nums[i], dp2[i-1]);
        }

        dp2[size-1] = dp2[size-3] + nums[size-1];

        return Math.max(dp1[size-1], dp2[size-1]);

    }
}
