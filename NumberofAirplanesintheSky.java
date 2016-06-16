/* http://www.lintcode.com/en/problem/number-of-airplanes-in-the-sky/# */
/* One problem that use Interval Structure */

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */


class Point {
    int time;
    // flag = 1 take off
    // flag = 0 land
    int flag;

    Point(int t, int f) {
        this.time = t;
        this.flag = f;
    }

    //Need to provide compartor for Collections to sort
    public static Comparator<Point> PointComparator = new Comparator<Point>() {
        public int compare(Point p1, Point p2) {
            // If take off and landing at the same time then
            // landing first
            if(p1.time == p2.time) return p1.flag - p2.flag;
            else return p1.time - p2.time;
        }
    };
}


class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {

        // write your code here
        int res = 0;
        if(airplanes == null || airplanes.size() == 0) return 0;
        int size = airplanes.size();
        List<Point> lst = new ArrayList<>(size*2);

        //Better use foreach method
        for(Interval i : airplanes) {
            lst.add(new Point(i.start, 1));
            lst.add(new Point(i.end, 0));
        }

        Collections.sort(lst, Point.PointComparator);
        int cnt = 0;

        //Better use foreach method
        for(Point p : lst) {
            if(p.flag == 1) cnt++;
            else cnt--;
            res = Math.max(res,cnt);
        }


        return res;
    }
}
