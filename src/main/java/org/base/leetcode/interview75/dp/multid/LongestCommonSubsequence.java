package org.base.leetcode.interview75.dp.multid;

/**
 * <a href="https://leetcode.com/problems/longest-common-subsequence/description/?envType=study-plan-v2&envId=leetcode-75">
 *     1143. Longest Common Subsequence</a>
 * <p>
 *     Stats:
 *     Runtime:   22ms  (46.98%)
 *     Memory: 50.22mb  (87.24%)
 * </p>
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] table = new int[m][n];

        for (int row = 0; row < m; row++)
            for (int col = 0; col < n; col++)
                if (text1.charAt(row) == text2.charAt(col))
                    table[row][col] = 1 + get(table, row - 1, col - 1);
                else
                    table[row][col] = Math.max(
                            get(table, row, col - 1),
                            get(table, row - 1, col));

        return table[m - 1][n - 1];
    }

    int get(int[][] table, int row, int col) {
        if (row < 0 || col < 0 || row >= table.length || col >= table[row].length)
            return 0;
        else
            return table[row][col];
    }
}
