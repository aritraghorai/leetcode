
package in.aritraghorai.leetcode.dec_2022;

/*
 *  !Name: Aritra Ghorai
 *  !Date:20/12/2023
 *  ?Program Details: 2706. Buy Two Chocolates
 *  https://leetcode.com/problems/buy-two-chocolates/
 *    */

public class Q2706_Buy_Two_Chocolates {
  public int buyChoco(int[] prices, int money) {
    int min = Integer.MAX_VALUE;
    int position = -1;
    int secondMin = Integer.MAX_VALUE;

    for (int i = 0; i < prices.length; i++) {
      if (min > prices[i]) {
        min = prices[i];
        position = i;
      }
    }
    for (int i = 0; i < prices.length; i++) {
      if (secondMin > prices[i] && i != position) {
        secondMin = prices[i];
      }
    }
    if (secondMin + min > money) {
      return money;
    }
    return (money - (secondMin + min));
  }
}
