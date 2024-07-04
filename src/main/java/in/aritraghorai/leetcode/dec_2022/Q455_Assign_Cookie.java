package in.aritraghorai.leetcode.dec_2022;

import java.util.Arrays;

public class Q455_Assign_Cookie {

  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int i = 0;
    int j = 0;
    while (i < g.length && j < s.length) {
      if (g[i] <= s[j]) {
        i++;
        j++;
      } else {
        j++;
      }
    }
    return i;
  }
}
