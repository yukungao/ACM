/* http://www.lintcode.com/en/problem/paint-house-ii/ */

public class Solution {
    /**
     * @param costs n x k cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        // Write your code here

        if(costs == null || costs.length == 0 || costs[0] == null) return 0;
        int size = costs.length;
        int colorNum = costs[0].length;

        // Index ---> cost
        // Question, can the firstCand and secondCand have the same color chose;
        int[] firstCand = new int[2];
        int[] secondCand = new int[2];

        firstCand[0] = -1;
        firstCand[1] = Integer.MAX_VALUE;

        secondCand[0] = -1;
        secondCand[1] = Integer.MAX_VALUE;

        // Initialize the firstCand, secondCand  from the first house
        for(int j = 0; j < colorNum; j++) {
            if(costs[0][j] < firstCand[1]) {
                firstCand[0] = j;
                firstCand[1] = costs[0][j];
            } else if(costs[0][j] < secondCand[1]) {
                secondCand[0] = j;
                secondCand[1] = costs[0][j];
            }
        }

        for(int i = 1; i < size; i++) {

            int firstMin = Integer.MAX_VALUE;
            int secondMin = Integer.MAX_VALUE;

            int firstIndex = -1;
            int secondIndex = -1;

            for(int j = 0; j < colorNum; j++) {

                costs[i][j] = costs[i][j] + (firstCand[0] != j ? firstCand[1] : secondCand[1]);

                if(costs[i][j] < firstMin) {
                    secondIndex = firstIndex;
	                secondMin = firstMin;

	                firstIndex = j;
	                firstMin = costs[i][j];

                } else if(costs[i][j] < secondMin) {
                    secondIndex = j;
                    secondMin = costs[i][j];
                }

            }

            firstCand[0] = firstIndex;
            firstCand[1] = firstMin;

            secondCand[0] = secondIndex;
            secondCand[1] = secondMin;

        }

        int res = Integer.MAX_VALUE;
        res = firstCand[1];
        return res;
    }
}
