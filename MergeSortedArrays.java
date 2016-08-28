/* http://www.lintcode.com/en/problem/merge-sorted-array/ */

/*
Key part:
1. Fill the array backwardsly.
2. Blindly merge
*/

public void mergeSortedArray(int[] A, int m, int[] B, int n) {
    // write your code here
    // Merge backwards
    int pt1 = m -1 ;
    int pt2 = n - 1;
    int tail = m+n - 1;

    while(pt1 >= 0 && pt2 >= 0) {
        if(A[pt1] < B[pt2]) {
            A[tail--] = B[pt2--];
        } else {
            A[tail--] = A[pt1--];
        }
    }

    // Blindly merge
    while(pt1 >= 0){
        A[tail--] = A[pt1--];
    }

    while(pt2 >= 0){
        A[tail--] = B[pt2--];
    }

}
