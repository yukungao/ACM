/* https://leetcode.com/problems/word-pattern-ii/ */

/*
无他, 唯 backtracking 尔
*/

public boolean wordPatternMatch(String pattern, String str) {
    if(pattern == null && str == null) return true;
    if(pattern.length() == 0 && str.length() == 0) return true;
    if(pattern == null || pattern.length() == 0 || str == null || str.length() == 0) return false;
    Map<String, Character> word2char = new HashMap<String, Character>();
    Map<Character, String> char2word = new HashMap<Character, String>();
    return backTracking(pattern, str, word2char, char2word, 0, 0);
}


private boolean backTracking(String pattern, String str, Map<String, Character> word2char, Map<Character, String> char2word, int pat_index, int str_index) {

    if((pat_index == pattern.length()) && (str_index != str.length())) return false;
    if((pat_index != pattern.length()) && (str_index == str.length())) return false;
    if((pat_index == pattern.length()) && (str_index == str.length())) return true;

    char pat_char = pattern.charAt(pat_index);

    if(char2word.containsKey(pat_char)) {
        String exp = char2word.get(pat_char);
        if(str_index + exp.length() > str.length() || !exp.equals(str.substring(str_index, str_index + exp.length()))) {
            return false;
        } else {
            return backTracking(pattern, str, word2char, char2word, pat_index + 1, str_index + exp.length());
        }
    } else {
        // Do the backtracking
        for(int i = str_index + 1; i <= str.length(); i++) {
            String candidate = str.substring(str_index, i);
            if(word2char.containsKey(candidate)) continue;
            word2char.put(candidate, pat_char);
            char2word.put(pat_char, candidate);
            if(backTracking(pattern, str, word2char, char2word, pat_index + 1,i)) {
                return true;
            }
            word2char.remove(candidate);
            char2word.remove(pat_char);
        }
    }

    return false;
}
