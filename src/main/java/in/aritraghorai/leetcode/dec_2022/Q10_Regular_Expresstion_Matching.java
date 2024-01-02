package in.aritraghorai.leetcode.dec_2022;
/*
 !Name: Aritra Ghorai
 !Date:27/12/2023
 ?Program Details: 10. Regular Expression Matching
   */

public class Q10_Regular_Expresstion_Matching {

  public static void main(String[] args) {
    Q10_Regular_Expresstion_Matching regular_Expresstion_Matching = new Q10_Regular_Expresstion_Matching();
    System.out.println(regular_Expresstion_Matching.isMatch("aab", "c*a*b"));
    System.out.println(regular_Expresstion_Matching.isMatch("aa", "a"));
  }

  public boolean isMatch(String s, String p) {
    return solve(s, p, 0, 0, new Boolean[s.length() + 1][p.length() + 1]);
  }

  public boolean solve(String s, String p, int sIndex, int pIntdex,
      Boolean[][] dp) {
    if (s.length() <= sIndex && p.length() <= pIntdex) {
      return true;
    }
    if (s.length() > sIndex && p.length() <= pIntdex) {
      return false;
    }

    if (sIndex >= s.length() && p.length() > pIntdex) {
      if (pIntdex != p.length() - 1 && p.charAt(pIntdex + 1) == '*') {
        return solve(s, p, sIndex, pIntdex + 2, dp);
      }
      return false;
    }
    if (dp[sIndex][pIntdex] != null) {
      return dp[sIndex][pIntdex];
    }

    boolean res = false;

    if (pIntdex != p.length() - 1 && p.charAt(pIntdex + 1) == '*') {
      res |= solve(s, p, sIndex, pIntdex + 2, dp);
      if (s.charAt(sIndex) == p.charAt(pIntdex) || p.charAt(pIntdex) == '.') {
        res |= solve(s, p, sIndex + 1, pIntdex, dp);
      }
    } else if (s.charAt(sIndex) == p.charAt(pIntdex) || p.charAt(pIntdex) == '.') {
      res |= solve(s, p, sIndex + 1, pIntdex + 1, dp);
    }
    dp[sIndex][pIntdex] = res;
    return dp[sIndex][pIntdex];
  }
}
