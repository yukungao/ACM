/* http://www.lintcode.com/en/problem/add-and-search-word/# */
/* This is a trie implementation problem */
class TrieNode {
    public boolean finish;
    public Map<Character, TrieNode> children;

    // Initialize your data structure here.
    public TrieNode() {
        finish = false;
        children = new HashMap<Character, TrieNode>();
    }
}


public class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
        TrieNode now = root;
        for(int i = 0; i < word.length(); i++ ){
            Character nowChar = word.charAt(i);
            if(! now.children.containsKey(nowChar) ) {
                now.children.put(nowChar, new TrieNode());
            }
            now = now.children.get(nowChar);
        }
        now.finish = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    // The iterative way hard to implement '.' wild card, so change to
    // recursive way.
    public boolean search(String word) {
        // Write your code here
        return find(word, 0, root);
    }

    private boolean find(String word, int index, TrieNode now) {
        if(index == word.length()) {
            return now.finish;
        }

        Character nowChar = word.charAt(index);

        if( now.children.containsKey(nowChar)) {
            return find(word, index+1, now.children.get(nowChar));
        } else if(nowChar == '.') {
            boolean result = false;
            for(Map.Entry<Character, TrieNode> child : now.children.entrySet()) {
                if(index == word.length()-1 && child.getValue().finish){
                    return true;
                }

                //if any path is true, set result to be true;
                if(find(word, index+1, child.getValue()) ){
                    result = true;
                }
            }
            return result;
        } else
            return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
