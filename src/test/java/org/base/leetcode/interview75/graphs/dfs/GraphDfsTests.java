package org.base.leetcode.interview75.graphs.dfs;

import org.junit.jupiter.api.Test;

import static org.base.leetcode.util.Helper.toNestedIntList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
