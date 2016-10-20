/* http://www.lintcode.com/en/problem/maximum-gap/ */
/* https://discuss.leetcode.com/topic/51276/solutions-in-c-with-explanation-read-it-and-then-you-get-it */
/* The keypoint here is
1. The Bucket is like [min, min+gap);
2. to determin the buckets (We want the result happends in sucessive two bucket)
  a) The maxim a bucket would provide is gap-1,
  b)the gap-1 should be at least average length (maxValue - minValue)/(nums.length-1)
  c)So the gap is (maxValue - minValue)/(nums.length-1) + 1;

3. Trick is two initialize the result is the bucket[0].max - bucket[0].min
*/
class Solution {
    /**
     * @param nums: an array of integers
     * @return: the maximum difference
     */
    public int maximumGap(int[] nums) {
        // write your code here
        // The count sort could solve this problem in linear time

        if(nums == null || nums.length < 2) return 0;
        if(nums.length == 2) return Math.abs(nums[1] - nums[0]);
        // Find the min/max in one iteration
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            minValue = Math.min(minValue, nums[i]);
            maxValue = Math.max(maxValue, nums[i]);
        }
        if(minValue == maxValue) return 0;

        // Caculate the average length of bucket
        /*
        */
        int avgLen = (maxValue - minValue)/(nums.length-1) + 1;

        int numOfBucket = nums.length;

        // Create buckets and put element into it.
        Bucket[] buckets = new Bucket[nums.length];
        for(int i = 0; i < numOfBucket; i++) {
            buckets[i] = new Bucket();
        }

        // Start to put things into bucket.
        for(int num : nums) {
            int index = (num - minValue) / avgLen;
            if(buckets[index].min == -1 && buckets[index].max == -1) {
                buckets[index].min = num;
                buckets[index].max = num;
            } else {
                buckets[index].min = Math.min(buckets[index].min, num);
                buckets[index].max = Math.max(buckets[index].max, num);
            }
        }
        // Caculate the curr.min - pre.max
        int lastMax = buckets[0].max;
        int thisMin = buckets[0].min;
        int res = lastMax - thisMin;

        for(int i = 1; i < nums.length; i++) {
            if(buckets[i].min == -1 && buckets[i].max == -1) continue;
            res = Math.max(res, (buckets[i].min - lastMax));
            lastMax = buckets[i].max;
        }

        return res;
    }


    public class Bucket {

        public int min;
        public int max;

        public Bucket( ) {
            this.min = -1;
            this.max = -1;
        }
    }
}
