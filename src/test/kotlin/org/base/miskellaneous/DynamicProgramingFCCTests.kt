package org.base.miskellaneous

import org.base.miskellaneous.DynamicProgramingFCC.canSumMemo
import org.base.miskellaneous.DynamicProgramingFCC.canSumTab
import org.base.miskellaneous.DynamicProgramingFCC.fibMemo
import org.base.miskellaneous.DynamicProgramingFCC.fibTab
import org.base.miskellaneous.DynamicProgramingFCC.gridTravelerMemo
import org.base.miskellaneous.DynamicProgramingFCC.gridTravelerTab
import org.base.miskellaneous.DynamicProgramingFCC.howSumMemo
import org.base.miskellaneous.DynamicProgramingFCC.howSumTab
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class DynamicProgramingFCCTests {

    @Test
    fun testFibMemo() {
        assertEquals(13, fibMemo(7))
        assertEquals(12586269025, fibMemo(50))
    }

    @Test
    fun testFibTabulation() {
        assertEquals(13, fibTab(7))
        assertEquals(12586269025, fibTab(50))
    }

    @Test
    fun testGridTravelerMemo() {
        assertEquals(1, gridTravelerMemo(1, 1))
        assertEquals(3, gridTravelerMemo(2, 3))
        assertEquals(3, gridTravelerMemo(3, 2))
        assertEquals(6, gridTravelerMemo(3, 3))
        assertEquals(2333606220, gridTravelerMemo(18, 18))
    }

    @Test
    fun testGridTravelerTabulation() {
        assertEquals(1, gridTravelerTab(1, 1))
        assertEquals(3, gridTravelerTab(2, 3))
        assertEquals(3, gridTravelerTab(3, 2))
        assertEquals(6, gridTravelerTab(3, 3))
        assertEquals(2333606220, gridTravelerTab(18, 18))
    }

    @Test
    fun testCanSum() {
        assertFalse(canSumMemo(7, intArrayOf(2, 4)))
        assertTrue(canSumMemo(7, intArrayOf(2, 3)))
        assertTrue(canSumMemo(7, intArrayOf(5, 3, 4, 7)))
        assertTrue(canSumMemo(8, intArrayOf(2, 3, 5)))
        assertFalse(canSumMemo(300, intArrayOf(7, 14)))
    }


    @Test
    fun testCanSumTabulation() {
        assertFalse(canSumTab(7, intArrayOf(2, 4)))
        assertTrue(canSumTab(7, intArrayOf(2, 3)))
        assertTrue(canSumTab(7, intArrayOf(5, 3, 4, 7)))
        assertTrue(canSumTab(8, intArrayOf(2, 3, 5)))
        assertFalse(canSumTab(300, intArrayOf(7, 14)))
    }

    @Test
    fun testHowSumMemo() {
        assertEquals(mutableListOf(3, 2, 2), howSumMemo(7, intArrayOf(2, 3)))
        assertEquals(mutableListOf(7), howSumMemo(7, intArrayOf(5, 3, 4, 7)))
        assertNull(howSumMemo(7, intArrayOf(2, 4)))
        assertEquals(mutableListOf(5, 3), howSumMemo(8, intArrayOf(2, 3, 5)))
        assertNull(howSumMemo(300, intArrayOf(7, 14)))
    }

    @Test
    fun testHowSumTabulation() {
        assertEquals(mutableListOf(3, 2, 2), howSumTab(7, intArrayOf(2, 3)))
        assertEquals(mutableListOf(4, 3), howSumTab(7, intArrayOf(5, 3, 4, 7)))
        assertNull(howSumTab(7, intArrayOf(2, 4)))
        assertEquals(mutableListOf(2, 2, 2, 2), howSumTab(8, intArrayOf(2, 3, 5)))
        assertNull(howSumTab(300, intArrayOf(7, 14)))
    }
}