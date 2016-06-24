/* https://leetcode.com/problems/game-of-life/ */

/* Since you need to inplace change, and you don't want to let next state
affect your current state. So 2 bit to represent state is a good way*/


public class Solution {
    public void gameOfLife(int[][] board) {
        //Encoding, 00,01,10,11 (next_state, curr_state)
        if(board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j++) {
                int lives = checkNeighber(i,j,m,n,board);

                if(board[i][j] == 1 && lives >= 2 && lives <=3) {
                    board[i][j] = 3;
                }
                if(board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2;
                }
                // Natually, the 01-->00 make no differnce, so we only
                // track if the first-bit become 1.
            }
        }

        // Iteration again to get the next state
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] >>=1;
            }
        }

    }

    private int checkNeighber(int i, int j, int m, int n, int[][] board) {
        int lives = 0;
        // Need to learn how to write like this
        for(int x = Math.max(i-1,0); x <= Math.min(i+1,m-1); x++) {
            for(int y = Math.max(j-1,0); y <= Math.min(j+1, n-1); y++) {
                lives += board[x][y] & 1;
            }
        }
        //Need to remove the duplicate i,j
        lives -= board[i][j] & 1;
        return lives;
    }
}
