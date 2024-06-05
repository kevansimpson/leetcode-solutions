package org.base.leetcode.interview75.binarytree;

import org.base.leetcode.model.TreeNode;

/**
 * <a href="https://leetcode.com/problems/delete-node-in-a-bst/description/?envType=study-plan-v2&envId=leetcode-75">
 *     450. Delete Node in a BST</a>
 * <p>
 *     Stats:
 *     Runtime:    0ms (100.00%)
 *     Memory: 45.67mb  (80.96%)
 * </p>
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (root.val < key)
            root.right = deleteNode(root.right, key);
        else if (root.val > key)
            root.left = deleteNode(root.left, key);
        else {
            if (root.left == null) {
                if (root.right == null)
                    return null;
                else
                    return root.right;
            }
            else if (root.right == null)
                return root.left;
            else {
                TreeNode repl = findReplacement(root.right);
                root.val = repl.val;
                root.right = deleteNode(root.right, repl.val);
                return root;
            }
        }
        return root;
    }

    TreeNode findReplacement(TreeNode node) {
        while (node.left != null)
            node = node.left;

        return node;
    }
}
