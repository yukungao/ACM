/* */

/* The difference between I and II is that II support modify*/

public class Solution {
    /* you may need to use some attributes here */

    SegmentTree st;
    /**
     * @param A: An integer array
     */
    public Solution(int[] A) {
        // write your code here
        this.st = new SegmentTree(A);
    }

    /**
     * @param start, end: Indices
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        // write your code here
        return st.query(st.root, start, end);
    }

    /**
     * @param index, value: modify A[index] to value.
     */
    public void modify(int index, int value) {
        // write your code here
         st.modify(st.root, index, value);
    }


    // The bollowing are the Segment Tree part.
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

        //Top-down search
        // Bottom up modify
        private void modify(TreeNode root, int index, int value) {
            if(root == null) return;

            if(index == root.start && index == root.end) {
                root.sum = value;
                return;
            }

            int mid = (root.start + root.end)/2;

            if(root.start <= index && index <= root.end) {
                if(index <= mid) {
                    modify(root.left, index, value);
                } else {
                    modify(root.right, index, value);
                }
            }
            root.sum = root.left.sum + root.right.sum;
            return;
        }
    }

}
