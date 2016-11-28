/* http://www.lintcode.com/en/problem/remove-node-in-binary-search-tree/# */
/*
应该注意的问题：

1. Have a dummy root, since you may delete the original root

2. Before you want to get the value of a node, need to check if current node is null
or not

3. If you want to get both parent and currNode, design the dfs as dfs(parent, curr);

4. Find the left-most, need to use
   while(leftMost.left != null) {
     parent = leftMost;
     leftMost = leftMost.left;
   }

5. Always check if parent.left == curr or parent.right == curr
*/


public TreeNode removeNode(TreeNode root, int value) {
   // Write your code here
   if(root == null) return null;

   // Create a dummy head just incase we want to delete the root node.
   TreeNode dummy = new TreeNode(0);
   dummy.left = root;

   // Find the target node and its parent
   TreeNode parent = findTarget(dummy, root, value);

   TreeNode node = null;

   // Need to judge first.
   if(parent.left != null && parent.left.val == value) {
       node = parent.left;
   } else if (parent.right != null && parent.right.val == value) {
       node = parent.right;
   } else {
       // We couldn't find the node with value, just return orginal tree
       return dummy.left;
   }
   deleteTarget(parent, node);
   return dummy.left;


}

// Pass parent and current in to dfs function make the code clean;
private TreeNode findTarget(TreeNode parent, TreeNode current, int target) {

   if(current == null) {
       return parent;
   }

   if(current.val == target) {
       return parent;
   } else if(current.val < target){
       return findTarget(current, current.right, target);
   } else {
       return findTarget(current, current.left, target);
   }

}

// Three conditions to remove the





private void deleteTarget(TreeNode parent, TreeNode target) {
   // Condition 1: the node is leaf node, then simply make parent point to null
   if(target.left == null && target.right == null) {
       if(parent.left == target) {
           parent.left = null;
       } else {
           parent.right = null;
       }
   } else if(target.left == null || target.right == null) {
   // Condition 2: one of the node's child is empty, then simply make parent point to
   // non null child.
       if(target.left == null) {
           if(parent.left == target) {
               parent.left = target.right;
           } else {
               parent.right = target.right;
           }
       } else {
           if(parent.left == target) {
               parent.left = target.left;
           } else {
               parent.right = target.left;
           }
       }
   } else {
   // Condition 3: The node has two children, then we find the left-most of its right child and it's parent, then swap it with target node.
       TreeNode preLeftMost = target;
       TreeNode leftMost = target.right;


       while(leftMost.left != null) {
           preLeftMost = leftMost;
           leftMost = leftMost.left;
       }

       // preLeftMost,
       if(preLeftMost.left == leftMost) {
           preLeftMost.left = leftMost.right;
       } else {
           preLeftMost.right = leftMost.right;
       }

       if(parent.left == target) {
           parent.left = leftMost;
       } else {
           parent.right = leftMost;
       }

       leftMost.left = target.left;
       leftMost.right = target.right;

   }
}
