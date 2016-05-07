/* http://www.lintcode.com/en/problem/word-ladder/ */

public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        // Everytime change 1 char, make the shortest path problem solvable
        // Using BFS. Once it reach the result, could return directly.
        if(dict.size() == 0) return 0;
        int res = 1;
        Queue<String> myQ = new LinkedList<String>();
        myQ.offer(start);
        dict.remove(start);

        while(!myQ.isEmpty()) {
            int size = myQ.size();
            for(int i=0; i < size; i++) {
                String curNode = myQ.poll();
                // max iter 26 instead of dict.size()
                for(char c = 'a'; c <= 'z'; c++) {
                    for (int j = 0; j < curNode.length(); j++) {
                        if(c == curNode.charAt(j)) continue;
                        String tmpNode = replace(curNode, c, j);
                        if(tmpNode.equals(end)) return res +1;
                        if(dict.contains(tmpNode)) {
                            // Use dict as visited[];
                            dict.remove(tmpNode);
                            myQ.offer(tmpNode);
                        }
                    }
                }
            }
            res++;
        }
        return 0;
    }

    private String replace(String str, char c, int j) {
        char [] chars = str.toCharArray();
        chars[j] = c;
        return new String(chars);
    }
}
