/*
http://www.lintcode.com/en/problem/subtree/
这个题容易犯错误的地方是:
不管现在的是不是sameTree,都要往下比一比.

TimeComplexity:
 isSameTree-> worstcase O(n2);
 isSubTree-> O(n1)
 Time O(n1*n2)

*/

public boolean isSubtree(TreeNode T1, TreeNode T2) {
    // write your code here
    if(T2 == null) return true;
    if(T1 == null) return false;

    Boolean currSame = false;
    Boolean leftSame = false;
    Boolean rightSame = false;

    if(isSameTree(T1,T2)) return true;

    return isSubtree(T1.left, T2) || isSubtree(T1.right, T2);


}

private boolean isSameTree(TreeNode T1, TreeNode T2) {
   if(T1 == null && T2 == null) return true;
   if(T1 == null || T2 == null) return false;
   if(T1.val != T2.val) return false;

   return isSameTree(T1.left, T2.left) && isSameTree(T1.right, T2.right);
}
