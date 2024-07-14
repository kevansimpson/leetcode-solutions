package org.base.leetcode.interview75.bit;

import org.junit.jupiter.api.Test;

import static org.base.leetcode.util.Helper.toIntArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitManipulationTests {
    @Test
    public void testCountingBits() {
        CountingBits bits = new CountingBits();
        assertArrayEquals(new int[] {0,1,1}, bits.countBits(2));
        assertArrayEquals(new int[] {0,1,1,2,1,2}, bits.countBits(5));
    }

    @Test
    public void testSingleNumber() {
        SingleNumber single = new SingleNumber();
        assertEquals(1, single.singleNumber(toIntArray("[2,2,1]")));
        assertEquals(4, single.singleNumber(toIntArray("[4,1,2,1,2]")));
        assertEquals(1, single.singleNumber(toIntArray("[1]")));
        assertEquals(-1, single.singleNumber(toIntArray("[-1]")));
    }

    @Test
    public void testMinimumFlips() {
        MinimumFlips flips = new MinimumFlips();
        assertEquals(3, flips.minFlips(2, 6, 5));
        assertEquals(1, flips.minFlips(4, 2, 7));
        assertEquals(0, flips.minFlips(1, 2, 3));
        assertEquals(3, flips.minFlips(8, 3, 5));
    }
}
