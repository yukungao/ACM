/* http://www.lintcode.com/en/problem/generate-parentheses/ */

public class Solution {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public ArrayList<String> generateParenthesis(int n) {

        // Write your code here
        //Treat it like dicesion tree,
        //Everytime put a left, reduce the # of left and increase the # of right
        // Left first then right, would guarntee the # of right <= # of left

        ArrayList<String> res = new ArrayList<String>();
        if(n == 0) return res;
        String path = "";
        dfs(res, n, 0, path);
        return res;
    }

    private void dfs(ArrayList<String> res, int left, int right, String path) {
        if(left == 0 && right == 0) {
            res.add(path);
            return;
        }

        if(left > 0) {
            path = path + "(";
            dfs(res, left-1, right+1, path);
            path = path.substring(0, path.length()-1);
        }
        if(right > 0) {
            path = path + ")";
            dfs(res, left, right-1, path);
            path = path.substring(0, path.length()-1);
        }
        return;
    }
}
