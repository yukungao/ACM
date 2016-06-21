/* https://leetcode.com/problems/add-digits/
For example:
Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
*/


/* The no-trick implementation */

public class Solution {
    public int addDigits(int num) {
      int res = 0;
      int cur = num;
      boolean oneDigit = false;

      // The reason why we need to use onDigit instead of res/10 is because we
      // initialize res as 0.
      while(!oneDigit) {

          while(cur/10 != 0) {
            res += cur%10;
            cur = cur/10;
          }
          res = res + cur;
          if(res/10 == 0) {
            oneDigit = true;
          } else {
            cur = res;
            // Notice, we need to reset res = 0;
            res = 0;
          }
      }
      return res;
    }
}

/* The trick implementation */
/* One prove is that dr(num) = num - num/9*9; */
public class Solution {
    public int addDigits(int num) {
        return (num-1)%9 + 1;
    }
}
