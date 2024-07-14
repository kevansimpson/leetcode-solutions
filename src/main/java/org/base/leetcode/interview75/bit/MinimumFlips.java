package org.base.leetcode.interview75.bit;


/**
 * <a href="https://leetcode.com/problems/single-number/description/?envType=study-plan-v2&envId=leetcode-75">
 *     136. Single Number</a>
 * <p>
 *     Stats:
 *     Runtime:    0ms (100.0%)
 *     Memory: 40.25mb  (44.42%)
 * </p>
 */
public class MinimumFlips {
    public int minFlips(int a, int b, int c) {
        int flips = 0, two = 1;

        while (two <= Math.max(Math.max(a, b), c)) {
            if ((c & two) == two) {
                if (((a & two) == 0) && ((b & two) == 0)) {
                    flips += 1;
                }
            }
            else {
                if ((a & two) == two) {
                    if ((b & two) == two)
                        flips += 2;
                    else
                        flips += 1;
                }
                else if ((b & two) == two) {
                    flips += 1;
                }
            }
            two *= 2;
        }

        return flips;
    }
}
