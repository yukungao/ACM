/* http://www.lintcode.com/en/problem/search-range-in-binary-search-tree/ */


// Since you need to return result in ascending order and the BST self Satisfy
// left <= root <= right, thus do the in-order traversal, with left/right as the boundary


public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        dfs(root, k1, k2, res);
        return res;

    }

    private void dfs(TreeNode root, int k1, int k2, ArrayList<Integer> res) {

        if(root == null) {
            return;
        }

        // In ascending order, then the in-order traversal
        if(  root.val > k1) {
            dfs(root.left, k1, k2,res);
        }
        // Satisfy the requirement, add to the solution
        if(k1 <= root.val && root.val <= k2) {
            res.add(root.val);
        }

        if( root.val < k2) {
            dfs(root.right, k1, k2, res);
        }
        return;
    }
}
