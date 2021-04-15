package detail;

public class Trie {
    Trie[] next;
    boolean isEnd;

    public Trie() {
        next = new Trie[26];
        isEnd = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie root = this;
        for (char c :
                word.toCharArray()) {
            if (root.next[c - 'a'] == null) {
                root.next[c - 'a'] = new Trie();
            }
            root = root.next[c - 'a'];
        }
        root.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie root = this;
        for (char c :
                word.toCharArray()) {
            if (root.next[c - 'a'] == null)
                return false;
            root = root.next[c - 'a'];
        }
        return root.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie root = this;
        for (char c :
                prefix.toCharArray()) {
            if (root.next[c - 'a'] == null) return false;
            root = root.next[c - 'c'];
        }
        return true;
    }
}
