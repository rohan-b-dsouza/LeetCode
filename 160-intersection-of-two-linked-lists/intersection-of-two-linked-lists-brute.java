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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> st1 = new HashSet<>();
        ListNode temp = headA;
        // Store all elements of first LL into a hashset
        while (temp != null) {
            st1.add(temp);
            temp = temp.next;
        }
        temp = headB;
        // Traverse through second LL and check if the node (reference) exits in the hashset
        while (temp != null) {
            // if yes return the reference
            if (st1.contains(temp)) return temp;
            temp = temp.next;
        }
        // if no intersection found, return null
        return null;
    }
}

// T.C => O(n + m) where n and m is size of LL A and LL B respectively
// S.C => O(n) for the extra hashset
