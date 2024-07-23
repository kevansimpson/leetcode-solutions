package org.base.leetcode.interview75.trie;

import org.junit.jupiter.api.Test;

import static org.base.leetcode.util.Helper.toArray;
import static org.base.leetcode.util.Helper.toNestedList;
import static org.junit.jupiter.api.Assertions.*;

public class TrieTests {
    @Test
    public void testPrefixTree() {
        Trie trie = new Trie();
        trie.insert("apple");
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("app"));
        assertTrue(trie.startsWith("app"));
        trie.insert("app");
        assertTrue(trie.search("app"));
    }

    @Test
    public void testSearchSuggestions() {
        SearchSuggestions search = new SearchSuggestions();
        assertEquals(toNestedList("[[\"mobile\",\"moneypot\",\"monitor\"],[\"mobile\",\"moneypot\",\"monitor\"],[\"mouse\",\"mousepad\"],[\"mouse\",\"mousepad\"],[\"mouse\",\"mousepad\"]]"),
                search.suggestedProducts(toArray("[mobile,mouse,moneypot,monitor,mousepad]"), "mouse"));
        assertEquals(toNestedList("[[\"havana\"],[\"havana\"],[\"havana\"],[\"havana\"],[\"havana\"],[\"havana\"]]"),
                search.suggestedProducts(toArray("[havana]"), "havana"));
        assertEquals(toNestedList("[[],[],[],[],[],[],[]]"),
                search.suggestedProducts(toArray("[havana]"), "tatiana"));
    }
}
