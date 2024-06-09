package org.base.leetcode.interview75.graphs.dfs;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/number-of-provinces/?envType=study-plan-v2&envId=leetcode-75">
 *     547. Number of Provinces</a>
 * <p>
 *     Stats:
 *     Runtime:   80ms  (43.97%)
 *     Memory: 70.90mb  (71.78%)
 * </p>
 */
public class ReorderRoutes {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> roads = new ArrayList<>();
        for (int i = 0; i < n; i++)
            roads.add(new ArrayList<>());

        for (int[] r : connections) {
            roads.get(r[0]).add(r[1]);
            roads.get(r[1]).add(-r[0]);
        }

        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        return findNode(0, roads, visited);
    }

    int findNode(int node, List<List<Integer>> roads, Set<Integer> visited) {
        int count = 0;
        for (int n : roads.get(node)) {
            if (!visited.contains(Math.abs(n))) {
                visited.add(Math.abs(n));
                if (n > 0) count++;
                count += findNode(Math.abs(n), roads, visited);
            }
        }
        return count;
    }
}
