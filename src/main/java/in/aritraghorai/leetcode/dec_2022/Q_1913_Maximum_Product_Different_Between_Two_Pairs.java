package in.aritraghorai.leetcode.dec_2022;

import java.util.Arrays;

public class Q_1913_Maximum_Product_Different_Between_Two_Pairs {

  public static void main(String[] args) {
    int[] nums = new int[] { 5, 6, 2, 7, 4 };
    System.out.println(maxProductDifference(nums));
  }

  public static int maxProductDifference(int[] nums) {
    // int min = Integer.MAX_VALUE;
    // int max = Integer.MIN_VALUE;
    // int secondMax = Integer.MIN_VALUE;
    // int secondMin = Integer.MAX_VALUE;
    // for (int num : nums) {
    // max = Math.max(max, num);
    // min = Math.min(min, num);
    // }
    //
    // for (int num : nums) {
    // if (max != num && min != num) {
    // secondMax = Math.max(num, secondMax);
    // secondMin = Math.min(num, secondMin);
    // }
    // }
    //
    // return (max * secondMax) - (min * secondMin);
    Arrays.sort(nums);
    return (nums[nums.length - 1] * nums[nums.length - 2]) -
        (nums[0] * nums[1]);
  }
}
