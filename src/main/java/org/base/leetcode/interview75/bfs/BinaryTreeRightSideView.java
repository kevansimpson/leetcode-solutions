package org.base.leetcode.interview75.bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.base.leetcode.model.TreeNode;

/**
 * <a href="https://leetcode.com/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=leetcode-75">
 *     199. Binary Tree Right Side View</a>
 * <p>
 *     Stats:
 *     Runtime:    1ms (67.05%)
 *     Memory: 41.88mb (69.01%)
 * </p>
 *
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> nodeList = new Stack<>();
            nodeList.add(root);
            while (!nodeList.isEmpty()) {
                rightSide.add(nodeList.peek().val);
                Stack<TreeNode> next = new Stack<>();
                for (TreeNode n : nodeList) {
                    if (n.left != null) next.push(n.left);
                    if (n.right != null) next.push(n.right);
                }
                nodeList = next;
            }
        }

        return rightSide;
    }
}
