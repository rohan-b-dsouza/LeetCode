// Optimal (Tortoise and Hare Algorithm)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
         if (head == null) return head;
        ListNode fast = head;
        ListNode slow = head; 
        // Traverse till fast is not null and not at the last node
        while (fast != null && fast.next != null) {
            fast = fast.next.next; // increment fast by 2 steps
            slow = slow.next; // increment slow by one step
        }
        return slow; // Return the middle node
    }
}

// T.C => O(n)
// S.C => O(1)
