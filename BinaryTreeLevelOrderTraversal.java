/* http://www.lintcode.com/en/problem/binary-tree-level-order-traversal/# */
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
      * @param root: The root of binary tree.
      * @return: Level order a list of lists of integer
      */
     public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {

         // write your code here
         // Apperantely a BFS problem.

         ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
         ArrayList<Integer> currLevel = new ArrayList<Integer>();

         if(root == null) return res;

         Queue<TreeNode> queue = new LinkedList<TreeNode>();
         queue.offer(root);

         int count = 0;
         int levelCount = 1;
         int nextLevelCount = 0;

         // Need to know the
         while( queue.size() != 0) {

             TreeNode currNode = queue.poll();
             count++;
             currLevel.add(currNode.val);

             if(currNode.left != null) {
                 queue.add(currNode.left);
                 nextLevelCount++;
             }

             if(currNode.right != null) {
                 queue.add( currNode.right);
                 nextLevelCount++;
             }

             if(count == levelCount) {
                 res.add(new ArrayList<Integer>(currLevel));
                 currLevel.clear();
                 count = 0;
                 levelCount = nextLevelCount;
                 nextLevelCount = 0;
             }
         }

         return res;
     }
 }
