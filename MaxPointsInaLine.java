/* http://www.lintcode.com/en/problem/max-points-on-a-line/# */
/*
1. 垂直曲线， 即斜率无穷大
2. 重复节点
3. Store the value in (Double)
*/
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param points an array of point
     * @return an integer
     */
    public int maxPoints(Point[] points) {
        // Write your code here
        if(points == null || points.length == 0) return 0;
        HashMap<Double, Integer> map = new HashMap<Double,Integer>();
        int res = 1;
        int dup = 0;
        // Notice that maybe all the points are the same points.

        for(int i = 0; i < points.length; i++) {
            map.clear();
            dup = 0;
            boolean sameFlag = true;
            for(int j = 0; j < points.length; j++){
                if(j == i) continue;
                // Please be aware if two points are same, you should count dup.
                if(points[i].x == points[j].x && points[i].y == points[j].y) {
                    dup++;
                    continue;
                }
                sameFlag = false;
                //Caculate the slop
                double slop = (points[i].x - points[j].x) == 0 ? Double.MAX_VALUE : 0.0 + (double) (points[i].y - points[j].y) / (double) (points[i].x - points[j].x) ;
                if(map.containsKey(slop)) {
                    map.put(slop, map.get(slop) + 1);
                } else {
                    map.put(slop,2);
                }

            }
            if(sameFlag) res = dup + 1;

            for(int temp : map.values()) {
                res = Math.max(res, temp + dup);
            }
        }
        return res;
    }
}
