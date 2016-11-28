/* https://leetcode.com/problems/sort-transformed-array/ */
/*
假如a > 0, 我们能确定最高点. 假如 a < 0 我们能确定最低点.
看到sorted array,就应该想到 two pointers!
*/
public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
    // Two coner cases
    if(nums == null) return null;
    if(a==0 && b==0 && c==0) return new int[nums.length];

    // Trying to maintain the monotonic
    /*
        Since its a second order equation, if a > 0, it has lowest point, if a < 0 it has highest point
        Thus for a > 0, we should fill in the result from the end, since we don't know when we get the lowest point
        Similarily, if a < 0, we need to fill the result from the start.

    */
    int start = 0;
    int end = nums.length - 1;
    int [] res = new int[nums.length];

    int index = (a > 0) ? nums.length - 1 : 0;

    while(start <= end) {
        if(a > 0) {
            res[index--] =  calFunction(nums[start], a, b, c) > calFunction(nums[end], a, b, c) ? calFunction(nums[start++], a, b, c) : calFunction(nums[end--], a, b, c);
        } else {
            res[index++] =  calFunction(nums[start], a, b, c) < calFunction(nums[end], a, b, c) ? calFunction(nums[start++], a, b, c) : calFunction(nums[end--], a, b, c);
        }
    }
    return res;
}

private int calFunction(int x, int a, int b, int c) {
    return a*x*x + b*x + c;
}
