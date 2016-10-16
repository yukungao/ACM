/* https://leetcode.com/problems/is-subsequence/ */

/*
Solutio 1: Two pointer search
Time complexity O(s);
容易犯错的一个点儿就是, 忘了设置 flag, 只有没找到的时候,才能让p2++。找到了
p2直接就跳过去了.



Solution 3: Binary Search, for multi source purpose.
*/
public boolean isSubsequence(String s, String t) {

        if(s == null || s.length() == 0 && t.length() >= 0) return true;

        int s_size = s.length();
        int t_size = t.length();

        int p1 = 0;
        int p2 = 0;

        while(p1 < s_size && p2 < t_size) {
            int end = p2;
            boolean flag  = false;
            while(end < t_size) {
                if(s.charAt(p1) == t.charAt(end)) {
                    p1++;
                    p2 = end+1;
                    flag = true;
                    break;
                }
                end++;
            }
            // For s[p1], we couldn't find in the string t
            if(end == t_size && p1 != s_size) {
                return false;
            }

            //Advance p2 if not found p1's first char
            if(flag == false) {
                p2++;
            }

        }

        if(p1 == s_size) {
            return true;
        } else {
            return false;
        }
    }

/*
    Solution 2: DP?
    Time complexity O(n*m)
    这个DP 有个很狗的地方,就是转移方程不好写.
    dp[i][j] 表示的是 s1(0->i-1) 能在 s2(0->j-1)里找到, 那么
    可以很自然的想到状态可以被 s1(i) == s2(i) ? 来分开对吧,假如
    s1(i) == s2(i), 我们只关心 dp[i-1][j-1]这个没错
    但是当 s1(i) != s2(i)的时候呢? 我们只能来自于 dp[i][j-1],
    假如前j-1 个就包含了i，那是最好。假如没有的话也无妨.

    不过借此机会练习了一下空间压缩.
*/
    public boolean isSubsequence(String s, String t) {

            if (s == null || s.isEmpty())
                return true;
            if (t == null || t.isEmpty())
                return false;
            char[] sArray = s.toCharArray();
            char[] tArray = t.toCharArray();
            int sizeS = s.length();
            int sizeT = t.length();

            // Space optimzation
            boolean dp_0[] = new boolean[sizeT + 1];
            boolean dp_1[] = new boolean[sizeT + 1];

            for (int i = 0; i <= sizeT; ++i) {
                dp_0[i] = true;
            }

            for (int i = 1; i <= sizeS; ++i) {
                for (int j = 1; j <= sizeT; ++j) {
                    if (sArray[i - 1] == tArray[j - 1]) {
                        dp_1[j] = dp_0[j -1];
                    } else {
                        dp_1[j] = dp_1[j -1];
                    }
                }
                for(int k = 0; k <= sizeT; k++) {
                    dp_0[k] = dp_1[k];
                }

                dp_1 = new boolean [sizeT+1];
            }
            return dp_0[sizeT];
        }

/*

Binary search
这个是有follow up,就是你的s query来的很多的时候，如何提高效率?
其实是建一个 表，然后 o(s)*lg(length repeat char);

*/
