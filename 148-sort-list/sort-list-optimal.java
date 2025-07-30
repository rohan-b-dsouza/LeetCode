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
    // Function to get middle node of a LL
    public ListNode getMiddleNode (ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    // Function to merge two lists
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
    // Recursive function to sort the LL using merge sort
    public ListNode sortList(ListNode head) {
        // If the list is empty or there is only one node
        if (head == null || head.next == null) return head;
        // Get the middle node of the current LL
        ListNode middle = getMiddleNode(head);
        // Get the start node of right list
        ListNode right = middle.next;
        // Get the start node of left list
        ListNode left = head;
        // Break the link between left and right list
        middle.next = null;
        // Recursively sort the left list
        left = sortList(left);
        // Recursively sort the right list
        right = sortList(right);
        // Merge the two lists
        return mergeTwoLists(left, right);
    }
}

// T.C => O(log (n) * (n + n / 2)) = O(n * log (n)) ------------- {as there are log(n) calls and for each call we take approx. O(n) for finding middle node and O(n) for merging two lists}
// S.C => O(log (n)) for the recursive stack (merge sort)
