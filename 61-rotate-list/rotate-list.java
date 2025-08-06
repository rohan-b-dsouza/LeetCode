/*Definition of singly linked list:
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}
 */

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // If list is empty or has only one node
        if (head == null || head.next == null) return head;
        ListNode temp = head;
        int cnt = 1;
        // Count the no. of nodes in the LL
        while (temp.next != null) {
            temp = temp.next;
            cnt++;
        }
        // Store the lastnode
        ListNode lastnode = temp;
        // Reset temp to head
        temp = head;
        // When k is more than length of list adjust it within bounds of LL
        k = k % cnt;
        // Iterate up to the node before the part to be rotated
        for (int i = 1; i < (cnt - k); i++) {
            temp = temp.next;
        } 
        // Link lastnode to head
        lastnode.next = head;
        // Update head to the starting node of part to be rotated
        head = temp.next;
        // Break the link between the non-rotated part and part to be rotated
        temp.next = null;
        // Return the new Head
        return head;
    }
}