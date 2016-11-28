/* https://leetcode.com/problems/sliding-window-maximum/ */
public int[] maxSlidingWindow(int[] nums, int k) {
    // Maintain a deque with size k

    /*

     O(n) solution:

     The Queue is storing the index
     When a new element comes:
        a) check if the front of queue is out of window
        b) pop from the tail util tail larger than current value
        c) push current index into the queue.
     Then the front one is the result for current window.

     Trick:
     To keep the window sliding, use the right bound! to track. since we need
     to decide when to store the result.


     This is also bring in the vague computation between index and length
     index_a - index_b + 1 = (length) !!
    */
    if(nums == null || nums.length < 2 || k == 1) return nums;

    int size = nums.length - k + 1;
    int[] res = new int[size];

    Deque<Integer> deque = new LinkedList<Integer>();


    // Process the first k elements
    for(int i = 0; i < nums.length; i++) {

        if(!deque.isEmpty()) {
            int front_index = deque.getFirst();
            if(front_index <= i - k) {
                deque.pollFirst();
            }
        }

        while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
            deque.pollLast();
        }

        deque.addLast(i);

        if( i >= k - 1) {
            res[i - k + 1] = nums[deque.getFirst()];
        }

    }
    return res;
}


/*
O(nlogk) Solution:
其实严格意义上来讲,并不是 O(nlogk)因为heap的remove开销比较大.
可以优化的方式就是，再抽象一下为Node{val, index}. 然后用hash存index-->node.实现
O(1)时间的查找和 O(lgk)的heapify
*/

public int[] maxSlidingWindow(int[] nums, int k) {
    /*
        We could maintain a max-heap. But here, we need to delete the
        value, if its index is out of window.
        Since the insert take o(lgk) but the delete take o(n)!
        To improve it, we need to use hash-heap? but how.
    */

    if(nums == null || nums.length < 2 || k == 1) return nums;

    int [] res = new int[nums.length - k + 1];

    Queue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare (Integer a, Integer b) {
            return b-a;
        }
    });

    for(int i = 0; i < nums.length; i++) {
        if(i >= k) {
            // Take a lot of time.
            heap.remove(nums[i-k]);
        }

        heap.add(nums[i]);

        if(i >= k - 1) {
            res[i-k+1] = heap.peek();
        }
    }

    return res;
}
