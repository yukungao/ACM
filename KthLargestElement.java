/* http://www.lintcode.com/en/problem/kth-largest-element/# */
/* Given an array, find Kth Largest Element */

/* Solution 1: Heapify the array and 2. pop Kth times
    The time complexity is O(k*lgn + o(n))
    /* Find Kth largest element */
    /* If we are using max-heap,
       Build Heap time O(n) <-- Heapify
       k*shiftDown <-- klogN;
       Mem-space O(1)
*/
    class Solution {
        /*
         * @param k : description of k
         * @param nums : array of nums
         * @return: description of return
         */
        public int kthLargestElement(int k, int[] nums) {
            // write your code here
            if(nums == null || nums.length == 0) return 0;


            //Max-Heapify the nums
            heapify(nums, nums.length);
            int res = nums[0];

            //Pop k times to find the Kth longest
            for(int i = 0; i < k; i++) {
                res = top(nums, nums.length - i);
            }

            return res;
        }

        // The "int len" provide masking functionality
        private int top(int[] A, int len) {
            int res = A[0];

            // Swap A[0] with tail
            A[0] = A[len-1];
            // Then do shift-Down, mask the tail!
            shiftDown(A,0,len-1);

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
    };
/* Solution 2: Quick select */
