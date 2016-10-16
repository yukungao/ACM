/* https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/ */
/*

刚开始写的时候，先写了一个计算height的，然后再isBalanced 里面
return isBalanced(root.left) && isBalanaced(root.right) && Math.abs(height(root.left) - height(root.right) <= 1);
这有个问题是，height 会被反反复复的call.
所以不如用技巧, 在算height 的时候，当两遍不平衡的时候，return -1
*/


public boolean isBalanced(TreeNode root) {
    if(root == null) {
        return true;
    }

    if(height(root) == -1) {
        return false;
    }

    return true;

}


public int height(TreeNode root) {
    if(root == null) {
        return 0;
    }
    //Divide
    int left = height(root.left);
    int right = height(root.right);

    //Conquer, if one side is -1, then return -1 immediately
    if(left == -1 || right == -1 || Math.abs(left - right) > 1) {
        return -1;
    }

    return 1 + Math.max(left, right);
}
