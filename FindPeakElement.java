/* http://www.lintcode.com/en/problem/find-peak-element/ */
/* Suppose A[1] > A[0]; A[A.length-2] < A[A.length-1] */

class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        int start = 1;
        int end = A.length - 2;

        while(start + 1 < end) {
            int mid = start + (end-start)/2;

            if(A[mid] < A[mid-1]) {
                end = mid;
            } else if(A[mid] < A[mid+1]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if(A[start] < A[end]) {
            return end;
        } else {
            return start;
        }
    }
}
