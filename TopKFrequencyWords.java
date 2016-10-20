
/* https://leetcode.com/problems/top-k-frequent-elements/ */

/*
需要注意的点: priorityqueue(k,myComparator); 这里的k并不是真正

*/

/*
Solution 1: Using a Heap. PriorityQueue to do this
*/



public List<Integer> topKFrequent(int[] nums, int k) {

    List<Integer> res = new ArrayList<Integer>();
    if(nums == null || nums.length == 0 || k == 0) {
        return res;
    }


    // Build a hash map to hash the num and its frequency
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int num : nums) {
        if(!map.containsKey(num)) {
            map.put(num , 1);
        } else {
            map.put(num, map.get(num) + 1);
        }
    }
    // Use a max-heap to only store the K.
    Comparator<Data> dataComparator = new DataComparator();
    PriorityQueue<Data> pq = new PriorityQueue<Data>(k, dataComparator);

    // Do an abstraction
    for(int key : map.keySet()) {
        pq.offer(new Data(key, map.get(key)));
    }


    while(res.size() < k) {
        res.add(pq.poll().val);
    }

    return res;
}

 //
public class Data {
    int val;
    int freq;

    public Data(int val, int freq) {
        this.val = val;
        this.freq = freq;
    }
}

// Realize the comparator
public class DataComparator implements Comparator<Data> {
    @Override
    public int compare(Data a , Data b) {
        return b.freq-a.freq;
    }
}

/*
Solution 2: Since the # of candidate is fixed, we could get the maxim frequency
this indicate we could use the bucket sort idea.
*/
