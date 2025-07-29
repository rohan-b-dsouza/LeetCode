// Optimal

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp = temp1;
                temp1 = temp1.next;
            }
            else {
                temp.next = temp2;
                temp = temp2;
                temp2 = temp2.next;
            }
        }
        temp.next = temp1 != null ? temp1 : temp2;
        return dummyNode.next;
    }
}

// T.C => O(n + m)
// S.C => O(1)
