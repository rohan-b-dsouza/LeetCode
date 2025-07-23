
/*Definition for Singly Linked List
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
         // Edge case: empty list
        if (head == null) return head;
        ListNode temp = head;
        int noOfNodes = 0;
        // Step 1: Count total number of nodes
        while (temp != null) {
            noOfNodes++;
            temp = temp.next;
        }
        // Step 2: If head needs to be removed
        if (noOfNodes == n) {
            return head.next;
        }
        int cnt = 1;
        temp = head;
        // Step 3: Reach the node just before the one to be deleted
        while (cnt < (noOfNodes - n)) {
            temp = temp.next;
            cnt++;
        }
        // Step 4: Delete the node
        temp.next = temp.next.next;
        return head;
    }
}