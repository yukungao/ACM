/* http://www.lintcode.com/en/problem/perfect-squares/ */

/*
  头一次碰到这种 边穷举边build的题
  Similar Problems are: 
  Ugly Number I, Ugly Number II, Supper Ugly Number
*/
public int numSquares(int n) {
        /*
            dp[i + (1->j)^2] = dp[i] + 1 where i -> 0-->n, j is i + (1->j)^2 >= n
        */

        // Sanity Check
        if(n < 0) return 0;
        if(n <= 1) return n;
        int [] dp = new int[n+1];

        for(int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        for(int i = 0; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i + j*j > n) break;
                dp[i + j*j ] = Math.min(dp[i+j*j],dp[i] + 1);
            }
        }

        return dp[n];
    }
