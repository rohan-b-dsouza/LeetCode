// Optimal

/*Definition for singly Linked List
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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(-1);
    ListNode tail = dummyHead;
    int sum = 0;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
      sum = carry;
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }
      ListNode newNode = new ListNode(sum % 10);
      carry = sum / 10;
      tail.next = newNode;
      tail = newNode;
    }
    return dummyHead.next;
  }
}

// T.C => O(max(n, m)) where n and m are size of linked list l1 & l2 respectively
// S.C => O(max(n, m)) where n and m are size of linked list l1 & l2 respectively
