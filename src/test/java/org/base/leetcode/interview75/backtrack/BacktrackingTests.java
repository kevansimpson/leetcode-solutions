package org.base.leetcode.interview75.backtrack;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.base.leetcode.util.Helper.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BacktrackingTests {
    @Test
    public void testLetterCombinations() {
        LetterCombinations combos = new LetterCombinations();
        assertEquals(List.of("ad","ae","af","bd","be","bf","cd","ce","cf"),
                combos.letterCombinations("23"));
        assertEquals(Collections.emptyList(), combos.letterCombinations(""));
        assertEquals(List.of("a","b","c"), combos.letterCombinations("2"));
    }
}
