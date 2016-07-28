/* http://www.lintcode.com/en/problem/largest-rectangle-in-histogram/ */

/* http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html */

// Post caculate till you can't do it greedy,
// When caculate, you are sure current stack.pop() is the shortest one.. so h[t] *(i-stack.peek()-1) is the area h[t] could
// contribute

/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Given height = [2,1,5,6,2,3],
return 10.
*/

public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;


        for(int i = 0; i <= height.length; i++) {
            // Push -1 so that it won't happen if the stack doesn't pop
            int curr_ht = (i == height.length) ? -1 : height[i];

            while(!stack.isEmpty() && curr_ht < height[stack.peek()]) {
                int ht = height[stack.pop()];
                // Calculate the width, notice that if stack.isEmpty(), we should use i;
                int width = stack.isEmpty()? i : i - stack.peek() -1;
                res = Math.max(res, ht * width);
            }

            stack.push(i);
        }
        return res;
    }
}
