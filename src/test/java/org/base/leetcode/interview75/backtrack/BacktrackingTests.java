package org.base.leetcode.interview75.backtrack;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.base.leetcode.util.Helper.toNestedIntList;
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

    @Test
    public void testCombinationSum3() {
        CombinationSum3 sum3 = new CombinationSum3();
        assertEquals(toNestedIntList("[[1,2,4]]"), sum3.combinationSum3(3, 7));
        assertEquals(toNestedIntList("[[1,2,6],[1,3,5],[2,3,4]]"), sum3.combinationSum3(3, 9));
        assertEquals(Collections.emptyList(), sum3.combinationSum3(4, 1));
        assertEquals(toNestedIntList("[[1,5,9],[1,6,8],[2,4,9],[2,5,8],[2,6,7],[3,4,8],[3,5,7],[4,5,6]]"),
                sum3.combinationSum3(3, 15));
    }
}
