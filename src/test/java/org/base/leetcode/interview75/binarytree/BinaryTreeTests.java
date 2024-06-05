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
}
