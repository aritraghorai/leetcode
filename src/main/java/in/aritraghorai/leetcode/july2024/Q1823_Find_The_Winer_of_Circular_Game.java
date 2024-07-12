package in.aritraghorai.leetcode.july2024;

import java.util.ArrayList;

/**
 * Q1823_Find_The_Winer_of_Circular_Game
 */
public class Q1823_Find_The_Winer_of_Circular_Game {

  public static void main(String[] args) {
    Q1823_Find_The_Winer_of_Circular_Game q =
        new Q1823_Find_The_Winer_of_Circular_Game();
    System.out.println(q.findTheWinner(5, 2));
  }
  public int findTheWinner(int n, int k) {
    ArrayList<Integer> arr = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      arr.add(i);
    }
    return findTheWinnerRecursive(0, k - 1, arr);
  }

  public int findTheWinnerRecursive(int n, int k, ArrayList<Integer> arr) {
    if (arr.size() == 1) {
      return arr.get(0);
    }
    int newIndex = (n + k) % arr.size();
    arr.remove(newIndex);
    return findTheWinnerRecursive(newIndex, k, arr);
  }
}
