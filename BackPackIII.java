/* http://www.lintcode.com/en/problem/backpack-iii/# */


/* This fucking stupid*/
public int backPackIII(int[] A, int[] V, int m) {
    // Write your code here

    if(m == 0 || A == null || A.length == 0 || V == null || V.length == 0) return 0;

    int[][] dp = new int[A.length+1][m+1];


      for(int i = 0; i <= A.length; i++) {
          dp[i][0] = 0;
      }

      // Time complexity is n^2*m;
      // Why it could represent the result ?
      for(int i = 1; i <= A.length; i++){
          for(int j = 1; j <= m; j++) {
              dp[i][j] = dp[i-1][j];
              // This layer will look everything from start now...
              for(int k = 1; k <= A.length; i++) {
                  if(j >= A[k-1]) {
                     dp[i][j] = Math.max(dp[i][j], dp[i-1][j-A[k-1]] + V[k-1]);
                  }
              }
          }
      }

      return dp[A.length][m];
    }
