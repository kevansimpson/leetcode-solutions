package org.base.leetcode.interview75.graphs.bfs;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/rotting-oranges/description/?envType=study-plan-v2&envId=leetcode-75">
 *     994. Rotting Oranges</a>
 * <p>
 *     Stats:
 *     Runtime:   16ms (5.53%)
 *     Memory: 43.24mb (7.15%)
 * </p>
 */
public class RottingOranges {
    public record Orange(int y, int x) {}

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxY = m - 1, maxX = n - 1;
        int fresh = 0;
        Set<Orange> rotten = new HashSet<>();
        for (int y = 0; y <= maxY; y++)
            for (int x = 0; x <= maxX; x++)
                switch (grid[y][x]) {
                    case 1 -> fresh++;
                    case 2 -> rotten.add(new Orange(y, x));
                }

        if (fresh == 0) // no fresh oranges
            return 0;
        else if (rotten.isEmpty()) // no rotten
            return -1;

        Set<Orange> visited = new HashSet<>();
        fresh = -1;
        while (!rotten.isEmpty()) {
            fresh++;
            Set<Orange> next = new HashSet<>();
            for (Orange o : rotten) {
                visited.add(o);
                if (o.y > 0 && grid[o.y - 1][o.x] == 1)
                    next.add(new Orange(o.y - 1, o.x));
                if (o.y < maxY && grid[o.y + 1][o.x] == 1)
                    next.add(new Orange(o.y + 1, o.x));
                if (o.x > 0 && grid[o.y][o.x - 1] == 1)
                    next.add(new Orange(o.y, o.x - 1));
                if (o.x < maxX && grid[o.y][o.x + 1] == 1)
                    next.add(new Orange(o.y, o.x + 1));
            }
            next.removeAll(visited);
            rotten = next;
        }
        for (int y = 0; y <= maxY; y++)
            for (int x = 0; x <= maxX; x++)
                if (grid[y][x] == 1 && !visited.contains(new Orange(y, x)))
                    return -1;

        return fresh;
    }
}
