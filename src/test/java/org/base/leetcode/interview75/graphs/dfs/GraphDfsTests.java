package org.base.leetcode.interview75.graphs.dfs;

import org.junit.jupiter.api.Test;

import static org.base.leetcode.util.Helper.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GraphDfsTests {
    @Test
    public void testKeysAndRooms() {
        KeysAndRooms keys = new KeysAndRooms();
        assertTrue(keys.canVisitAllRooms(toNestedIntList("[[1],[2],[3],[]]")));
        assertFalse(keys.canVisitAllRooms(toNestedIntList("[[1,3],[3,0,1],[2],[0]]")));
        assertFalse(keys.canVisitAllRooms(toNestedIntList("[[1],[2],[],[3]]")));
        assertTrue(keys.canVisitAllRooms(toNestedIntList("[[2],[],[1]]")));
        assertTrue(keys.canVisitAllRooms(toNestedIntList(
                "[[6,7,8],[5,4,9],[],[8],[4],[],[1,9,2,3],[7],[6,5],[2,3,1]]")));
    }

    @Test
    public void testNumberOfProvinces() {
        NumberOfProvinces provinces = new NumberOfProvinces();
        assertEquals(2, provinces.findCircleNum(toNestedIntArray("[[1,1,0],[1,1,0],[0,0,1]]")));
        assertEquals(3, provinces.findCircleNum(toNestedIntArray("[[1,0,0],[0,1,0],[0,0,1]]")));
        assertEquals(3, provinces.findCircleNum(toNestedIntArray(
                "[[1,1,0,0,0,0],[1,1,0,1,0,0],[0,0,1,0,0,0],[0,1,0,1,0,0],[0,0,0,0,1,1],[0,0,0,0,1,1]]")));
        assertEquals(1, provinces.findCircleNum(toNestedIntArray(
                "[[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]")));
    }

    @Test
    public void testReorderRoutes() {
        ReorderRoutes reorderRoutes = new ReorderRoutes();
        assertEquals(3, reorderRoutes.minReorder(6, toNestedIntArray(
                "[[0,1],[1,3],[2,3],[4,0],[4,5]]")));
        assertEquals(2, reorderRoutes.minReorder(5, toNestedIntArray(
                "[[1,0],[1,2],[3,2],[3,4]]")));
        assertEquals(0, reorderRoutes.minReorder(3, toNestedIntArray(
                "[[1,0],[2,0]]")));
    }

    @Test
    public void testEvaluateDivision() {
        EvaluateDivision division = new EvaluateDivision();
        double[] expected1 = new double[] {6.00000,0.50000,-1.00000,1.00000,-1.00000};
        assertArrayEquals(expected1, division.calcEquation(
                toNestedList("[[\"a\",\"b\"],[\"b\",\"c\"]]"),
                new double[] {2.0, 3.0},
                toNestedList("[[\"a\",\"c\"],[\"b\",\"a\"],[\"a\",\"e\"],[\"a\",\"a\"],[\"x\",\"x\"]]")));

        double[] expected2 = new double[] {3.75000,0.40000,5.00000,0.20000};
        assertArrayEquals(expected2, division.calcEquation(
                toNestedList("[[\"a\",\"b\"],[\"b\",\"c\"],[\"bc\",\"cd\"]]"),
                new double[] {1.5,2.5,5.0},
                toNestedList("[[\"a\",\"c\"],[\"c\",\"b\"],[\"bc\",\"cd\"],[\"cd\",\"bc\"]]")));

        double[] expected3 = new double[] {0.50000,2.00000,-1.00000,-1.00000};
        assertArrayEquals(expected3, division.calcEquation(
                toNestedList("[[\"a\",\"b\"]]"),
                new double[] {0.5},
                toNestedList("[[\"a\",\"b\"],[\"b\",\"a\"],[\"a\",\"c\"],[\"x\",\"y\"]]")));

        double[] expected4 = new double[] {1.33333,1.00000,-1.00000};
        assertArrayEquals(expected4, division.calcEquation(
                toNestedList("[[\"a\",\"e\"],[\"b\",\"e\"]]"),
                new double[] {4.0,3.0},
                toNestedList("[[\"a\",\"b\"],[\"e\",\"e\"],[\"x\",\"x\"]]")));
    }
}
