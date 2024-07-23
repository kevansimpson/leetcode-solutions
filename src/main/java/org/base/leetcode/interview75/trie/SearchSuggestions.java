package org.base.leetcode.interview75.trie;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

/**
 * <a href="https://leetcode.com/problems/search-suggestions-system/description/?envType=study-plan-v2&envId=leetcode-75">
 *     1268. Search Suggestions System</a>
 * <p>
 *     Stats:
 *     Runtime:   101ms  (18.46%)
 *     Memory:  51.48mb   (9.28%)
 * </p>
 */
public class SearchSuggestions {
    private static class TrieNode {
        final TrieNode[] trie = new TrieNode[26];
        boolean wordEnd = false;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        for (String p : products)
            insert(root, p);

        List<List<String>> suggestions = new ArrayList<>();
        TrieNode node = root;
        String query = "";
        for (int i = 0; i < searchWord.length(); i++) {
            char ch = searchWord.charAt(i);
            query += ch;
            if (node != null) {
                node = node.trie[ch - 'a'];
                List<String> words = new ArrayList<>();
                suggest(query, node, words);
                suggestions.add(words);
            }
            else
                suggestions.add(emptyList());
        }

        return suggestions;
    }

    void suggest(String query, TrieNode node, List<String> words) {
        if (words.size() < 3 && node != null) {
            if (node.wordEnd)
                words.add(query);

            for (int i = 0; i < 26; i++) {
                TrieNode child = node.trie[i];
                if (child != null) {
                    suggest(query + (char) ('a' + i), child, words);
                }
            }
        }
    }

    public void insert(TrieNode node, String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode child = node.trie[ch - 'a'];
            if (child == null)
                node.trie[ch - 'a'] = (child = new TrieNode());
            node = child;
        }
        node.wordEnd = true;
    }
}
