/* http://www.lintcode.com/en/problem/segment-tree-query-ii/ */
/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, count;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int count) {
 *         this.start = start;
 *         this.end = end;
 *         this.count = count;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param root, start, end: The root of segment tree and
     *                         an segment / interval
     *@return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if( start > end || root == null) return 0;

        // This part is very important, when you found the start, end is larger
        // than current root could provide, you should
        if(start <= root.start && end >= root.end) return root.count;

        int mid = (root.start + root.end)/2;

        int left_count = 0;
        int right_count = 0;

        if( mid < start) {
            right_count = query(root.right, start, end);
        } else if( mid > end) {
            left_count =  query(root.left, start, end);
        } else {
            left_count =  query(root.left, start, mid);
            right_count =  query(root.right, mid + 1, end);
        }

        // If the (start, end) has no overlap with current node, what
        // will happend?

        return (left_count + right_count);
    }
}
