/* https://leetcode.com/problems/path-sum-ii/ */
/* Path sum II */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        if(root == null) return res;
        dfs(res, path, root, sum);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, TreeNode root, int target) {
        if(root == null) return;
        target = target - root.val;

        //Add so it could be complete path
        path.add(root.val);

        if(target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<Integer>(path));
            //Necessary to go back!
            path.remove(path.size()-1);
            return;
        }

        // Be sure to check instead of blindly running dfs(root.left)
        if(root.left != null) {
            dfs(res, path, root.left, target);
        }

        if(root.right != null) {
            dfs(res, path, root.right, target);
        }
        //Necessary to go back!
        path.remove(path.size()-1);
    }

}
