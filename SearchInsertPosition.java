/* http://www.lintcode.com/en/problem/search-insert-position/# */
// Binary tree implementation 


public int searchInsert(int[] A, int target) {
    if(A == null || A.length == 0) return 0;
    
    int left = 0;
    int right = A.length - 1;
    
    while(left <= right) {
        int mid = left + (right - left)/2;
        if(A[mid] == target) return mid;
        else if (A[mid] > target) right = mid - 1;
        else left = mid + 1;
    }
    
    return left;
}