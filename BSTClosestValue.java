/* https://leetcode.com/problems/closest-binary-search-tree-value/ */

public int closestValue(TreeNode root, double target) {

    if(root == null) return target > 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;

    if(root.val < target) {
        // Two possibility, either current root value, or from the right tree, left tree is
        // impossible any more
        int candidate = closestValue(root.right, target);
        return Math.abs(candidate - target) < Math.abs(root.val - target) ? candidate : root.val;

    } else {
        int candidate = closestValue(root.left, target);
        return Math.abs(candidate - target) < Math.abs(root.val - target) ? candidate : root.val;
    }
}
