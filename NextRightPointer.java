/* https://leetcode.com/problems/populating-next-right-pointers-in-each-node/ */

/*
 DFS solution
 The trick part is need to take care of left.right -> right.left
*/
public class Solution {
     public void connect(TreeLinkNode root) {
        if(root == null) return;
        dfs(root.left, root.right);
    }

    private void dfs(TreeLinkNode left, TreeLinkNode right) {
        // Connect the direct relationship
        if(left == null) return;

        left.next = right;

        dfs(left.left, left.right);

        if(right != null) {
            // Take care of 2nd level
            dfs(left.right, right.left);
            dfs(right.left, right.right);
        }

    }
}
