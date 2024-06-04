package org.base.leetcode.interview75.dfs;

import org.base.leetcode.model.TreeNode;

/**
 * <a href="https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75">
 *     Count Good Nodes in Binary Tree</a>
 * <p>
 *     Stats:
 *     Runtime:    2ms (82.37%)
 *     Memory: 52.10mb (55.01%)
 * </p>
 *
 */
public class CountGoodNodesBinaryTree {
    public int goodNodes(TreeNode root) {
        return 1 + goodNodes(root.left, root.val) + goodNodes(root.right, root.val);
    }

    public int goodNodes(TreeNode node, int max) {
        if (node != null) {
            int newMax = Math.max(max, node.val);
            return ((node.val == newMax) ? 1 : 0) + goodNodes(node.left, newMax) + goodNodes(node.right, newMax);
        }

        return 0;
    }
}
