/* https://discuss.leetcode.com/category/339/closest-binary-search-tree-value */

// Notice that either the Iterative or Recursive, we need to reach the end of Tree
// Before we could finish the search. That's because the nature of Binary Search Tree
// It's not Red-Black Tree or 2-3 Tree which are sorted !

// Iterative
// Something like Pre-order traversal
public int closestValue(TreeNode root, double target) {
    int ret = root.val;
    while(root != null){
        if(Math.abs(target - root.val) < Math.abs(target - ret)){
            ret = root.val;
        }
        root = root.val > target? root.left: root.right;
    }
    return ret;
}

// Recursive
// Divided and Conquer
// Two situation: 1. current node's value is closet 2.Its leafs value is closet
// Conquer: Return either current node or the closet one in his child
public int closestValue(TreeNode root, double target) {
    int a = root.val;
    TreeNode kid = target < a ? root.left : root.right;
    if (kid == null) return a;
    int b = closestValue(kid, target);
    return Math.abs(a - target) < Math.abs(b - target) ? a : b;
}


// My implementation

public int closetValue(TreeNode root, double target) {
  return helper(root, target, Integer.MAX_VALUE);
}

private int helper(TreeNode root, double target, int res) {
  if(root == null) {
    return res;
  }

  if(Math.abs(root.val - target) < res) {
    res = Math.abs(root.val - target);
  }

  if(root.val < target) {
    return helper(root.right, target, res);
  } else {
    return helper(root.right, target, res);
  }

}
