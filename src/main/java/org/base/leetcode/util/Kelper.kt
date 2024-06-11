package org.base.leetcode.util

object Kelper {
    private val bracketSplit = "],\\[".toRegex()
    private val commaSplit = ",\\s?".toRegex()

    fun toCharArray(str: String): CharArray {
        val sub = if (str.startsWith("[")) str.substring(1, str.length - 1) else str
        return sub.replace("\"", "").split(commaSplit).map { s -> s[0] }.toCharArray()
    }

    fun toNestedCharArray(str: String): Array<CharArray> {
        val sub = str.subSequence(2, str.length - 2)
        val arr = sub.split(bracketSplit)
        val matrix: MutableList<CharArray> = mutableListOf()
        for (i in arr.indices)
            matrix.add(if (arr[i].isBlank()) charArrayOf() else toCharArray(arr[i]))

        return matrix.toTypedArray()
    }
}