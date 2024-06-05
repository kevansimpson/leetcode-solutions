package org.base.leetcode.interview75.bfs;

import org.base.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=leetcode-75">
 *     199. Binary Tree Right Side View</a>
 * <p>
 *     Stats:
 *     Runtime:    9ms (43.82%)
 *     Memory: 46.14mb (92.92%)
 * </p>
 */
public class MaxLevelSum {
    public int maxLevelSum(TreeNode root) {
        int level = 0;
        if (root != null) {
            List<TreeNode> nodeList = new ArrayList<>();
            nodeList.add(root);
            int max = Integer.MIN_VALUE, current = 0;
            while (!nodeList.isEmpty()) {
                current++;
                int sum = 0;
                List<TreeNode> next = new ArrayList<>();
                for (TreeNode n : nodeList) {
                    if (n != null) {
                        sum += n.val;
                        next.add(n.left);
                        next.add(n.right);
                    }
                }
                if (sum > max) {
                    max = sum;
                    level = current;
                }
                nodeList = next;
            }
        }
        return level;
    }
}
