/* http://www.lintcode.com/en/problem/n-queens-ii/ */


class Solution {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public static int res;
    public int totalNQueens(int n) {
        //write your code here
        res = 0;
        ArrayList<Integer> partial = new ArrayList<Integer>();
        backTracking(partial,n);
        return res;
    }


    // We use ArrayList<Integer> to store the chessboard so far
    // index--> row, value --> col;

    private boolean isValid(ArrayList<Integer> cols, int col) {
        int row = cols.size();

        for(int i = 0; i < cols.size(); i++) {
            // The same colum:
            if(cols.get(i) == col) {
                return false;
            }
            if(i - row == cols.get(i) - col) {
                return false;
            }
            if(i + cols.get(i) == col + row) {
                return false;
            }
        }
        return true;
    }

    private void backTracking(ArrayList<Integer> partial, int n) {
        // if all the colums are filled up, then its a valid solution
        if(partial.size() == n) {
            res++;
            return;
        }

        // Try each position
        for(int i = 0; i < n; i++) {

            if(!isValid(partial,i)) continue;

            partial.add(i);
            backTracking(partial,n);
            partial.remove(partial.size()-1);
        }
        return;
    }
};
