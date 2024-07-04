package in.aritraghorai.leetcode.jan2024;

import java.util.ArrayList;
import java.util.HashMap;
/*
 *  !Name: Aritra Ghorai
 *  !Date:02/01/2024
 *  ?Program Details: 2610. Convert an Array Into a 2D Array With Conditions
 *    */
import java.util.List;

public class Q2610_Convert_Array_Into_2d_Array_With_Condition {

  public List<List<Integer>> findMatrix(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    List<List<Integer>> res = new ArrayList<>();
    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
      int val = map.get(i);
      if (val > res.size()) {
        res.add(new ArrayList<>());
      }
      res.get(val - 1).add(i);
    }
    return res;
  }
}
