/* http://www.lintcode.com/en/problem/burst-balloons/ */
public int maxCoins(int[] nums) {
    // Write your code here

    // Range dp problem.
    // dp[i][j] is burst balloons from i to j could achieve max score
    // dp[i][j] = Math.max(dp[i][k-1] + dp[k+1][j] + nums[k] * nums[i-1] * nums[j+1])
    // i< k < j;

    if(nums == null || nums.length == 0) return 0;

    // We'd better to have a new nums[0] = 1; nums[n+1] = 1;
     int size = nums.length;
    int [] myNums = new int[size + 2];

    myNums[0] = 1;
    myNums[size+1] = 1;

    for(int i = 1; i <= size; i++) {
        myNums[i] = nums[i-1];
    }

    // dp[i][j] is the result we have to brust nums[i-1]*nums[j+1]*nums[k] k is anyone between
    // i and j and the result is dp[0][n+1];

    // Initialization dp[i][i] is not allowed, but could initial them as Integer.MIN_VALUE;

    int[][] dp = new int[size+2][size+2];

    return dfs(dp, myNums, 1, size);

}
//
private int dfs(int[][] dp, int [] nums, int start, int end) {

    if(dp[start][end] != 0){
        return dp[start][end];
    }

    int res = 0;

    for(int k = start; k <= end ; k++) {
        int tmp = nums[start-1] * nums[end+1] * nums[k] +  dfs(dp, nums, start, k-1) + dfs(dp, nums, k+1, end);
        res = Math.max(res, tmp);
    }

    dp[start][end] = res;
    return res;
}
