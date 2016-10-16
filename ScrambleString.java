/* http://www.lintcode.com/en/problem/scramble-string/ */

public boolean isScramble(String s1, String s2) {
    // Write your code here

    // Corner cases
    if(s1 == null && s2 == null ) return true;
    if(s1 == null || s2 == null || s1.length() != s2.length() || !isAnagrams(s1,s2)) return false;

    // dp[i][j][len], means from i to i + len, and j to j + len is scramble.
    // Result is dp[0][0][size];

    // Initialization: dp[i][j][0] = true;
    // dp[i][j][len] = dp[i][j][k] && dp[i+k][j+k][len-k] || dp[i][len-k][k] && dp[i+len-k][j][len-k]


    int size = s1.length();
    int [][][] mem = new int[size][size][size + 1];
    for(int i = 0; i < size; i++) {
        for(int j = 0; j < size; j++) {
            for(int k = 0; k <= size; k++) {
                mem[i][j][k] = -1;
            }
        }
    }

    // Use Memorization is a easy way to code
    return dfs(0,0,s1,s2,size, mem) == 1;


}

private int dfs(int s1_index, int s2_index, String s1, String s2, int len, int[][][] mem) {
   // Return condition ?
   if(len == 0) {
       mem[s1_index][s2_index][len] = 1;
       return 1;
   }

   if(len == 1) {

       if(s1.charAt(s1_index) == s2.charAt(s2_index)) {
           mem[s1_index][s2_index][len] = 1;
           return 1;
       } else {
           mem[s1_index][s2_index][len] = 0;
           return 0;
       }
   }

   if(mem[s1_index][s2_index][len] != -1) {
       return mem[s1_index][s2_index][len];
   }

   // What's the boundary.
   for(int k = 1; k <= len; k++) {
       if( (dfs(s1_index, s2_index, s1, s2, k, mem) == 1)  && (dfs(s1_index + k, s2_index + k, s1, s2, len - k, mem) == 1) ) {
           mem[s1_index][s2_index][len] = 1;
           return 1;
       }

       if( (dfs(s1_index, s2_index + len - k, s1, s2, k, mem) == 1) && (dfs(s1_index + k, s2_index, s1, s2, len - k, mem) == 1) ) {
           mem[s1_index][s2_index][len] = 1;
           return 1;
       }
   }

   mem[s1_index][s2_index][len] = 0;
   return 0;

}

private boolean isAnagrams(String s1, String s2) {
    char[] str1 = s1.toCharArray();
    char[] str2 = s2.toCharArray();
    Arrays.sort(str1);
    Arrays.sort(str2);
    return Arrays.equals(str1,str2);
}
