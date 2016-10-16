/* https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/ */
public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }

        return dfs(nums, 0, nums.length - 1);

    }


    private TreeNode dfs(int[] A, int start, int end) {

        if(start > end) {
            return null;
        }

        if(start == end) {
            return new TreeNode(A[start]);
        }

        int mid = (start + end)/2;

        TreeNode curr = new TreeNode(A[mid]);

        curr.left = dfs(A, start, mid-1);
        curr.right = dfs(A, mid+1, end);

        return curr;

    }
