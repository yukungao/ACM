/* http://www.lintcode.com/zh-cn/problem/first-position-of-target/ */
/* Binary Search */

class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if(nums == null || nums.length == 0) return -1;

        int lt = 0;
        int rt = nums.length - 1;


        while(lt + 1< rt) {
            int mid = lt + (rt - lt)/2;
            if(nums[mid] == target ) {
                rt = mid;
            } else if(nums[mid] > target) {
                rt = mid;
            } else {
                lt = mid;
            }
        }

        //Find left-one first
        if(nums[lt] == target) {
            return lt;
        }

        //Find right-one first
        if(nums[rt] == target) {
            return rt;
        }
        return -1;
    }
}
