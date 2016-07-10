/* http://www.lintcode.com/en/problem/paint-house/ */
public class Solution {
    /**
     * @param costs n x 3 cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {

        // Write your code here
        if(costs == null || costs.length == 0) return 0;
        int size = costs.length;

        // Rolling array to reduce space complexity to constant

        // New three dp array
        int[] dp_0 = new int[2];
        int[] dp_1 = new int[2];
        int[] dp_2 = new int[2];
        dp_0[0] = costs[0][0];
        dp_1[0] = costs[0][1];
        dp_2[0] = costs[0][2];

        for (int i = 1; i < size; i++) {
            dp_0[i%2] = Math.min(dp_1[(i-1)%2],dp_2[(i-1)%2]) + costs[i][0];
            dp_1[i%2] = Math.min(dp_0[(i-1)%2],dp_2[(i-1)%2]) + costs[i][1];
            dp_2[i%2] = Math.min(dp_0[(i-1)%2],dp_1[(i-1)%2]) + costs[i][2];
        }

        return Math.min( Math.min(dp_0[(size-1)%2], dp_1[(size-1)%2]) , dp_2[(size-1)%2]);
    }
}
