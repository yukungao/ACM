/* https://leetcode.com/problems/valid-perfect-square/ */

/* Binary Search, 有个trick 是 判断 a*a == b 可以转为
(a == b/a && b%a == 0) 这个方式比 a * 1.0 == b*1.0/a 要快
*/

public boolean isPerfectSquare(int num) {
    // Sanity check
    if(num == 0) return true;
    if(num < 0) return false;

    int start = 1 ;
    int end = num;

    while(start + 1 < end) {
        int mid = (start + end)/2;
        if(mid == num / mid && num % mid == 0) {
            return true;
        } else if(num / mid > mid ) {
            start = mid;
        } else {
            end = mid;
        }
    }

    return (start == num /start  && num%start == 0)|| (end == num / end && num%end == 0);
}
