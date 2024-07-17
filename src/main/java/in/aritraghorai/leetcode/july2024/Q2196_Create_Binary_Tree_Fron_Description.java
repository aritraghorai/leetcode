package in.aritraghorai.leetcode.july2024;

import java.util.HashMap;

/*
 *  !Name: Aritra Ghorai
 *  !Date:15/07/2024
*  ?Program Details:  Q2196. Create Binary Tree From Description
*    */
public class Q2196_Create_Binary_Tree_Fron_Description {
  public static void main(String[] args) {

  }

  public TreeNode createBinaryTree(int[][] descriptions) {
    HashMap<Integer, TreeNode> nodeMap = new HashMap<>();
    HashMap<Integer, Boolean> isChilden = new HashMap<>();
    for (int i = 0; i < descriptions.length; i++) {
      int val = descriptions[i][0];
      // * Check if parent node already exist
      if (!nodeMap.containsKey(val)) {
        nodeMap.put(val, new TreeNode(val));
      }
      // * Check if child node already exist
      if (!nodeMap.containsKey(descriptions[i][1])) {
        nodeMap.put(descriptions[i][1], new TreeNode(descriptions[i][1]));
      }

      isChilden.putIfAbsent(descriptions[i][1], true);

      TreeNode node = nodeMap.get(val);
      if (descriptions[i][2] == 1) {
        node.left = nodeMap.get(descriptions[i][1]);
      } else {
        node.right = nodeMap.get(descriptions[i][1]);
      }
    }
    nodeMap.keySet().removeAll(isChilden.keySet());
    return nodeMap.get(nodeMap.keySet().iterator().next());
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
