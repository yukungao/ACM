/* http://www.lintcode.com/en/problem/search-insert-position/# */
// Binary tree implementation


public int searchInsert(int[] A, int target) {
    if(A == null || A.length == 0) return 0;

    int left = 0;
    int right = A.length - 1;

    while(left  + 1 < right) {
        int mid = left + (right - left)/2;
        if(A[mid] == target) return mid;
        else if (A[mid] < target) left = mid;
        else right = mid;
    }
    // Right now we need to deciede if we want to return left firt or right.

    // If A[left] > target, means all of the element in A is larger than target
    if( A[left] >= target) return left;

    // If A[right] > A[target], return right
    else if( A[right] >= target) return right;

    // If A[right] < target means all the element in A is smaller than target
    else return right + 1;

}
