package org.base.hakkerrank

/**
 * <a href="https://www.hackerrank.com/challenges/one-week-preparation-kit-caesar-cipher-1/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-three">
 *     Julius Caesar protected his confidential information by encrypting it
 *     using a cipher. Caesar's cipher shifts each letter by a number of letters.
 *     If the shift takes you past the end of the alphabet, just rotate back to
 *     the front of the alphabet. In the case of a rotation by 3, w, x, y and z
 *     would map to z, a, b and c.</a>
 */
object CaesarCipher {
    private const val lowerA = 'a'.code
    private val a2z = 'a'..'z'
    private val lowerCase = a2z.toList().toTypedArray()

    private const val upperA = 'A'.code
    private val A2Z = 'A'..'Z'
    private val upperCase = A2Z.toList().toTypedArray()

    fun caesarCipher(s: String, k: Int): String =
        s.map {
            if (a2z.contains(it)) {
                lowerCase[((it.code - lowerA + k) % 26)]
            }
            else if (A2Z.contains(it)) {
                upperCase[((it.code - upperA + k) % 26)]
            }
            else it
        }.joinToString("")
}