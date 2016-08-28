/* http://www.lintcode.com/en/problem/trailing-zeros/# */
/*
No fancy operation. Just need to get the idea that # of 0 is larger than
# of 5 for a given number. So the idea is get # of 5.

*/
class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here

        // Find largest k that satisfy 5k <= n;
        if(n < 0) return 0;

        long sum = 0;

        while(n != 0) {
            sum += (n / 5);
            n = n/5;
        }

        return sum;
    }
};
