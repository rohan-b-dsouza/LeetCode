// Optimal

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

  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode prev = null; // pointer for previous node
    ListNode next = null; // pointer for next node
    ListNode temp = head; // pointer for current node
    while (temp != null) {
      next = temp.next; // store pointer to next node of current
      temp.next = prev; // link current node to previous
      prev = temp; // update prev node to current node
      temp = next; // increment temp to next node
    }
    return prev; // return head of reverse LL
  }

  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;
    ListNode fast = head;
    ListNode slow = head;
      // This loop helps in finding the middle node
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
      // Divide the linked list into two parts, left part having elements before middle node and right part having middle node and elements after it
    ListNode left = head;
    ListNode right = reverseList(slow);
    ListNode secondHalfHead = right; // store the head of reversed right part, this is reqd to later restore original list
      // Check if LL is a palindrome
    while (left != null && right != null) {
        if (left.val != right.val) return false;
        left = left.next;
        right = right.next;
    }
      // Restore original list
    reverseList(secondHalfHead);
    return true;
  }
}

// T.C => O(n / 2) + O(n / 2) + O(n / 2) + O(n / 2) = O(2 * n) = O(n)
// S.C => O(1)

// T.C => O()
