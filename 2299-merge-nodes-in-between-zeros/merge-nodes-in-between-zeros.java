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
        while (temp.next != null) {
            curr = temp;
            int sum = 0;
            while (temp.next != null && temp.next.val != 0) {
                sum += temp.val;
                temp = temp.next;
            }
            sum += temp.val;
            curr.val = sum;
            temp = temp.next;
            curr.next = temp;
        }
        curr.next = null;
        return head;
    }
}