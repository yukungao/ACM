/* http://www.lintcode.com/en/problem/insert-interval/# */

/*
Example
Insert [2, 5] into [[1,2], [5,9]], we get [[1,9]].

Insert [3, 4] into [[1,2], [5,9]], we get [[1,2], [3,4], [5,9]].
*/


/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> res = new ArrayList<Interval>();

        // wArrayList<Interval> res = new ArrayList<Interval>();rite your code here
        if(newInterval == null || intervals == null) return intervals;
        if(intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }

        Interval collection = new Interval(newInterval.start, newInterval.end);

        int i = 0;
        for(; i < intervals.size(); i++) {
            Interval current = intervals.get(i);

            // If current intervals have no overlap with collection
            // Then break and add the followings into result.
            if(current.end < collection.start) {
                res.add(current);
            } else if(collection.end < current.start) {
                break;
            } else {
                collection.start = Math.min(collection.start, current.start);
                collection.end = Math.max(collection.end, current.end);
            }

        }
        res.add(collection);
        for(int j = i; j < intervals.size(); j++) {
            res.add(intervals.get(j));
        }

        return res;
    }
}
