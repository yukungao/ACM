/* http://www.lintcode.com/en/problem/implement-trie/ */
/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
 
class TrieNode {
    public boolean finish;
    public Map<Character, TrieNode> children;

    // Initialize your data structure here.
    public TrieNode() {
        finish = false;
        children = new HashMap<Character, TrieNode>();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
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

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode now = root;
        for(int i = 0; i < word.length(); i++) {
            Character nowChar = word.charAt(i);
            if(! now.children.containsKey(nowChar)) return false;
            now = now.children.get(nowChar);
        }
        return now.finish;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode now = root;
        for(int i = 0; i < prefix.length(); i++) {
            Character nowChar = prefix.charAt(i);
            if(! now.children.containsKey(nowChar)) return false;
            now = now.children.get(nowChar);
        }
        return true;


    }
}
