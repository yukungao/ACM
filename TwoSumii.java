
/* http://www.lintcode.com/zh-cn/problem/two-sum-ii/ */
/* Two pointer */

public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        if(nums == null || nums.length < 2) return 0;
        // Write your code here
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length -1;
        int ans = 0;
        while(left < right) {
            if(nums[left] + nums[right] > target) {

                ans = ans + (right - left);

                right--;
            } else {
                left++;
            }
        }
        return ans;
    }
}
