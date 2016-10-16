/* https://leetcode.com/problems/word-pattern/ */
/*
这个题的精髓在于, 如何维护一个 1->1 的relationship
//How to maintain a->b is 1:1 relationship, if a is not seen before but b is seen, then false
// else put (a->b) (b->a). If a is seen before but  a!->b, then false;
*/
public boolean wordPattern(String pattern, String str) {
        if(pattern == null && str == null) return true;
        if(pattern.length() == 0 && str.length() == 0) return true;
        if(pattern == null || pattern.length() == 0 || str == null || str.length() == 0) return false;


        String[] words = str.split("\\s+");
        if(words.length != pattern.length()) return false;
        Map<String, Character> map = new HashMap<String, Character>();
        Map<Character, String> invermap = new HashMap<Character, String>();

        for(int i = 0; i < words.length; i++) {

            if(!map.containsKey(words[i])) {
                if(invermap.containsKey(pattern.charAt(i))) {
                    return false;
                }
                map.put(words[i] , pattern.charAt(i));
                invermap.put(pattern.charAt(i), words[i]);
            } else {
                if(!map.get(words[i]).equals(pattern.charAt(i))) {
                    return false;
                }
            }
        }

        return true;
    }
