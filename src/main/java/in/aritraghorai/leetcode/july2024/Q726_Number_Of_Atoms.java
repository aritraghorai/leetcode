package in.aritraghorai.leetcode.july2024;

import java.util.HashMap;
import java.util.Stack;
import java.util.TreeMap;

/*
 *  !Name: Aritra Ghorai
 *  !Date:14/07/2024
 *  ?Program Details: Q726. Number Of Atoms
 *    */
public class Q726_Number_Of_Atoms {

  public static void main(String[] args) {
    Q726_Number_Of_Atoms q = new Q726_Number_Of_Atoms();
    System.out.println(q.countOfAtoms("H11He49NO35B7N46Li20"));
  }

  public String countOfAtoms(String formula) {
    Stack<HashMap<String, Integer>> stack = new Stack<>();

    char[] formulaChars = formula.toCharArray();
    int i = 0;
    stack.push(new HashMap<>());

    while (i < formulaChars.length) {
      if (formulaChars[i] == '(') {
        stack.push(new HashMap<>());
        i++;
      } else if (formulaChars[i] == ')') {
        HashMap<String, Integer> map = stack.pop();
        StringBuilder multiplier = new StringBuilder();
        ++i;
        while (i < formulaChars.length && Character.isDigit(formulaChars[i])) {
          multiplier.append(formulaChars[i]);
          i++;
        }
        Integer mul = multiplier.length() == 0
                          ? 1
                          : Integer.parseInt(multiplier.toString());
        for (String key : map.keySet()) {
          map.put(key, map.get(key) * mul);
        }

        if (!stack.isEmpty()) {
          HashMap<String, Integer> temp = stack.pop();
          for (String key : temp.keySet()) {
            map.put(key, map.getOrDefault(key, 0) + temp.get(key));
          }
        }
        stack.push(map);
      } else {
        HashMap<String, Integer> map = stack.peek();
        StringBuilder atom = new StringBuilder();
        atom.append(formulaChars[i]);
        i++;
        while (i < formulaChars.length &&
               Character.isLowerCase(formulaChars[i])) {
          atom.append(formulaChars[i]);
          i++;
        }
        StringBuilder multiplier = new StringBuilder();
        while (i < formulaChars.length && Character.isDigit(formulaChars[i])) {
          multiplier.append(formulaChars[i]);
          i++;
        }
        Integer mul = multiplier.length() == 0
                          ? 1
                          : Integer.parseInt(multiplier.toString());
        map.put(atom.toString(), map.getOrDefault(atom.toString(), 0) + mul);
      }
    }
    TreeMap<String, Integer> treeMap = new TreeMap<>(stack.pop());
    StringBuilder sb = new StringBuilder();
    for (String word : treeMap.keySet()) {
      if (treeMap.get(word) == 1) {
        sb.append(word);
      } else {
        sb.append(word).append(treeMap.get(word));
      }
    }
    return sb.toString();
  }
}
