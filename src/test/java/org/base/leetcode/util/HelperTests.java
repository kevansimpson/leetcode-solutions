package org.base.leetcode.util;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;

import static org.base.leetcode.util.Helper.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelperTests {
    @Test
    public void testToIntArray() {
        assertArrayEquals(new int[] {1,2,3}, toIntArray("[1,2,3]"));
    }

    @Test
    public void testToNestedArray() {
        String[][] expected1 = new String[][] { {"1"}, {"2"}, {"3"}, {} };
        assertNestedArrayEquals(expected1, toNestedArray("[[1],[2],[3],[]]"));

        String[][] expected2 = new String[][] { {"1","3"}, {"3","0","1"}, {"2"}, {"0"} };
        assertNestedArrayEquals(expected2, toNestedArray("[[1,3],[3,0,1],[2],[0]]"));
    }

    @Test
    public void testToNestedIntArray() {
        int[][] expected1 = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        assertArrayEquals(expected1, toNestedIntArray("[[1,1,0],[1,1,0],[0,0,1]]"));
        int[][] expected2 = new int[][]{{1,0,0},{0,1,0},{0,0,1}};
        assertArrayEquals(expected2, toNestedIntArray("[[1,0,0],[0,1,0],[0,0,1]]"));
    }

    @Test
    public void testToIntList() {
        assertEquals(List.of(1, 2, 3), toIntList("[1,2,3]"));
        assertEquals(List.of(), toIntList("[]"));
    }

    @Test
    public void testToList() {
        assertEquals(List.of(1,2,3), toList("[1,2,3]", Integer::parseInt));
        assertEquals(List.of("1","2","3"), toList("[1,2,3]", Function.identity()));
    }

    @Test
    public void testToNestedIntList() {
        assertEquals(List.of(List.of(1), List.of(2), List.of(3), List.of()),
                toNestedIntList("[[1],[2],[3],[]]"));
        assertEquals(List.of(List.of(1,3), List.of(3,0,1), List.of(2), List.of(0)),
                toNestedIntList("[[1,3],[3,0,1],[2],[0]]"));
    }

    public static <T> void assertNestedArrayEquals(T[][] expected, T[][] actual) {
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i].length, actual[i].length);
            for (int j = 0; j < actual[i].length; j++)
                assertEquals(expected[i][j], actual[i][j]);
        }
    }
}
