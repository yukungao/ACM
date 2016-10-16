/* https://leetcode.com/problems/shortest-word-distance/ */
public int shortestDistance(String[] words, String word1, String word2) {
    /*
        We keep updating the word1 & word2's index and everytime we calculate the res
    */
    if(words == null || words.length == 0 || word1.equals(word2)) return 0;

    int a_index = -1;
    int b_index = -1;
    int res = Integer.MAX_VALUE;

    for(int i = 0; i < words.length ; i++) {
        if(words[i].equals(word1)) {
            a_index = i;
        }

        if(words[i].equals(word2)) {
            b_index = i;
        }

        if(a_index == -1 || b_index == -1) continue;

        res = Math.min(Math.abs(a_index - b_index), res);

    }

    return res;

}

/*
Follow up 2: If you have multi querys, design a data structure to do it.
https://leetcode.com/problems/shortest-word-distance-ii/
*/

private Map<String,List<Integer>> map;

   public WordDistance(String[] words) {
       map = new HashMap<String, List<Integer>>();
       for(int i = 0; i < words.length; i++) {
           if(!map.containsKey(words[i])) {
               map.put(words[i], new ArrayList<Integer>());
           }
           map.get(words[i]).add(i);
       }
   }

   public int shortest(String word1, String word2) {
       // Till now we have the map
       List<Integer> word1Indexs = map.get(word1);
       List<Integer> word2Indexs = map.get(word2);
       int res = Integer.MAX_VALUE;
       if(word1Indexs == null || word2Indexs == null) return res;

       int p1 = 0;
       int p2 = 0;

       while(p1 < word1Indexs.size() && p2 < word2Indexs.size()) {
           if(word1Indexs.get(p1) < word2Indexs.get(p2)) {
               res = Math.min(res, word2Indexs.get(p2) - word1Indexs.get(p1));
               p1++;
           } else {
               res = Math.min(res, word1Indexs.get(p1) - word2Indexs.get(p2));
               p2++;
           }
       }

       return res;
   }


/*https://leetcode.com/problems/shortest-word-distance-iii/*/
/*
假如 word1 == word2, 需要循环移位index1 && index2 !!
*/
public int shortestWordDistance(String[] words, String word1, String word2) {
    if(words == null || words.length == 0) return 0;

    /*
        If word1 != word2, we keep update res and update index1 and index2 sperately
        if word1 == word2, we should shift index1 , index2 <= index2, new Index
    */
    int index1 = -1;
    int index2 = -1;
    int res = Integer.MAX_VALUE;

    for(int i = 0; i < words.length; i++) {
        if(words[i].equals(word1) && words[i].equals(word2)) {
            index1 = index2;
            index2 = i;
        } else {
            if(words[i].equals(word1)) index1 = i;
            if(words[i].equals(word2)) index2 = i;
        }

        if(index1 != -1 && index2 != -1) {
            res = Math.min(res, Math.abs(index2 - index1));
        }

    }

    return res;
}
