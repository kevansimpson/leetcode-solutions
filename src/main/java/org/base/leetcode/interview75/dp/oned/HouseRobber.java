package org.base.leetcode.interview75.dp.oned;

/**
 * <a href="https://leetcode.com/problems/house-robber/description/?envType=study-plan-v2&envId=leetcode-75">
 *     198. House Robber</a>
 * <p>
 *     Stats:
 *     Runtime:    0ms (100.00%)
 *     Memory: 40.66mb  (78.33%)
 * </p>
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int len = nums.length;
        return switch (len) {
            case 0 -> 0;
            case 1 -> nums[0];
            case 2 -> Math.max(nums[0], nums[1]);
            case 3 -> Math.max(nums[0] + nums[2], nums[1]);
            default -> {
                nums[len - 3] += nums[len - 1];
                for (int i = len - 4; i >= 0; i--)
                    nums[i] += Math.max(nums[i + 2], nums[i + 3]);
                yield Math.max(nums[0], nums[1]);
            }
        };
    }
}
