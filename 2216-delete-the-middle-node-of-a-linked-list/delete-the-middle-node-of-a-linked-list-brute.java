// Brute

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
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;    
        ListNode temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        temp = head;
        for (int i = 1; i < (cnt / 2); i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}

// T.C => O(n) + O(n / 2) = O(n)
// S.C => O(1)

