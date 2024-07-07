package org.base.leetcode.interview75.dp.oned;

import org.base.leetcode.interview75.backtrack.CombinationSum3;
import org.base.leetcode.interview75.backtrack.LetterCombinations;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.base.leetcode.util.Helper.toIntArray;
import static org.base.leetcode.util.Helper.toNestedIntList;
import static org.base.leetcode.util.TestCaseReader.readTestInput;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicProgrammingTests {
    @Test
    public void testTribonacci() {
        Tribonacci tribonacci = new Tribonacci();
        assertEquals(4, tribonacci.tribonacci(4));
        assertEquals(1389537, tribonacci.tribonacci(25));
    }

    @Test
    public void testMinCostClimbingStairs() {
        MinCostClimbingStairs minCost = new MinCostClimbingStairs();
        assertEquals(15, minCost.minCostClimbingStairs(toIntArray(
                "[10,15,20]")));
        assertEquals(6, minCost.minCostClimbingStairs(toIntArray(
                "[1,100,1,1,1,100,1,1,100,1]")));
        assertEquals(2, minCost.minCostClimbingStairs(toIntArray(
                "[0,1,2,2]")));
        assertEquals(209040, minCost.minCostClimbingStairs(toIntArray(readTestInput(
                "/minCostClimbingStairs_testCase4_input.txt"))));
    }
}
