package search;

public class Trie {
    Trie[] child;
    boolean isEnd;
    public Trie() {
        child = new Trie[26];
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie root = this;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (root.child[idx] == null)
                root.child[idx] = new Trie();
            root = root.child[idx];
        }
        root.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie root = this;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (root.child[idx] == null)
                return false;
            root = root.child[idx];
        }
        return root.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie root = this;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (root.child[idx] == null)
                return false;
            root = root.child[idx];
        }
        return true;
    }
}
