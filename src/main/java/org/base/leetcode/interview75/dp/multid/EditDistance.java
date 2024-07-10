package org.base.leetcode.interview75.dp.multid;

/**
 * <a href="https://leetcode.com/problems/edit-distance/description/?envType=study-plan-v2&envId=leetcode-75">
 *     72. Edit Distance</a>
 * <p>
 *     Stats:
 *     Runtime:    5ms  (64.96%)
 *     Memory: 44.81mb  (51.23%)
 * </p>
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] table = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            table[i][0] = i;
        for (int i = 0; i <= n; i++)
            table[0][i] = i;

        for (int row = 1; row <= m; row++)
            for (int col = 1; col <= n; col++)
                if (word1.charAt(row - 1) == word2.charAt(col - 1))
                    table[row][col] = table[row - 1][col - 1];
                else
                    table[row][col] = 1 + Math.min(
                            table[row - 1][col - 1],
                            Math.min(
                                table[row][col - 1],
                                table[row - 1][col]));

        return table[m][n];
    }
}
