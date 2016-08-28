/* http://www.lintcode.com/en/problem/the-smallest-difference/# */
// The smallest difference

public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        if(A == null || B == null || A.length == 0 || B.length == 0) return 0;
        int size_a = A.length;
        int size_b = B.length;
        Arrays.sort(A);
        Arrays.sort(B);

        int p1 = 0;
        int p2 = 0;
        int res = Integer.MAX_VALUE;

        while(p1 < size_a && p2 < size_b) {
            res = Math.min(res, abs(A[p1] - B[p2]));

            if(A[p1] < B[p2]) {
                p1++;
            } else if(A[p1] > B[p2]) {
                p2++;
            } else {
                p1++;
                p2++;
            }
        }

        return res;

    }

    private int abs(int a) {
        return a > 0 ? a : -a;
    }
}
