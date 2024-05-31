package org.base.leetcode.util;

import org.junit.jupiter.api.Test;

import static org.base.leetcode.util.Helper.toIntArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HelperTests {
    @Test
    public void testToIntArray() {
        assertArrayEquals(new int[] {1,2,3}, toIntArray("[1, 2, 3]"));
    }
}
