/* http://www.lintcode.com/en/problem/first-bad-version/* /
/* Since it has been "sorted", find the change should be able to use Binary
Search*/

/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        int start = 0;
        int end = n;

        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(SVNRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if(SVNRepo.isBadVersion(start)) return start;
        else return end;
    }
}
