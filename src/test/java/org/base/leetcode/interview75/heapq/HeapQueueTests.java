package org.base.leetcode.interview75.heapq;

import org.junit.jupiter.api.Test;

import static org.base.leetcode.util.Helper.toIntArray;
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
    }
}
