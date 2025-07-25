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
    public ListNode reverseList(ListNode head) {
    // Base case: if list is empty or only one node
        if (head == null || head.next == null) return head;
        // Recurse till the last node
        ListNode newHead = reverseList(head.next);
        // get front node
        ListNode front = head.next; // node after current
        front.next = head; // reverse the pointer
        head.next = null;  // cut off original link
        return newHead; // return head of reverse list
    }
}