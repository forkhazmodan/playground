package problems.leetcode.binary_tree_paths;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

  public static List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();
    dfs(root, result, "");
    return result;
  }

  public static void dfs(TreeNode root, List<String> list, String path) {

    if (root == null) {
      return;
    }

    path += root.val;
    if (root.right == null && root.left == null) {
      list.add(path);
    }

    dfs(root.left, list, path + "-->");
    dfs(root.right, list, path + "-->");
  }

}
