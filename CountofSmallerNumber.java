/* http://www.lintcode.com/en/problem/count-of-smaller-number/ */
public class Solution {
   /**
     * @param A: An integer array
     * @return: The number of element in the array that
     *          are smaller that the given integer
     */
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here

        SegmentTree st = new SegmentTree();
        for(int i = 0; i < A.length; i++) {
            st.modify(st.root,A[i],1);
        }

        ArrayList<Integer> res = new ArrayList<Integer>();
        if(queries == null || queries.length == 0) return res;

        for(int i = 0; i < queries.length; i++) {
            res.add(st.query(st.root,0,queries[i]-1));
        }
        return res;
    }


    // Build the Segment Tree

public class TreeNode {
       public int start, end;
       public int count;

       public TreeNode left, right;

       public TreeNode(int start, int end, int count) {
           this.start = start;
           this.end = end;
           this.count = count;
           this.left = null;
           this.right = null;
       }
    }

    public class SegmentTree {

        public TreeNode root;

        public SegmentTree() {
            this.root = builder(0, 10000);
        }


        private TreeNode builder(int start, int end) {
            if(start > end) {
                return null;
            }

            TreeNode root = new TreeNode(start, end, 0);

            if(start != end) {
                int mid = start + (end - start)/2;
                root.left  = builder(start, mid);
                root.right = builder(mid+1, end);
                root.count = 0;
            }

            return root;
        }

        // Return the
        private int query(TreeNode root, int left, int right) {
            if(left > right) {
                return 0;
            }

            // If the range is within a root,
            // return the root count directly
            if( left <= root.start && root.end <= right) {
                return root.count;
            }

            // Start query
            int mid = (root.start + root.end)/2;
            int left_count = 0;
            int right_count = 0;

            if(mid < left) {
                right_count = query(root.right, left, right);
            } else if(mid > right) {
                left_count = query(root.left, left, right);
            } else {
                left_count = query(root.left, left, mid);
                right_count = query(root.right, mid + 1, right);
            }
            return left_count + right_count;
        }

        private void modify(TreeNode root, int index, int value) {
            if(root == null) return;

            if(index == root.start && index == root.end) {
                root.count += value;
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
            root.count = root.left.count + root.right.count;
            return;
        }
    }

}


/* Binary Search Method */

/*
Step 1: Quick Sort the array
Step 2: Search Insertion point
*/
public class Solution {
   /**
     * @param A: An integer array
     * @return: The number of element in the array that
     *          are smaller that the given integer
     */
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        // Sort A first

        ArrayList<Integer> res = new ArrayList<Integer>();
        if(queries == null || queries.length == 0) return res;
        quickSort(0,A.length - 1,A);



        for(int i = 0; i < queries.length; i++) {
            //Binary Search for the insertion point
            res.add(binarySearch(A, queries[i]));
        }

        return res;

    }

    private int binarySearch(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        if(A.length == 0 || A[end] < target) return end+1;

        while(start + 1 < end) {

            int mid = start + (end - start)/2;

            if(A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }


        if(A[start] >= target) {
            return start;
        } else if(A[end] >= target) {
            return end;
        }  else {
            return end+1;
        }
    }

    private void quickSort(int start, int end, int[] A) {
        if(start >= end) return;
        int left = start;
        int i = start;
        int right = end;

        int pviot = A[start];

        while(i <= right) {
            if(A[i] < pviot ) {
                swap(A, i++,left++);
            } else if(A[i] > pviot){
                swap(A, i, right--);
            } else {
                i++;
            }
        }

        quickSort(start,left-1,A);
        quickSort(right+1, end, A);
        return;
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
