// Optimal

/*Definition for Singly Linked List
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        // Move the fast pointer n nodes ahead
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }
        // If fast becomes null, then the node to be deleted is head
        if (fast == null) {
            return head.next;
        }
        // Move both fast and slow pointer till fast reaches the last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // Delete the nth node from the end
        slow.next = slow.next.next;
        return head;
    }
}

// T.C => O(L) where L is the length of the LL
// S.C => O(1)
