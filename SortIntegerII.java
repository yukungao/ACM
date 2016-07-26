/* http://www.lintcode.com/zh-cn/problem/sort-integers-ii/ */

public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        // Write your code here
        quickSort(A,0,A.length-1);
    }


    private void quickSort(int[] A, int start, int end) {
        if(start >= end) return;
        int left = start;
        int right = end;
        int i = start;

        int pv = A[start];

        while(i <= right) {
            if(A[i] < pv) {
                swap(A, i++,left++);
            } else if(A[i] > pv) {
                swap(A,i, right--);
            } else {
                i++;
            }
        }
        quickSort(A,start,left-1);
        quickSort(A,right+1,end);
    }

    private void swap(int[] A, int i , int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
