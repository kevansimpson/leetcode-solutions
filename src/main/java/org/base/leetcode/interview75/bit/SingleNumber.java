package org.base.leetcode.interview75.bit;


/**
 * <a href="https://leetcode.com/problems/single-number/description/?envType=study-plan-v2&envId=leetcode-75">
 *     136. Single Number</a>
 * <p>
 *     Stats:
 *     Runtime:    1ms (99.89%)
 *     Memory: 46.30mb (17.24%)
 * </p>
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int n = nums[0];
        for (int i = 1; i < nums.length; i++)
            n = n ^ nums[i];

        return n;
    }
}
