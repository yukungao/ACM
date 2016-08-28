/* http://www.lintcode.com/en/problem/binary-search-tree-iterator/ */
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * }
 */


// Using stack to do the iterative "in-order"traversal, the time complexity is O(h);
public class BSTIterator {
    //@param root: The root of binary tree.
    private Stack<TreeNode> stack;
    TreeNode curr;
    public BSTIterator(TreeNode root) {
        // write your code here
        stack = new Stack<TreeNode>();
        curr = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        // Only push left realize o(h) space
        while(curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        return !stack.isEmpty();
    }

    //@return: return next node
    public TreeNode next() {
        // Defer the operation in next();
        curr = stack.pop();
        TreeNode node = curr;
        curr = curr.right;

        return node;
    }
}
