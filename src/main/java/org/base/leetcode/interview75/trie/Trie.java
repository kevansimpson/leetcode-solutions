package org.base.leetcode.interview75.trie;

/**
 * <a href="https://leetcode.com/problems/implement-trie-prefix-tree/description/?envType=study-plan-v2&envId=leetcode-75">
 *     208. Implement Trie (Prefix Tree)</a>
 * <p>
 *     Stats:
 *     Runtime:    30ms  (99.74%)
 *     Memory:  55.21mb  (45.41%)
 * </p>
 */
public class Trie {
    private final Trie[] trie = new Trie[26];
    private boolean wordEnd = false;

    public Trie() {

    }

    public void insert(String word) {
        Trie node = this;
        for (char ch : word.toCharArray()) {
            Trie child = node.trie[ch - 'a'];
            if (child == null)
                node.trie[ch - 'a'] = (child = new Trie());
            node = child;
        }
        node.wordEnd = true;
    }

    public boolean search(String word) {
        Trie node = this;
        for (char ch : word.toCharArray()) {
            Trie child = node.trie[ch - 'a'];
            if (child == null)
                return false;
            node = child;
        }
        return node.wordEnd;
    }

    public boolean startsWith(String prefix) {
        Trie node = this;
        for (char ch : prefix.toCharArray()) {
            Trie child = node.trie[ch - 'a'];
            if (child == null)
                return false;
            node = child;
        }
        return true;
    }
}
