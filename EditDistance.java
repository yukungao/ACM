/* https://leetcode.com/problems/edit-distance/ */
/*
dp[i][j] = if(s.charAt(i-1) == s2.charAt(j-1)) ? dp[i-1][j-1] : Math.min(dp[i-1][j-1],dp[i-1][j], dp[i][j-1]) + 1

*/
public int minDistance(String word1, String word2) {
    // Coner case tackle;
    if(word1 == null) {
        if(word2 == null) {
            return 0;
        } else {
            return word2.length();
        }
    }

    if(word2 == null) {
        if(word1 == null) {
            return 0;
        } else {
            return word1.length();
        }
    }

    /*
        Typical dp problem:
        dp[i][j] represnet the minEditdance to make s1[0->i] == s2[0->j] inclusive i and j
        So the result is dp[s1-1][s2-1];
        Initial dp[0][0]
        Trans Function:
        dp[i][j] = if(i-1 == j-1) ? dp[i-1][j-1] : Math.min(dp[i-1][j-1],dp[i-1][j], dp[i][j-1]) + 1

    */
    int s1 = word1.length();
    int s2 = word2.length();

    int[][] dp = new int[s1+1][s2+1];
    // Initialization:
    dp[0][0] = 0;
    for(int i = 1; i <= s2; i++) {
        dp[0][i] = i;
    }

    for(int i = 1; i <= s1; i++) {
        dp[i][0] = i;
    }

    for(int i = 1; i <= s1; i++) {
        for(int j = 1; j <= s2; j++) {
            if(word1.charAt(i-1) == word2.charAt(j-1)) {
                dp[i][j] = dp[i-1][j-1];
            } else {
                dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]) , dp[i-1][j-1]) + 1;
            }
        }
    }

    return dp[s1][s2];
}
