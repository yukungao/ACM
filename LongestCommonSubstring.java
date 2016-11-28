public int longestCommonSubstring(String A, String B) {
        // write your code here
        int A_size = A.length();
        int B_size = B.length();

        if(A_size == 0 || B_size== 0) return 0;

        // dp[i][j] contain the length of common substring between A(i)-->B(j)
        int[][] dp = new int[A_size+1][B_size+1];

        for(int i = 0; i < A_size+1; i++) {
            for(int j = 0; j < B_size+1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                if(A.charAt(i-1) == B.charAt(j-1)){
                  dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
                }
            }
        }

        return dp[A_size][B_size];
    }
