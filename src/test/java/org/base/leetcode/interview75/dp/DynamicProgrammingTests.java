package org.base.leetcode.interview75.dp;

import org.base.leetcode.interview75.dp.multid.LongestCommonSubsequence;
import org.base.leetcode.interview75.dp.multid.MaxProfit;
import org.base.leetcode.interview75.dp.multid.UniquePaths;
import org.base.leetcode.interview75.dp.oned.DominoTiling;
import org.base.leetcode.interview75.dp.oned.HouseRobber;
import org.base.leetcode.interview75.dp.oned.MinCostClimbingStairs;
import org.base.leetcode.interview75.dp.oned.Tribonacci;
import org.junit.jupiter.api.Test;

import static org.base.leetcode.util.Helper.toIntArray;
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


    @Test
    public void testHouseRobber() {
        HouseRobber robber = new HouseRobber();
        assertEquals(4, robber.rob(toIntArray("[1,2,3,1]")));
        assertEquals(12, robber.rob(toIntArray("[2,7,9,3,1]")));
        assertEquals(1, robber.rob(toIntArray("[1,1]")));
        assertEquals(4, robber.rob(toIntArray("[2,1,1,2]")));
    }

    @Test
    public void testDominoTiling() {
        DominoTiling tiling = new DominoTiling();
        assertEquals(5, tiling.numTilings(3));
        assertEquals(1, tiling.numTilings(1));
        assertEquals(11, tiling.numTilings(4));
        assertEquals(24, tiling.numTilings(5));
        assertEquals(882347204, tiling.numTilings(60));
    }

    @Test
    public void testUniquePaths() {
        UniquePaths paths = new UniquePaths();
        assertEquals(28, paths.uniquePaths(3, 7));
        assertEquals(3, paths.uniquePaths(3, 2));
    }

    @Test
    public void testLongestCommonSubsequence() {
        LongestCommonSubsequence longest = new LongestCommonSubsequence();
        assertEquals(3, longest.longestCommonSubsequence("abcde", "ace"));
        assertEquals(3, longest.longestCommonSubsequence("abc", "abc"));
        assertEquals(0, longest.longestCommonSubsequence("abc", "def"));
    }

    @Test
    public void testMaxProfit() {
        MaxProfit maxProfit = new MaxProfit();
        assertEquals(8, maxProfit.maxProfit(toIntArray("[1,3,2,8,4,9]"), 2));
        assertEquals(6, maxProfit.maxProfit(toIntArray("[1,3,7,5,10,3]"), 3));
    }
}
