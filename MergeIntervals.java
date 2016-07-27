/* http://www.lintcode.com/en/problem/merge-intervals/ */

/*

[                     [
  [1, 3],               [1, 6],
  [2, 6],      =>       [8, 10],
  [8, 10],              [15, 18]
  [15, 18]            ]
]

*/

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        List<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0) return res;

        Collections.sort(intervals, new IntervalComparator());
        // So far the intervals are sorted by there start value.
        Interval collect = new Interval(intervals.get(0).start, intervals.get(0).end);
        for(int i = 0; i < intervals.size() - 1 ; i++) {
            Interval current = intervals.get(i);
            Interval next = intervals.get(i+1);

            // Merge until it couldn't be mergered!! Should use collect's end instead of current end!
            if(collect.end >= next.start){
                collect.end = Math.max(Math.max(current.end, next.end), collect.end);
            } else {
                // Add to the result and start with next.
                res.add(new Interval(collect.start, collect.end));
                collect.start = next.start;
                collect.end = next.end;
            }
        }
        res.add(new Interval(collect.start, collect.end));

        return res;
    }

    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a , Interval b) {
            return a.start - b.start;
        }
    }

}
