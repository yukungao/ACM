/* http://www.lintcode.com/en/problem/backpack-ii/# */

public int backPackII(int m, int[] A, int V[]) {
      // write your code here
      if(m == 0 || A == null || A.length == 0 || V == null || V.length == 0) return 0;

      int[][] dp = new int[A.length+1][m+1];


      for(int i = 0; i <= A.length; i++) {
          dp[i][0] = 0;
      }

      for(int i = 1; i <= A.length; i++){
          for(int j = 1; j <= m; j++) {
              dp[i][j] = dp[i-1][j];
              if(j >= A[i-1]) {
                  dp[i][j] = Math.max(dp[i][j], dp[i-1][j-A[i-1]] + V[i-1]);
              }
          }
      }

      return dp[A.length][m];
  }
