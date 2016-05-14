/* http://www.lintcode.com/en/problem/candy/ */

public class Solution {
    /**
     * @param ratings Children's ratings
     * @return the minimum candies you must give
     */
    public int candy(int[] ratings) {
        // Write your code here
        // Left--> Right, find the left constraints left[i]
        // Right ---> Left, find the right cosntraints right[i]
        // Then chosen the max(left[i], right[i])
        if(ratings == null || ratings.length == 0) return 0;
        int size = ratings.length;
        // From left-> right, find the left constraints
        int[] left = new int [size];
        int[] right = new int [size];
        left[0] = 1;
        for(int i = 1; i < size; i++) {
            if(ratings[i] > ratings[i-1]) {
                left[i] = left[i-1] + 1;
            } else {
                left[i] = 1;
            }
        }
        right[size-1] = left[size-1];
        for(int i = size-2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]) {
                right[i] = right[i+1] + 1;
            } else {
                right[i] = 1;
            }
        }

        int res = 0;
        for(int i = 0; i < size ; i++) {
            res += Math.max(left[i], right[i]);
        }

        return res;
    }
}
