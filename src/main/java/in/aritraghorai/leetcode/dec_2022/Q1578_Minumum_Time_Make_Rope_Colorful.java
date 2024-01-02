package in.aritraghorai.leetcode.dec_2022;

/*
 *  !Name: Aritra Ghorai
 *  !Date:27/12/2023
 *  ?Program Details: 1578. Minimum Time to Make Rope Colorful
 *    */

public class Q1578_Minumum_Time_Make_Rope_Colorful {
  public int minCost(String colors, int[] neededTime) {
    return minCost2(colors, neededTime, '*', 0,
        new Integer[colors.length() + 1][30]);
  }

  public int minCost2(String colors, int[] neededTime, char prevColor,
      int index, Integer[][] dp) {
    if (index == colors.length()) {
      return 0;
    }

    if (prevColor != '*' & dp[index][prevColor - 'a'] != null) {
      return dp[index][prevColor - 'a'];
    }

    Integer res = Integer.MAX_VALUE;
    char currentColor = colors.charAt(index);
    if (prevColor != currentColor) {
      res = Math.min(res,
          minCost2(colors, neededTime, currentColor, index + 1, dp));
    }
    res = Math.min(res, minCost2(colors, neededTime, prevColor, index + 1, dp) +
        neededTime[index]);

    if (prevColor != '*') {
      dp[index][prevColor - 'a'] = res;
    }
    return res;
  }
}
