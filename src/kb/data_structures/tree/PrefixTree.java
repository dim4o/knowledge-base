package kb.data_structures.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Prefix tree (Trie) implementation. Provides a fast search of word by prefix. 
 * @author dimcho.nedev
 */
public class PrefixTree {
    final class Node {
        final Map<Character, Node> map = new HashMap<>();
        boolean isEnd = false;
    }

    final Node root;

    public PrefixTree() {
        this.root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            curr.map.computeIfAbsent(ch, k -> new Node());
            curr = curr.map.get(ch);
            if (i == word.length() - 1)
                curr.isEnd = true;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return find(word, false);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return find(prefix, true);
    }

    private boolean find(String str, boolean isPrefix) {
        Node curr = root;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!curr.map.containsKey(ch))
                return false;
            curr = curr.map.get(ch);
        }
        return isPrefix ? true : curr.isEnd;
    }
}
