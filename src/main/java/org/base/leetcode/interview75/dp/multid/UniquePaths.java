package org.base.leetcode.interview75.dp.multid;

/**
 * <a href="https://leetcode.com/problems/unique-paths/?envType=study-plan-v2&envId=leetcode-75">
 *     62. Unique Paths</a>
 * <p>
 *     Stats:
 *     Runtime:    0ms (100.00%)
 *     Memory: 40.10mb  (78.33%)
 * </p>
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] table = new int[m + 2][n + 2];
        table[1][1] = 1;
        for (int row = 0; row <= m; row++)
            for (int col = 0; col <= n; col++) {
                table[row][col + 1] += table[row][col];
                table[row + 1][col] += table[row][col];
            }

        return table[m][n];
    }
}
