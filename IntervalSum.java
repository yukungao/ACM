/*
http://www.lintcode.com/en/problem/interval-sum/#
Nothing very speical, just need to pay attention to the long type of the sum !
*/


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
    public ArrayList<Long> intervalSum(int[] A,
                                       ArrayList<Interval> queries) {
        // write your code here
        if(A == null || A.length == 0 || queries == null || queries.size() == 0) {
            return null;
        }

        // Build the segment tree
        SegmentTree st = new SegmentTree(A);
        ArrayList<Long> res = new ArrayList<Long>();

        for(Interval query : queries) {
            res.add(st.query(st.root, query.start, query.end));
        }

        return res;
    }



    public class TreeNode {
       public int start, end;
       public long sum;

       public TreeNode left, right;

       public TreeNode(int start, int end, long sum) {
           this.start = start;
           this.end = end;
           this.sum = sum;
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

            TreeNode root = new TreeNode(start, end, 0);

            if(start == end) {
                root.sum = (long) A[start];
            } else {
                int mid = start + (end - start)/2;
                root.left  = builder(start, mid, A);
                root.right = builder(mid+1, end, A);
                root.sum = root.left.sum + root.right.sum;
            }

            return root;
        }

        // Return the
        private long query(TreeNode root, int left, int right) {
            if(left > right) {
                return 0;
            }

            // If the range is within a root,
            // return the root sum directly
            if( left <= root.start && root.end <= right) {
                return root.sum;
            }

            // Start query
            int mid = (root.start + root.end)/2;
            long left_sum = 0;
            long right_sum = 0;

            if(mid < left) {
                right_sum = query(root.right, left, right);
            } else if(mid > right) {
                left_sum = query(root.left, left, right);
            } else {
                left_sum = query(root.left, left, mid);
                right_sum = query(root.right, mid + 1, right);
            }
            return left_sum + right_sum;
        }
    }
}
