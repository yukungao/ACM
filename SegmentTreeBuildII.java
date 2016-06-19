/* http://www.lintcode.com/en/problem/segment-tree-build-ii/# */
/* Recursively build */

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
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        // write your code here
        if(A == null || A.length == 0) return null;
        SegmentTreeNode root = build(0,A.length-1,A);
        return root;
    }

    private SegmentTreeNode build(int start, int end, int[] A) {
        if(start > end) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end, Integer.MIN_VALUE);

        if(start !=end ){
            root.left = build(start,start+(end-start)/2,A);
            root.right = build(start+(end-start)/2+1,end,A);
            root.max = Math.max(root.left.max, root.right.max);
        } else {
            root.max = A[start];
        }

        return root;
    }
}
