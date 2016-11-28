/* http://www.lintcode.com/en/problem/maximum-subarray-iii/# */
public int maxSubArray(int[] nums, int k) {
    // write your code here

    /*
    1. Based on usual thought, for specific i, we have two choice
    Pick it or Drop it.
    2. Usually we define dp with dimension with index in this case i and required parameter, in this case k.

    Based on the 1 & 2, we can say, we want to have two table one
    local[i][j], global[i][j].
    local[i][j] means we must pick nums[i] to formate j disconnected subarray
    global[i][j] means we can either pick nums[i] or not.

    The initialize part is:
    local[0][i] = 0; local[i][0] =
    global[0][i] = 0;

    The transform function is:
    local[i][j] = Math.max(local[i-1][j] , global[i-1][j-1]) + nums[i];

    Question: Why not global[i-1][j],

    Answer: That's because if we don't pick i-1 in global[i-1][j-1], then the new coming nums[i] will be another subarray, which is not correct.

    global[i][j] = Math.max(local[i][j], global[i-1][j]);
    */

    if(nums == null || nums.length == 0 || k == 0) return 0;
    int size = nums.length;
    int[][] local = new int[size + 1] [k+1];
    int[][] global = new int[size + 1][k+1];

    local[0][0] = 0;
    global[0][0] = 0;

    for(int i = 1; i <= k; i++) {
        local[i-1][i] = Integer.MIN_VALUE;
    }

    for(int j = 1; j <= k; j++) {
        for(int i = j; i <= size; i++) {
            local[i][j] = Math.max(local[i-1][j], global[i-1][j-1]) + nums[i-1];
            global[i][j] = (i == j) ? local[i][j] : Math.max(local[i][j], global[i-1][j]);
        }
    }

    return global[size][k];
}
