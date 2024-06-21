package org.base.leetcode.interview75.binarysearch;

/**
 * <a href="https://leetcode.com/problems/find-peak-element/description/?envType=study-plan-v2&envId=leetcode-75">
 *     162. Find Peak Element</a>
 * <p>
 *     Stats:
 *     Runtime:    0ms (100.00%)
 *     Memory: 42.04mb  (73.91%)
 * </p>
 * Followed solution from <a
 * href="https://www.geeksforgeeks.org/find-the-maximum-element-in-an-array-which-is-first-increasing-and-then-decreasing/?ref=header_search">
 * here</a> because this was a niche problem.
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        return findPeak(nums, 0, nums.length - 1);
    }

    int findPeak(int[] nums, int left, int right) {
        if (left == right)
            return left;

        if (left + 1 == right)
            return nums[left] >= nums[right] ? left : right;

        int mid = (left + right) / 2;
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
            return mid;

        if (nums[mid] > nums[mid + 1] && nums[mid] < nums[mid - 1])
            return findPeak(nums, left, mid - 1);
        else
            return findPeak(nums, mid + 1, right);
    }
}
