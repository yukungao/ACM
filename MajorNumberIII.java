/* http://www.lintcode.com/en/problem/majority-number-iii/ */
// Find number that more than 1/K of the whole array
/*
Key 1: If the candidate map is larger than k, remove everything that happen only 1s

Key 2: Pick the larger one

*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        if(nums == null || nums.size() == 0) return Integer.MIN_VALUE;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // Put everything inside of the map
        for(Integer num : nums) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            // If the map's size
            if(map.size() >= k) {
                removeUnqualified(map);
            }
        }
        // If everything come up only once, there are no result then
        if(map.size() == 0) return Integer.MIN_VALUE;

        // Reset the map
        for(Integer key : map.keySet()) {
            map.put(key, 0);
        }


        for(Integer num : nums) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }
        }

        // So far all the stuff inside of map is candidate, we can go ahead
        // and find the one with largest count.

        int res = Integer.MIN_VALUE;
        int count = 0;

        for(Integer key : map.keySet()) {
            if(map.get(key) > count) {
                count = map.get(key);
                res = key;
            }
        }

        return res;
    }

    // Why we need to remove every
    private void removeUnqualified(HashMap<Integer, Integer> map) {
        ArrayList<Integer> removes = new ArrayList<Integer>();

        for(int key : map.keySet()) {
            if(map.get(key) == 1) {
                removes.add(key);
            } else {
                map.put(key, map.get(key) -1);
            }
        }

        for(Integer remove : removes) {
            map.remove(remove);
        }
    }
}
