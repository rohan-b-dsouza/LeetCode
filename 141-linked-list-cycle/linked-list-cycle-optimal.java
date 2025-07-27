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
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        // Initialize two pointers fast and slow
        ListNode fast = head;
        ListNode slow = head;
        // Traverse the LL with the fast and slow pointers
        while (fast != null && fast.next != null) {
            fast = fast.next.next; // Move fast by two step
            slow = slow.next; // Move slow by one step
            // Check if slow and fast pointers meet
            if (fast == slow) return true; // Loop is detected
        }
        // If fast reaches end of loop or null, there is no loop
        return false;
    }
}

// T.C => O(n)
// S.C => O(1)
