package org.base.leetkode.util

import org.base.leetkode.util.Kelper.toCharArray
import org.base.leetkode.util.Kelper.toNestedCharArray
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