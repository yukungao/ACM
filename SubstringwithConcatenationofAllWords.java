/* https://leetcode.com/problems/substring-with-concatenation-of-all-words/ */


// Brute Force 解法
// 注意,字典里的word可能有重复.
public List<Integer> findSubstring(String s, String[] words) {

       List<Integer> res = new ArrayList<Integer>();
       // Three corner case
       if(s == null || words == null ) return res;

       if(s.length() == 0 || words.length == 0) {
           res.add(0);
           return res;
       }

       int wordLen = words[0].length();
       int num = words.length;
       int windowSize = num * wordLen;
       if(s.length() < windowSize) return res;
       Map<String, Integer> map = new HashMap<String, Integer>();
       for(String word : words) {
           if(!map.containsKey(word)) {
               map.put(word, 0);
           }
           map.put(word, map.get(word) + 1);
       }

       // Keep a sliding window
       int i = 0;
       int j = 0;
       while(i <= s.length() - windowSize) {
           j = i;
           while(j <= i + windowSize - wordLen) {
               // Sliding j with wordLen;
               if(!map.containsKey(s.substring(j,j+wordLen)) || map.get(s.substring(j,j+wordLen)) == 0) {
                   break;
               } else {
                   map.put(s.substring(j,j+wordLen),map.get(s.substring(j,j+wordLen)) - 1);
                   j = j + wordLen;
                   if(j == i+ windowSize) {
                       res.add(i);
                   }
               }
           }

           // Reset the map
           for(String word : words) {
               if(!map.containsKey(word)) {
                   map.put(word, 0);
               }
               map.put(word, map.get(word) + 1);
           }
       }

       return res;
   }


   /* Sliding Window Solution O(wordLen * stringLen) */

   /*
    利用两点:
    1. 假如window里的word # equal dictions # 并且 window里word的出现次数 <= dictions里
    word的出现次数. 那么这个window就是解
    2. 起始位置需要0,1,...wordLen - 1. 因为 wordLen开始的会被 0 开始的sliding window cover
   */


   public List<Integer> findSubstring(String s, String[] words) {
       List<Integer> res = new ArrayList<Integer>();
       // Three corner case
       if(s == null || words == null ) return res;

       if(s.length() == 0 || words.length == 0) {
           res.add(0);
           return res;
       }

       int wordLen = words[0].length();
       int num = words.length;
       int windowSize = num * wordLen;
       int strLen = s.length();

       if(strLen< windowSize) return res;
       Map<String, Integer> map = new HashMap<String, Integer>();
       for(String word : words) {
           if(!map.containsKey(word)) {
               map.put(word, 0);
           }
           map.put(word, map.get(word) + 1);
       }

       // i = wordLen will be covered in the i=0 run,
       // Thus we only need to iterate wordLen time
       for(int i = 0; i < wordLen; i++) {

           // Do the typical sliding window start with i.
           int left = i;
           int right = i;
           int count = 0; // How many words in dict covered so far

           // Store the String -> # in current run.
           Map<String, Integer> window = new HashMap<String, Integer>();

           while(right <= strLen - wordLen) {
               String currWord = s.substring(right, right + wordLen);

               if(!map.containsKey(currWord)) {
                   left = right + wordLen;
                   right = left;
                   window.clear();
                   count = 0;
                   continue;
               }


               window.put(currWord, window.getOrDefault(currWord, 0) + 1);
               count++;

               // If larger than dicts.
               //Move the left pointer until currWord satisfy again
               while((left < right) && window.get(currWord) > map.get(currWord)) {
                   String leftString = s.substring(left, left + wordLen);
                   window.put(leftString, window.get(leftString) - 1);
                   // We could blindly reduce the count--
                   count--;
                   left = left + wordLen;
               }

               // If count equal num and all the window(word) <= map(word), then that must be equal
               if(count == num) {
                   res.add(left);
               }

               right = right + wordLen;
           }
       }
       return res;
