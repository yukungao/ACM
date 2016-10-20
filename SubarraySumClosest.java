/*http://www.lintcode.com/en/problem/subarray-sum-closest/# */

/*

Key points : Collection Sort
index calculate: minIndex + 1;

*/
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] res = new int[2];
        if(nums == null || nums.length ==0) return res;
        int size = nums.length;

        if(size == 1) {
            res[0] = 0;
            res[1] = 0;
            return res;
        }

        int sum = 0;
        ArrayList<Point> points = new ArrayList<Point>();
        //Step 1: Calculate the pre-fix sum and create Point
        for(int i = 0; i < size; i++) {
            sum += nums[i];
            Point currNode = new Point(i,sum);
            points.add(currNode);
        }

        // Step 2: Sort the Points based on sum value
        Collections.sort(points, new MyComparator());
        for(Point point : points) {

        }


        // Step 3: Iterate through array and found adjcancy difference is 0;
        int minDiff = Integer.MAX_VALUE;
        for(int i = 1; i < points.size(); i++) {
            int currDiff = points.get(i).sum - points.get(i-1).sum;
            if(Math.abs(currDiff)  < minDiff) {
                minDiff = currDiff;
                res[0] = Math.min(points.get(i-1).index, points.get(i).index)+1;
                res[1] = Math.max(points.get(i-1).index, points.get(i).index);
            }
        }

        return res;
    }

    public class MyComparator implements Comparator<Point> {
        public int compare(Point p1, Point p2) {
            return p1.sum - p2.sum;
        }
    }

    public class Point {
        public int index;
        public int sum;

        public Point (int index, int sum) {
            this.index = index;
            this.sum = sum;
        }
    }
}
