
/* http://www.lintcode.com/zh-cn/problem/kth-largest-in-n-arrays/# */

public class Solution {
    /**
     * @param arrays a list of array
     * @param k an integer
     * @return an integer, K-th largest element in N arrays
     */
    public int KthInArrays(int[][] arrays, int k) {
        // Write your code here
        if(arrays == null || arrays.length == 0) {
            return 0;
        }
        /*
          Notice the arrays may like
          arrays = {{},{},{1},{2,3}};
          So we can't assume arrays is full with m = arrays.length,
          n = arrays[0].length
        */
        int sz = 0;
        for(int[] a : arrays) {
            for(int b : a) {
                sz++;
            }
        }

        int [] nums = new int[sz];

        sz = 0;
        for(int[] a : arrays) {
            for(int b : a) {
                nums[sz] = b;
                sz++;
            }
        }

        heapify(nums,sz);

        int res = 0;
        for(int i = 0; i < k; i++) {
            res = top(nums , sz-i);
        }

        return res;
    }

    private int top(int[] nums, int len) {
        int res = nums[0];
        nums[0] = nums[len-1];
        shiftDown(nums, 0, len-1);
        return res;
    }

    private void heapify(int[] nums, int len) {

        for(int i = len/2; i >= 0; i--) {
            shiftDown(nums, i,nums.length);
        }

    }

    //Swap until current value is the max value between its children
    private void shiftDown(int[] A, int parent, int len) {

        int maxIndex = parent;
        int leftIndex = 2*parent + 1;
        int rightIndex = 2*parent +2;

        while(leftIndex < len || rightIndex < len) {

            if(leftIndex < len && A[leftIndex] > A[maxIndex]) {
                maxIndex = leftIndex;
            }

            if(rightIndex < len && A[rightIndex] > A[maxIndex]) {
                maxIndex = rightIndex;
            }

            if(maxIndex != parent) {
                int tmp = A[parent];
                A[parent] = A[maxIndex];
                A[maxIndex] = tmp;

                parent = maxIndex;
                leftIndex = 2*parent + 1;
                rightIndex = 2*parent + 2;
            } else {
                // No need to shiftDown further
                break;
            }

        }
    }
}
