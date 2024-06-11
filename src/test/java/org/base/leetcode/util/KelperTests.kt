package org.base.leetcode.util

import org.base.leetcode.util.Kelper.toCharArray
import org.base.leetcode.util.Kelper.toNestedCharArray
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class KelperTests {
    @Test
    fun `should parse char array with quotes`() {
        assertArrayEquals(charArrayOf('+','+','.','+'), toCharArray("[\"+\",\"+\",\".\",\"+\"]"))
    }

    @Test
    fun `should parse nested char array with quotes`() {
        assertArrayEquals(arrayOf(
            charArrayOf('+','+','.','+'), charArrayOf('.','.','.','+'), charArrayOf('+','+','+','.')),
            toNestedCharArray("[[\"+\",\"+\",\".\",\"+\"],[\".\",\".\",\".\",\"+\"],[\"+\",\"+\",\"+\",\".\"]]"))
    }
}