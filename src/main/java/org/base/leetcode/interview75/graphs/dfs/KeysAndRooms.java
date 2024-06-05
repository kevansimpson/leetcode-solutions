package org.base.leetcode.interview75.graphs.dfs;

import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/keys-and-rooms/description/?envType=study-plan-v2&envId=leetcode-75">
 *     841. Keys and Rooms</a>
 * <p>
 *     Stats:
 *     Runtime:    1ms (77.08%)
 *     Memory: 44.09mb (63.14%)
 * </p>
 */
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> keys = new Stack<>();
        keys.push(0); // first room
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;

        while (!keys.isEmpty()) {
            int keySet = keys.pop();
            for (int roomKey : rooms.get(keySet))
                if (!visited[roomKey]) {
                    visited[roomKey] = true;
                    keys.push(roomKey);
                }
        }

        for (boolean v : visited)
            if (!v)
                return false;
        return true;
    }
}
