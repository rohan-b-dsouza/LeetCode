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
        Map<Integer, Integer> map = new LinkedHashMap<>();
        ListNode temp = head;
        while (temp != null) {
            map.merge(temp.val, 1, Integer::sum);
            temp = temp.next;
        }
        ListNode dummy = new ListNode(-1);
        temp = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 1) continue;
            ListNode a = new ListNode(entry.getKey());
            if (temp == null) {
                dummy.next = a;
            }
            else {
                temp.next = a;
            }
            temp = a;
        }
        return dummy.next;
    }
}