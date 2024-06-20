package org.base.leetcode.interview75.binarysearch;

public class SuccessfulPairs {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] successful = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            for (int p : potions)
                if ((long) spells[i] * p >= success)
                    successful[i]++;
        }
        return successful;
    }
}
