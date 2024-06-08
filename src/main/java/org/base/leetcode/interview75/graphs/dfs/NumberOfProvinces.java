package org.base.leetcode.interview75.graphs.dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/number-of-provinces/?envType=study-plan-v2&envId=leetcode-75">
 *     547. Number of Provinces</a>
 * <p>
 *     Stats:
 *     Runtime:    3ms (37.40%)
 *     Memory: 47.55mb (56.90%)
 * </p>
 */
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        Set<Integer> visited = new HashSet<>();
        int provinces = 0;

        for (int row = 0; row < isConnected.length; row++) {
            if (!visited.contains(row)) {
                fillProvince(row, isConnected, visited);
                provinces++;
            }
        }
        return provinces;
    }

    void fillProvince(int row, int[][] matrix, Set<Integer> visited) {
        visited.add(row);
        for (int col = 0; col < matrix.length; col++) {
            if (!visited.contains(col)) {
                if (matrix[row][col] == 1) {
                    visited.add(col);
                    if (col != row)
                        fillProvince(col, matrix, visited);
                }
            }
        }
    }
}
