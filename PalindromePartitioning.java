public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<ArrayList<String>();
        List<String> partial = new ArrayList<String>();

        // Step 1, record all the dp[i][j] represent from i->j is palindrom
        boolean [][] isPalindrom = new boolean [][];
        int size = s.length();

        for (int i = size -1; i >= 0; i--) {
            for (int j = i; j < size; j++) {
                if((s.charAt(i) == s.charAt(j)) && (j == i || j-i < 2 || isPalindrom[i+1][j-1])) {
                    isPalindrom[i][j] = true;
                }
            }
        }

        // Step 2, backtracking with such partition.
        backTracking(res, partial, s, 0, isPalindrom);
        return res;
    }


    private void backTracking(List<List<String>> res, List<String> partial, String s, int start, boolean[][] dp) {
      // Reach the end of the string
      if(start == s.length()) {
          res.add(new List<String>(partial));
          return;
      }

      for(int i = start; i < s.length(); i++) {
        if(dp[start][i]) {
          partial.add(s.substring(start,i+1));
          backTracking(res, partial, s, i+1, dp);
          partial.remove(partial.size()-1);
        }
      }

      return;
    }
}
