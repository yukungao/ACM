/* https://leetcode.com/problems/decode-string/ */

/*
Build two stks:
-> stk1 is for data;
-> stk2 is for string;

Iterate through the string s:
-> Ignore the '['
-> construct data or string
-> push data into stk1
-> push string into stk2

-> If encounter the ']'
    -> pop data form stk1 and string from stk2
    -> Build the string data x string
    -> If the stk1 is not empty,
        -> Append it to the peek of the stk2
    -> If the stk1 is empty, we kind of add current string to result
*/



/*
We could think this problem as DFS problem.
Every time we encounter digit, means we need to call the dfs to solve the sub-problem(which is sub parents).

-> From given level, we have the repeat from the uper level, we then calculate
the substring for current level and multiply repeat time, add to the partial result.

-> We also want to return the index we finish in current level, so the upper level could
directly jump over the substring covered by dfs();
*/

/*
dfs
*/
public String decodeString(String s) {

        // Tradition stack problem.
        if(s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        dfs(sb,s,0);
        return sb.toString();
    }

    private int dfs(StringBuilder partial, String s, int start) {

        if(start >= s.length()) {
            return s.length();
        }

        for(int i = start; i < s.length();) {

            // If we encounter ] that means it's time to return to
            // the previous level
            if(s.charAt(i) == ']') {
                return i+1;
            }

            // Find the string part
            if(validChar(s.charAt(i))){
                int tmp = i;
                while(tmp < s.length() && validChar(s.charAt(tmp))) {
                    tmp++;
                }
                partial.append(s.substring(i, tmp));
                if(tmp == s.length()) {
                    return s.length();
                }
                i = tmp;
            }

            // Find the Integer Part * Repeating String
            if(Character.isDigit(s.charAt(i))) {
                int tmp = i;
                while(tmp < s.length() && Character.isDigit(s.charAt(tmp))) {
                    tmp++;
                }
                int repeat = Integer.parseInt(s.substring(i,tmp));
                // This should be the [
                if(s.charAt(tmp) != '[') {
                    //System.out.println("ERROR! ILLEGE FORMART");
                    return s.length();
                }

                StringBuilder innerSb = new StringBuilder();
                int end = dfs(innerSb, s, tmp+1);
                i = end;
                while(repeat > 0) {
                    partial.append(innerSb.toString());
                    repeat--;
                }
            }

        }
        //Find the string part of
        return s.length();
    }

    private boolean validChar(char c) {

      if( (c - 'a' >= 0) && (c - 'z' <= 0)) {
        return true;
      } else {
        return false;
      }
    }
