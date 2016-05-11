/* Input: 2D board
   A person could walk on the board
   Output: # of paths if the steps are constraint between 4 and 9
*/


public int encodingWay(char[][] board) {
       // write your code here
       // Four way DFS.
       if(board == null || board.length == 0 || board[0].length == 0) return 0;
       boolean[][] visited = new boolean[board.length][board[0].length];

       for(int i = 0; i < board.length; i++) {
           for(int j=0; j < board[0].length; j++) {
              // If not allowed global var
              // res += dfs(board,visited,i,j,0));
              // If allowed global var
              //dfs(board,visited,i,j,0));
           }
       }
       return res;
}

  // If allow global var
  private static int res;
  private void dfs(char[][] board, boolean[][] visited, int x, int y, int depth) {
        // Out of boundary,
        if(x < 0 || x > board.length -1 || y < 0 || y > board[0].length -1 || depth > 9) return;
        if(depth >= 4) res++;
        if(!visited[x][y]) {
            visited[x][y] = true;
            dfs(board, visited,x,y-1,depth+1);
            dfs(board, visited,x,y+1,depth+1);
            dfs(board, visited,x-1,y,depth+1);
            dfs(board, visited,x+1,y,depth+1);
            visited[x][y] = false;
        }
        return res;
  }


  // If don't allow global var, we need to avoid
  private int dfs(char[][] board, boolean[][] visited, int x, int y, int depth) {
        // Out of boundary, need to check
        if(x < 0 || x > board.length -1 || y < 0 || y > board[0].length -1 || visited[x][y] || depth > 9) {
          return 0;
        }

        visited[x][y] = true;
        int left = dfs(board, visited,x,y-1,depth+1);
        int right = dfs(board, visited,x,y+1,depth+1);
        int up = dfs(board, visited,x-1,y,depth+1);
        int down = dfs(board, visited,x+1,y,depth+1);
        visited[x][y] = false;
        return depth >= 4 ? (left + right + up + down + 1) : (left + right + up + down);
  }
