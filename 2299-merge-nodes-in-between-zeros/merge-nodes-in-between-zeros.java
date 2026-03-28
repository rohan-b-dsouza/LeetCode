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
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = head;
        ListNode curr = head;
        while (temp != null) {
            curr = temp;
            int sum = 0;
            while (temp != null && temp.val != 0) {
                sum += temp.val;
                temp = temp.next;
            }
            if (temp != null) temp = temp.next;
            curr.val = sum;
            curr.next = temp;
        }
        curr.next = null;
        return head.next;
    }
}