package org.base.leetcode.interview75.dp.multid;

/**
 * <a href="https://leetcode.com/problems/longest-common-subsequence/description/?envType=study-plan-v2&envId=leetcode-75">
 *     1143. Longest Common Subsequence</a>
 * <p>
 *     Stats:
 *     Runtime:   19ms  (87.63%)
 *     Memory: 50.34mb  (84.39%)
 * </p>
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] table = new int[m + 1][n + 1];

        for (int row = 1; row <= m; row++)
            for (int col = 1; col <= n; col++)
                if (text1.charAt(row - 1) == text2.charAt(col - 1))
                    table[row][col] = 1 + table[row - 1][col - 1];
                else
                    table[row][col] = Math.max(
                            table[row][col - 1],
                            table[row - 1][col]);

        return table[m][n];
    }
}
