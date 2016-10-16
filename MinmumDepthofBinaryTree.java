/* https://leetcode.com/problems/minimum-depth-of-binary-tree/ */

public int minDepth(TreeNode root) {
    if(root == null) {
        return 0;
    }

    int res = Integer.MAX_VALUE;

    if(root.left == null && root.right == null) {
        return 1;
    }

    if (root.left != null) {
        res = minDepth(root.left)+1;
    }

    if (root.right != null) {
        res = Math.min(minDepth(root.right)+1, res);
    }

    return res;
}
