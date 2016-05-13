/* http://www.lintcode.com/en/problem/gas-station/# */
public class Solution {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        // Use sum to store remaining gas in tank
        // Use total to store possible remaining gas in tank
        // start is the result.
        int sum = 0;
        int total = 0;
        int start = 0;

        for(int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            // If current sum < 0, means the start point could only after i;
            if(sum < 0) {
                start = i + 1;
                sum = 0;
            }
            total += gas[i] -cost[i];
        }

        if(total < 0) {
            // The sum of cost is larger than sum of gas
            return -1;
        } else {
            return start;
        }
    }
}
