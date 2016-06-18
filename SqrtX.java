/* http://www.lintcode.com/en/problem/sqrtx/# */
/* Tradition binary search problem, only concern is
mid*mid may have possibility to overflow then mid*mid (<=>) x may not work
One way is to use mid(<=>) x/mid; */

class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if(x <= 0) return 0;

        int start = 1;
        int end = x;

        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(mid == x/mid) return mid;
            else if(mid < x/mid) start = mid;
            else end =mid;
        }
        if(end < x/end) return end;
        return start;
    }
}
