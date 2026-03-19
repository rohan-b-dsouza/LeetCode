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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        ListNode dummy = new ListNode(-1);
        ListNode curr = null;
        while (temp != null) {
            if (temp.next != null && temp.val == temp.next.val) {
                while (temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
            } else {
                if (curr == null) {
                    dummy.next = temp;
                    curr = temp;
                } else {
                    curr.next = temp;
                    curr = temp;
                }
            }
            temp = temp.next;
        }
        if (curr != null) curr.next = null;
        return dummy.next;
    }
}