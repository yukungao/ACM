/* http://www.lintcode.com/en/problem/unique-binary-search-trees-ii/ */


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
 */
public class Solution {
    /**
     * @paramn n: An integer
     * @return: A list of root
     */
    public List<TreeNode> generateTrees(int n) {
        // write your code here
        return dfs(1,n);

    }


    // Construct the tree bottom up
    // Left tree is from start--->i-1,
    // Right tree is from i+1 ---->end;
    // Go deeper will narrow the window
    // Divid and conquer

    private List<TreeNode> dfs(int start, int end) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(start > end) {
            result.add(null);
            return result;
        }
        // Pick one as the root
        for(int i = start; i <=end; i++) {
            // Divide
            List<TreeNode> leftTree = dfs(start, i-1);
            List<TreeNode> rightTree = dfs(i+1, end);

            // Conquer <-- Why like this?
            for(TreeNode lnode : leftTree) {
                for(TreeNode rnode : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    result.add(root);
                }
            }

        }

        return result;

    }
}
