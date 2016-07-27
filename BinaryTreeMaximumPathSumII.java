/* http://www.lintcode.com/en/problem/binary-tree-maximum-path-sum-ii/ */
/* maximum path sum from the root, could end at any node */

public class Solution {
    /**
     * @param root the root of binary tree.
     * @return an integer
     */
    public int maxPathSum2(TreeNode root) {
        // Write your code here
        if(root == null) return 0;

        return Math.max(root.val, root.val + Math.max(maxPathSum2(root.right),maxPathSum2(root.left)));
    }
}
