/* http://www.lintcode.com/en/problem/max-tree/# */

/* http://www.geeksforgeeks.org/cartesian-tree/ */

// The in-order traversal should be original array
// And it's keep the max(min) heap feature!!!

// ------------------------------------
// Recursion, similiar like segment tree build
// ------------------------------------
//-- What's the time complexity of this one?
public TreeNode maxTree(int[] A) {
      // write your code here
      if(A == null || A.length == 0) return null;
      TreeNode root = dfs(root);
      return root;
}


private TreeNode dfs(TreeNode root, int start, int end, int[] A) {
    if(start > end) {
      return null;
    }
    // Find the largest in current Array， o(n)
    int index = findLargestElementIndex(A, start, end);

    root = new TreeNode(A[index]);
    root.left = dfs(root, start, index,  A);
    root.right = dfs(root, index, end,   A);

    return root;
}





// ------------------------------------
// Iteration with an decreasing stack.
// ------------------------------------

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
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
      // write your code here
      if(A == null || A.length == 0) return null;

      // We will maintain a decreasing stack!!!
      Stack<TreeNode> stack = new Stack<TreeNode>();

      // Iteration through the array
      for(int i = 0; i < A.length; i++) {

          TreeNode currNode = new TreeNode(A[i]);

          while(!stack.isEmpty() && stack.peek().val < A[i]) {
              currNode.left = stack.pop();
          }

          //If it's not empty, means currNode less than that value, we should put as it's right node
          if(!stack.isEmpty()) {
              stack.peek().right = currNode;
          }

          stack.push(currNode);
      }

      //Result's in the stack floor !
      TreeNode result = new TreeNode(0);
      while(!stack.isEmpty()) {
          result = stack.pop();
      }
      return result;
    }

}
