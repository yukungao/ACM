/* https://leetcode.com/problems/single-number/ */
// The typical "XOR" process

public class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int res = 0;

        for(int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }

        return res;
    }
}
