package in.aritraghorai.leetcode.dec_2022;

public class Q1422_Maximum_Score_After_Splitting_Sting {
  public static void main(String[] args) {
    System.out.println(maxScore("011101"));
  }

  public static int maxScore(String s) {
    int max = Integer.MIN_VALUE;
    int[] numsOfZero = new int[s.length()];
    if (s.charAt(0) == '0') {
      numsOfZero[0] = 1;
    }
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == '0') {
        numsOfZero[i] = numsOfZero[i - 1] + 1;
      } else {
        numsOfZero[i] = numsOfZero[i - 1];
      }
    }
    int numberOf1 = 0;
    for (int i = s.length() - 1; i >= 1; i--) {
      if (s.charAt(i) == '1') {
        numberOf1++;
      }
      max = Math.max(numberOf1 + numsOfZero[i - 1], max);
    }

    return max;
  }
}
