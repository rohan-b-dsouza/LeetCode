/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode slast = null;
        while (node.next != null) {
            node.val = node.next.val;
            slast = node;
            node = node.next;
        }
        slast.next = null;
    }
}