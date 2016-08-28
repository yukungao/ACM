/* http://www.lintcode.com/en/problem/count-of-smaller-number-before-itself/ */

/*Segement Tree Version */
// Query first then modify
public class Solution {
   /**
     * @param A: An integer array
     * @return: Count the number of element before this element 'ai' is
     *          smaller than it and return count number array
     */
    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(A == null || A.length == 0) return res;
        SegmentTree st = new SegmentTree();

        for(Integer num : A) {
            // First query then put it
            res.add(st.query(st.root, 0, num - 1));
            st.modify(st.root, num, 1);
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


/* Binary Search Version */
// However, the time complexity should be o(n^2)
// Because the cost of remove of ArrayList Element is to costy.
// Also change the type from ArrayList to LinkedList will TLE


public class Solution {
   /**
     * @param A: An integer array
     * @return: Count the number of element before this element 'ai' is
     *          smaller than it and return count number array
     */
    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        // O(n^2)
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(A == null || A.length == 0) return res;
        ArrayList<Integer> B = new ArrayList<Integer>();
        for(Integer num : A) {
            B.add(num);
        }
        //Sort once:
        quickSort(0,B.size()-1,B);

        for(int i = A.length - 1; i >= 0; i-- ) {
            // Find A[i] in B, swap it to the end of array, ignore it.
            int index = binarySearch(B,A[i]);
            res.add(index);
            //This is an o(n) operation
            B.remove(index);
        }
        Collections.reverse(res);
        return res;
    }


    private int binarySearch(ArrayList<Integer> A, int target) {
        int start = 0;
        int end = A.size() - 1;
        if(A.size() == 0 || A.get(end) < target) return end+1;

        while(start + 1 < end) {

            int mid = start + (end - start)/2;

            if(A.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }


        if(A.get(start) >= target) {
            return start;
        } else if(A.get(end) >= target) {
            return end;
        }  else {
            return end+1;
        }
    }

    private void quickSort(int start, int end, ArrayList<Integer> A) {
        if(start >= end) return;
        int left = start;
        int i = start;
        int right = end;

        int pviot = A.get(start);

        while(i <= right) {
            if(A.get(i) < pviot ) {
                swap(A, i++,left++);
            } else if(A.get(i) > pviot){
                swap(A, i, right--);
            } else {
                i++;
            }
        }

        quickSort(start,left-1,A);
        quickSort(right+1, end, A);
        return;
    }

    private void swap(ArrayList<Integer> A, int i, int j) {
        int tmp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, tmp);
    }
}
