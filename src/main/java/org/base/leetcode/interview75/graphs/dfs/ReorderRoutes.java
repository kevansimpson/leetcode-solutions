package org.base.leetcode.interview75.graphs.dfs;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/?envType=study-plan-v2&envId=leetcode-75">
 *     1466. Reorder Routes to Make All Paths Lead to the City Zero</a>
 * <p>
 *     Stats:
 *     Runtime:   34ms  (87.33%)
 *     Memory: 69.41mb  (76.14%)
 * </p>
 */
public class ReorderRoutes {
    public record Road(int node, int weight) {}

    public int minReorder(int n, int[][] connections) {
        Deque<Road>[] roads = new Deque[n];
        for (int i = 0; i < n; i++)
            roads[i] = new LinkedList<>();

        for (int[] r : connections) {
            roads[r[0]].add(new Road(r[1], 1));
            roads[r[1]].add(new Road(r[0], 0));
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.add(0);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                visited[node] = true;

                for (Road road : roads[node]) {
                    if (!visited[road.node]) {
                        stack.add(road.node);
                        if (road.weight == 1)
                            count++;
                    }
                }
            }
        }

        return count;
    }
}
