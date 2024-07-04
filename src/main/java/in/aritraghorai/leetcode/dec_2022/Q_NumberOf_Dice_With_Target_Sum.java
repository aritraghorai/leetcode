package in.aritraghorai.leetcode.dec_2022;

public class Q_NumberOf_Dice_With_Target_Sum {
  Integer num = 1000000007;

  public int numRollsToTarget(int n, int k, int target) {
    return solve(n, k, target, new Integer[n + 1][target + 1]);
  }

  public int solve(int n, int k, int target, Integer[][] arr) {
    if (target == 0 && n == 0) {
      return 1;
    }
    if (n <= 0 || target < 0) {
      return 0;
    }
    if (arr[n][target] != null) {
      return arr[n][target] % num;
    }
    int res = 0;
    for (int i = 1; i <= k && target >= i; i++) {
      res += solve(n - 1, k, target - i, arr);
      res %= num;
    }
    return arr[n][target] = res % num;
  }
}
