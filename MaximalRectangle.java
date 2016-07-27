

/* http://www.lintcode.com/en/problem/maximal-rectangle/# */

// Solution 1
/* http://www.cnblogs.com/lichen782/p/leetcode_maximal_rectangle.html */


// Solution 2
/* https://siddontang.gitbooks.io/leetcode-solution/content/array/maximal_rectangle.html */

// Solution 3:
https://discuss.leetcode.com/topic/6650/share-my-dp-solution


matrix
0 0 0 1 0 0 0
0 0 1 1 1 0 0
0 1 1 1 1 1 0

height
0 0 0 1 0 0 0
0 0 1 2 1 0 0
0 1 2 3 2 1 0

left
0 0 0 3 0 0 0
0 0 2 3 2 0 0
0 1 2 3 2 1 0

right
7 7 7 4 7 7 7
7 7 5 4 5 7 7
7 6 5 4 5 4 7

result
0 0 0 1 0 0 0
0 0 3 2 3 0 0
0 5 6 3 6 5 0
