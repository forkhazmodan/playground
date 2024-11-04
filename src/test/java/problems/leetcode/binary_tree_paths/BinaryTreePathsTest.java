package problems.leetcode.binary_tree_paths;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import problems.leetcode.binary_tree_paths.BinaryTreePaths;

class BinaryTreePathsTest {

  @Test
  void binaryTreePaths() {
    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode3 = new TreeNode(3);
    TreeNode treeNode4 = new TreeNode(4);
    TreeNode treeNode5 = new TreeNode(5);
    TreeNode treeNode6 = new TreeNode(6);
    TreeNode treeNode7 = new TreeNode(7);

    treeNode1.left = treeNode2;
    treeNode1.right = treeNode3;
    treeNode2.left = treeNode4;
    treeNode2.right = treeNode5;
    treeNode4.left = treeNode7;
    treeNode5.right = treeNode6;

    for (String s : BinaryTreePaths.binaryTreePaths(treeNode1)) {
      System.out.println(s);
    }
  }
}
