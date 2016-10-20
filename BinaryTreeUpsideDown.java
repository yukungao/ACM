/* https://leetcode.com/problems/binary-tree-upside-down/ */


public TreeNode upsideDownBinaryTree(TreeNode root) {
       /*
           Bottom up soultion to reconstruct the tree
           The template is kind of

           dfs(parent, curr) {
               1. check return condition

               2. go deeper

               3. At current level solve problem

               4. return things you want keep.
           }


       */
       if(root == null || root.left == null) return root;
       return dfs(root, root.left);
   }

   private TreeNode dfs(TreeNode parent, TreeNode curr) {
       // Reach the left most leaf
       if(parent.left == null && parent.right == null) return parent;

       TreeNode root = dfs(parent.left, parent.left.left);

       // Curr right now is the left most leaf,
       if(curr.left == null && curr.right == null) {
           curr.left = parent.right;
           curr.right = parent;
           parent.left = null;
           parent.right = null;
       }

      return root;

   }
