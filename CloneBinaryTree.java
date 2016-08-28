/* http://www.lintcode.com/en/problem/clone-binary-tree/ */
/*
Basic Tree In-order Traversal
Please notice that need to new a Node.
*/
public class Solution {
    /**
     * @param root: The root of binary tree
     * @return root of new tree
     */
    public TreeNode cloneTree(TreeNode root) {
        // Write your code here
        if(root == null) return null;
        TreeNode newTree = new TreeNode(root.val);
        newTree.left = cloneTree(root.left);
        newTree.right = cloneTree(root.right);
        return newTree;
    }
}
