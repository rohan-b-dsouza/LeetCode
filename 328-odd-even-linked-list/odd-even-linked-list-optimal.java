// Optimal

/*
Definition for singly linked list:
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}
*/

class Solution {
    public ListNode oddEvenList(ListNode head) {
      if (head == null || head.next == null || head.next.next == null) return head;
      ListNode odd = head;
      ListNode even = head.next;
      ListNode evenHead = head.next;
      while (even != null && even.next != null) {
          odd.next = even.next;
          odd = odd.next;
          even.next = odd.next;
          even = even.next;
      }
      odd.next = evenHead;
      return head;
    }
}

// T.C => O(n)
// S.C => O(1)
