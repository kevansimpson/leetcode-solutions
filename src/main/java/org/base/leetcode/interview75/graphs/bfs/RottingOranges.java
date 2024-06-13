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
    private static final int[] moveX = new int[] {0, 1, 0, -1};
    private static final int[] moveY = new int[] {1, 0, -1, 0};

    public record Point(int y, int x) {}

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<Point> fresh = new HashSet<>();
        for (int y = 0; y < m; y++)
            for (int x = 0; x < n; x++)
                if (grid[y][x] == 1)
                    fresh.add(new Point(y, x));

        if (fresh.isEmpty()) // no fresh oranges
            return 0;

        int steps = 0;
        while (!fresh.isEmpty()) {
            Set<Point> rotted = new HashSet<>();
            steps++;
            for (Point pt : fresh) {
                for (int i = 0; i < 4; i++) {
                    int dy = pt.y + moveY[i];
                    int dx = pt.x + moveX[i];
                    if (dy >= 0 && dy < m && dx >=0 && dx < n) { // in grid
                        if (grid[dy][dx] == 2) { // rotten neighbor
                            rotted.add(pt);
                        }
                    }
                }
            }

            if (rotted.isEmpty()) {
                for (Point safe : fresh)
                    if (isOrangeSafe(safe.y, safe.x, m, n, grid))
                        return -1;
            }
            else
                for (Point rot : rotted) {
                    fresh.remove(rot);
                    grid[rot.y][rot.x] = 2;
                }
        }

        return steps;
    }

    boolean isOrangeSafe(int y, int x, int m, int n, int[][] grid) {
        for (int i = 0; i < 4; i++) {
            int dy = y + moveY[i];
            int dx = x + moveX[i];
            if (dy >= 0 && dy < m && dx >= 0 && dx < n) { // in grid
                if (grid[dy][dx] == 2)
                    return false;
            }
        }
        return true;
    }
}
