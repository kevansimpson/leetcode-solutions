package org.base.leetcode.interview75.dp.oned;

import org.base.leetcode.interview75.backtrack.CombinationSum3;
import org.base.leetcode.interview75.backtrack.LetterCombinations;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.base.leetcode.util.Helper.toNestedIntList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicProgrammingTests {
    @Test
    public void testTribonacci() {
        Tribonacci tribonacci = new Tribonacci();
        assertEquals(4, tribonacci.tribonacci(4));
        assertEquals(1389537, tribonacci.tribonacci(25));
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
