package org.base.leetcode.interview75.heapq;

import org.junit.jupiter.api.Test;

import static org.base.leetcode.util.Helper.toIntArray;
import static org.base.leetcode.util.TestCaseReader.readTestInput;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeapQueueTests {
    @Test
    public void testLargestArrayElement() {
        LargestArrayElement lae = new LargestArrayElement();
        assertEquals(5, lae.findKthLargest(toIntArray("[3,2,1,5,6,4]"), 2));
        assertEquals(4, lae.findKthLargest(toIntArray("[3,2,3,1,2,4,5,5,6]"), 4));
    }

    @Test
    public void testSmallestInfiniteSet() {
        SmallestInfiniteSet set = new SmallestInfiniteSet();
        set.addBack(2);    // 2 is already in the set, so no change is made.
        // return 1, since 1 is the smallest number, and remove it from the set.
        assertEquals(1, set.popSmallest());
        // return 2, and remove it from the set.
        assertEquals(2, set.popSmallest());
        // return 3, and remove it from the set.
        assertEquals(3, set.popSmallest());
        set.addBack(1);    // 1 is added back to the set.
        // return 1, since 1 was added back to the set and
        // is the smallest number, and remove it from the set.
        assertEquals(1, set.popSmallest());
        // return 4, and remove it from the set.
        assertEquals(4, set.popSmallest());
        // return 5, and remove it from the set.
        assertEquals(5, set.popSmallest());
    }

    @Test
    public void testMaxSubsequenceScore() {
        MaxSubsequenceScore score = new MaxSubsequenceScore();
        assertEquals(12, score.maxScore(
                toIntArray("[1,3,3,2]"), toIntArray("[2,1,3,4]"), 3));
        assertEquals(30, score.maxScore(
                toIntArray("[4,2,3,1,1]"), toIntArray("[7,5,10,9,6]"), 1));
        assertEquals(168, score.maxScore(
                toIntArray("[2,1,14,12]"), toIntArray("[11,7,13,6]"), 3));
        assertEquals(29997900036L, score.maxScore(
                toIntArray(readTestInput("/maxSubsequenceScore_testCase4_part1.txt")),
                toIntArray(readTestInput("/maxSubsequenceScore_testCase4_part1.txt")),
                3));
    }

    @Test
    public void testTotalCostWorkers() {
        TotalCostWorkers cost = new TotalCostWorkers();
        assertEquals(11, cost.totalCost(toIntArray("[17,12,10,2,7,2,11,20,8]"), 3, 4));
        assertEquals(4, cost.totalCost(toIntArray("[1,2,4,1]"), 3, 3));
        assertEquals(423, cost.totalCost(toIntArray(
                "[31,25,72,79,74,65,84,91,18,59,27,9,81,33,17,58]"), 11, 2));
        assertEquals(223, cost.totalCost(toIntArray(
                "[18,64,12,21,21,78,36,58,88,58,99,26,92,91,53,10,24,25,20,92,73,63,51,65,87,6,17,32,14,42,46,65,43,9,75]"),
                13, 23));
        assertEquals(526, cost.totalCost(toIntArray(
                "[57,33,26,76,14,67,24,90,72,37,30]"), 11, 2));
    }
}
