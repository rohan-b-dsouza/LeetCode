// Brute

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
  public ListNode rotateRight(ListNode head, int k) {
    // If list is empty or has only one node
    if (head == null || head.next == null) return head;
    for (int i = 0; i < k; i++) {
        // Update temp to the new Head
      ListNode temp = head;
      // Find the second last node
      while (temp.next.next != null) {
        temp = temp.next;
      }
      // Get the last node
      ListNode lastnode = temp.next;
      // Link the last node to the first
      lastnode.next = head;
      // Update the head to this new Head (lastnode)
      head = lastnode;
      // Break the link between the second last and last node
      temp.next = null;
    }
    return head;
  }
}

// T.C => O(k * n)
// S.C => O(1)
