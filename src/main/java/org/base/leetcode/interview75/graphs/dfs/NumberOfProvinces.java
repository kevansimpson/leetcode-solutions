package org.base.leetcode.interview75.graphs.dfs;

/**
 * <a href="https://leetcode.com/problems/number-of-provinces/?envType=study-plan-v2&envId=leetcode-75">
 *     547. Number of Provinces</a>
 * <p>
 *     Stats:
 *     Runtime:    0ms (100.00%)
 *     Memory: 44.33mb  (99.69%)
 * </p>
 */
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int provinces = 0;

        for (int row = 0; row < isConnected.length; row++) {
            if (!visited[row]) {
                fillProvince(row, isConnected, visited);
                provinces++;
            }
        }
        return provinces;
    }

    void fillProvince(int row, int[][] matrix, boolean[] visited) {
        visited[row] = true;
        for (int col = 0; col < matrix.length; col++) {
            if (!visited[col]) {
                if (matrix[row][col] == 1) {
                    visited[col] = true;
                    if (col != row)
                        fillProvince(col, matrix, visited);
                }
            }
        }
    }
}
