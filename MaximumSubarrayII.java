/* http://www.lintcode.com/en/problem/maximum-subarray-ii/# */

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        // The essential idea here is to split array by index i,
        // Calculate the maximum sum [0..i] from left to right
        // Calculate the maximum sum [i..n-1] from right to left
        // Then merger them togther.
        // 1. Need to store max and min so far, then the max = max - min
        // 2. Don't add nums[i] twice

        if(nums == null || nums.size() == 0) return 0;

        int size = nums.size();
        int sum  = 0;
        int leftMax[] = new int[size];
        int rightMax[] = new int[size];

        // From left to right
        int curMax = Integer.MIN_VALUE;
        int curMin = 0;
        for(int i=0; i < size; i++) {
            sum = sum + nums.get(i);
            curMax = Math.max(curMax, sum - curMin);
            curMin = Math.min(curMin, sum);
            leftMax[i] = curMax;
        }

        // From right to left, find the right part maxim sum
        sum = 0;
        curMax = Integer.MIN_VALUE;
        curMin = 0;

        for(int i = size -1; i >= 0; i--) {
            sum = sum + nums.get(i);
            curMax = Math.max(curMax, sum - curMin);
            curMin = Math.min(curMin, sum);
            rightMax[i] = curMax;
        }

        // Merge together
        //merge
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < size - 1; i++) {
            result = Math.max(leftMax[i] + rightMax[i+1], result);
        }
        return result;

    }
}
