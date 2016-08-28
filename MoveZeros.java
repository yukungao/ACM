/*
 其实就是count住下一个可以放数的位置就行
*/
public void moveZeroes(int[] nums) {
    // Write your code here
    if(nums == null || nums.length == 0) return;

    int count = 0;

    for(int i = 0; i < nums.length; i++) {
        if(nums[i] != 0) {
            int tmp = nums[count];
            nums[count++] = nums[i];
            nums[i] = tmp;
        }
    }
}
