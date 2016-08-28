/* http://www.lintcode.com/en/problem/copy-books/ */

// DP solution: dp[i][j], reprenset the smallest time that 0->i books is copying
//by j pepole, the result is dp[pages.length][k];


public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here

        // dp[i][j] means firt i books assigned to j peopler, need smallest minutes.
        // dp[i][j] = Math.max(dp[p-1][j-1] , cost[p][i]) where p<i;

        // Initialization:
        // dp[i][1] = cost[1][i];


        if(pages == null || pages.length == 0 ) return 0;
        if(k == 0) return Integer.MAX_VALUE;

        int size = pages.length;

        // Build a Segment_Tree to support the range sum query
        SegmentTree st = new SegmentTree(pages);
        int [][] dp = new int[size+1][k+1];

        // Initialization:
        for(int i = 1; i <= size; i++) {
            dp[i][1] = st.query(st.root, 0,i-1);
        }

        // Fill the dp
        for(int j = 2; j <= k; j++) {
            dp[i][j] = Integer.MAX_VALUE;
            for(int i = 1 ; i <= size; i++) {
                for(int p = 1; p < i; p++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[p-1][j-1], st.query(st.root, p-1,i-1)));
                }
            }
        }

        return dp[size][k];
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



// Binary Search Method, which is very very very tricky

public int copyBooks(int[] pages, int k) {
        // write your code here
        // The binary search method
        if(pages == null || pages.length == 0) return 0;
        if(k <= 0) return Integer.MAX_VALUE;

        // Binary search to find the tight bound
        // 1. The sum of Array is the total time for 1 person
        // 2. The lower bound is average (Sum of array)/k
        int sum = 0;
        int max = 0;
        for(int i = 0; i < pages.length; i++) {
            sum += pages[i];
            max = Math.max(max, pages[i]);
        }
        // If this corner case are not
        if(k >= pages.length) return max;

        int start = sum/k;
        int end = sum;

        while (start + 1 < end) {

            int mid = start + (end - start)/2;

            if(valid(pages,k,mid)) {
                end = mid;
            } else {
                start = mid;
            }

        }

        if(valid(pages,k,start)) {
            return start;
        } else if(valid(pages,k,end)) {
            return end;
        } else {
            return Integer.MAX_VALUE;
        }
    }

  // Greedy valid since each segment shouldn't be larger than time
  private boolean valid(int[] pages, int k, int time) {
        int currSeg = 0;
        int pepole = 1;

        for(int i = 0; i < pages.length && pepole <= k; i++) {

            if(currSeg + pages[i] > time) {
                currSeg = 0;
                pepole++;
            }

            currSeg += pages[i];

        }
        // Need to
        return pepole <= k && currSeg <= time;
    }
