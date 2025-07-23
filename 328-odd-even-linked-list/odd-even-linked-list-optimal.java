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
        // Edge case: if list has fewer than 3 nodes, no need to rearrange
      if (head == null || head.next == null || head.next.next == null) return head;
       // Initialize pointers:
        // 'odd' tracks current odd-indexed node
        // 'even' tracks current even-indexed node
        // 'evenHead' stores the head of the even list to attach later
      ListNode odd = head;
      ListNode even = head.next;
      ListNode evenHead = head.next;
            // Re-link nodes to group odd and even positioned nodes separately
      while (even != null && even.next != null) {
          odd.next = even.next;   // Connect current odd node to the next odd node
          odd = odd.next;     // Move odd pointer forward
          even.next = odd.next; // Connect current even node to the next even node
          even = even.next;   // Move even pointer forward
      }
       // Append the even list after the odd list
      odd.next = evenHead;
      return head;
    }
}

// T.C => O(n)
// S.C => O(1)
