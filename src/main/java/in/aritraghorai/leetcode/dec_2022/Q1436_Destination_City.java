package in.aritraghorai.leetcode.dec_2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 *  !Name: Aritra Ghorai
 *  !Date:15/12/2023
 *  ?Program Details: 1436. Destination City
 *
 */

public class Q1436_Destination_City {
  public static void main(String[] args) {
    System.out.println("Hello World!");
  }

  public String destCity(List<List<String>> paths) {
    HashMap<String, List<String>> map = new HashMap<>();
    for (List<String> path : paths) {
      String source = path.get(0);
      String destination = path.get(1);
      if (!map.containsKey(source)) {
        map.put(source, new ArrayList<>());
      }
      if (!map.containsKey(destination)) {
        map.put(destination, new ArrayList<>());
      }
      map.get(source).add(destination);
    }
    for (String key : map.keySet()) {
      if (map.get(key).size() == 0) {
        return key;
      }
    }
    return "";
  }
}
