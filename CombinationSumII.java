/* http://www.lintcode.com/en/problem/combination-sum-ii/ */

public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        if(num == null || num.length == 0) return res;
        Arrays.sort(num);
        backtracking(num, res, target, path, 0);
        return res;
    }



     private void backtracking(int[] candidates, List<List<Integer>> res, int target,

        List<Integer> path, int start) {

        if(target == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        int prev = -1;
        for(int i = start; i < candidates.length; i++) {
            if(candidates[i] > target) break;
            // prev node is equal current node, need to skip to avoid duplicate
            if(prev != -1 && prev == candidates[i]) continue;
            path.add(candidates[i]);
            // start = i+1 determine it couldn't chose current node again.
            backtracking(candidates, res, target - candidates[i], path,i+1);
            path.remove(path.size()-1);
            prev = candidates[i];
        }
        return;
    }

}
