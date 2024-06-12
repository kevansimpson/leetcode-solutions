package org.base.leetcode.interview75.graphs.bfs

import org.base.leetcode.util.Kelper.toNestedCharArray
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GraphBfsTests {
    @Test
    fun `should find nearest exit`() {
        val exit = NearestExit()
        assertEquals(1, exit.nearestExit(
            toNestedCharArray("[[\"+\",\"+\",\".\",\"+\"],[\".\",\".\",\".\",\"+\"],[\"+\",\"+\",\"+\",\".\"]]"),
            intArrayOf(1,2)))
        assertEquals(2, exit.nearestExit(
            toNestedCharArray("[[\"+\",\"+\",\"+\"],[\".\",\".\",\".\"],[\"+\",\"+\",\"+\"]]"),
            intArrayOf(1,0)))
        assertEquals(-1, exit.nearestExit(
            toNestedCharArray("[[\".\",\"+\"]]"),
            intArrayOf(0,0)))
        assertEquals(12, exit.nearestExit(
            toNestedCharArray("[[\"+\",\".\",\"+\",\"+\",\"+\",\"+\",\"+\"],[\"+\",\".\",\"+\",\".\",\".\",\".\",\"+\"],[\"+\",\".\",\"+\",\".\",\"+\",\".\",\"+\"],[\"+\",\".\",\".\",\".\",\"+\",\".\",\"+\"],[\"+\",\"+\",\"+\",\"+\",\"+\",\".\",\"+\"]]"),
            intArrayOf(0,1)))
    }
}