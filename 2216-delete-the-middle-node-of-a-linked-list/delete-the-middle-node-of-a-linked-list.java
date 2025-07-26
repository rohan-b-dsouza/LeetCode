// Optimal (Tortoise and Hare Algorithm)

/*Definition of singly linked list:
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
  public ListNode deleteMiddle(ListNode head) {
    if (head == null || head.next == null) return null;
    ListNode fast = head.next.next; // start fast pointer by 2 steps from head to ensure slow reaches one node before the middle node
    ListNode slow = head;
      // Traverse till fast becomes null or reaches last node
    while (fast != null && fast.next != null) {
      fast = fast.next.next; // increment fast by 2 steps
      slow = slow.next; // increment slow by one step
    }
      // delete the middle node
    slow.next = slow.next.next;
    return head;
  }
}

// T.C => O(n / 2)
// S.C => O(1)
