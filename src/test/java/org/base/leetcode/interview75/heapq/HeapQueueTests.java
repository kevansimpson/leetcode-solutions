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
}
