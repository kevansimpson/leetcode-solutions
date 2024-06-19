package org.base.hakkerrank

import org.base.hakkerrank.CaesarCipher.caesarCipher
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class HakkerTests {
    @Test
    fun testCaesarCipher() {
        assertEquals("okffng-Qwvb", caesarCipher("middle-Outz", 2))
    }
}