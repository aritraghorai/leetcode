package in.aritraghorai.leetcode.july2024;

/*
 *  !Name: Aritra Ghorai
 *  !Date:12/07/2024
 *  ?Program Details: Maximal Score from Removing Substrings
 */
public class Q1717_Maximal_Score_from_Removing_Substrings {

  class SubstringAndScore {

    public SubstringAndScore(int score, String string) {
      this.score = score;
      this.string = string;
    }

    public int score;
    public String string;
  }

  public static void main(String[] args) {
    Q1717_Maximal_Score_from_Removing_Substrings q =
        new Q1717_Maximal_Score_from_Removing_Substrings();
    System.out.println(q.maximumGain("cdbcbbaaabab", 4, 5));
  }

  public int maximumGain(String s, int x, int y) {
    String firstString = x > y ? "ab" : "ba";
    String secondString = firstString.equals("ab") ? "ba" : "ab";
    int score = 0;
    SubstringAndScore res1 =
        deleteSubstringAndScore(s, firstString, x > y ? x : y);

    score += res1.score;

    SubstringAndScore res2 =
        deleteSubstringAndScore(res1.string, secondString, x > y ? y : x);

    score += res2.score;
    return score;
  }

  public SubstringAndScore deleteSubstringAndScore(String s, String subString,
                                                   int score) {
    char[] string = s.toCharArray();
    char[] newString = new char[s.length()];
    int writeIndex = 0;
    int currentScore = 0;
    for (int i = 0; i < newString.length; i++) {
      newString[writeIndex] = string[i];
      writeIndex++;
      if (writeIndex > 1) {
        // System.out.println(" subString:" + subString + " " +
        //                    newString[writeIndex - 2] +
        //                    newString[writeIndex - 1]);
        if (newString[writeIndex - 1] == subString.charAt(1) &&
            newString[writeIndex - 2] == subString.charAt(0)) {
          writeIndex -= 2;
          currentScore += score;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < writeIndex; i++) {
      sb.append(newString[i]);
    }
    SubstringAndScore current =
        new SubstringAndScore(currentScore, sb.toString());
    return current;
  }
}
