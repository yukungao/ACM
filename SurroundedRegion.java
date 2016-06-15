/* http://www.lintcode.com/en/problem/surrounded-regions/# */
/* Surrounding region */

/* Union-found */

public class Solution {
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    private int [] sz;
    private int [] id;

    public void surroundedRegions(char[][] board) {
        // Write your code here
        if(board.length == 0 || board[0].length == 0) return;

        int m = board.length;
        int n = board[0].length;

        // Prepare for the union find

        sz = new int[m*n+1];
        id = new int[m*n+1];

        //Initialize the arrary for union and find
        for(int i = 0; i < m*n+1; i++) {
            sz[i] = 1;
            id[i] = i;
        }

        // Do the union
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(board[i][j] == 'O') {

                    if(i==0 || i== m-1 || j==0 || j == n-1) {
                        Union(i*n+j,m*n);

                    } else {

                        if(board[i-1][j] == 'O') Union( (i-1)*n+j , i*n+j);
                        if(board[i+1][j] == 'O') Union( (i+1)*n+j , i*n+j);
                        if(board[i][j-1] == 'O') Union( (i*n+(j-1)) , i*n+j);
                        if(board[i][j+1] == 'O') Union( (i*n+(j+1)) , i*n+j);

                    }
                }
            }
        }

        //If "O" is connected to dummy node m*n. Keep it
        //If "O" is not connected to dummy node m*n Mark it as X

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //if(board[i][j] == 'O') {
                if(!connected(i*n+j, m*n))
                    board[i][j] = 'X';
                //}
            }
        }
    }
      boolean connected (int q, int p) {
        return root(q) == root(p);
    }

    // union with path compression
    int root(int i) {
        while(i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    void Union(int q, int p) {
        int i = root(q);
        int j = root(p);
        if(i==j) return;

        if(sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }
