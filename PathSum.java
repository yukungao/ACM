/* https://leetcode.com/problems/path-sum/ */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root,sum);
    }
    private boolean dfs(TreeNode root,int target){
        if(root == null) return false;
        target -= root.val;
        //Should use this to check instead of root == null, coz many times
        // root == null is not leaf
        if(target == 0 && root.left == null && root.right == null) return true;
        return dfs(root.left,target) || dfs(root.right,target) ;
    }
}
