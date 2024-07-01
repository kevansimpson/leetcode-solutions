package org.base.miskellaneous

/**
 * From <a href="https://youtu.be/oBt53YbR9Kk?si=uoP-GovsHC9KtBwZ">
 *     Dynamic Programming - Learn to Solve Algorithmic Problems & Coding Challenges</a>
 */
object DynamicProgramingFCC {
    fun fibMemo(n: Int, map: MutableMap<Int, Long>? = mutableMapOf(1 to 1, 2 to 1)): Long =
        if (map!!.containsKey(n))
            map[n]!!
        else {
            val n1 = fibMemo(n - 1, map) + fibMemo(n - 2, map)
            map[n] = n1
            n1
        }

    fun fibTab(n: Int): Long {
        val array = LongArray(n + 3) { 0 }
        array[1] = 1
        for (i in 0..n) {
            array[i + 1] += array[i]
            array[i + 2] += array[i]
        }
        return array[n]
    }

    // same as fibonacci except the tree is length*width dimensions of the grid
    fun gridTravelerMemo(m: Int, n: Int, map: MutableMap<Pair<Int, Int>, Long>? = mutableMapOf(1 to 1 to 1)): Long =
        when {
            m == 0 || n == 0 -> 0
            map!!.containsKey(m to n) -> map[m to n]!!
            else -> {
                val routes = gridTravelerMemo(m - 1, n, map) + gridTravelerMemo(m, n - 1, map)
                map[m to n] = routes
                routes
            }
        }

    fun gridTravelerTab(m: Int, n: Int): Long {
        val table = Array(m + 2) { LongArray(n + 2) { 0 } }
        table[1][1] = 1
        for (row in 0..m)
            for (col in 0..n) {
                val here = table[row][col]
                table[row][col + 1] += here
                table[row + 1][col] += here
            }
        return table[m][n]
    }

    fun canSumMemo(n: Int, array: IntArray, map: MutableMap<Int, Boolean>? = mutableMapOf(0 to false)): Boolean =
        when {
            map!!.contains(n) -> map[n]!!
            n == 0 -> true
            n < 1 -> false
            array.contains(n) -> true
            else -> {
                var can = false
                for (i in array)
                    if (canSumMemo(n - i, array, map)) {
                        can = true
                        break
                    }
                map[n] = can
                can
            }
        }

    fun canSumTab(n: Int, array: IntArray): Boolean {
        val table = BooleanArray(n + 1) { false }
        table[0] = true
        for (i in 0..n)
            if (table[i])
                for (num in array)
                    if (i + num <= n)
                        table[i + num] = true

        return table[n]
    }

    fun howSumMemo(n: Int,
                   array: IntArray,
                   map: MutableMap<Int, MutableList<Int>?>? = mutableMapOf()): MutableList<Int>? =
        when {
            map!!.containsKey(n) -> map[n]
            n == 0 -> mutableListOf()
            n < 0 -> null
            else -> {
                var result: MutableList<Int>? = null
                for (i in array) {
                    val list = howSumMemo(n - i, array, map)
                    if (list != null) {
                        list.add(i)
                        if (result == null || list.size < result.size)
                            result = list
                    }
                }
                map[n] = result
                result
            }
        }

    fun howSumTab(n: Int, array: IntArray): MutableList<Int>? {
        val table: Array<MutableList<Int>?> = Array(n + 1) { null }
        table[0] = mutableListOf()
        for (i in 0..n)
            table[i]?.let {
                for (num in array)
                    if (num + i <= n)
                        table[num + i] = it.toMutableList().apply { add(num) }
            }
        return table[n]
    }
}