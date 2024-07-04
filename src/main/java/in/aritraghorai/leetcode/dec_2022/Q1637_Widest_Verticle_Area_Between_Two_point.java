package in.aritraghorai.leetcode.dec_2022;

import java.util.Arrays;

/*
 *  !Name: Aritra Ghorai
 *  !Date:21/12/2023
 *  ?Program Details:1637. Widest Vertical Area Between Two Points Containing No
 * Points
 *    */

public class Q1637_Widest_Verticle_Area_Between_Two_point {
  public int maxWidthOfVerticalArea(int[][] points) {
    int max = 0;
    int[] x = new int[points.length];
    for (int i = 0; i < points.length; i++) {
      x[i] = points[i][0];
    }
    Arrays.sort(x);
    for (int i = 0; i < x.length - 1; i++) {
      max = Math.max(max, x[i + 1] - x[i]);
    }
    return max;
  }
}
