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
        if (head == null || head.next == null) return head;
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode dummy = new ListNode(-1);
        ListNode temp = null;
        while (p1 != null) {
            p2 = p1.next;
            if (p2 == null || p2.val != p1.val) {
                if (p2 == null) {
                    if (temp != null) temp.next = p1;
                    else dummy.next = p1;
                }
                else if (temp == null) {
                    dummy.next = p1;
                    temp = p1;
                }
                else {
                    temp.next = p1;
                    temp = p1;
                }
                p1 = p1.next;
            }
            else {
                while (p2 != null && p2.val == p1.val) {
                    p2 = p2.next;
                }
                if (p2 == null) {
                   if (temp != null) temp.next = null;
                }
                p1 = p2;
            }
        }
        return dummy.next;
    }
}