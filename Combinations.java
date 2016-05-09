/* http://www.lintcode.com/en/problem/combinations/ */

public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
		// write your code here
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();

		if(n <= 0 || k <= 0) return res;
		backTracking(1, n, k, path, res);
		return res;
    }

    private void backTracking(int start, int end, int k, List<Integer> path, List<List<Integer>> res) {
        // Find the solution, should add to res's repo
        if(path.size() == k) {
            res.add(new ArrayList(path));
            return;
        }

        for(int i = start ; i <= end; i++) {
            path.add(i);
            backTracking(i+1, end, k, path, res);
            path.remove(path.size()-1);
        }

        return;
    }


}
