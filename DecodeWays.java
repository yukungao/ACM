/* http://www.lintcode.com/en/problem/decode-ways/ */

public class Solution {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // Write your code here
        if(s == null || s.length() == 0) return 0;

        // dp[i] the decode way of s.char(0-->i-1);
        // The result be dp[s.length()]

        int [] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = (s.charAt(0) == '0' ? 0 : 1);

        for(int i = 2; i <= s.length(); i++) {
            // current char is not '0'
            // If current char is '0', then it depends on whether it can be
            // 10-->26 with pre char.
            // If current char is not '0', then it at least have dp[i-1]'s result.

            if(s.charAt(i-1) != '0') {
                dp[i] = dp[i-1];
            }

            int twoChars = (s.charAt(i-2) - '0') * 10 + (s.charAt(i-1) - '0');
            // Two digit are acceptable.
            // Then find another way to decode : dp[i] = dp[i-2] + dp[i-1];
            if (twoChars >= 10 && twoChars <=26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];

    }
}
