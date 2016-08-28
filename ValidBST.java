/* http://www.lintcode.com/en/problem/validate-binary-search-tree/# */

/* This is the totally WRONG Answer, because it only validate  left<root<right
for each node, however, the BST definition is left_MAX < root < right.MIN


public class Solution {
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if(root == null) return true;

        boolean ltBST = false;
        boolean rtBST = false;

        if(root.left == null) {
            ltBST = true;
        } else if(root.left.val < root.val) {
            ltBST = isValidBST(root.left);
        }

        if(root.right == null) {
            rtBST = true;
        } else if(root.val < root.right.val) {
            rtBST = isValidBST(root.right);
        }

        return ltBST&&rtBST;
    }
}

*/
// In order traversal version
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    long preValue = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        // write your code here
        // In order traversal to see if its in ascending order

        if(root == null) return true;

        boolean ltBST = isValidBST(root.left);

        if(root.val <= preValue) {
            return false;
        }

        preValue = root.val;

        boolean rtBST = isValidBST(root.right);

        return ltBST&&rtBST;

    }
}

// Validate range version.
