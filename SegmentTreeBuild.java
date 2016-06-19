/* http://www.lintcode.com/en/problem/segment-tree-build/# */


/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end) {
 *         this.start = start, this.end = end;
 *         this.left = this.right = null;
 *     }
 * }
 */

/* Recursion way */
public class Solution {
    /**
     *@param start, end: Denote an segment / interval
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int start, int end) {
        // write your code here
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        root = helper(start,end);
        return root;

    }
    private SegmentTreeNode helper(int start, int end) {
        if(start > end) return null;
        SegmentTreeNode root = new SegmentTreeNode(start,end);
        // If start == end, no need to do the recursion further;
        if(start != end) {
            root.left = helper(start, start+(end-start)/2);
            root.right = helper(start+(end-start)/2 + 1, end);
        }
        return root;
    }
}

/* Iterative way */
