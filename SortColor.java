/* http://www.lintcode.com/en/problem/sort-colors/ */
/* tag: two-pointers */

class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length <= 1) {
            return;
        }

        // Tracking the end of rd
        int rd_pos = 0;
        // Tracking the start of blue
        int bl_pos = nums.length - 1;
        int cur = 0;
        //Only need to swip till bl_pos
        while (cur <= bl_pos) {
            // If red, then swap with red
            if (nums[cur] == 0) {
                swap(nums, rd_pos, cur);
                rd_pos++;
                cur++;
            // If white, continue
            } else if(nums[cur] == 1) {
                cur++;
            } else {
            // If blue, swap, then blue--
                swap(nums, bl_pos, cur);
                bl_pos--;
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
