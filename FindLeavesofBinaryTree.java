/* https://leetcode.com/problems/find-leaves-of-binary-tree/ */

/*
开始的时候犯了个错误,就是
1. 以为  List<List<Integer>> res = new ArrayList<List<Integer>>(5);
天真的认为，就push了5个null进去，事实上不是这样的. 事实上, 只是capacity有5 而已，
并不是size 是5

2. 即便对,可以预先的set好arraylist 为5，但是也不能从上往下放, 因为你现在考虑的是到leaf的距离
而不是到root的距离，所以你需要 post-order traversal！

*/


public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if(root == null) {
        return res;
    }
    // Get the depth of this tree
    dfs(root, res);

    return res;
}


private int dfs(TreeNode root, List<List<Integer>> res) {
    if(root == null) {
        return 0;
    }


    int left_depth = dfs(root.left, res);
    int right_depth = dfs(root.right, res);

    int curr_depth = Math.max(left_depth, right_depth) + 1;

    if(res.size() < curr_depth) {
        res.add(new ArrayList<Integer>());
    }

    res.get(curr_depth-1).add(root.val);
    return curr_depth;
}
