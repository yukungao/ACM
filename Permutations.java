/* http://www.lintcode.com/en/problem/permutations/ */


// Iterative, insertion way

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        // Iterative way to implement
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.size() == 0) return res;
        Collections.sort(nums);
        res.add(new ArrayList<Integer>());


        for(int i = 0; i < nums.size(); i++) {
            ArrayList<ArrayList<Integer>> nextRes = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> ele : res) {
                for(int j = 0; j <= ele.size(); j++) {
                    ele.add(j, nums.get(i));
                    nextRes.add(new ArrayList<Integer>(ele));
                    ele.remove(j);

                }
            }
            res = nextRes;
        }

        return res;
    }
}

// Iterative, BFS way

public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
    // write your code here
    // Iterative way to implement
    // Basically a BFS
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    if(nums == null || nums.size() == 0) return res;
    Collections.sort(nums);

    Queue<ArrayList<Integer>> queue = new LinkedList<ArrayList<Integer>>();
    queue.offer(new ArrayList<Integer>());

    while(!queue.isEmpty()) {
        ArrayList<Integer> partial = (ArrayList<Integer>) queue.poll();

        for(int i = 0; i < nums.size(); i++) {
          if(partial.contains(nums.get(i))) continue;
            partial.add(nums.get(i));
            if(partial.size() == nums.size()) {
              //System.out.println(partial.toString());
              res.add(new ArrayList<Integer>(partial));
            }
            queue.offer(new ArrayList<Integer>(partial));
            partial.remove(partial.size()-1);
        }

    }
    return res;
}
