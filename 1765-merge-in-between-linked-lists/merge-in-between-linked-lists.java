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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp = list1;
        ListNode ath = null; ListNode bth = null;
        int cnt = 0;
        ListNode head = null;
        while (temp != null) {
            if (head == null && cnt != a && cnt != b) head = temp;
            
            if (cnt == a - 1) {
                ath = temp;
            }
            else if (cnt == b + 1) {
                bth = temp;
                break;
            }
            temp = temp.next;
            cnt++;
        }
        if (ath != null) ath.next = list2;
        ListNode tail2 = list2;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }
        tail2.next = bth;
        return head;

    }
}