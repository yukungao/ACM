/* http://www.lintcode.com/en/problem/house-robber-iii/# */

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber3(TreeNode root) {
        // write your code here

        // Navie dfs would be timeout, need to use dp.
        // Tree DP problem.

        // dp[0] store the maxim value could get with current node as root
        // dp[1] store the maxim value could get with current node not robbed
        return dfs(root)[0];

    }
    private int [] dfs(TreeNode root){

        int [] dp = {0,0};

        if(root != null) {
            int [] dp_L = dfs(root.left);
            int [] dp_R = dfs(root.right);
            dp[1] = dp_L[0] + dp_R[0];
            dp[0] = Math.max(dp[1], root.val + dp_L[1] + dp_R[1]);
        }
        return dp;
    }
}
