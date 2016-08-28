 /*Insert Node in a Binary Search Tree */
 /* http://www.lintcode.com/en/problem/insert-node-in-a-binary-search-tree/ */
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




  // Standard solution beautiful implementation!
  public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if(root == null) return node;
        if(root.val < node.val) {
            root.right = insertNode(root.right, node);
        } else {
            root.left = insertNode(root.left, node);
        }
        return root;
    }
  }

  // My recursion solution, which is very very ugly
  public class Solution {
      /**
       * @param root: The root of the binary search tree.
       * @param node: insert this node into the binary search tree
       * @return: The root of the new binary search tree.
       */
      public TreeNode insertNode(TreeNode root, TreeNode node) {
          // write your code here
          if(root == null) return node;
          TreeNode head = root;
          dfs(root, node);
          return head;
      }

      private void dfs(TreeNode root, TreeNode node) {
          if(root.val < node.val) {
              if(root.right == null) {
                  root.right = node;
                  return;
              }
              root = insertNode(root.right,node);
          } else {
              if(root.left == null) {
                  root.left = node;
                  return;
              }
              root = insertNode(root.left,node);
          }

          return;
      }
  }
