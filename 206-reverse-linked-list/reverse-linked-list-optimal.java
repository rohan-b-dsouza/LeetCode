// Optimal (Iterative)

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
        if (head == null || head.next == null) return head;
        ListNode prev = null; // pointer for previous node
        ListNode next = null; // pointer for next node
        ListNode temp = head; // pointer for current node
        while (temp != null) {
            next = temp.next; // store pointer to next node of current
            temp.next = prev; // link current node to previous
            prev = temp; // update prev node to current node
            temp = next; // increment temp to next node
        }
        return prev; // return head of reverse LL
    }
}

// T.C => O(n)
// S.C => O(1)
