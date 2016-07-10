/* http://www.lintcode.com/en/problem/paint-fence/ */

public class Solution {
    /**
     * @param n non-negative integer, n posts
     * @param k non-negative integer, k colors
     * @return an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        if( n < 3) return (int) Math.pow(k,n);

        // Same[i] store # of ways if(a[i] == a[i-1])
        // notSame[i] store # of ways if(a[i] != a[i-1])

        int [] same = new int[n];
        int [] notSame = new int[n];

        same[0] = k;
        same[1] = k;

        notSame[0] = k;
        notSame[1] = k*(k-1);

        for(int i = 2; i < n; i++) {
            // Same can only happend with notSame
            same[i] = notSame[i-1];

            // notSame can from
            notSame[i] = same[i-1] * (k-1) + notSame[i-1] * (k-1);

        }

        return notSame[n-1] + same[n-1];
    }
}
