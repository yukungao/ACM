/*
https://leetcode.com/problems/distinct-subsequences/

Given a string S and a string T, count the number of distinct subsequences of T in S.
A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
*/


/*
卧槽,纯想想出来的hard 题:
首先俩字符串,找出多少个. 就得想起来这是个dp题目, 然后显然就是两个维度为i,j
代表 t(0->i-1), 在s(0 ->j-1)中出现的次数. 你看天然想到第一维是 t， 第二维是 s
然后呢, 对于
dp[i][j], 首先能保证 dp[i][j-1]. 但是呢,假如 t.charAt(i-1) == s.charAt(j-1). 我们
可以很自然的得出哦，还可以把dp[i-1][j-1]给算上.


*/

public int numDistinct(String s, String t) {
        //
        if(t == null) {
            if(s == null) {
                return 1;
            } else {
                return s.length();
            }
        }

        if(s == null) {
            if(t == null){
                return 1;
            } else {
                return 0;
            }
        }

        if(s.length() == 0) {
            if(t.length() == 0){
                return 1;
            } else {
                return 0;
            }
        }


        int s_size = s.length();
        int t_size = t.length();

        int[][] dp = new int[t_size+1][s_size+1];

        // Initialization
        for(int i = 0; i <= s_size; i++) {
            dp[0][i] = 1;
        }

        // Transfrom
        for(int i = 1; i <= t_size; i++) {
            for(int j = i; j <= s_size; j++) {
                dp[i][j] = dp[i][j-1];

                if(s.charAt(j-1) == t.charAt(i-1)){
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }

        // Result
        return dp[t_size][s_size];
    }
