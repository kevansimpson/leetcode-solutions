package org.base.leetcode.interview75.graphs.bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/submissions/1286458990/?envType=study-plan-v2&envId=leetcode-75">
 *     1926. Nearest Exit from Entrance in Maze</a>
 * <p>
 *     Stats:
 *     Runtime:    5ms (83.33%)
 *     Memory: 45.32mb (82.54%)
 * </p>
 */
public class NearestExit {
    private static final int[] moveX = new int[] {0, 1, 0, -1};
    private static final int[] moveY = new int[] {1, 0, -1, 0};

    public record Point(int y, int x) {}

    public int nearestExit(char[][] maze, int[] entrance) {
        int steps = -1, m = maze.length, n = maze[0].length;
        List<Point> paths = new ArrayList<>();
        paths.add(new Point(entrance[0], entrance[1]));

        while (!paths.isEmpty()) {
            steps++;
            List<Point> next = new ArrayList<>(paths);
            paths.clear();
            for (Point point : next) {
                if (point.x == 0 || point.x >= n - 1 || point.y == 0 || point.y >= m - 1)
                    if (!(point.y == entrance[0] && point.x == entrance[1]))
                        return steps;

                for (int xy = 0; xy < 4; xy++) {
                    int dx = point.x + moveX[xy];
                    int dy = point.y + moveY[xy];
                    if (dx >= 0 && dx < n && dy >= 0 && dy < m && '.' == maze[dy][dx]) {
                        paths.add(new Point(dy, dx));
                        maze[dy][dx] = 'v';
                    }
                }
            }
        }

        return -1;
    }
}
/*
        val paths = mutableListOf(entrance[0] to entrance[1])
        var steps = -1
        val m = maze.size
        val n = maze[0].size

        while (paths.isNotEmpty()) {
            steps++
            val next = paths.toList().also { paths.clear() }
            for (point in next) {
                val x = point.second
                val y = point.first
                if (x == 0 || x >= n - 1 || y == 0 || y >= m - 1)
                    if (!(y == entrance[0] && x == entrance[1]))
                        return steps

                for (xy in 0..3) {
                    val dx = x + moveX[xy]
                    val dy = y + moveY[xy]
                    if (dx in 0..<n && dy >= 0 && dy < m && '.' == maze[dy][dx]) {
                        paths.add(dy to dx)
                        maze[dy][dx] = 'v'
                    }
                }
            }
        }

        return -1

 */
