/* http://www.lintcode.com/en/problem/partition-array-by-odd-and-even/ */

public void partitionArray(int[] nums) {
    // write your code here;
    if(nums == null || nums.length == 0) return;

    int left = 0;
    int right = nums.length -1;
    int i = 0;

    while(i <= right) {
        if(nums[i]%2 != 0) {
            swap(nums,i++,left++);
        } else {
            swap(nums,i,right--);
        }
    }
    return;
}

private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}
