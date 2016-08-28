/* http://www.lintcode.com/en/problem/longest-substring-with-at-most-k-distinct-characters/ */


// This is o(n^2) soluton !!!
public class Solution {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;

        // write your code here
        char[] ary = s.toCharArray();
        int size = ary.length;

        HashSet<Character> dict = new HashSet<Character>();

        int p1 = 0;
        int p2 = 0;

        int res = 0;

        // Need to iterate p1 from 0->length, instead of p1 = p2 do the jump!!!
        for(; p1 < size; p1++) {
            p2 = p1;
            while(p2 < size && !dict.contains(ary[p2])) {
                dict.add(ary[p2]);
                p2++;
            }
            res = Math.max(res, p2-p1);

            if(p2 == size) {
                // Break ahead
                return res;
            } else {
                dict.clear();
            }
        }

        return res;
    }
}
