// Brute

/*
Definition for singly linked list:
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
    public ListNode oddEvenList(ListNode head) {
 if (head == null || head.next == null || head.next.next == null) return head;
        ListNode temp = head; // start from odd node
        // List to store values in odd......even..... order
        List<Integer> anslist = new ArrayList<>();
        while (temp != null) {
            anslist.add(temp.val);
            if (temp.next == null) break;
            temp = temp.next.next; // take only odd nodes
        }
        temp = head.next; // start from even node
        while (temp != null) {
            anslist.add(temp.val);
            if (temp.next == null) break;
            temp = temp.next.next; // take only even nodes 
        }
        temp = head;
        for (int num : anslist) {
            temp.val = num;
            temp = temp.next;
        }
        return head;
    }
}

// T.C => O(n / 2) + O(n / 2) + O(n) = O(2 * n) = O(n)
// S.C => O(n)
