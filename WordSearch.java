/* http://www.lintcode.com/en/problem/word-search/ */

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        // Four way DFS.
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        if(word == null || word.length() == 0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++) {
            for(int j=0; j < board[0].length; j++) {
                // Stop searching once find a solution
                if(dfs(board,visited,i,j,word,0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int x, int y, String word, int index) {

        if(x < 0 || x > board.length -1 || y < 0 || y > board[0].length -1 ) return false;

        if(!visited[x][y] && board[x][y] == word.charAt(index)) {
            if(index == word.length()-1) return true;
            visited[x][y] = true;
            boolean up = dfs(board, visited,x,y-1,word,index+1);
            boolean down = dfs(board, visited,x,y+1,word,index+1);
            boolean left = dfs(board, visited,x-1,y,word,index+1);
            boolean right = dfs(board, visited,x+1,y,word,index+1);
            visited[x][y] = up || down || left || right;
            return (up || down || left || right);
        }

        return false;

    }
}
