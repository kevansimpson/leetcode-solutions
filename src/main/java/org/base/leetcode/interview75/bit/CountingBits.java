package org.base.leetcode.interview75.bit;


/**
 * <a href="https://leetcode.com/problems/counting-bits/?envType=study-plan-v2&envId=leetcode-75">
 *     338. Counting Bits</a>
 * <p>
 *     Stats:
 *     Runtime:    2ms (92.98%)
 *     Memory: 46.29mb (85.27%)
 * </p>
 */
public class CountingBits {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++)
            bits[i] = solve(i, bits);
        return bits;
    }

    int solve(int n, int[] bits) {
        return switch (n) {
            case 0 -> 0;
            case 1 -> 1;
            default -> {
                if (bits[n] == 0) {
                    if ((n % 2) == 0)
                        bits[n] = solve(n / 2, bits);
                    else
                        bits[n] = 1 + solve(n / 2, bits);
                }
                yield bits[n];
            }
        };
    }
}
