/* http://www.lintcode.com/en/problem/binary-tree-maximum-path-sum/ */
/* maximum path sum from the any node to any node */


public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
        if(root == null ) return 0;

        // Optimization with cache
        HashMap<TreeNode, int[]> cache = new HashMap<TreeNode,int[]>();

        int [] res = dfs(root,cache);
        return Math.max(res[0],res[1]);
    }

    // Assume the dfs return two value
    // res[0] contains the result either left-way, or right-way
    // res[1] contains the result through root
    public int[] dfs(TreeNode root,  HashMap<TreeNode, int[]> cache) {

        if(cache.containsKey(root)) {
            return cache.get(root);
        }

        int[] res = {Integer.MIN_VALUE, Integer.MIN_VALUE};

        if(root == null) {
            // Return what?
            return res;
        }

        int[] left_res  = dfs(root.left, cache);
        int[] right_res = dfs(root.right, cache);

        /*
        // No crossing, either left-way or right-way
        */
        res[0] = Math.max(left_res[0], right_res[0]) > 0 ?  root.val + Math.max(left_res[0], right_res[0]) : root.val;

        // Crossing.
        int from_sub = Math.max(left_res[1], right_res[1]);
        int from_curr = root.val;

        if(left_res[0] > 0) {
            from_curr = from_curr + left_res[0];
        }

        if(right_res[0] > 0) {
            from_curr = from_curr + right_res[0];
        }

        res[1] = Math.max(from_sub, from_curr);
        cache.put(root, res);
        return res;
    }
}
