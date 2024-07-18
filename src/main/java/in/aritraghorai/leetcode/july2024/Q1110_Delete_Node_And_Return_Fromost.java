package in.aritraghorai.leetcode.july2024;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

//ahdsffds
public class Q1110_Delete_Node_And_Return_Fromost {
  public static void main(String[] args) {
  }

  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    List<TreeNode> res = new ArrayList<>();
    Set<Integer> set = Set.of(Arrays.stream(to_delete).boxed().toArray(Integer[]::new));
    helper(root, set, res);
    if (!set.contains(root.val)) {
      res.add(root);
    }
    return res;
  }

  public TreeNode helper(TreeNode node, Set<Integer> set, List<TreeNode> res) {
    if (node == null) {
      return null;
    }
    node.left = helper(node.left, set, res);
    node.right = helper(node.right, set, res);
    if (set.contains(node.val)) {
      if (node.left != null) {
        res.add(node.left);
      }
      if (node.right != null) {
        res.add(node.right);
      }
      return null;
    }
    return node;
  }
}
