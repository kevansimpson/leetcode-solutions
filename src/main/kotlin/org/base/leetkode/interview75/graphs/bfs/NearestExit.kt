package org.base.leetkode.interview75.graphs.bfs

/**
 * <a href="https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/submissions/1286458990/?envType=study-plan-v2&envId=leetcode-75">
 *     1926. Nearest Exit from Entrance in Maze</a>
 * <p>
 *     Stats:
 *     Runtime:  289ms (90.41%)
 *     Memory: 45.85mb (93.15%)
 * </p>
 */
class NearestExit {
    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        val paths = mutableListOf(entrance[0] to entrance[1])
        var steps = -1
        val m = maze.size
        val n = maze[0].size

        while (paths.isNotEmpty()) {
            steps++
            val next = paths.toList().also { paths.clear() }
            for (point in next) {
                val x = point.second
                val y = point.first
                if (x == 0 || x >= n - 1 || y == 0 || y >= m - 1)
                    if (!(y == entrance[0] && x == entrance[1]))
                        return steps

                for (xy in 0..3) {
                    val dx = x + moveX[xy]
                    val dy = y + moveY[xy]
                    if (dx in 0..<n && dy >= 0 && dy < m && '.' == maze[dy][dx]) {
                        paths.add(dy to dx)
                        maze[dy][dx] = 'v'
                    }
                }
            }
        }

        return -1
    }

    companion object {
        private val moveX = intArrayOf(0, 1, 0, -1)
        private val moveY = intArrayOf(1, 0, -1, 0)
    }
}