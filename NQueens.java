/* http://www.lintcode.com/en/problem/n-queens/ */


class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        ArrayList<ArrayList<String>> chessBoards= new ArrayList<ArrayList<String>>();

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> partial = new ArrayList<Integer>();
        backTracking(res, partial, n);

        // For each solution
        for(ArrayList<Integer> cb : res) {
            //For each row, build a string and add to chase board
            ArrayList<String> sol = new ArrayList<String>();
            for(int i = 0; i < n; i++) {
                StringBuilder row = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    if(j != cb.get(i)) {
                        row.append('.');
                    } else {
                        row.append('Q');
                    }
                }
                sol.add(row.toString());
            }
            chessBoards.add(sol);

        }
        return chessBoards;
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

    private void backTracking(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> partial, int n) {
        // if all the colums are filled up, then its a valid solution
        if(partial.size() == n) {
            res.add(new ArrayList<Integer>(partial));
            return;
        }

        // Try each position
        for(int i = 0; i < n; i++) {

            if(!isValid(partial,i)) continue;

            partial.add(i);
            backTracking(res,partial,n);
            partial.remove(partial.size()-1);
        }
        return;
    }
};
