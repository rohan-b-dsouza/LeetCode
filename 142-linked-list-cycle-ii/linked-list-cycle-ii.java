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
        if (head == null || head.next == null)
            return null;
        // Hashset to store visited nodes
        HashSet<ListNode> st = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            // If visited node appears, cycle exists return starting node
            if (st.contains(temp)) {
                return temp;
            }
            // Store current node to the HashSet
            st.add(temp);
            temp = temp.next;
        }
        // If no cycle detected, return null
        return null;
    }
}