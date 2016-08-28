/* http://www.lintcode.com/en/problem/recover-rotated-sorted-array/  */
/*
三步翻转法.. 我一直在想能不能用binary search 找到转折点..
*/

public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
    // write your code
    if(nums == null || nums.size() == 0) return;

    // Step 1, found the rotate point
    int size = nums.size();

    int i = 0;
    for(; i < size - 1; i++) {
        if(nums.get(i) > nums.get(i+1)) {
            break;
        }
    }

    // Step 2, reverse the 0-now
    reverse(nums, 0, i);
    // Step 3, reverse now - end
    reverse(nums, i+1, size -1);
    //Step 4, reverse everything
    reverse(nums, 0, size -1);

    return;
}

private void reverse(ArrayList<Integer> nums, int start, int end) {
    int i = start;
    int j = end;

    while(i < j) {
        int tmp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, tmp);
        i++;
        j--;
    }
}
