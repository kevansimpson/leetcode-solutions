package org.base.leetcode.interview75.bit;

import org.base.leetcode.interview75.backtrack.CombinationSum3;
import org.base.leetcode.interview75.backtrack.LetterCombinations;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.base.leetcode.util.Helper.toNestedIntList;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitManipulationTests {
    @Test
    public void testCountingBits() {
        CountingBits bits = new CountingBits();
        assertArrayEquals(new int[] {0,1,1}, bits.countBits(2));
        assertArrayEquals(new int[] {0,1,1,2,1,2}, bits.countBits(5));
    }
}
