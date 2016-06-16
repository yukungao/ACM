/* http://www.lintcode.com/en/problem/search-for-a-range/ */
/* Binary Search implementation */

// solution 1: iterative binary search
public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] res = {-1, -1};
        if(A == null || A.length == 0) return res;
        
        
        int l = 0;
        int r = A.length-1;
        
        // Find the left boarder
        while(l <= r) {
            int m = l + (r-l)/2;
            if(A[m] >= target ) {
                r = m -1;
            } else {
                l = m+1;
            }
        }
        
        int left = l;
        
        l = 0;
        r = A.length - 1;
        
        // Find the right boarder
        while(l <= r) {
            int m = l + (r-l)/2;
            if(A[m] <= target) {
                l = m + 1;
            } else {
                r = m -1;
            }
        }
        
        int right = r;
        // Means find a valid res;
        if(left <= right) {
            res[0] = left;
            res[1] = right;
        }
        return res;
    }
}

// solution 2: recursive way to implement
public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] res = {-1, -1};
        if(A == null || A.length == 0) return res;
        
        // 1st time to find if exist
        int index = helper(A,0,A.length -1, target);
        
        if(index != -1) {
            int left = index;
            int right = index;
            
            //If only one target in the array, make it as left & right
            res[0] = left;
            res[1] = right;
            
            while((left = helper(A,0, left-1, target)) != -1) res[0] = left;
            while((right = helper(A,right+1,A.length-1, target)) != -1) res[1] = right;
        }
        
        return res;
    }
    
    
    private int helper(int[] A, int left, int right, int target) {
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(A[mid] == target) return mid;
            else if  (A[mid] > target) right = mid -1;
            else left = mid + 1;
        }
        return -1;
    }
}