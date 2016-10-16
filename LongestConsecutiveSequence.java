/* https://leetcode.com/problems/longest-consecutive-sequence/ */

/* Greedy Search + Set, 假如num-1,不存在，我们开始从num搜. 代表着线段的开始 */
public int longestConsecutive(int[] nums) {
        // Build a hashset, if n-1 not in set,
        // Means it doesn't belong to any set yet.
        // then greedily find n+1, n+2, n+3
        if(nums == null || nums.length == 0) return 0;

        /* Step 1 Put everything into the set */
        Set set = new HashSet<Integer>();
        for(Integer num : nums) {
            set.add(num);
        }
        /* Step 2 */
        int res = 0;
        for(Integer num : nums) {
            if(!set.contains(num-1)){
                int tmp = 0;
                while(set.contains(num)) {
                    tmp++;
                    num++;
                }
                res = Math.max(res, tmp);
            }
        }

        return res;
    }


/*
HashMap 存线段的 (start, end).注意，update的时候，是update new lowerbound
和 new highbound. 因为他俩是新线段的头和尾
*/

public int longestConsecutive(int[] nums) {
    // Build a hashset, if n-1 not in set,
    // Means it doesn't belong to any set yet.
    // then greedily find n+1, n+2, n+3
    if(nums == null || nums.length == 0) return 0;

    /* Construct map to store key ---> [lowbound, upperbound] */
    /*
        This idea doesn't work if you only update num-1 and num+1
        Actually, you should update  - left , num + right
    */

    Map<Integer, int[]> map = new HashMap<Integer, int[]>();
    int res = 0;
    for(Integer num : nums) {
        if(map.containsKey(num)) continue;

        int [] bounds = new int[] {num, num};
        if(map.containsKey(num-1)) {
            bounds[0] = map.get(num-1)[0];
        }

        if(map.containsKey(num+1)) {
            bounds[1] = map.get(num+1)[1];
        }
        /* Update the bound */
        if(map.containsKey(num-1)) map.put(bounds[0], bounds);
        if(map.containsKey(num+1)) map.put(bounds[1], bounds);
        map.put(num, bounds);
        res = Math.max(res, bounds[1] - bounds[0] + 1);
    }

    return res;
}
