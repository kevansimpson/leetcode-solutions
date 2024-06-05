package org.base.leetcode.interview75.bfs;

import org.base.leetcode.model.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.base.leetcode.model.TreeNode.fromString;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeBfsTests {
    @Test
    public void testBinaryTreeRightSideView() {
        BinaryTreeRightSideView rsv = new BinaryTreeRightSideView();
        TreeNode example1 = fromString("[1,2,3,null,5,null,4]");
        assertEquals(List.of(1, 3, 4), rsv.rightSideView(example1));
        TreeNode example2 = fromString("[1,null,3]");
        assertEquals(List.of(1, 3), rsv.rightSideView(example2));
        TreeNode example3 = fromString("[]");
        assertEquals(List.of(), rsv.rightSideView(example3));
        TreeNode example4 = fromString("[1,2,3,4]");
        assertEquals(List.of(1, 3, 4), rsv.rightSideView(example4));
    }

    @Test
    public void testMaxLevelSum() {
        MaxLevelSum mls = new MaxLevelSum();
        TreeNode example1 = fromString("[1,7,0,7,-8,null,null]");
        assertEquals(2, mls.maxLevelSum(example1));
        TreeNode example2 = fromString("[989,null,10250,98693,-89388,null,null,null,-32127]");
        assertEquals(2, mls.maxLevelSum(example2));
    }
}
