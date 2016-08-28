/* http://www.lintcode.com/en/problem/interval-minimum-number/# */
/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Integer> intervalMinNumber(int[] A,
                                                ArrayList<Interval> queries) {
        // write your code here
        if(A == null || A.length == 0 || queries == null || queries.size() == 0) {
            return null;
        }

        // Build the segment tree
        SegmentTree st = new SegmentTree(A);
        ArrayList<Integer> res = new ArrayList<Integer>();

        for(Interval query : queries) {
            res.add(st.query(st.root, query.start, query.end));
        }

        return res;
    }

     public class TreeNode {
       public int start, end;
       public int min;

       public TreeNode left, right;

       public TreeNode(int start, int end, int min) {
           this.start = start;
           this.end = end;
           this.min = min;
           this.left = null;
           this.right = null;
       }
    }

    public class SegmentTree {

        public TreeNode root;

        public SegmentTree(int[] A) {
            this.root = builder(0, A.length - 1 , A);
        }


        private TreeNode builder(int start, int end, int[] A) {
            if(start > end) {
                return null;
            }

            TreeNode root = new TreeNode(start, end, Integer.MAX_VALUE);

            if(start == end) {
                root.min =  A[start];
            } else {
                int mid = start + (end - start)/2;
                root.left  = builder(start, mid, A);
                root.right = builder(mid+1, end, A);
                root.min = Math.min(root.left.min , root.right.min);
            }

            return root;
        }

        // Return the
        private int query(TreeNode root, int left, int right) {
            if(left > right) {
                return Integer.MAX_VALUE;
            }

            // If the range is within a root,
            // return the root min directly
            if( left <= root.start && root.end <= right) {
                return root.min;
            }

            // Start query
            int mid = (root.start + root.end)/2;
            int left_min = Integer.MAX_VALUE;
            int right_min = Integer.MAX_VALUE;

            if(mid < left) {
                right_min = query(root.right, left, right);
            } else if(mid > right) {
                left_min = query(root.left, left, right);
            } else {
                left_min = query(root.left, left, mid);
                right_min = query(root.right, mid + 1, right);
            }
            return Math.min(left_min,  right_min);
        }
    }
}
