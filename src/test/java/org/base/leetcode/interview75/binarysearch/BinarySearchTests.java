package org.base.leetcode.interview75.binarysearch;

import org.junit.jupiter.api.Test;

import static org.base.leetcode.util.Helper.toIntArray;
import static org.base.leetcode.util.TestCaseReader.readTestInput;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTests {
    @Test
    public void testSuccessfulPairs() {
        SuccessfulPairs pairs = new SuccessfulPairs();
        assertArrayEquals(toIntArray("[4,0,3]"), pairs.successfulPairs(
                toIntArray("[5,1,3]"), toIntArray("[1,2,3,4,5]"), 7));
        assertArrayEquals(toIntArray("[2,0,2]"), pairs.successfulPairs(
                toIntArray("[3,1,2]"), toIntArray("[8,5,8]"), 16));
        assertArrayEquals(
                toIntArray(readTestInput("/successfulPairs_testCase3_expected.txt")), pairs.successfulPairs(
                toIntArray(readTestInput("/successfulPairs_testCase3_spells.txt")),
                toIntArray(readTestInput("/successfulPairs_testCase3_potions.txt")),
                5433930978L));
    }

    @Test
    public void testFindPeakElement() {
        FindPeakElement find = new FindPeakElement();
        assertEquals(2, find.findPeakElement(toIntArray("[1,2,3,1]")));
        assertEquals(5, find.findPeakElement(toIntArray("[1,2,1,3,5,6,4]")));
    }

    @Test
    public void testKokoEatingBananas() {
        KokoEatingBananas koko = new KokoEatingBananas();
        assertEquals(4, koko.minEatingSpeed(toIntArray("[3,6,7,11]"), 8));
        assertEquals(30, koko.minEatingSpeed(toIntArray("[30,11,23,4,20]"), 5));
        assertEquals(23, koko.minEatingSpeed(toIntArray("[30,11,23,4,20]"), 6));
    }
}
