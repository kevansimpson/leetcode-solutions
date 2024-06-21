package org.base.leetcode.interview75.binarysearch;

/**
 * <a href="https://leetcode.com/problems/koko-eating-bananas/description/?envType=study-plan-v2&envId=leetcode-75">
 *     875. Koko Eating Bananas</a>
 * <p>
 *     Stats:
 *     Runtime:    6ms (98.94%)
 *     Memory: 44.54mb (95.25%)
 * </p>
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int right = piles[0];
        for (int i = 1; i < piles.length; i++)
            right = Math.max(right, piles[i]);


        int left = 1, speed = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (finishBananas(piles, h, mid)) {
                right = mid - 1;
                speed = mid;
            }
            else
                left = mid + 1;
        }

        return speed;
    }

    boolean finishBananas(int[] piles, int hours, int rate) {
        if (rate <= 0)
            return false;

        int ix = 0;
        while (hours >= 0 && ix < piles.length) {
            hours -= Math.ceilDiv(piles[ix++], rate);
        }
        return hours >= 0 && ix == piles.length;
    }
}
