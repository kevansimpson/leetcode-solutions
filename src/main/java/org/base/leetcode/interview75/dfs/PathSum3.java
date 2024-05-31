package org.base.leetcode.interview75.dfs;

/**
 * <a href="https://leetcode.com/problems/path-sum-iii/description/?envType=study-plan-v2&envId=leetcode-75">
 *     Path Sum III</a>
 * <p>
 *     Stats:
 *     Runtime:   18ms (39.07%)
 *     Memory: 42.82mb (91.25%)
 * </p>
 */
public class PathSum3 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        return pathSumFrom(root, targetSum)
                + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    public int pathSumFrom(TreeNode node, long targetSum) {
        if (node == null)
            return 0;
        return ((node.val == targetSum) ? 1 : 0)
                +
                pathSumFrom(node.left, targetSum - node.val)
                +
                pathSumFrom(node.right, targetSum - node.val);
    }
}
