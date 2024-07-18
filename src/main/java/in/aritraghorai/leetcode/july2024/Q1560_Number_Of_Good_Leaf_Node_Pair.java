package in.aritraghorai.leetcode.july2024;

import java.util.Arrays;

/*
 *  !Name: Aritra Ghorai
 *  !Date:18/07/2024
*  ?Program Details: 1530. Number of Good Leaf Nodes Pairs
*    */
public class Q1560_Number_Of_Good_Leaf_Node_Pair {

  int answer = 0;

  public int countPairs(TreeNode root, int distance) {
    Integer res = 0;
    helper(root, distance, res);
    return answer;
  }

  public int[] helper(TreeNode node, int distance, Integer res) {
    int[] arr = new int[11];
    if (node == null) {
      return arr;
    }
    if (node.left == null && node.right == null) {
      arr[1] = 1;
      return arr;
    }
    int[] res1 = helper(node.left, distance, res);
    int[] res2 = helper(node.right, distance, res);
    for (int i = 1; i < 11; i++) {
      for (int j = 1; j < 11; j++) {
        if (i + j <= distance) {
          answer += res1[i] * res2[j];
        } else {
          break;
        }
      }
    }
    for (int i = 1; i < 11; i++) {
      arr[i] = res1[i - 1] + res2[i - 1];
    }
    return arr;
  }

}
