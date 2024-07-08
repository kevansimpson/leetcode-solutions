package org.base.leetcode.interview75.dp.oned;

/**
 * <a href="https://leetcode.com/problems/domino-and-tromino-tiling/description/?envType=study-plan-v2&envId=leetcode-75">
 *     790. Domino and Tromino Tiling</a>
 * <p>
 *     Stats:
 *     Runtime:    0ms (100.00%)
 *     Memory: 39.86mb  (96.21%)
 * </p>
 */
public class DominoTiling {
    public int numTilings(int n) {
        return switch (n) {
            case 0 -> 0;
            case 1 -> 1;
            case 2 -> 2;
            case 3 -> 5;
            default -> {
                long[] tiles = new long[n + 1];
                tiles[0] = 1L;
                tiles[1] = 1L;
                tiles[2] = 2L;
                tiles[3] = 5L;
                for (int i = 4; i <= n; i++)
                    tiles[i] = (tiles[i - 1] * 2 + tiles[i - 3])  % 1000000007L;
                yield (int) tiles[n];
            }
        };
    }
}
