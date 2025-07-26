// Brute

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
        ListNode temp = head;
        int cnt = 0;
        // Calculate the no. of nodes
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        temp = head;
        // Traverse to the middle node
        for (int i = 1; i < (cnt / 2 + 1); i++) {
            temp = temp.next;
        }
        // Return the middle node
        return temp;
    }
}

// T.C => O(n) + O(n / 2) = O(n)
// S.C => O(1)
