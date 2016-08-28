/* http://www.lintcode.com/en/problem/maximum-subarray-difference/ */
// O(n) time O(n) space
/*
1. 记以包含当前节点的,left_min_sum, left_max_sum, right_min_sum, right_max_sum;
2. 最后的答案是 Math.max(abs(left_min_sum - right_max_sum), abs(left_max_sum - right_min_sum));
min_sum = sum - maxSumSubarray;
max_sum = sum - minSumSubarray;
*/
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return 0;

        // Construct four array
        int size = nums.length;
        //
        int [] leftMin = new int[size];
        int [] leftMax = new int[size];
        int [] rightMin = new int[size];
        int [] rightMax = new int[size];

        int max = Integer.MIN_VALUE;

        // Calculate  LeftMax
        int sum = 0;
        int minSum = 0;
        for(int i = 0; i < size; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            leftMax[i] = max;
        }

        // Calculate LeftMin
        int min = Integer.MAX_VALUE;
        sum = 0;
        int maxSum = 0;
        for(int i = 0; i < size; i++) {
            sum += nums[i];
            min = Math.min(min, sum - maxSum);
            maxSum = Math.max(sum, maxSum);
            leftMin[i] = min;
        }

        // Caculate the rightMax
        max = Integer.MIN_VALUE;
        sum = 0;
        minSum = 0;
        for(int i = size-1; i >= 0; i--) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            rightMax[i] = max;
        }

        // Caculate the rightMin
        min = Integer.MAX_VALUE;
        sum = 0;
        maxSum = 0;
        for(int i = size - 1; i >= 0; i--) {
            sum += nums[i];
            min = Math.min(min, sum - maxSum);
            maxSum = Math.max(sum, maxSum);
            rightMin[i] = min;
        }

        // Find the potential result
        int res = 0;
        for(int i = 0; i < size - 1; i++) {
            res = Math.max(res, Math.abs(leftMax[i] - rightMin[i+1]));
            res = Math.max(res, Math.abs(leftMin[i] - rightMax[i+1]));
        }
        return res;
    }
}
