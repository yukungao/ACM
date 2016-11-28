public int res;

public int numberOfPatterns(int m, int n) {
    // No need to do the sanity check since 1<=m<=n<=9 is assumption
    if(m == 1 && n == 1) return 9;

    boolean [] visited = new boolean[10];
    visited[0] = true;
    int[][] jumpTable = new int[10][10];
    jumpTable[1][9] = 5;
    jumpTable[9][1] = 5;
    jumpTable[3][7] = 5;
    jumpTable[7][3] = 5;

    jumpTable[1][7] = 4;
    jumpTable[7][1] = 4;
    jumpTable[2][8] = 5;
    jumpTable[8][2] = 5;
    jumpTable[3][9] = 6;
    jumpTable[9][3] = 6;

    jumpTable[1][3] = 2;
    jumpTable[3][1] = 2;
    jumpTable[4][6] = 5;
    jumpTable[6][4] = 5;
    jumpTable[7][9] = 8;
    jumpTable[9][7] = 8;


    for(int start = 1; start <= 9; start++) {
        backTracking(1, visited, 1, m,n, jumpTable) *;
    }

    return res;
}

private void backTracking (int currNode, boolean[] visited, int currLen, int lower, int upper, int[][] jumpTable){

    if(currLen > upper) {
        return;
    }

    if(currLen >= lower) res++;

    // Mark currNode as visited
    visited[currNode] = true;

    // Find the next avilable
    for(int i = 1; i <= 9; i++) {
        if ((visited[i] == false)  && (visited[jumpTable[currNode][i]])) {
            backTracking(i, visited, currLen + 1, lower, upper, jumpTable);
        }
    }

    visited[currNode] = false;
    return;
}
