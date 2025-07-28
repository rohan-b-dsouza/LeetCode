// Optimal (Tortoise and Hare algorithm)
 
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        // Traverse till fast is not null or fast is not at last node
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // If fast and slow meet it means that cycle exists, hence set slow to head and move fast and slow pointer by one step till they meet again
            if (fast == slow) {
                slow = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                // Return the starting point of loop
                return slow;
            }
        }
        return null;
    }
}

// T.C => O(n)
// S.C => O(1)
