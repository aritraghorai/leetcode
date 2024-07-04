package in.aritraghorai.leetcode.jan2024;

import java.util.HashMap;

public class Q2870_Minimum_number_of_operation_to_make_an_array_empty {
  public int minOperations(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int operations = 0;
    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    for (int i : map.keySet()) {
      if (map.get(i) % 2 == 0) {
        operations += map.get(i) / 2;
      } else if (map.get(i) % 3 == 0) {
        operations += map.get(i) / 3;
      } else {
        return -1;
      }
    }
    return operations;
  }
}
