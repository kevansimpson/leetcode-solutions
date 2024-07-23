package org.base.leetcode.interview75.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;

/**
 * <a href="https://leetcode.com/problems/search-suggestions-system/description/?envType=study-plan-v2&envId=leetcode-75">
 *     1268. Search Suggestions System</a>
 * <p>
 *     Stats:
 *     Runtime:    26ms  (55.51%)
 *     Memory:  49.18mb  (29.74%)
 * </p>
 */
public class SearchSuggestions {
    private static class TrieNode {
        final TrieNode[] trie = new TrieNode[26];
        boolean wordEnd = false;
        final List<String> list = new ArrayList<>();
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        for (String p : products)
            insert(root, p);

        List<List<String>> suggestions = new ArrayList<>();
        TrieNode node = root;
        for (int i = 0; i < searchWord.length(); i++) {
            char ch = searchWord.charAt(i);
            if (node != null)
                node = node.trie[ch - 'a'];
            if (node != null) {
                Collections.sort(node.list);
                suggestions.add(node.list.subList(0, Math.min(3, node.list.size())));
            }
            else
                suggestions.add(emptyList());
        }

        return suggestions;
    }

    void insert(TrieNode node, String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode child = node.trie[ch - 'a'];
            if (child == null)
                node.trie[ch - 'a'] = (child = new TrieNode());
            node = child;
            node.list.add(word);
        }
        node.wordEnd = true;
    }
}
