/* http://www.lintcode.com/en/problem/lowest-common-ancestor */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
       // write your code here
       if(root == null) {
           return null;
       }

       if(root == A || root == B) {
           return root;
       }
       // Divided
       TreeNode left = lowestCommonAncestor(root.left, A, B);
       TreeNode right = lowestCommonAncestor(root.right, A, B);

       // Conquer
       if(left != null && right != null) {
           return root;
       }

       return (left == null ? right : left);

   }
}

/* AMZ OA It has multiply reports*/
/* Note: A/B may not be a valid employee! */
/* The node may have multiple childs*/
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B, boolean [] flag) {
  // write your code here
  if(root == null) {
      return null;
  }
  boolean isEmployee = false;
  if(root == A || root == B) {
      isEmployee = true;

      if(!flag[0]) {
        flag[0] = true;
      } else {
        flag[1] = true;
        return root;
      }
      // We couldn't return but continue to search
      //return root;
  }


  // Divided
  TreeNode found1 = null;
  TreeNode found2 = null;

  for(TreeNode child ：root.getchildren()) {
    TreeNode tmp = lowestCommonAncestor(child, A, B);
    if(tmp != null) {
      if(found1 == null) found1 = child;
      else found2 = child;
    }
  }

  // Conquer
  // CurrentNode is Employee and it has subEmployee
  if(found1 != null && found2 != null) {
    return root;
  }

  return (found1 == null ? found2 : found1);

}
