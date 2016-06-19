/* http://www.lintcode.com/en/problem/segment-tree-query/ */
/* Segment Tree Query */
/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param root, start, end: The root of segment tree and
     *                         an segment / interval
     *@return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        // Find exact node, return
        if(root == null) return Integer.MIN_VALUE;

        if(start == root.start && end == root.end) return root.max;

        //Decide the search area based on the mid location
        int mid = root.start + (root.end-root.start)/2;
        int left_max = Integer.MIN_VALUE;
        int right_max = Integer.MIN_VALUE;

        if(mid < start) {
            right_max = query(root.right, start, end);
        } else if(mid > end) {
            left_max = query(root.left, start, end);
        } else {
            // mid is in between of the start and end
            right_max = query(root.right, mid+1, end);
            left_max = query(root.left, start, mid);
        }

        return Math.max(left_max, right_max);
    }
}
