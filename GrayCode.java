/* http://www.lintcode.com/en/problem/gray-code/ */
// The way to generate gray-code:
// Reverese number inside of res, and add (1<<(i-1));
public class Solution {
    /**
     * @param n a number
     * @return Gray code
     */
    public ArrayList<Integer> grayCode(int n) {
        // Write your code here
        if(n < 0) return null;
        ArrayList<Integer> res = new ArrayList<Integer>();

        if(n == 0) {
            res.add(0);
            return res;
        }
        // n > 0
        res.add(0);

        // O(n*(n-1)/2);
        for(int i = 1; i <= n; i++) {
            int high_bit = 1 << (i-1);
            int size = res.size();

            // Reverse the previous one and add high bit to it.
            for(int j = size-1; j >= 0; j--) {
                int tmp = res.get(j);
                tmp += high_bit;
                res.add(tmp);
            }

        }

        return res;

    }
}
