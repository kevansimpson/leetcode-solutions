package org.base.leetcode.interview75.dfs;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int v) { val = v; }
    TreeNode(int v, TreeNode l, TreeNode r) {
        this(v);
        left = l;
        right = r;
    }

    @Override
    public String toString() {
        return String.format("[%d,%s,%s]", val, left, right);
    }

    public static boolean equals(TreeNode node1, TreeNode node2) {
        if (node1 == null) {
            return node2 == null;
        }
        else if (node2 == null)
            return false;

        return node1.val == node2.val && equals(node1.left, node2.left) && equals(node1.right, node2.right);
    }

    public static TreeNode fromString(String str) {
        str = str.replace("[", "").replace("]", "");
        String[] arr = str.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        int i = 1;
        while (!nodeList.isEmpty() && i < arr.length) {
            List<TreeNode> next = new ArrayList<>();
            for (TreeNode n : nodeList) {
                if (!arr[i].equals("null")) {
                    n.left = new TreeNode(Integer.parseInt(arr[i]));
                    next.add(n.left);
                }
                if (++i >= arr.length)
                    break;
                if (!arr[i].equals("null")) {
                    n.right = new TreeNode(Integer.parseInt(arr[i]));
                    next.add(n.right);
                }
                if (++i >= arr.length)
                    break;
            }

            nodeList = next;
        }

        return root;
    }
}
