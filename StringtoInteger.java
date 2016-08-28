/* http://www.lintcode.com/en/problem/string-to-integer-ii/# */
/*
Keypoint:
1. Use double to store res, otherwise will overflow.
2. Determin if "+" is implict or explict.
*/
public class Solution {
    /**
     * @param str: A string
     * @return An integer
     */
    public int atoi(String str) {
        // write your code here
        // No valid parsing
        if(str == null || str.length() == 0) return 0;
        str = str.trim();

        boolean isPositive = true;
        int i = 0;
        if(str.charAt(0) == '-') {
            isPositive = false;
            i++;
        } else if(str.charAt(0) == '+') {
            i++;
        }

        double res = 0;
        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            res = res * 10 + (str.charAt(i) - '0');
            i++;
        }

        if(!isPositive) {
            res = -res;
        }

        if(res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) res;
        }
    }
}
