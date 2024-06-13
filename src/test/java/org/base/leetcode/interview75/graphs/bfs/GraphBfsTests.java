package org.base.leetcode.interview75.graphs.bfs;

import org.junit.jupiter.api.Test;

import static org.base.leetcode.util.Helper.toNestedCharArray;
import static org.base.leetcode.util.Helper.toNestedIntArray;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphBfsTests {
    @Test
    public void testNearestExit() {
        NearestExit exit = new NearestExit();
        assertEquals(1, exit.nearestExit(
                toNestedCharArray("[[\"+\",\"+\",\".\",\"+\"],[\".\",\".\",\".\",\"+\"],[\"+\",\"+\",\"+\",\".\"]]"),
                new int[] {1,2}));
        assertEquals(2, exit.nearestExit(
                toNestedCharArray("[[\"+\",\"+\",\"+\"],[\".\",\".\",\".\"],[\"+\",\"+\",\"+\"]]"),
                new int[] {1,0}));
        assertEquals(-1, exit.nearestExit(
                toNestedCharArray("[[\".\",\"+\"]]"),
                new int[] {0,0}));
        assertEquals(12, exit.nearestExit(
                toNestedCharArray("[[\"+\",\".\",\"+\",\"+\",\"+\",\"+\",\"+\"],[\"+\",\".\",\"+\",\".\",\".\",\".\",\"+\"],[\"+\",\".\",\"+\",\".\",\"+\",\".\",\"+\"],[\"+\",\".\",\".\",\".\",\"+\",\".\",\"+\"],[\"+\",\"+\",\"+\",\"+\",\"+\",\".\",\"+\"]]"),
                new int[] {0,1}));
    }

    @Test
    public void testRottingOranges() {
        RottingOranges rotting = new RottingOranges();
        assertEquals(4, rotting.orangesRotting(
                toNestedIntArray("[[2,1,1],[1,1,0],[0,1,1]]")));
        assertEquals(-1, rotting.orangesRotting(
                toNestedIntArray("[[2,1,1],[0,1,1],[1,0,1]]")));
        assertEquals(0, rotting.orangesRotting(
                toNestedIntArray("[[0,2]]")));
    }
}
