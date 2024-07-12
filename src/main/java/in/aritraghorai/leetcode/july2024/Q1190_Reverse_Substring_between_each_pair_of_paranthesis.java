package in.aritraghorai.leetcode.july2024;

import java.util.Stack;

/**
 * Q1190_Reverse_Substring_between_each_pair_of_paranthesis
 */
public class Q1190_Reverse_Substring_between_each_pair_of_paranthesis {
  public String reverseParentheses(String s) {
    Stack<Character> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (c == ')') {
        StringBuilder temp = new StringBuilder();
        while (stack.peek() != '(') {
          temp.append(stack.pop());
        }
        stack.pop();
        for (char ch : temp.toString().toCharArray()) {
          stack.push(ch);
        }
      } else {
        stack.push(c);
      }
    }
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    return sb.reverse().toString();
  }

}
