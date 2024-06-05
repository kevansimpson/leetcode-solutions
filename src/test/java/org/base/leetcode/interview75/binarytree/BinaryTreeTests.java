package org.base.leetcode.interview75.binarytree;

import org.base.leetcode.model.TreeNode;
import org.junit.jupiter.api.Test;

import static org.base.leetcode.model.TreeNode.fromString;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTests {
    @Test
    public void testSearch() {
        Search search = new Search();
        TreeNode example1 = fromString("[4,2,7,1,3]");
        TreeNode expected1 = fromString("[2,1,3]");
        assertTrue(TreeNode.equals(expected1, search.searchBST(example1, 2)));
        assertNull(search.searchBST(example1, 5));
    }

    @Test
    public void testDeleteNode() {
        DeleteNode deleteNode = new DeleteNode();
        TreeNode example1 = fromString("[5,3,6,2,4,null,7]");
        TreeNode expected1 = fromString("[5,4,6,2,null,null,7]");
        TreeNode actual1 = deleteNode.deleteNode(example1, 3);
        assertTrue(TreeNode.equals(expected1, actual1));
        TreeNode example2 = fromString("[5,3,6,2,4,null,7]");
        assertTrue(TreeNode.equals(example2, deleteNode.deleteNode(example2, 0)));
        assertNull(deleteNode.deleteNode(fromString("[]"), 0));
        TreeNode example4 = fromString("[5,3,6,2,4,null,7]");
        TreeNode expected4 = fromString("[6,3,7,2,4]");
        TreeNode actual4 = deleteNode.deleteNode(example4, 5);
        assertTrue(TreeNode.equals(expected4, actual4));
    }
}
