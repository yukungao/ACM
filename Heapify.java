/* http://www.lintcode.com/en/problem/heapify/ */
/* Procedure to build min(max) heap */
/* Given an integer array, heapify it into a min-heap array.

/*For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1] is
the left child of A[i] and A[i * 2 + 2] is the right child of A[i] */

/*Anlysis, bottom-up + iteration(shift_down) */

public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here

       for(int i = A.length/2; i >= 0; i--) {
           shiftDown(A,i);
       }
    }


    //
    private void shiftDown(int[] A, int parent) {
        // Need to judge if current parent have subnodes.
        int minIndex = parent;
        int leftIndex = 2*parent + 1;
        int rightIndex = 2*parent + 2;

        // Use iteration instead of recursion
        while(leftIndex < A.length || rightIndex < A.length) {

            if(leftIndex < A.length && A[leftIndex] < A[minIndex] ) {
                minIndex = leftIndex;
            }

            if(rightIndex < A.length && A[rightIndex] < A[minIndex] ) {
                minIndex = rightIndex;
            }

            if(minIndex != parent) {
                int tmp = A[parent];
                A[parent] = A[minIndex];
                A[minIndex] = tmp;

                parent = minIndex;
                leftIndex = 2*parent + 1;
                rightIndex = 2*parent + 2;
            } else {
                break;
            }

        }

    }

}
