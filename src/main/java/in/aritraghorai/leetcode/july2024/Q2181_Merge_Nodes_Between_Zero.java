package in.aritraghorai.leetcode.july2024;

class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

public class Q2181_Merge_Nodes_Between_Zero {
  public ListNode mergeNodes(ListNode head) {
    if (head == null || head.next == null)
      return head;

    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy;
    int val = 0;

    ListNode temp = head;
    while (temp != null) {
      if (temp.val == 0 && val > 0) {
        prev.next = new ListNode(val);
        prev = prev.next;
        val = 0;
      } else {
        val += temp.val;
      }
      temp = temp.next;
    }

    return dummy.next;

  }
}
