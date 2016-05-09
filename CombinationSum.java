/* http://www.lintcode.com/en/problem/combination-sum/ */

public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        if(candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        backtracking(candidates, res, target, path, 0);
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
            // start = i will allow the chose of current node again.
            backtracking(candidates, res, target - candidates[i], path,i);
            path.remove(path.size()-1);
            prev = candidates[i];
        }
        return;
    }
}
