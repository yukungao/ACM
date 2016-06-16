/* http://www.lintcode.com/en/problem/first-position-of-target/# */



class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if(nums == null || nums.length == 0) return -1;
        int res = -1;
        
        int lt = 0;
        int rt = nums.length - 1;
        boolean flag = false;
        
        while(lt <= rt) {
            int mid = lt + (rt - lt)/2;
            if(nums[mid] == target ) {
                flag = true;
                rt = mid - 1;
            } else if(nums[mid] > target) {
                rt = mid -1;
            } else {
                lt = mid + 1;
            }
        }
        // If found, we can make sure lt is the left most
        if(flag) {
            res = lt;
        }
        
        return res;
    }
}