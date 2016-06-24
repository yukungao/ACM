/* https://leetcode.com/problems/nim-game/ */
/* Nim Game */


//Solution 1: Memorized search
public class Solution {
    public boolean canWinNim(int n) {

        // Memorized search
        // dp[i] represent i stone left, the first player will win
        // dp[i] = !(dp[i-1] || dp[i-2] || dp[i-3])
        boolean [] dp = new boolean [n+1];
        boolean [] visited = new boolean[n+1];
        return memSearch(n,dp,visited);
    }

    private boolean memSearch(int i,boolean [] dp, boolean [] visited) {
        if(visited[i]) return dp[i];
        if(i == 0) return false;
        else if(i == 1 || i==2 || i==3) return true;
        dp[i] = memSearch(i-1,dp,visited) || memSearch(i-2,dp,visited) || memSearch(i-3,dp,visited);
        visited[i] = true;
        return dp[i];
    }
}
// Solution 2: Simple mathmatic
public class Solution {
    public boolean canWinNim(int n) {
        return !(n%4 == 0);
    }
}
