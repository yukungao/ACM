/*  http://www.lintcode.com/en/problem/palindrome-partitioning-ii/# */

public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        // write your code here
        if(s == null || s.length() < 2) return 0;

        //char[] charArray = s.toCharArray();
        int size = s.length();

        // isPalindrom[i][j] represent if the subString(i-->j) is palindrome or not
        boolean [][] isPalindrom = new boolean[size][size];
        // isPalindrom[i][j] = (s.charAt(i) == s.charAt(j)) && ( isPalindrom[i+1][j-1] || j-i <=1)

        //minCut[i] represent include i, subString(i-->end) need the minCut number.
        int[] minCut = new int[size+1];
        // If the s.subString(i,j+1) is parlindrom, then we simply add one more cut after j.
        // minCut[i] = min( isPalindrom[i][j] && minCut[j+1]) + 1, for i< j <=size
        // Result is stored at minCut[0];


        // Initialize the minCut:
        for(int i = 0; i <= size; i++) {
            minCut[i] = size - 1 - i;
        }


        for(int i = size -1 ; i >= 0; i--) {

            for(int j = i; j < size; j++) {

                if ( (s.charAt(i) == s.charAt(j)) && (j-i < 2 || isPalindrom[i+1][j-1]) ){
                    isPalindrom[i][j] = true;
                }

                // If i is j is palindrom
                if(isPalindrom[i][j]) {
                    minCut[i] = Math.min(minCut[i], minCut[j+1] + 1);
                }

            }
        }

        return minCut[0];
    }
};
