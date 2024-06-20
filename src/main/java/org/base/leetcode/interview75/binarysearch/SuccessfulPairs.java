package org.base.leetcode.interview75.binarysearch;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/?envType=study-plan-v2&envId=leetcode-75">
 *     2300. Successful Pairs of Spells and Potions</a>
 * <p>
 *     Stats:
 *     Runtime:   40ms (78.00%)
 *     Memory: 61.55mb (85.01%)
 * </p>
 */
public class SuccessfulPairs {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] successful = new int[spells.length];
        int p = potions.length;
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int left = 0, right = p - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (((long) spells[i] * potions[mid]) >= success)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            successful[i] = p - left;
        }
        return successful;
    }
}
