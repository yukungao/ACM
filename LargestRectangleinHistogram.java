/* http://www.lintcode.com/en/problem/largest-rectangle-in-histogram/ */

/* http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html */

// Post caculate till you can't do it greedy,
// When caculate, you are sure current stack.pop() is the shortest one.. so h[t] *(i-stack.peek()-1) is the area h[t] could
// contribute
