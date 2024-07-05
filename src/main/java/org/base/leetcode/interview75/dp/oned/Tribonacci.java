package org.base.leetcode.interview75.dp.oned;


/**
 * <a href="https://leetcode.com/problems/n-th-tribonacci-number/description/?envType=study-plan-v2&envId=leetcode-75">
 *     1137. N-th Tribonacci Number</a>
 * <p>
 *     Stats:
 *     Runtime:    0ms (100.00%)
 *     Memory: 39.73mb  (95.66%)
 * </p>
 */
public class Tribonacci {
    public int tribonacci(int n) {
        int[] table = new int[n + 3];
        table[1] = 1;

        for (int i = 0; i < n; i++) {
            table[i + 1] += table[i];
            table[i + 2] += table[i];
            table[i + 3] += table[i];
        }
        return table[n];
    }
}
